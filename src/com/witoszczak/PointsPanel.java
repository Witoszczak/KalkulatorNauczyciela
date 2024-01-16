package com.witoszczak;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PointsPanel extends JPanel {

    private String textToDisplay = "*** podaj punktację i kliknij przycisk... ***";
    private JTextArea textArea;
    Font tekstDlaOknaWyniku = new Font("Times New Roman", Font.PLAIN, 22);

    public PointsPanel(){

        textArea = new JTextArea();
        textArea.setFont(tekstDlaOknaWyniku);
        textArea.setText(textToDisplay);

        Border innerBorder = BorderFactory.createTitledBorder("Rozkład punktów na oceny");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setLayout(new BorderLayout());

        add(new JScrollPane(textArea), BorderLayout.CENTER);

    }

    public String getTextToDisplay() {
        return textToDisplay;
    }

    public void setTextToDisplay(String textToDisplay) {
        textArea.setText(textToDisplay);
    }
}
