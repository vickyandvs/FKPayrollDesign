

import java.sql.Date;  
import java.util.*;  
class PostSalesReceipt{
	
	int empID;
	int id;
	Date time;
	String place;
	double amount;
	
	String date;
	PostSalesReceipt(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter employee id");
		empID=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter date of sale in format yyyy-mm-dd");
		date=sc.nextLine();
		time=Date.valueOf(date);
		System.out.println("Enter organization name to which sale is made on date : "+ date);
		place=sc.nextLine();
		System.out.println("Enter payment received from organization "+place+" :");
		amount=sc.nextDouble();
		sc.nextLine();

	}

	String queryGenerator(){
		String query="insert into Commission(time,place,amount,empID)values('"+date+"','"+place+"',"+amount+","+empID+")";
		return query;
	}


}