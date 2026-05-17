package Invoice;

public class savetotxt implements saveto {
    // method that will take the invoice object and save it to a text file
    @Override
    public void save(invoice invoice) {
        // code to save the invoice object to a text file
        System.out.println("Saving invoice to text file: " + invoice.getId() + ", " + invoice.getAmount() + ", " + invoice.getDescription());
    }
}
