import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class KalkulatorFigur extends JFrame {
    private JRadioButton kwadratRadioButton;
    private JRadioButton prostokątRadioButton;
    private JRadioButton trójkątRadioButton;
    private JRadioButton trapezRadioButton;
    private JRadioButton sześcianRadioButton;
    private JRadioButton prostopadłościanRadioButton;
    private JRadioButton walecRadioButton;
    private JRadioButton kulaRadioButton;
    private JTextField textBoka;
    private JTextField textPole;
    private JTextField textBokb;
    private JTextField textObwód;
    private JTextField textObjętość;
    private JTextField textWysokość;
    private JTextField textPromień;
    private JButton wyczyśćButton;
    private JButton obliczButton;
    private JPanel panelMain;
    private JPanel PanelText;
    private JRadioButton trójkątProstokątnyRadioButton;
    private  ButtonGroup bgroup =  new ButtonGroup();
    private float a, b, h, r;
    private double pole,obw,obj;
    String test;
    DecimalFormat df = new DecimalFormat("#.####");

    public static void main(String[] args) {
        KalkulatorFigur calcFigur = new KalkulatorFigur();
        calcFigur.setVisible(true);
    }

    public KalkulatorFigur() {
        super("Kalkultor figur");
        this.setContentPane(this.panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        setLayout(null);



        // grupa radio buttonów
        bgroup.add(kulaRadioButton);
        bgroup.add(kwadratRadioButton);
        bgroup.add(trapezRadioButton);
        bgroup.add(sześcianRadioButton);
        bgroup.add(prostokątRadioButton);
        bgroup.add(prostopadłościanRadioButton);
        bgroup.add(walecRadioButton);
        bgroup.add(trójkątRadioButton);
        bgroup.add(trójkątProstokątnyRadioButton);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object przycisk =e.getSource();

                // wyłączanie i włączanie pól tekstowych na dane
                if(przycisk == kulaRadioButton) {
                    for (Component c : PanelText.getComponents()) {
                        if (c instanceof JTextField) {
                            (   (JTextField) c).setText("");
                            c.setEnabled(false);
                        }}
                    textPromień.setEnabled(true);
                }
                else if(przycisk == kwadratRadioButton) {
                    for (Component c : PanelText.getComponents()) {
                        if (c instanceof JTextField) {
                            ((JTextField) c).setText("");
                            c.setEnabled(false);
                        }}
                    textBoka.setEnabled(true);
                }
                else if(przycisk == trapezRadioButton) {
                    for (Component c : PanelText.getComponents()) {
                        if (c instanceof JTextField) {
                            ((JTextField) c).setText("");
                            c.setEnabled(false);
                        }}
                    textBoka.setEnabled(true);
                    textBokb.setEnabled(true);
                    textWysokość.setEnabled(true);
                }
                else if(przycisk == sześcianRadioButton) {
                    for (Component c : PanelText.getComponents()) {
                        if (c instanceof JTextField) {
                            ((JTextField) c).setText("");
                            c.setEnabled(false);
                        }}
                    textBoka.setEnabled(true);
                }
                else if(przycisk == prostokątRadioButton) {
                    for (Component c : PanelText.getComponents()) {
                        if (c instanceof JTextField) {
                            ((JTextField) c).setText("");
                            c.setEnabled(false);
                        }}
                    textBoka.setEnabled(true);
                    textBokb.setEnabled(true);
                }
                else if(przycisk == prostopadłościanRadioButton) {
                    for (Component c : PanelText.getComponents()) {
                        if (c instanceof JTextField) {
                            ((JTextField) c).setText("");
                            c.setEnabled(false);
                        }}
                    textBoka.setEnabled(true);
                    textWysokość.setEnabled(true);
                }
                else if(przycisk == trójkątRadioButton) {
                    for (Component c : PanelText.getComponents()) {
                        if (c instanceof JTextField) {
                            ((JTextField) c).setText("");
                            c.setEnabled(false);
                        }}
                    textBoka.setEnabled(true);
                    textBokb.setEnabled(true);
                    textWysokość.setEnabled(true);
                }
                else if(przycisk == trójkątProstokątnyRadioButton) {
                    for (Component c : PanelText.getComponents()) {
                        if (c instanceof JTextField) {
                            ((JTextField) c).setText("");
                            c.setEnabled(false);
                        }}
                    textBoka.setEnabled(true);
                    textBokb.setEnabled(true);
                }
                else if(przycisk == walecRadioButton) {
                    for (Component c : PanelText.getComponents()) {
                        if (c instanceof JTextField) {
                            ((JTextField) c).setText("");
                            c.setEnabled(false);
                        }}
                    textPromień.setEnabled(true);
                    textWysokość.setEnabled(true);
                }

                // wyczyść inputy i zaznaczenie figury
                if(przycisk == wyczyśćButton) {
                    bgroup.clearSelection();
                    for (Component c : PanelText.getComponents()) {
                        if (c instanceof JTextField) {
                            ((JTextField) c).setText("");
                            c.setEnabled(false);
                        }}
                }
                // obliczenia
                else if(przycisk == obliczButton) {

                    for (Component c : PanelText.getComponents()) {
                        if (c instanceof JTextField) {
                            c.setBackground(Color.WHITE);
                            ((JTextField) c).setDisabledTextColor(Color.BLACK);
                        }
                    }

                    if (kulaRadioButton.isSelected()) {
                        r = Float.parseFloat(textPromień.getText());
                        obj = (4.0 / 3) * Math.PI * Math.pow(r, 3);
                        textObjętość.setText(String.valueOf(df.format(obj)));

                    } else if (kwadratRadioButton.isSelected()) {
                        a = Float.parseFloat(textBoka.getText());
                        pole = Math.pow(a, 2);
                        obw = 4 * a;
                        textPole.setText(String.valueOf(df.format(pole)));
                        textObwód.setText(String.valueOf(df.format(obw)));

                    } else if (trapezRadioButton.isSelected()) {
                        a = Float.parseFloat(textBoka.getText());
                        b = Float.parseFloat(textBokb.getText());
                        h = Float.parseFloat(textWysokość.getText());

                        pole = 0.5*(a+b)*h;
                        textPole.setText(String.valueOf(df.format(pole)));

                    } else if (sześcianRadioButton.isSelected()) {
                        a = Float.parseFloat(textBoka.getText());
                        pole = 6 * Math.pow(a, 2);
                        obj = Math.pow(a, 3);

                        textPole.setText(String.valueOf(df.format(pole)));
                        textObjętość.setText(String.valueOf(df.format(obj)));
                    } else if (prostokątRadioButton.isSelected()) {
                        a = Float.parseFloat(textBoka.getText());
                        b = Float.parseFloat(textBokb.getText());
                        pole = a * b;
                        obw = 2 * a + 2 * b;

                        textPole.setText(String.valueOf(df.format(pole)));
                        textObwód.setText(String.valueOf(df.format(obw)));
                    } else if (prostopadłościanRadioButton.isSelected()) {
                        a = Float.parseFloat(textBoka.getText());
                        h = Float.parseFloat(textWysokość.getText());
                        pole = 2 * Math.pow(a, 2) + 4 * a * h;
                        obj = Math.pow(a, 2) * h;

                        textPole.setText(String.valueOf(df.format(pole)));
                        textObjętość.setText(String.valueOf(df.format(obj)));
                    } else if (trójkątRadioButton.isSelected()) {
                        a = Float.parseFloat(textBoka.getText());
                        h = Float.parseFloat(textWysokość.getText());

                        if (a == b) { // trójkąt równoramienny
                            obw = 3 * a;
                            pole = 0.5 * a * h;
                        } else { // trójkąt różnoboczny
                            double c;
                            c = Math.pow(0.5 * a, 2) + Math.pow(h, 2);
                            obw = a + b + Math.sqrt(c);
                            pole = 0.5 * a * h;
                        }
                        textPole.setText(String.valueOf(df.format(pole)));
                        textObwód.setText(String.valueOf(df.format(obw)));
                    } else if (trójkątProstokątnyRadioButton.isSelected()) {
                        a = Float.parseFloat(textBoka.getText());
                        b = Float.parseFloat(textBokb.getText());
                        pole = 0.5 * a * b;
                        double c = Math.pow(a, 2) + Math.pow(b, 2);
                        obw = a + b + Math.sqrt(c);
                        textPole.setText(String.valueOf(df.format(pole)));
                        textObwód.setText(String.valueOf(df.format(obw)));
                    } else if (walecRadioButton.isSelected()) {
                        r = Float.parseFloat(textPromień.getText());
                        h = Float.parseFloat(textWysokość.getText());

                        pole = 2 * Math.PI * Math.pow(r, 2) + 2 * Math.PI * r * h;
                        obj = Math.PI * Math.pow(r, 2) * h;

                        textPole.setText(String.valueOf(df.format(pole)));
                        textObjętość.setText(String.valueOf(df.format(obj)));
                    }
                }
            }};

        // nasłuchiwanie przycisków
        kulaRadioButton.addActionListener(listener);
        kwadratRadioButton.addActionListener(listener);
        trapezRadioButton.addActionListener(listener);
        sześcianRadioButton.addActionListener(listener);
        prostokątRadioButton.addActionListener(listener);
        prostopadłościanRadioButton.addActionListener(listener);
        trójkątRadioButton.addActionListener(listener);
        trójkątProstokątnyRadioButton.addActionListener(listener);
        walecRadioButton.addActionListener(listener);
        wyczyśćButton.addActionListener(listener);
        obliczButton.addActionListener(listener);
    }
}
