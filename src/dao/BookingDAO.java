package dao;

import model.Booking;

import java.io.*;
import java.util.ArrayList;

public class BookingDAO {

    private final String FILE_PATH = "bookings.txt";

    // ADD BOOKING

    public void addBooking(Booking booking) {

        try {

            FileWriter writer =
                    new FileWriter(FILE_PATH, true);

            writer.write(
                    booking.getBookingId()
                            + " | "
                            + booking.getCustomerName()
                            + " | "
                            + booking.getVendorName()
                            + " | "
                            + booking.getBookingDate()
                            + "\n"
            );

            writer.close();

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    // READ BOOKINGS

    public ArrayList<String> getAllBookings() {

        ArrayList<String> bookings =
                new ArrayList<>();

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(FILE_PATH)
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                bookings.add(line);
            }

            reader.close();

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return bookings;
    }

    // UPDATE BOOKING

    public void updateBooking(
            String bookingId,
            String newVendor,
            String newDate
    ) {

        ArrayList<String> bookings =
                new ArrayList<>();

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(FILE_PATH)
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data =
                        line.split("\\|");

                String id =
                        data[0].trim();

                if (id.equals(bookingId)) {

                    line =
                            id
                                    + " | "
                                    + data[1].trim()
                                    + " | "
                                    + newVendor
                                    + " | "
                                    + newDate;
                }

                bookings.add(line);
            }

            reader.close();

            FileWriter writer =
                    new FileWriter(FILE_PATH);

            for (String booking : bookings) {

                writer.write(booking + "\n");
            }

            writer.close();

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    // DELETE BOOKING

    public void deleteBooking(String bookingId) {

        ArrayList<String> bookings =
                new ArrayList<>();

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(FILE_PATH)
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data =
                        line.split("\\|");

                String id =
                        data[0].trim();

                if (!id.equals(bookingId)) {

                    bookings.add(line);
                }
            }

            reader.close();

            FileWriter writer =
                    new FileWriter(FILE_PATH);

            for (String booking : bookings) {

                writer.write(booking + "\n");
            }

            writer.close();

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }
}