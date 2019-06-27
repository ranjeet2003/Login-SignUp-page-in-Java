
/*<Applet code="Login" width=800 height=800>
</applet>*/
package app;


import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import jdbc.Project;

public class Login extends JFrame{

    public static void main(String[] args) {
        JFrame f=new JFrame("Title");
         JTextField t=new JTextField();
          t.setBounds(50,50,150,20);
       
         JLabel l1=new JLabel("username"); 
        l1.setBounds(50, 25, 100, 30);
         JLabel l2=new JLabel("password");  
        l2.setBounds(50, 75, 100, 30);
         JButton b1=new JButton("login");//to create a button
          b1.setBounds(50,130,150,30);
         JButton b2=new JButton("Sign up");//to create a button
          b2.setBounds(50,180,150,30);
          JTextField pf=new JTextField();
          pf.setBounds(50, 100, 150, 20);
        b1.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String a=t.getText();
                 
           
          String b1=pf.getText();
                
        String url="jdbc:derby://localhost:1527/sample";
        String user="app";
        String pass="app";
        
          
         String p=null;
           try {
          Connection con=DriverManager.getConnection(url,user,pass);
            //PreparedStatement pst=con.prepareStatement("select password from CLIENT_DATA where username="+login);
            
            Statement pst=con.createStatement();//
          //  pst.setString(1, login);
          
             ResultSet rs=pst.executeQuery("select * from CLIENT_DATA where username='"+b1+"'");
              
             while(rs.next())
           {
                  p=rs.getString("PASSWORD");
                 System.out.println(p);
                
           }            
             } catch (SQLException ex) {
            System.out.println("ERROR");
        }
                if(b1.equals(p))
                {
                    JOptionPane.showMessageDialog(f, "Valid login!!!");
                } 
            }}); 
//        b2.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(java.awt.event.ActionEvent e) {
//                String s=e.getActionCommand();
//                if(s.equals("Sign up")){
//            Login l=new Login();
//           l.coon();
//                  
//              
//                }
//            }
//        });
        f.add(b1);f.add(t);f.add(l1);f.add(l2);f.add(pf);f.add(b2);
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        
       
        
        
        
    }
    
}
