package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class ViewVendorsUI extends JFrame {

    JTable table;
    DefaultTableModel model;

    public ViewVendorsUI() {

        setTitle("View Vendors");

        setSize(850,500);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        getContentPane().setBackground(
                new Color(245,245,245)
        );

        // ================= TITLE =================

        JLabel title =
                new JLabel(
                        "Vendor List",
                        JLabel.CENTER
                );

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        24
                )
        );

        add(title, BorderLayout.NORTH);

        // ================= TABLE =================

        String[] columns = {

                "Vendor ID",
                "Vendor Name",
                "Service",
                "Contact"
        };

        model =
                new DefaultTableModel(columns,0);

        table =
                new JTable(model){

                    public boolean isCellEditable(
                            int row,
                            int column
                    ){

                        return false;
                    }
                };

        table.setRowHeight(30);

        table.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        15
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

        add(pane, BorderLayout.CENTER);

        // ================= LOAD DATA =================

        loadVendors();

        // ================= TABLE CLICK =================

        table.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    public void mouseClicked(
                            java.awt.event.MouseEvent evt
                    ) {

                        int row =
                                table.getSelectedRow();

                        String id =
                                model.getValueAt(row,0)
                                        .toString();

                        String name =
                                model.getValueAt(row,1)
                                        .toString();

                        String service =
                                model.getValueAt(row,2)
                                        .toString();

                        String contact =
                                model.getValueAt(row,3)
                                        .toString();

                        new VendorDetailsUI(
                                id,
                                name,
                                service,
                                contact
                        );
                    }
                }
        );

        setVisible(true);
    }

    // ================= LOAD FILE METHOD =================

    private void loadVendors() {

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(
                                    "src/vendors.txt"
                            )
                    );

            String line;

            while((line = reader.readLine()) != null){

                String[] parts =
                        line.split("\\|");

                String id =
                        parts[0]
                                .replace("Vendor ID:","")
                                .trim();

                String name =
                        parts[1]
                                .replace("Vendor Name:","")
                                .trim();

                String service =
                        parts[2]
                                .replace("Service:","")
                                .trim();

                String contact =
                        parts[3]
                                .replace("Contact:","")
                                .trim();

                model.addRow(
                        new Object[]{

                                id,
                                name,
                                service,
                                contact
                        }
                );
            }

            reader.close();

        } catch(Exception ex){

            JOptionPane.showMessageDialog(

                    this,

                    "No Vendors Found"
            );
        }
    }
}