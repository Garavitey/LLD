package Prototype;

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog(5, "Buddy");
        Dog dog2 = dog1.copy();
        dog2.age = 3;

        System.out.println("Dog 1: " + dog1.name + ", Age: " + dog1.age);
        System.out.println("Dog 2: " + dog2.name + ", Age: " + dog2.age);
    }
}
