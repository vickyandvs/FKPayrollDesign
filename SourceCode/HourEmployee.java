
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

	public double calculateSalary(Date now,ArrayList<Double> hoursPerDay)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(now);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		if(dayOfWeek!=6)return -1;
		double payment=0;
		for(Double hours:hoursPerDay){

			double extraHours=hours-8;
			if(extraHours>0)
			{

				payment+=extraHours*(1.5)*rate;
				payment+=(hours-extraHours)*rate;

			}
			else
			{

				payment+=hours*rate;

			}



		}
		lastPaid=now;

		return payment;


	}








}