package Strategy;

public class Main {
    public static void main(String[] args) {
        FlyWay flyWay1 = new FlyWay1();
        Bird bird2 = new Bird2(flyWay1);
        bird2.fly();
        bird2.eat();
        FlyWay flyWay2 = new FlyWay2();
        Bird sparrow = new Bird1(flyWay2);
        sparrow.fly();
        sparrow.eat();
    }
    
}
