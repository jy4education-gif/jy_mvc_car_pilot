package model;

public class CarModel {
    
    
    private String name;
    private String color;
    private String type;
    private int productionYear;
    private double mileage;
    private boolean engineIsRunning; // besser isEngineRunnig, per Konvention für booleans
    private int maxTankVolume;
    private double currentTankVolume;
    private double fuelConsumption; 

 
    public CarModel(String name, String color, String type, int productionYear, int maxTankVolume, double fuelConsumption) {
        this.name = name;
        this.color = color;
        this.type = type;
        this.productionYear = productionYear;
        this.maxTankVolume = maxTankVolume;
        this.currentTankVolume = maxTankVolume; 
        this.mileage = 0.0;
        this.engineIsRunning = false;
        this.fuelConsumption = fuelConsumption;
    }

  
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getProductionYear() { return productionYear; }

    public double getMileage() { return mileage; }
    public void setMileage(double mileage) { this.mileage = mileage; }

    public boolean isEngineIsRunning() { return engineIsRunning; }
    public void setEngineIsRunning(boolean engineIsRunning) { this.engineIsRunning = engineIsRunning; }

    public int getMaxTankVolume() { return maxTankVolume; }

    public double getCurrentTankVolume() { return currentTankVolume; }
    public void setCurrentTankVolume(double currentTankVolume) { 
        if (currentTankVolume <= maxTankVolume) {
            this.currentTankVolume = currentTankVolume; 
        } else {
            this.currentTankVolume = maxTankVolume;
        }
    }

    public double getFuelConsumption() { return fuelConsumption; }
    public void setFuelConsumption(double fuelConsumption) { this.fuelConsumption = fuelConsumption; }
}