package view;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class CarView extends JFrame {
    
    // UI
    private JLabel infoLabel = new JLabel("Motor: Aus | Kilometer: 0.0 km | Tank: 0.0 L");
    private JButton startButton = new JButton("Motor Starten");
    private JButton stopButton = new JButton("Motor Stoppen");
    private JButton driveButton = new JButton("10 km Fahren");

    public CarView() {
        // Window
        this.setTitle("Car Simulator (MVC)");
        this.setSize(400, 150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        // Layout
        JPanel panel = new JPanel(new GridLayout(2, 1));
        JPanel buttonPanel = new JPanel();
        
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(driveButton);
        
        panel.add(infoLabel);
        panel.add(buttonPanel);
        
        this.add(panel);
    }

    
    public void updateCarDisplay(boolean engineRunning, double mileage, double fuel) {
        String status = engineRunning ? "An" : "Aus"; // thanks mr. schmidt!
        infoLabel.setText(String.format("Motor: %s | Kilometer: %.1f km | Tank: %.1f L", status, mileage, fuel));
    }

    
    public void addStartEngineListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }

    public void addStopEngineListener(ActionListener listener) {
        stopButton.addActionListener(listener);
    }

    public void addDriveListener(ActionListener listener) {
        driveButton.addActionListener(listener);
    }
}