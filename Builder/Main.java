package Builder;

public class Main {
    static public void main(String[] args) {
        Computer computer = new Computer.ComputerBuilder()
                .setStorage("512GB SSD")
                .setGPU("NVIDIA GTX 1660")
                .setRAM("16GB")
                .setCPU("Intel i7")
                .setColor("black")
                .build();

        computer.PrintSpecs();
    }
    
}
