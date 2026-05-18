package model;

public class EngagementEvent extends WeddingEvent {

    public EngagementEvent(
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
                "Engagement"
        );
    }

    @Override
    public String displayEventDetails() {

        return "ENGAGEMENT EVENT -> "
                + getCustomerName()
                + " | "
                + getVenue();
    }
}