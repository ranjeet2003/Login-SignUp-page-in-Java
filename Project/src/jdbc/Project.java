package jdbc;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Project {
  
        String url="jdbc:derby://localhost:1527/sample";
        String user="app";
        String pass="app";
        int a;
          Connection con=null;
          public void con()
          {
            try {
                con=DriverManager.getConnection(url,user,pass);
            } catch (SQLException ex) {
                Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        public int register(String Name,String DOB,String Mobile,String Email, String Username,char[] Password){
        String q="insert into CLIENT_DATA values(?,?,?,?,?,?)";
      
        try {
            
            PreparedStatement pst=con.prepareStatement(q);
            pst.setString(1, Name);
            pst.setString(2, DOB);
            pst.setString(3, Mobile);
            pst.setString(4, Email);
            pst.setString(5, Username);
            String p=new String(Password);
            pst.setString(6,p);
             a=pst.executeUpdate();
//            if(a!=-1)
//            {
//                System.out.println("Data is registered!");
//            }       
            
        } catch (SQLException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
            }}
         return a;}
        
        public String login(String login)
        {
          //  String q="select password from CLIENT_DATA where username=?";
   String p=null;
        try {
          //  con=DriverManager.getConnection(url,user,pass);
            //PreparedStatement pst=con.prepareStatement("select password from CLIENT_DATA where username="+login);
            
            Statement pst=con.createStatement();//
          //  pst.setString(1, login);
          
             ResultSet rs=pst.executeQuery("select * from CLIENT_DATA where username='"+login+"'");
              
             while(rs.next())
           {
                 p=rs.getString("PASSWORD");
                 System.out.println(p);
                
           }            
             } catch (SQLException ex) {
            System.out.println("ERROR");
        }
        finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
            }}
            
            return p;
        }
    
}

   
