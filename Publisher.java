public class Publisher {
    private int publisherId;
    private String publisherName;
    private String country;
    private String contact;

    public Publisher() {}

    public Publisher(int publisherId, String publisherName, String country, String contact) {
        this.publisherId = publisherId;
        this.publisherName = publisherName;
        this.country = country;
        this.contact = contact;
    }

    public Publisher(String publisherId, String publisherName, String country, String contact) {
        this.publisherId = Integer.parseInt(publisherId);
        this.publisherName = publisherName;
        this.country = country;
        this.contact = contact;
    }

    public Publisher(String dataLine) {
        String[] data = dataLine.split(",");
        this.publisherId = Integer.parseInt(data[0]);
        this.publisherName = data[1];
        this.country = data[2];
        this.contact = data[3];
    }

    public String toString() {
        return publisherId + "," + publisherName + "," + country + "," + contact + "\n";
    }

    public String showInfoGUI() {
        return "Publisher ID: " + publisherId + "\n" +
               "Name: " + publisherName + "\n" +
               "Country: " + country + "\n" +
               "Contact: " + contact + "\n\n";
    }
}