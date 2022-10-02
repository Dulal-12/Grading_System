import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

class LoginFrame extends JFrame  {

    Container c;
    JLabel l1,l2,l3 , l4,l5;
    JTextField userId;
    JPasswordField ps;

    JButton loginBtn;
    LoginFrame(){

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
        l1.setText("Login");
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



        loginBtn = new JButton();
        loginBtn.setText("Login");
        loginBtn.setFont(font);
        loginBtn.setBounds(170,170,80,30);
        loginBtn.setBackground(Color.BLACK);
        loginBtn.setForeground(Color.white);


        l4 = new JLabel();
        l4.setText("Haven't account? Sign Up");
        l4.setFont(fontLabel);
        l4.setForeground(Color.BLUE);
        l4.setBounds(100 , 210 , 150,20);
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        l4.setCursor(cursor);

        l5 = new JLabel();
        l5.setFont(fontLabel);
        l5.setForeground(Color.BLACK);
        l5.setBounds(140 , 250 , 250,20);




        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(l4);
        c.add(userId);
        c.add(ps);
        c.add(loginBtn);
        c.add(l5);




        l4.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {

               new Sign();
               dispose();

            }
        });


        loginBtn.addActionListener(new ActionListener() {
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
                                Statement stmt = conn.createStatement();
                                ResultSet rs = stmt.executeQuery("SELECT * from information");
                                while(rs.next()){
                                    int stuId = rs.getInt(1);
                                    String pass = rs.getString(2);
                                    if(stuId == id && password.equals(pass)){
                                        new Dash();
                                        dispose();
                                    }
                                }

                                l5.setText("Please provide write id and password");


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


public class Login {

    public static void main(String[] args) {

        new LoginFrame();

    }
}