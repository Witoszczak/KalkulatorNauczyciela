package com.witoszczak;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kalkulator {

    //Elements of the window
    JFrame window;
    JPanel northPanel, topPanelNorth, centerPanelNorth, downPanelNorth;
    JPanel centerPanel;
    JLabel labelOne, labelTwo;
    JTextField textOne, textTwo;
    JTextArea oknoWynikow, oknoRozkladu;
    JButton calculate, clearResults;
    Font tekstDlaOknaWyniku = new Font("Times New Roman", Font.PLAIN, 40);

    //Main method
    public static void main(String[] args) {
        new Kalkulator();
    }

    //Main constructor
    public Kalkulator(){
        window = new JFrame("Kalkulator Punktacji");
        window.setSize(400,400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());

        northPanel = new JPanel();
        topPanelNorth = new JPanel();
        centerPanelNorth = new JPanel();
        downPanelNorth = new JPanel();

        labelOne = new JLabel("MAKS punkty      ");
        labelTwo = new JLabel("ZDOBYTE punkty");
        textOne = new JTextField(10);
        textTwo = new JTextField(10);

        topPanelNorth.add(labelOne);
        topPanelNorth.add(textOne);

        centerPanelNorth.add(labelTwo);
        centerPanelNorth.add(textTwo);

        calculate = new JButton("Przelicz");
        calculate.addActionListener(new calculateListener());
        clearResults = new JButton("Wyczyść");
        clearResults.addActionListener(new clearListener());

        downPanelNorth.add(calculate);
        downPanelNorth.add(clearResults);

        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.add(topPanelNorth);
        northPanel.add(centerPanelNorth);
        northPanel.add(downPanelNorth);



        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(Color.MAGENTA);
        oknoWynikow = new JTextArea();
        Border innerBorder = BorderFactory.createTitledBorder("");//"Rozkład punktów na oceny");
        Border outerBorder = BorderFactory.createEmptyBorder(15,15,15,15);
        oknoWynikow.setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        oknoWynikow.setBackground(Color.MAGENTA);
        centerPanel.add(oknoWynikow, BorderLayout.CENTER);

        String rozkladText = "\n    A:\n    B:\n    C:\n    D:\n";
        oknoRozkladu = new JTextArea();
        oknoRozkladu.setText(rozkladText);
        window.getContentPane().add(oknoRozkladu, BorderLayout.SOUTH);

        window.getContentPane().add(northPanel, BorderLayout.NORTH);
        window.getContentPane().add(centerPanel, BorderLayout.CENTER);
        window.setVisible(true);

    }

    private class calculateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            double gotPointNumber = Double.parseDouble(textTwo.getText());
            double maxPointNumber = Double.parseDouble(textOne.getText());

            double percentile = (gotPointNumber*100)/maxPointNumber;

            String ocena = "";
            if(percentile >=93){
                ocena = "ocena A";
            }else if (percentile >= 68 && percentile < 93){
                ocena = "ocena B";
            }else if(percentile >= 40 && percentile < 68){
                ocena = "ocena C";
            }else{
                ocena = "ocena D";
            }
            oknoWynikow.append(textTwo.getText() + " - " + ocena + "\n");

            double percentage100 = maxPointNumber;
            double percentageA  = (maxPointNumber * 93 )/ 100;
            double percentageB  = (maxPointNumber * 68 )/ 100;
            double percentageC  = (maxPointNumber * 40 )/ 100;
            double percentageD = 0;

            double percentageAA = percentageA -0.01;
            double percentageBB = percentageB -0.01;
            double percentageCC = percentageC -0.01;
            double percentageDD = percentageD -0.01;

            String rozklad = String.format("A : %.2f - %.2f\nB : %.2f - %.2f\nC : %.2f - %.2f\nD : %.2f - %.2f\n",percentageA, percentage100, percentageB, percentageAA,percentageC, percentageBB,percentageD, percentageCC);

            oknoRozkladu.setText(rozklad);

        }
    }

    private class clearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            oknoRozkladu.setText("\n    A:\n    B:\n    C:\n    D:\n");
            oknoWynikow.setText("");
        }
    }
}
