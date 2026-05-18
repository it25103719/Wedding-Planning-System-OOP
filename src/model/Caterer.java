package model;

public class Caterer extends Vendor {

    public Caterer(int id, String name,
                   String service,
                   String location,
                   double price,
                   boolean available) {

        super(id, name,
                "Caterer",
                service,
                location,
                price,
                available);
    }

    @Override
    public void displayService() {
        System.out.println("Catering Services Available");
    }
}