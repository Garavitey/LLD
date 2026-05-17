package SmartHome;

public class Abulb implements Smartbulb, Device {
    
    @Override
    public void turnOnBulb() {
        System.out.println("Bulb is turned on.");
    }

    @Override
    public void turnOffBulb() {
        System.out.println("Bulb is turned off.");
    }

    @Override
    public void turnOn() {
        turnOnBulb();
    }

    @Override
    public void turnOff() {
        turnOffBulb();
    }
}
