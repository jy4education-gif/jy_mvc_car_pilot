package controller;

import model.CarModel;
import view.CarView;
// optional
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarController {
    
    private CarModel model;
    private CarView view;

    public CarController(CarModel model, CarView view) {
        this.model = model;
        this.view = view;
 
        this.view.addStartEngineListener(new StartEngineHandler());
        this.view.addStopEngineListener(new StopEngineHandler());
        this.view.addDriveListener(new DriveHandler());

        updateView();
    }
 
    public void startEngine() {
        model.setEngineIsRunning(true);
        updateView();
    }

    public void stopEngine() {
        model.setEngineIsRunning(false);
        updateView();
    }

    public void driveDistance(double distance) {
        if (model.isEngineIsRunning()) {
            double requiredFuel = (distance / 100.0) * model.getFuelConsumption();
            
            if (model.getCurrentTankVolume() >= requiredFuel) {
                model.setMileage(model.getMileage() + distance);
                consumeFuel(requiredFuel);
            } else {
                double possibleDistance = (model.getCurrentTankVolume() / model.getFuelConsumption()) * 100.0;
                model.setMileage(model.getMileage() + possibleDistance);
                model.setCurrentTankVolume(0.0);
                model.setEngineIsRunning(false);
                System.out.println("Tank leer! Das Auto ist stehen geblieben.");
            }
            updateView();
        } else {
            System.out.println("Fahren nicht möglich: Der Motor ist aus.");
        }
    }

    public void consumeFuel(double amount) {
        model.setCurrentTankVolume(model.getCurrentTankVolume() - amount);
    }

    private void updateView() {
        view.updateCarDisplay(model.isEngineIsRunning(), model.getMileage(), model.getCurrentTankVolume());
    }

    // Einstiegspunkt 
    public static void main(String[] args) {
        // Instanzen erzeugen
        CarModel car = new CarModel("Model S", "Schwarz", "Limousine", 2024, 60, 6.5);
        CarView gui = new CarView();
        
        // Initialisieren und Komponenten übergeben
        new CarController(car, gui);
        
        // GUI sichtbar machen
        gui.setVisible(true);
    }

    // inner Klassen frü ActionListeners
    private class StartEngineHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            startEngine();
        }
    }

    private class StopEngineHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            stopEngine();
        }
    }

    private class DriveHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            driveDistance(10.0); // simuliert 10 km Fahrt pro click
        }
    }
}