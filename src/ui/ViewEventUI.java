package ui;

import javax.swing.*;
import java.awt.*;

public class ViewEventUI {

    public ViewEventUI() {

        JFrame frame =
                new JFrame("View Events");

        frame.setSize(600,500);

        frame.setLocationRelativeTo(null);

        frame.setLayout(null);

        frame.getContentPane().setBackground(
                new Color(245,245,245)
        );

        JLabel title =
                new JLabel("View Event Details");

        title.setFont(
                new Font(
                        "Segoe UI",
                        Font.BOLD,
                        28
                )
        );

        title.setBounds(150,40,350,40);

        frame.add(title);

        JTextArea area =
                new JTextArea();

        area.setEditable(false);

        JScrollPane pane =
                new JScrollPane(area);

        pane.setBounds(50,120,480,280);

        frame.add(pane);

        try {

            java.io.BufferedReader reader =
                    new java.io.BufferedReader(
                            new java.io.FileReader("events.txt")
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                area.append(line + "\n");
            }

            reader.close();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(

                    null,

                    "Error Loading Events"
            );
        }

        frame.setVisible(true);
    }
}