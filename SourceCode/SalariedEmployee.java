
import java.util.*;

class HourEmployee implements Employee{
	String name;
	int id;
	String address;
	int modeOfPayment;
	boolean unionMember;
	double rate;
	Date lastPaid;
	double salary;
	int type;
	Date lastComm;



	private boolean isLastDay(Date now) {
	    Date test = new Date(now.getTime()),
	        Month month = test.getMonth();

	    test.setDate(test.getDate() + 1);
	    return test.getMonth() !== month;
	}



	private double calculateCommission(ArrayList<Double>bonus)
	{

		double comm=0;
		for(Double bon:bonus)
		{
			comm+=bon;
		}
		return comm;
	}

	public double calculateSalary(Date now,ArrayList<Double> bonus)
	{
		
		double payment=0;


		long diff = now.getTime() - lastComm.getTime();
 
		int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
		Calendar c = Calendar.getInstance();
		c.setTime(now);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

		if(diffDays>=14&&DAY_OF_WEEK==6)
		{
			payment+=calculateCommission(bonus);
			

			lastComm=now;
		}

		if(isLastDay)
		{

			payment+=salary;
			lastPaid=now;


		}

		return payment;






	}








}