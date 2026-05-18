package model;

public class CeremonyEvent extends WeddingEvent {

    public CeremonyEvent(
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
                "Ceremony"
        );
    }

    @Override
    public String displayEventDetails() {

        return "CEREMONY EVENT -> "
                + getCustomerName()
                + " | "
                + getVenue();
    }
}