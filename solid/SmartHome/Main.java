package SmartHome;

public class Main {
    public static void main(String[] args) {
        Abulb b1 = new Abulb();
        b1.turnOn();
        b1.turnOff();
        CSmartApp smartApp = new CSmartApp();
        smartApp.playMusic("Shape of You");
        smartApp.stopMusic();
        smartApp.turnOn();
        smartApp.turnOff();
        BSpeaker speaker = new BSpeaker();
        speaker.playMusic("Blinding Lights");
        speaker.stopMusic();   
        
        Remote remote = new Remote(speaker);
        remote.turnOnDevice();
        remote.turnOffDevice();

        Remote remote2 = new Remote(smartApp);
        remote2.turnOnDevice();
        remote2.turnOffDevice();    

        Remote remote3 = new Remote(b1);
        remote3.turnOnDevice();
        remote3.turnOffDevice();

    }
}

// now we need a remote that will be universal 
// to do that we need to create a interface device -> that will have two methods -> turnOn and turnOff
// then we will create a class for smart bulb and smart speaker that will implement the device interface
// then there will be a remote class that will take the device as input in the constructor and then we will have the remote 

