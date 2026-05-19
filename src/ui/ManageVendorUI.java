package ui;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ManageVendorUI extends JFrame {


        public ManageVendorUI() {

            JFrame frame =
                    new JFrame("Manage Vendors");

            frame.setSize(700,550);

            frame.setLocationRelativeTo(null);

            frame.setLayout(null);

            frame.getContentPane().setBackground(
                    new Color(245,245,245)
            );

            // ================= TITLE =================

            JLabel title =
                    new JLabel("Update / Delete Vendor");

            title.setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            28
                    )
            );

            title.setBounds(140,30,400,40);

            frame.add(title);

            // ================= VENDOR ID =================

            JLabel idLabel =
                    new JLabel("Vendor ID");

            idLabel.setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            18
                    )
            );

            idLabel.setBounds(60,120,140,30);

            frame.add(idLabel);

            JTextField idField =
                    new JTextField();

            idField.setBounds(250,120,280,35);

            frame.add(idField);

            // ================= VENDOR NAME =================

            JLabel nameLabel =
                    new JLabel("New Name");

            nameLabel.setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            18
                    )
            );

            nameLabel.setBounds(60,190,140,30);

            frame.add(nameLabel);

            JTextField nameField =
                    new JTextField();

            nameField.setBounds(250,190,280,35);

            frame.add(nameField);

            // ================= SERVICE =================

            JLabel serviceLabel =
                    new JLabel("New Service");

            serviceLabel.setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            18
                    )
            );

            serviceLabel.setBounds(60,260,140,30);

            frame.add(serviceLabel);

            JTextField serviceField =
                    new JTextField();

            serviceField.setBounds(250,260,280,35);

            frame.add(serviceField);

            // ================= CONTACT =================

            JLabel contactLabel =
                    new JLabel("New Contact");

            contactLabel.setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            18
                    )
            );

            contactLabel.setBounds(60,330,140,30);

            frame.add(contactLabel);

            JTextField contactField =
                    new JTextField();

            contactField.setBounds(250,330,280,35);

            frame.add(contactField);

            // ================= UPDATE BUTTON =================

            JButton updateBtn =
                    new JButton("Update Vendor");

            updateBtn.setBounds(100,430,190,45);

            updateBtn.setBackground(
                    new Color(230,200,150)
            );

            updateBtn.setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            16
                    )
            );

            frame.add(updateBtn);

            // ================= DELETE BUTTON =================

            JButton deleteBtn =
                    new JButton("Delete Vendor");

            deleteBtn.setBounds(350,430,190,45);

            deleteBtn.setBackground(
                    new Color(255,120,140)
            );

            deleteBtn.setForeground(Color.WHITE);

            deleteBtn.setFont(
                    new Font(
                            "Segoe UI",
                            Font.BOLD,
                            16
                    )
            );

            frame.add(deleteBtn);

            // ================= UPDATE =================

            updateBtn.addActionListener(e -> {

                try{

                    File file =
                            new File("src/vendors.txt");

                    BufferedReader reader =
                            new BufferedReader(
                                    new FileReader(file)
                            );

                    ArrayList<String> lines =
                            new ArrayList<>();

                    String line;

                    while((line = reader.readLine()) != null){

                        if(line.contains(
                                "Vendor ID: "
                                        + idField.getText()
                        )){

                            line =
                                    "Vendor ID: "
                                            + idField.getText()

                                            + " | Vendor Name: "
                                            + nameField.getText()

                                            + " | Service: "
                                            + serviceField.getText()

                                            + " | Contact: "
                                            + contactField.getText();
                        }

                        lines.add(line);
                    }

                    reader.close();

                    FileWriter writer =
                            new FileWriter(file);

                    for(String l : lines){

                        writer.write(l + "\n");
                    }

                    writer.close();

                    JOptionPane.showMessageDialog(

                            null,

                            "Vendor Updated!"
                    );

                }catch(Exception ex){

                    ex.printStackTrace();
                }
            });

            // ================= DELETE =================

            deleteBtn.addActionListener(e -> {

                try{

                    File file =
                            new File("src/vendors.txt");

                    BufferedReader reader =
                            new BufferedReader(
                                    new FileReader(file)
                            );

                    ArrayList<String> lines =
                            new ArrayList<>();

                    String line;

                    while((line = reader.readLine()) != null){

                        if(!line.contains(
                                "Vendor ID: "
                                        + idField.getText()
                        )){

                            lines.add(line);
                        }
                    }

                    reader.close();

                    FileWriter writer =
                            new FileWriter(file);

                    for(String l : lines){

                        writer.write(l + "\n");
                    }

                    writer.close();

                    JOptionPane.showMessageDialog(

                            null,

                            "Vendor Deleted!"
                    );

                }catch(Exception ex){

                    ex.printStackTrace();
                }
            });

            frame.setVisible(true);
        }
    }

