package com.witoszczak;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopControlPanel extends JPanel implements ActionListener {

    private JTextField maxPointsField, gotPointsField;
    private JButton calculateButton, calculateButton16;
    private JLabel maxPointsLabel,gotPointsLabel;

    private TextModifier textModifier;

    public TopControlPanel(){

        setBorder(BorderFactory.createTitledBorder("Generowanie rozkładu ocen dla danej punktacji"));

        maxPointsLabel = new JLabel("Podaj maksymalną liczbę punktów: ");
        maxPointsField = new JTextField(10);
        gotPointsLabel = new JLabel("Podaj zdobytą liczbę punktów: ");
        gotPointsField = new JTextField(10);

        calculateButton = new JButton("Przelicz punktację");
        calculateButton.addActionListener(this);

//        calculateButton16 = new JButton("Przelicz punktację 1-6");
//        calculateButton.addActionListener(this);

        setLayout(new BorderLayout());

        add(maxPointsLabel, BorderLayout.WEST);
        add(maxPointsField, BorderLayout.CENTER);
        add(gotPointsLabel, BorderLayout.NORTH);
        add(gotPointsField, BorderLayout.NORTH);

        add(calculateButton, BorderLayout.SOUTH);
//        add(calculateButton16, BorderLayout.NORTH);

    }

    public void getTextModifier(TextModifier text){
        this.textModifier = text;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton)e.getSource();
        double gotPointNumber = Double.parseDouble(gotPointsField.getText());
        double maxPointNumber = Double.parseDouble(maxPointsField.getText());

        double percentage100 = maxPointNumber;
        double percentageA  = (maxPointNumber * 93 )/ 100;
        double percentageB  = (maxPointNumber * 68 )/ 100;
        double percentageC  = (maxPointNumber * 40 )/ 100;
        double percentageD = 0;

        double percentage6  = (maxPointNumber * 90 )/ 100;
        double percentage5  = (maxPointNumber * 80 )/ 100;
        double percentage4  = (maxPointNumber * 70 )/ 100;
        double percentage3  = (maxPointNumber * 60 )/ 100;
        double percentage2  = (maxPointNumber * 50 )/ 100;
        double percentage1  = 0;

        double percentageAA = percentageA -0.01;
        double percentageBB = percentageB -0.01;
        double percentageCC = percentageC -0.01;
        double percentageDD = percentageD -0.01;

        double percentageGot = (gotPointNumber * 100)/ maxPointNumber;

        if (clicked == calculateButton){
           textModifier.textCalculated(gotPointNumber + " pkt. to: " + percentageGot + "%"
                                        + "\n\n\n *** Rozkład Ocen A B C D ***\n\n"
                                        + "       " + percentageA + " - " + percentage100 + " --- ocena A\n\n"
                                        + "       " + percentageB + " - " + percentageAA + " --- ocena B\n\n"
                                        + "       " + percentageC + " - " + percentageBB + " --- ocena C\n\n"
                                        + "       " + percentageD + " - " + percentageCC + " --- ocena D\n\n");
//                                        + "\n\n *** Rozkład Ocen 1...6 ***\n"
//                                        + percentage6 + " - " + percentage100 + " --- ocena 6\n"
//                                        + percentage5 + " - " + percentage6 + " --- ocena 5\n"
//                                        + percentage4 + " - " + percentage5 + " --- ocena 4\n"
//                                        + percentage3 + " - " + percentage4 + " --- ocena 3\n"
//                                        + percentage2 + " - " + percentage3 + " --- ocena 2\n"
//                                        + percentage1 + " - " + percentage2 + " --- ocena 1\n");
           //textModifier.textCalculated(String.valueOf(maxPointNumber));
        }

    }
}
