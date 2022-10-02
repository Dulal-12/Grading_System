import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import static java.lang.Class.forName;

class Sign extends JFrame{

    Container c;
    JLabel l1,l2,l3 , l4,l5;
    JTextField userId;
    JPasswordField ps;

    JButton signBtn;
    Sign(){

        c = getContentPane();
        setTitle("Grading System");

        ImageIcon image = new ImageIcon("resource/grade.png");
        setIconImage(image.getImage());

        setBounds(100,100,400,400);
        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Font font = new Font("Serif" , Font.BOLD , 14);
        l1 = new JLabel();
        l1.setText("SignUp");
        l1.setFont(font);
        l1.setBounds(180,50,150,30);

        Font fontLabel = new Font("Serif" , Font.PLAIN , 12);

        l2 = new JLabel();
        l2.setText("Student Id: ");
        l2.setFont(fontLabel);
        l2.setBounds(100,80,70,30);

        l3 = new JLabel();
        l3.setText("Password: ");
        l3.setFont(fontLabel);
        l3.setBounds(100,120,70,30);


        userId = new JTextField();
        userId.setFont(fontLabel);
        userId.setForeground(Color.DARK_GRAY);
        userId.setBounds(160,90,100,20);


        ps = new JPasswordField();
        ps.setEchoChar('*');
        ps.setForeground(Color.DARK_GRAY);
        ps.setBounds(160,130,100,20);



        signBtn = new JButton();
        signBtn.setText("SignUp");
        signBtn.setFont(font);
        signBtn.setBounds(170,170,80,30);
        signBtn.setBackground(Color.BLACK);
        signBtn.setForeground(Color.white);


        l4 = new JLabel();
        l4.setText("Haven account? Login");
        l4.setFont(fontLabel);
        l4.setForeground(Color.BLUE);
        l4.setBounds(100 , 210 , 150,20);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        l4.setCursor(cursor);

        l5 = new JLabel();
        l5.setFont(fontLabel);
        l5.setForeground(Color.BLACK);
        l5.setBounds(100 , 250 , 150,20);

        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(userId);
        c.add(ps);
        c.add(signBtn);
        c.add(l5);

        l4.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {

                new LoginFrame();
                dispose();

            }
        });

        signBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String i = userId.getText().toString();
                String password = ps.getText().toString();
                l5.setText("");

                if(!i.isEmpty() && !password.isEmpty()){

                    boolean c;
                    c = i.matches("-?\\d+(\\.\\d+)?");
                    if(c){
                        if(password.length() > 7){

                            int id = Integer.parseInt(i);
                            try{
                               Class.forName("com.mysql.jdbc.Driver");
                               Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/gradingsystem", "root","");
                               String query="insert into information values(?,?)";
                               PreparedStatement ps=conn.prepareStatement(query);
                               ps.setInt(1, id);
                               ps.setString(2, password);
                               int ix=ps.executeUpdate();
                               System.out.println("no. of rows updated ="+ix);
                               ps.close();
                               conn.close();
                               new LoginFrame();
                               dispose();

                            }catch(Exception ex){
                                ex.printStackTrace();
                            }
                        }
                        else{
                            l5.setText("Your password less than 7 digit");
                        }
                    }
                    else{
                        l5.setText("Student Id only Digit");
                    }
                }
                else{
                    //Toast
                    l5.setText("Please fill up input field");
                }

            }
        });
        setVisible(true);
    }
}


