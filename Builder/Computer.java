package Builder;

public class Computer {
    private String CPU;
    private String GPU;
    private String RAM;
    private String storage;

    // optional parameters can be added as needed
    private String color;
    private String brand;


    // private constructor to prevent direct instantiation
    private Computer(ComputerBuilder builder) {
        this.CPU = builder.CPU;
        this.GPU = builder.GPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.color = builder.color;
        this.brand = builder.brand;
    }

    void PrintSpecs() {
        System.out.println("CPU: " + CPU);
        System.out.println("GPU: " + GPU);
        System.out.println("RAM: " + RAM);
        System.out.println("Storage: " + storage);
        System.out.println("Color: " + color);
        System.out.println("Brand: " + brand);
    }

    // static nested builder class
    public static class ComputerBuilder {
        private String CPU;
        private String GPU;
        private String RAM;
        private String storage;
        private String color;
        private String brand;

        public ComputerBuilder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }
        public ComputerBuilder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }
        public ComputerBuilder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }
        public ComputerBuilder setStorage(String storage) {
            this.storage = storage;
            return this;
        }
        public ComputerBuilder setColor(String color) {
            if(color == "black") {
                this.color = color;
            } else {
                System.out.println("Only black color is allowed");
            }
            return this;
        }
        public Computer build() {
            return new Computer(this);
        }


    }

}
