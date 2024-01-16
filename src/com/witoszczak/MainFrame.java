package com.witoszczak;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    // -->> class variables
    private TopControlPanel topControlPanel;
    private PointsPanel pointsPanel;

    // -->> MainFrame class constructor
    public MainFrame(){

        super("Kalkulator Nauczyciela");

        setLayout(new BorderLayout());

        topControlPanel = new TopControlPanel();
        pointsPanel = new PointsPanel();

        topControlPanel.getTextModifier(new TextModifier() {
            @Override
            public void textCalculated(String text) {
                pointsPanel.setTextToDisplay(text);
            }
        });

        add(topControlPanel, BorderLayout.NORTH);
        add(pointsPanel, BorderLayout.CENTER);

        setSize(400,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }

}
