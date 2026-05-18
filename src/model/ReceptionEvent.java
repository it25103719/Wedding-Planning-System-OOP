package model;

public class ReceptionEvent extends WeddingEvent {

    public ReceptionEvent(
            int eventId,
            String customerName,
            String venue,
            String eventDate
    ) {

        super(
                eventId,
                customerName,
                venue,
                eventDate,
                "Reception"
        );
    }

    @Override
    public String displayEventDetails() {

        return "RECEPTION EVENT -> "
                + getCustomerName()
                + " | "
                + getVenue();
    }
}