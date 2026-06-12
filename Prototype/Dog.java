package Prototype;

public class Dog implements Clone<Dog> {
    int age;
    String name;

    public Dog(int age, String name) { // this is the constructor
        this.age = age;
        this.name = name;
    }

    // copy constructor
    public Dog(Dog dog) { // this is the copy constructor that takes another Dog object as a parameter and copies its properties
        this.age = dog.age;
        this.name = dog.name;
    }



    @Override
    public Dog copy() {  // this is the implementation of the copy method from the Clone interface, which creates a new Dog object using the copy constructor
        return new Dog(this); // we have <T> in the Clone interface, so we specify that we are returning a Dog object by using new Dog(this)
    }
}
