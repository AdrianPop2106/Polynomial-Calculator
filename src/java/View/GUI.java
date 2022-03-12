package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame{
    private final JTextField polinomial1 = new JTextField(15);
    private final JTextField polinomial2 = new JTextField(15);
    private final JTextField result = new JTextField(20);
    private final ArrayList<JButton> button =new ArrayList<>(6);

    public GUI(){
        result.setEditable(false);
        this.setLocationRelativeTo(null);
        JPanel polinoame=new JPanel();

        JLabel pol1=new JLabel("Polinom 1");
        pol1.setBounds(7,0,80,30);
        polinomial1.setBounds(87,5,170,22);
        polinoame.add(polinomial1);
        polinoame.add(pol1);
        JLabel pol2=new JLabel("Polinom 2");
        pol2.setBounds(7,30,80,30);
        polinomial2.setBounds(87,35,170,22);
        polinoame.add(pol2);
        polinoame.add(polinomial2);
        polinoame.setLayout(null);

        JPanel butoane=new JPanel();
        button.add(new JButton("Adunare"));
        butoane.add(button.get(0));
        button.add(new JButton("Scadere"));
        butoane.add(button.get(1));
        button.add(new JButton("Inmultire"));
        butoane.add(button.get(2));
        button.add(new JButton("Impartire"));
        butoane.add(button.get(3));
        button.add(new JButton("Derivare"));
        butoane.add(button.get(4));
        button.add(new JButton("Integrare"));
        butoane.add(button.get(5));
        butoane.setLayout(new GridLayout(3,2));

        JPanel fin=new JPanel();
        JLabel rez=new JLabel("Rezultat");
        fin.add(rez);
        rez.setAlignmentX(Box.CENTER_ALIGNMENT);
        fin.add(result);
        result.setAlignmentX(Box.CENTER_ALIGNMENT);
        fin.setLayout(new FlowLayout());

        JPanel panou=new JPanel();
        panou.add(polinoame);
        panou.add(Box.createRigidArea(new Dimension(5,10)));
        panou.add(butoane);
        panou.add(Box.createRigidArea(new Dimension(5,10)));
        panou.add(fin);
        panou.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panou.setLayout(new BoxLayout(panou,BoxLayout.Y_AXIS));

        this.setContentPane(panou);

        this.setTitle("Calculator polinomial");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public String getPolinomial1(){return polinomial1.getText();}
    public String getPolinomial2(){return polinomial2.getText();}
    public void setResult(String text){
        result.setText(text);}
    public void visible(){
        this.setSize(300,350);
        this.setVisible(true);
    }

    public void addButtonListener(ActionListener a,int but){ button.get(but).addActionListener(a);}
}
