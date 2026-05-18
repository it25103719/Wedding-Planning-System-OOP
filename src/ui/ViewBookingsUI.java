package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class ViewBookingsUI {
    public ViewBookingsUI() {

        JFrame frame =
                new JFrame("View Bookings");

        frame.setSize(900,500);

        frame.setLocationRelativeTo(null);

        frame.setLayout(new BorderLayout());

        // ================= TABLE =================

        String[] columns = {

                "Booking ID",
                "Customer Name",
                "Vendor Name",
                "Booking Date"
        };

        DefaultTableModel model =
                new DefaultTableModel(columns,0);

        JTable table = new JTable(model){

            public boolean isCellEditable(int row, int column){

                return false;
            }
        };

        table.setRowHeight(30);

        table.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        16
                )
        );

        table.getTableHeader().setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        16
                )
        );

        JScrollPane pane =
                new JScrollPane(table);

        frame.add(pane, BorderLayout.CENTER);

        // ================= READ FILE =================

        try{

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(
                                    "src/bookings.txt"
                            )
                    );

            String line;

            while((line = reader.readLine()) != null){

                String[] parts =
                        line.split("\\|");

                String id =
                        parts[0]
                                .replace("Booking ID:","")
                                .trim();

                String customer =
                        parts[1]
                                .replace("Customer Name:","")
                                .trim();

                String vendor =
                        parts[2]
                                .replace("Vendor Name:","")
                                .trim();

                String date =
                        parts[3]
                                .replace("Booking Date:","")
                                .trim();

                model.addRow(new Object[]{

                        id,
                        customer,
                        vendor,
                        date
                });
            }

            reader.close();

        }catch(Exception ex){

            JOptionPane.showMessageDialog(

                    null,

                    "No Bookings Found"
            );
        }

        frame.setVisible(true);
    }
}

