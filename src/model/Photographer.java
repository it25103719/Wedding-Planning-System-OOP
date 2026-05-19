package model;

public class Photographer extends Vendor {

    public Photographer(int id, String name,
                        String service,
                        String location,
                        double price,
                        boolean available) {

        super(id, name,
                "Photographer",
                service,
                location,
                price,
                available);
    }

    @Override
    public void displayService() {
        System.out.println("Photography Services Available");
    }
}