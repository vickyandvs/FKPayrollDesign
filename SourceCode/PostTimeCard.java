import java.sql.Date;  
import java.util.*;  
class PostTimeCard{
	
	int empID;
	int id;
	Date time;
	double hours;
	String date;
	PostTimeCard(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter employee id");
		empID=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter date in format yyyy-mm-dd");
		date=sc.nextLine();
		time=Date.valueOf(date);
		System.out.println("Enter hours worked on date : "+ date);
		hours=sc.nextDouble();
		sc.nextLine();

	}

	String queryGenerator(){
		String query="insert into DailyWork(time,hours,empID)values('"+date+"',"+hours+","+empID+")";
		return query;
	}


}