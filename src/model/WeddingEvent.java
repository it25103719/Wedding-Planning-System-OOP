package model;

public class WeddingEvent {

    private int eventId;
    private String customerName;
    private String venue;
    private String eventDate;
    private String eventType;

    public WeddingEvent(
            int eventId,
            String customerName,
            String venue,
            String eventDate,
            String eventType
    ) {

        this.eventId = eventId;
        this.customerName = customerName;
        this.venue = venue;
        this.eventDate = eventDate;
        this.eventType = eventType;
    }

    public int getEventId() {
        return eventId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getVenue() {
        return venue;
    }

    public String getEventDate() {
        return eventDate;
    }

    public String getEventType() {
        return eventType;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String displayEventDetails() {

        return "Event ID: " + eventId +
                " | Customer: " + customerName +
                " | Venue: " + venue +
                " | Date: " + eventDate +
                " | Type: " + eventType;
    }
}