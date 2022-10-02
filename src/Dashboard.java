import javax.swing.*;
import java.awt.*;

class Dash extends JFrame {

    Container c;
    JLabel l1 , l2,l3,l4,l5;
    JTextField java , javaLab , iit , evs;

    JButton check;

    Dash() {

        c = getContentPane();
        setTitle("Grading System");

        ImageIcon image = new ImageIcon("resource/grade.png");
        setIconImage(image.getImage());

        setBounds(100, 100, 400, 400);
        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);


        Font font = new Font("Serif", Font.BOLD, 20);
        l1 = new JLabel();
        l1.setText("Student Grade Calculation");
        l1.setFont(font);
        l1.setForeground(Color.RED);
        l1.setBounds(100, 50, 250, 20);

        Font fontLabel = new Font("Serif", Font.PLAIN, 12);
        l2 = new JLabel("Advanced Java Enterprise : ");
        l2.setFont(fontLabel);
        l2.setBounds(50 , 80 , 200,20);

        java = new JTextField();
        java.setFont(fontLabel);
        java.setBounds(200 , 80,100,20);

        l3 = new JLabel("Advanced Java Enterprise Lab : ");
        l3.setFont(fontLabel);
        l3.setBounds(50 , 100 , 200,20);


        javaLab = new JTextField();
        javaLab.setFont(fontLabel);
        javaLab.setBounds(200 , 100,100,20);

        l4 = new JLabel("IIT : ");
        l4.setFont(fontLabel);
        l4.setBounds(50 , 120 , 200,20);


        iit = new JTextField();
        iit.setFont(fontLabel);
        iit.setBounds(200 , 120,100,20);

        l5 = new JLabel("Environmental Science : ");
        l5.setFont(fontLabel);
        l5.setBounds(50 , 140 , 200,20);

        evs = new JTextField();
        evs.setFont(fontLabel);
        evs.setBounds(200 , 140,100,20);

        check = new JButton();
        check.setText("Check");
        check.setFont(font);
        check.setBounds(100,170,150,40);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.white);


        c.add(l1);
        c.add(l2);
        c.add(java);
        c.add(l3);
        c.add(javaLab);
        c.add(l4);
        c.add(iit);
        c.add(l5);
        c.add(evs);
        c.add(check);

        setVisible(true);

    }

}

    public class Dashboard{

    public static void main(String[] args){


        new Dash();
    }

    }
