package model;

public class Decorator extends Vendor {

    public Decorator(int id, String name,
                     String service,
                     String location,
                     double price,
                     boolean available) {

        super(id, name,
                "Decorator",
                service,
                location,
                price,
                available);
    }

    @Override
    public void displayService() {
        System.out.println("Decoration Services Available");
    }
}