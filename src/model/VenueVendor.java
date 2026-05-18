package model;

public class VenueVendor extends Vendor {

    public VenueVendor(int id, String name,
                       String service,
                       String location,
                       double price,
                       boolean available) {

        super(id, name,
                "Venue",
                service,
                location,
                price,
                available);
    }

    @Override
    public void displayService() {
        System.out.println("Venue Booking Services Available");
    }
}