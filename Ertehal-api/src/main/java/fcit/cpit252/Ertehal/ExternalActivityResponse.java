package fcit.cpit252.Ertehal;

public class ExternalActivityResponse {
    private final String title;
    private final String destination;
    private final double amount;

    public ExternalActivityResponse(String title, String destination, double amount) {
        this.title = title;
        this.destination = destination;
        this.amount = amount;
    }

    public String getTitle() { return title; }
    public String getDestination() { return destination; }
    public double getAmount() { return amount; }
}
