package ui;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AddVendorForm  extends JFrame {

    private String generateVendorId(){

        int count = 0;

        try{

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("src/vendors.txt")
                    );

            while(reader.readLine() != null){

                count++;
            }

            reader.close();

        }catch(Exception ex){

            ex.printStackTrace();
        }

        return "V" + (count + 1);
    }

    // ================= CONSTRUCTOR =================

    public AddVendorForm() {

        JFrame frame =
                new JFrame("Add Vendor");

        frame.setSize(700,700);

        frame.setLocationRelativeTo(null);

        frame.setLayout(null);

        frame.getContentPane().setBackground(
                new Color(245,245,245)
        );

        // ================= TITLE =================

        JLabel title =
                new JLabel("Add Vendor");

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        32
                )
        );

        title.setBounds(240,60,250,40);

        frame.add(title);

        // ================= VENDOR NAME =================

        JLabel nameLabel =
                new JLabel("Vendor Name");

        nameLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        nameLabel.setBounds(90,180,180,30);

        frame.add(nameLabel);

        JTextField nameField =
                new JTextField();

        nameField.setBounds(300,175,280,40);

        frame.add(nameField);

        // ================= SERVICE =================

        JLabel serviceLabel =
                new JLabel("Service");

        serviceLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        serviceLabel.setBounds(90,280,180,30);

        frame.add(serviceLabel);

        JTextField serviceField =
                new JTextField();

        serviceField.setBounds(300,275,280,40);

        frame.add(serviceField);

        // ================= CONTACT =================

        JLabel contactLabel =
                new JLabel("Contact");

        contactLabel.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        18
                )
        );

        contactLabel.setBounds(90,380,180,30);

        frame.add(contactLabel);

        JTextField contactField =
                new JTextField();

        contactField.setBounds(300,375,280,40);

        frame.add(contactField);

        // ================= BUTTON =================

        JButton addBtn =
                new JButton("Add Vendor");

        addBtn.setBounds(220,530,220,55);

        addBtn.setBackground(
                new Color(255,70,130)
        );

        addBtn.setForeground(Color.WHITE);

        addBtn.setFocusPainted(false);

        addBtn.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        22
                )
        );

        frame.add(addBtn);

        // ================= SAVE VENDOR =================

        addBtn.addActionListener(e -> {

            String name =
                    nameField.getText();

            String service =
                    serviceField.getText();

            String contact =
                    contactField.getText();

            // ===== VALIDATION =====

            if(
                    name.isEmpty()
                            ||
                            service.isEmpty()
                            ||
                            contact.isEmpty()
            ){

                JOptionPane.showMessageDialog(

                        null,

                        "Please Fill All Fields"
                );

                return;
            }

            try{

                FileWriter writer =
                        new FileWriter(
                                "src/vendors.txt",
                                true
                        );

                writer.write(

                        "Vendor ID: "
                                + generateVendorId()

                                + " | Vendor Name: "
                                + name

                                + " | Service: "
                                + service

                                + " | Contact: "
                                + contact

                                + "\n"
                );

                writer.close();

                JOptionPane.showMessageDialog(

                        null,

                        "Vendor Added Successfully"
                );

                // ===== CLEAR FIELDS =====

                nameField.setText("");

                serviceField.setText("");

                contactField.setText("");

            }catch(Exception ex){

                ex.printStackTrace();

                JOptionPane.showMessageDialog(

                        null,

                        "Error Saving Vendor"
                );
            }
        });

        // ================= SHOW FRAME =================

        frame.setVisible(true);
    }
}

