package Invoice;

public class invoice {
    private Integer id;
    private Integer amount;
    private String description;

    public invoice(Integer id, Integer amount, String description) {
        this.id = id;
        this.amount = amount;
        this.description = description;
    }

    // getters and setters
    public Integer getId() {
        return id;  
    }

    public Integer getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

}
