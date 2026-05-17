package Invoice;

public class Main {
    public static void main(String[] args) {

        invoice invoice1 = new invoice(1, 100, "Invoice 1");
        saveto savetotxt = new savetotxt();
        savetotxt.save(invoice1);
    }
}