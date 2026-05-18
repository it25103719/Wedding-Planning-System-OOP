package model;

public class Vendor {

    private int id;
    private String name;
    private String category;
    private String service;
    private String location;
    private double price;
    private boolean available;

    public Vendor(int id, String name, String category,
                  String service, String location,
                  double price, boolean available) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.service = service;
        this.location = location;
        this.price = price;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getService() {
        return service;
    }

    public String getLocation() {
        return location;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // POLYMORPHISM
    public void displayService() {
        System.out.println("General Vendor Service");
    }

    @Override
    public String toString() {
        return id + "," +
                name + "," +
                category + "," +
                service + "," +
                location + "," +
                price + "," +
                available;
    }
}