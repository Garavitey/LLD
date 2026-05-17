package SmartHome;

public class BSpeaker implements SmartSpeaker, Device {

    @Override
    public void playMusic(String song) {
        System.out.println("Playing music: " + song);
    }

    @Override
    public void stopMusic() {
        System.out.println("Stopping music");
    }

    @Override
    public void turnOn() {
        System.out.println("Speaker is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Speaker is turned off.");
    }
}
