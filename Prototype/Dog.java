package Prototype;

public class Dog implements Clone<Dog> {
    int age;
    String name;

    public Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }

    // copy constructor
    public Dog(Dog dog) {
        this.age = dog.age;
        this.name = dog.name;
    }



    @Override
    public Dog copy() {
        return new Dog(this);
    }
}
