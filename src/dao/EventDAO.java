package dao;

import model.WeddingEvent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class EventDAO {

    private final String FILE_PATH =
            "events.txt";

    // ========== ADD EVENT ==========

    public void addEvent(
            WeddingEvent event
    ) {

        try {

            FileWriter writer =
                    new FileWriter(
                            FILE_PATH,
                            true
                    );

            writer.write(

                    "Event ID: "
                            + event.getEventId()

                            + " | Customer Name: "
                            + event.getCustomerName()

                            + " | Venue: "
                            + event.getVenue()

                            + " | Event Date: "
                            + event.getEventDate()

                            + " | Event Type: "
                            + event.getEventType()

                            + "\n"
            );

            writer.close();

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    // ========== VIEW EVENTS ==========

    public ArrayList<String> getAllEvents() {

        ArrayList<String> events =
                new ArrayList<>();

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(FILE_PATH)
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                events.add(line);
            }

            reader.close();

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return events;
    }

    // ========== DELETE EVENT ==========

    public void deleteEvent(int eventId) {

        ArrayList<String> events =
                new ArrayList<>();

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(FILE_PATH)
                    );

            String line;

            while((line = reader.readLine()) != null) {

                if(!line.contains(
                        "Event ID: " + eventId
                )) {

                    events.add(line);
                }
            }

            reader.close();

            FileWriter writer =
                    new FileWriter(FILE_PATH);

            for(String event : events) {

                writer.write(event + "\n");
            }

            writer.close();

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }
}