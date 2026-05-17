package Strategy;

public class Bird2 implements Bird {
    
    FlyWay flyWay;

    public Bird2(FlyWay flyWay) {
        this.flyWay = flyWay;
    }

    @Override
    public void eat() {
        System.out.println("Bird2 is eating");
    }

    @Override
    public void fly() {
        flyWay.fly();
    }
}
