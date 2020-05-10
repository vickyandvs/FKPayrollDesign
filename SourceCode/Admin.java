





import java.util.*;

    import java.sql.*;  

    class Admin{  






    	public static String addEmployee(){
    		AddEmployee obj=new AddEmployee();
    		return obj.queryGenerator();


    	}


	    public static void main(String args[]){  
			    try{  
			    Class.forName("com.mysql.cj.jdbc.Driver");  
			    Connection con=DriverManager.getConnection(  
			    "jdbc:mysql://localhost:3306/FKpayroll","root","password");  
			    System.out.println("Connection Established");
			    
				

			    Statement stmt=con.createStatement();


			    String query=addEmployee();

			    int query_status=stmt.executeUpdate(query);

			    ResultSet rs;
			    
			    query="select max(id) from Employee";
			    rs=stmt.executeQuery(query);
			    if(rs.next()){
			    	int newID=rs.getInt(1);
			    	System.out.println("Employee added with id : "+newID);


			    }
			    
			    

			      




			    con.close();  

			    System.out.println("Connection Closed");
	    	}
	    	catch(Exception e){ System.out.println(e);}  
	    }  


    }  