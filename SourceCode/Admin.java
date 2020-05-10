





import java.util.*;

    import java.sql.*;  

    class Admin{  

    	static Connection con;
    	static String mySqlDriverName="com.mysql.cj.jdbc.Driver";
    	static String user="root";
    	static String password="password";
    	static String url="jdbc:mysql://localhost:3306/FKpayroll";


    	public static void connectToDatabase(){
    		try{
    			Class.forName(mySqlDriverName);  
			  	con=DriverManager.getConnection(  
			    url,user,password);  
			    System.out.println("Connection Established");
    		}
    		catch(Exception e){ System.out.println(e);} 


    	}

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

    	public static void updateEmployee(int employeeID,String attribute,String value,boolean singleQuotes){
    		try{
	    		String query="update Employee set "+attribute+"=";
	    		if(singleQuotes){
	    			query=query+"'"+value+"'"+" where id ="+employeeID; 			

	    		}
	    		else
	    		{
	    			query=query+value+" where id ="+employeeID; 			

	    		}
	    		
	    		Statement stmt=con.createStatement();
	    		int query_status=stmt.executeUpdate(query);
	    		System.out.println("Employee "+employeeID+" "+attribute+" value is "+value);
    		}
    		catch(Exception e){ System.out.println(e);}  







    	}

    	public static double hourEmployeeSalary(int employeeID,double hourRate,String lastPaid,String now){
    		double salary=-1;
    		try{

	    		Statement stmt1=con.createStatement();
	    		String query1="select hours from DailyWork where empID="+employeeID+" and time between '"+lastPaid+"' and '"+now+"'";

				ResultSet rs1=stmt1.executeQuery(query1);

				ArrayList<Double> hours=new ArrayList<Double>();
				    				    	
		    	while(rs1.next()){

			   		hours.add(rs1.getDouble(1));
			    	
			 	}

				HourEmployee emp=new HourEmployee();
				emp.rate=hourRate;  	
				java.sql.Date nowDate=java.sql.Date.valueOf(now);
				java.sql.Date lastPaidDate=java.sql.Date.valueOf(lastPaid);
				emp.lastPaid=lastPaidDate;
	    	   	salary=emp.calculateSalary(nowDate,hours);
	    	   	if(emp.lastPaid.equals(lastPaidDate))return salary;
	    	   	String attribute="lastPaidDate";
	    	   	updateEmployee(employeeID,attribute,now,true);
	    	   	
    		}
    		catch(Exception e){ System.out.println(e);}  
    		return salary;

    	}

    	public static double salariedEmployeeSalary(int employeeID,double commissionRate,double employeeSalary,String lastPaid,String lastComm,String now){


    		double salary=-1;
    		try{

	    		Statement stmt1=con.createStatement();
	    		String query1="select amount from Commission where empID="+employeeID+" and time between '"+lastComm+"' and '"+now+"'";

				ResultSet rs1=stmt1.executeQuery(query1);

				ArrayList<Double> sales=new ArrayList<Double>();
				    				    	
		    	while(rs1.next()){

			   		sales.add(rs1.getDouble(1));
			    	
			 	}

				SalariedEmployee emp=new SalariedEmployee();
				emp.rate=commissionRate;  	
				java.sql.Date nowDate=java.sql.Date.valueOf(now);
				java.sql.Date lastPaidDate=java.sql.Date.valueOf(lastPaid);
				java.sql.Date lastCommDate=java.sql.Date.valueOf(lastComm);
				emp.lastPaid=lastPaidDate;
				emp.lastComm=lastCommDate;
	    	   	salary=emp.calculateSalary(nowDate,sales);
	    	   	String attribute;
	    	   	if(emp.lastPaid.equals(lastPaidDate)==false){
	    	   		attribute="lastPaidDate";
	    	   		updateEmployee(employeeID,attribute,now,true);
	    	   	}
	    	   	if(emp.lastComm.equals(lastCommDate)==false){
	    	   		attribute="lastComm";
	    	   		updateEmployee(employeeID,attribute,now,true);
	    	   	}

	    	   	
	    	   	
	    	   	
    		}
    		catch(Exception e){ System.out.println(e);}  
    		return salary;











    	}










	    public static void main(String args[]){  
			try{  

			    connectToDatabase();			    
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
			    	System.out.println("Enter 4 to post sale receipt:\n");
			    	System.out.println("Enter 5 to pay Employees:\n");
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

			    		case 5:{

			    			System.out.println("Enter date upto which to generate payment in format YYYY-MM-DD:");
			    			String now=sc.nextLine();
			    			String query="select * from Employee";
			    			ResultSet rs=stmt.executeQuery(query);
			    			while(rs.next()){
			    				int typeOfEmployee=rs.getInt(8);
			    				int employeeID=rs.getInt(10);
			    				String lastPaid=rs.getString(5);
			    				double rate=rs.getDouble(4);
			    				int modeOfSalary=rs.getInt(3);
			    				String postalAdd=rs.getString(12);
			    				String accountNo=rs.getString(13);
			    				double employeeSalary=rs.getDouble(9);
			    				String lastComm=rs.getString(11);
			    				double salary=-1;
			    				if(typeOfEmployee==1)
			    				{
			    					salary=hourEmployeeSalary(employeeID,rate,lastPaid,now);
			    				}
			    				else
			    				{
			    					salary=salariedEmployeeSalary(employeeID,rate,salary,lastPaid,lastComm,now);
			    					
			    				}
			    				if(salary>0){
			    					if(modeOfSalary==1)System.out.println("\nEmployee "+employeeID+" pick salary of amount "+salary+"\n");
			    					else if(modeOfSalary==2)System.out.println("\nEmployee "+employeeID+" salary of amount "+salary+" posted to "+postalAdd+"\n");
			    					else System.out.println("\nEmployee "+employeeID+" salary of amount "+salary+" added to account "+accountNo+"\n");
			    				}


			    			}

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