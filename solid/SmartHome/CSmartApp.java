package SmartHome;

public class CSmartApp implements SmartSpeaker, Smartbulb, Device {

    @Override
    public void playMusic(String song) {
        System.out.println("Playing music: " + song);
    }

    @Override
    public void stopMusic() {
        System.out.println("Stopping music");
    }

    @Override
    public void turnOnBulb() {
        System.out.println("Turning on the smart bulb");
    }

    @Override
    public void turnOffBulb() {
        System.out.println("Turning off the smart bulb");
    }

    @Override
    public void turnOn() {
        System.out.println("Turning on the device");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off the device");
    }
}
