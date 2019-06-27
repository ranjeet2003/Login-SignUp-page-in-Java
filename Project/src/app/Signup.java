
/*<Applet code="Signup" width=800 height=800>
</applet>*/
package app;

import jdbc.Project;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Signup extends JFrame{

    public static void main(String[] args) {
        JFrame f = new JFrame("Title");

        JTextField t = new JTextField();
        t.setBounds(50, 50, 150, 20);
        JTextField t1 = new JTextField();
        t1.setBounds(50, 90, 150, 20);
        JTextField t2 = new JTextField();
        t2.setBounds(50, 130, 150, 20);
        JTextField t3 = new JTextField();
        t3.setBounds(50, 170, 150, 20);
        JTextField t4 = new JTextField();
        t4.setBounds(50, 210, 150, 20);
        JLabel l1 = new JLabel("Enter Name");
        l1.setBounds(50, 25, 100, 30);
        JLabel l2 = new JLabel("Enter DOB");
        l2.setBounds(50, 65, 100, 30);
        JLabel l3 = new JLabel("Mobile NO.");
        l3.setBounds(50, 105, 100, 30);
        JLabel l4 = new JLabel("Email");
        l4.setBounds(50, 145, 100, 30);
        JLabel l5 = new JLabel("User Name");
        l5.setBounds(50, 185, 100, 30);
        JLabel l6 = new JLabel("Password");
        l6.setBounds(50, 225, 100, 30);

        JButton b2 = new JButton("Sign up");//to create a button
        b2.setBounds(50, 280, 150, 30);
        // JButton b3 = new JButton("Login");//to create a button
       // b3.setBounds(250, 280, 150, 30);
        JPasswordField pf = new JPasswordField();
        pf.setBounds(50, 250, 150, 20);

        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String Name = t.getText();

                String DOB = t1.getText();

                String Mobile = t2.getText();

                String Email = t3.getText();

                String Username = t4.getText();

                char[] Password = pf.getPassword();
                Project p = new Project();
                p.con();
                int a = p.register(Name, DOB, Mobile, Email, Username, Password);
                if (a != -1) {
                   JOptionPane.showMessageDialog(f, "Data Saved");
                    t.setText(" ");
                    t1.setText(" ");
                    t2.setText(" ");
                    t3.setText(" ");
                    t4.setText(" ");
                    pf.setText("****");
                    Login  su=new Login();
                    su.setSize(500,500);
                su.setVisible(true);
                }

            }
            

        });
//         b3.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(java.awt.event.ActionEvent e) {
//                Signup  su=new Signup();
//                su.setVisible(true);
//                
//                
//           //     app2 = (Login)getAppletContext().getApplet("Login");
//            }
//             
//             
//             
//         });
        f.add(t);
        f.add(l1);
        f.add(pf);
        f.add(b2);
        //f.add(b3);
        f.add(t1);
        f.add(t2);
        f.add(t3);
        f.add(t4);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(l6);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);

    }

}
