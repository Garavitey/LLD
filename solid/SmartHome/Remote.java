package SmartHome;

public class Remote {
    private Device device;

    public Remote(Device device) {
        this.device = device;
    }

    public void turnOnDevice() {
        device.turnOn();
    }

    public void turnOffDevice() {
        device.turnOff();
    }
}
