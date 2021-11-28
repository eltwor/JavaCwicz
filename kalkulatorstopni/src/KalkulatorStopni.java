import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KalkulatorStopni extends JFrame {
    private JTextField stopnieCtext;
    private JTextField stopnieFtext;
    private JButton konwertujButton;
    private JButton wyczyśćButton;
    private JButton wyjścieButton;
    private JRadioButton czcionkaMałaRadioButton;
    private JRadioButton czcionkaŚredniaRadioButton;
    private JRadioButton czcionkaDużaRadioButton;
    private JCheckBox wielkieLiteryCheckBox;
    private JButton resetujButton;
    private JPanel panel1;
    private  ButtonGroup bgroup =  new ButtonGroup();
    private double tempC, tempF;

    public KalkulatorStopni() {
        super("Konwertowanie stopni");
        this.setContentPane(this.panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        setLayout(null);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object wprzycisk = e.getSource();
                if (wprzycisk == konwertujButton || wprzycisk == stopnieCtext) {
                    tempC = Double.parseDouble(stopnieCtext.getText());
                    tempF = 32.00 + (9.0/5.0) * tempC;
                    stopnieFtext.setText(String.valueOf(tempF));
                }
                else if (wprzycisk == wyjścieButton)
                {
                    dispose();
                } else if (wprzycisk == wyczyśćButton) {
                    stopnieFtext.setText("");
                    stopnieCtext.setText("");
                }
                else if (wprzycisk == wielkieLiteryCheckBox) {
                    if(wielkieLiteryCheckBox.isSelected()) {
                        stopnieFtext.setFont(new Font("Sans Serif",Font.BOLD,18));
                    } else {
                        stopnieFtext.setFont(new Font("Sans Serif", Font.PLAIN, 12));
                    }
                }
                else if (wprzycisk == czcionkaMałaRadioButton) {
                    stopnieFtext.setFont(new Font("Sans Serif",Font.PLAIN,7));
                } else if (wprzycisk == czcionkaŚredniaRadioButton) {
                    stopnieFtext.setFont(new Font("Sans Serif", Font.PLAIN,12));
                } else if (wprzycisk == czcionkaDużaRadioButton) {
                    stopnieFtext.setFont(new Font("Sans Serif",Font.PLAIN,16));
                } else if (wprzycisk == resetujButton) {
                    bgroup.add(wielkieLiteryCheckBox);
                    bgroup.add(czcionkaMałaRadioButton);
                    bgroup.add(czcionkaDużaRadioButton);
                    bgroup.add(czcionkaŚredniaRadioButton);
                    bgroup.clearSelection();
                    stopnieFtext.setFont(new Font("Sans Serif",Font.PLAIN,12));
                }}};

        resetujButton.addActionListener(listener);
        konwertujButton.addActionListener(listener);
        wyczyśćButton.addActionListener(listener);
        wyjścieButton.addActionListener(listener);
        czcionkaMałaRadioButton.addActionListener(listener);
        czcionkaDużaRadioButton.addActionListener(listener);
        czcionkaŚredniaRadioButton.addActionListener(listener);
        wielkieLiteryCheckBox.addActionListener(listener);
    }

    public static void main(String[] args) {
        KalkulatorStopni calcTemp = new KalkulatorStopni();
        calcTemp.setVisible(true);
    }

    }

