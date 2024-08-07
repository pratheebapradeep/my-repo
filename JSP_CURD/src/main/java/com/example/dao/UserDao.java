package com.example.dao;

  
import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;  
import com.example.bean.*;  
public class UserDao 
{  
  
public static Connection getConnection()
{  
    Connection con=null;  
    try
    {  
        Class.forName("com.mysql.jdbc.Driver");  
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb","root","pratheeba23");  
        System.out.println(con);
    }
    catch(Exception e)
    {
    	System.out.println(e);
    }  
    return con;  
    
}  
public static int save(User u)
{  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement(  
"insert into register(name,accountno,password,email,sex,country,balance) values(?,?,?,?,?,?,?)");  
        ps.setString(1,u.getName()); 
        ps.setString(2,u.getAccountno());
        ps.setString(3,u.getPassword());  
        ps.setString(4,u.getEmail());  
        ps.setString(5,u.getSex());  
        ps.setString(6,u.getCountry());
        ps.setString(7,u.getBalance());
       
        status=ps.executeUpdate();  
        System.out.println(u);
    
    }
    catch(Exception e)
    {
    	System.out.println(e);
    }  
    return status;  
}  
public static int update(User u)
{  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement(  
"update register set name=?,accountno=?,password=?,email=?,sex=?,country=?,balance=? where id=?");  
        ps.setString(1,u.getName()); 
        ps.setString(2, u.getAccountno());
        ps.setString(3,u.getPassword());  
        ps.setString(4,u.getEmail());  
        ps.setString(5,u.getSex());  
        ps.setString(6,u.getCountry());  
        ps.setString(7,u.getBalance());  
        
        ps.setInt(8,u.getId());
        
        status=ps.executeUpdate();  
    }
    catch(Exception e)
    {
    	System.out.println(e);
    	}  
    return status;  
}  
public static int delete(User u){  
    int status=0;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("delete from register where id=?");  
        ps.setInt(1,u.getId());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
  
    return status;  
}  
public static List<User> getAllRecords(){  
    List<User> list=new ArrayList<User>();  
      
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from register");  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            User u=new User();  
            u.setId(rs.getInt("id"));  
            u.setName(rs.getString("name"));  
            u.setAccountno(rs.getString("accountno"));
            u.setPassword(rs.getString("password"));  
            u.setEmail(rs.getString("email"));  
            u.setSex(rs.getString("sex"));  
            u.setCountry(rs.getString("country")); 
            u.setBalance(rs.getString("balance"));
            list.add(u);  
        }  
    }catch(Exception e){System.out.println(e);}  
    return list;  
}  
public static User getRecordById(int id){  
    User u=null;  
    try{  
        Connection con=getConnection();  
        PreparedStatement ps=con.prepareStatement("select * from register where id=?");  
        ps.setInt(1,id);  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            u=new User();  
            u.setId(rs.getInt("id"));  
            u.setName(rs.getString("name"));  
            u.setAccountno(rs.getString("accountno"));
            u.setPassword(rs.getString("password"));  
            u.setEmail(rs.getString("email"));  
            u.setSex(rs.getString("sex"));  
            u.setCountry(rs.getString("country"));  
            u.setBalance(rs.getString("balance"));
        }  
    }catch(Exception e){System.out.println(e);}  
    return u;  
}  
}  