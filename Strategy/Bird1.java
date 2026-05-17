package Strategy;

public class Bird1 implements Bird {

    FlyWay flyWay;
    public Bird1(FlyWay flyWay) {
        this.flyWay = flyWay;
    }
    @Override
    public void fly() {
        flyWay.fly();
    }

    @Override
    public void eat() {
        System.out.println("Bird1 is eating");
    }
}
