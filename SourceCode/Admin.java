





import java.util.*;

    import java.sql.*;  

    class Admin{  

    	public static String addEmployee(){
    		AddEmployee obj=new AddEmployee();
    		return obj.queryGenerator();
    	}

    	public static String postTimeCard(){
    		PostTimeCard obj=new PostTimeCard();
    		return obj.queryGenerator();

    	}
    	public static String postSalesReceipt(){
    		PostSalesReceipt obj = new PostSalesReceipt();
    		return obj.queryGenerator();
    	}


	    public static void main(String args[]){  
			    try{  
			    Class.forName("com.mysql.cj.jdbc.Driver");  
			    Connection con=DriverManager.getConnection(  
			    "jdbc:mysql://localhost:3306/FKpayroll","root","password");  
			    System.out.println("Connection Established");
			    Statement stmt=con.createStatement();
			  	Scanner sc= new Scanner(System.in);
			    int f=1;
			    System.out.println("\n|| WELCOME TO FLIPKART PAYROLL SYSTEM ||\n");
			    while(f==1)
			    {	
			    	System.out.println("Please select option:\n");
			    	System.out.println("Enter 1 to add employee :\n");
			    	System.out.println("Enter 2 to delete employee:\n");
			    	System.out.println("Enter 3 to post a time card:\n");
			    	System.out.println("Enter 4 to post sale receipy:\n");
			    	int option=sc.nextInt();
			    	sc.nextLine();
			    	switch(option){

			    		case 1:{
			    			String query=addEmployee();
						    int query_status=stmt.executeUpdate(query);
						    ResultSet rs;
						    query="select max(id) from Employee";
						    rs=stmt.executeQuery(query);
						    if(rs.next()){
						    	int newID=rs.getInt(1);
						    	System.out.println("Employee added with id : "+newID+"\n");
						    	}
						    break;
			    
			    		}
			    		case 3:{
			    			String query=postTimeCard();
			    			int query_status=stmt.executeUpdate(query);
			    			System.out.println("Time card added to DailyWork table.\n");
			    			break;
			    		}

			    		case 4:{
			    			String query=postSalesReceipt();
			    			int query_status=stmt.executeUpdate(query);
			    			System.out.println("Sales Receipt added to Commission table.\n");
			    			break;

			    		} 

			    		default:{
			    			System.out.println("\n|| CLOSING FLIPKART PAYROLL APPLICATION ||\n");
			    			f=0;
			    			break;
			    		}
			    	}
			    }

			  
			    con.close();  

			    System.out.println("Connection Closed");
	    	}
	    	catch(Exception e){ System.out.println(e);}  
	    }  


    }  