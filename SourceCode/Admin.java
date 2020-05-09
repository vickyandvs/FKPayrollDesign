
    import java.sql.*;  

    class Admin{  
	    public static void main(String args[]){  
			    try{  
			    Class.forName("com.mysql.cj.jdbc.Driver");  
			    Connection con=DriverManager.getConnection(  
			    "jdbc:mysql://localhost:3306/FKpayroll","root","password");  
			    System.out.println("Connection Established");
			    
			    	 String query = " insert into Employee (firstName, lastName, modeOfSalary, type)"
        + " values (?, ?, ?, ?)";

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = con.prepareStatement(query);
      preparedStmt.setString (1, "vaibhav");
      preparedStmt.setString (2, "sharma");
      preparedStmt.setInt   (3, 1);
      preparedStmt.setInt(4, 1);
      //preparedStmt.setInt    (5, 5000);

      // execute the preparedstatement
      preparedStmt.execute();
      




			    con.close();  

			    System.out.println("Connection Closed");
	    	}
	    	catch(Exception e){ System.out.println(e);}  
	    }  


    }  