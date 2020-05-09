





import java.util.*;

    import java.sql.*;  

    class Admin{  
	    public static void main(String args[]){  
			    try{  
			    Class.forName("com.mysql.cj.jdbc.Driver");  
			    Connection con=DriverManager.getConnection(  
			    "jdbc:mysql://localhost:3306/FKpayroll","root","password");  
			    System.out.println("Connection Established");
			    
				String query = "select * from Employee";

			    Statement stmt=con.createStatement();

			    ResultSet rs=stmt.executeQuery(query);
			    
			    String now="2020-05-10";
			    while(rs.next())
			    {
			    	java.sql.Date l=rs.getDate(5);
			    	String lastPaid=Objects.toString(l);
			    	//System.out.println(lastPaid);
			    	if(Objects.isNull(l))continue;
			    	int empID=rs.getInt(10);
			    	HourEmployee emp=new HourEmployee();
			    	emp.rate=rs.getDouble(4);
			    	//System.out.println(lastPaid+now);

			    	// now is the input date

			    	Statement stmt2=con.createStatement();

			    	String query2="select hours from DailyWork where empID="+empID+" and time between '"+lastPaid+"' and '"+now+"'";

			    	ResultSet rs2=stmt2.executeQuery(query2);

			    	ArrayList<Double> hours=new ArrayList<Double>();
			    				    	
			    	while(rs2.next()){

			    		hours.add(rs2.getDouble(1));
			    		
			    		System.out.println(rs2.getDouble(1));
			    	   	}

			    	   	
			    	   	double salary=emp.calculateSalary(l,hours);
			    	   	if(salary>0){
			    	   		updateLastDate(rs2.getInt(10),n);
			    	   			System.out.println(salary);
			    	   	}
			    	   



			    }

			      




			    con.close();  

			    System.out.println("Connection Closed");
	    	}
	    	catch(Exception e){ System.out.println(e);}  
	    }  


    }  