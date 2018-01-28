package Materials;
import org.simpleframework.xml.Element;

import org.simpleframework.xml.Root;

import java.lang.String;

/*
 * Predefined Criterias
 * Criteria object for the predefinedGradedAssignment class
 * @ author Bora Ecer
 * @ version 24.04.2016 v1
 * 
 */

@Root
public class PredefinedCriteria 
{
	@Element
	private String criteria;
	@Element
	private double percentage;
	@Element
	private double grade;

	//Full Constructor.
	public PredefinedCriteria(String criteria, double percentage)
	{
		this.criteria = criteria;
		this.percentage = percentage;
		this.grade = -1; //Default value
	}

	// Methods
	public String getCriteria()
	{
		return criteria;
	}


	public double getPercentage()
	{
		return percentage;
	}


	public double getGrade()
	{
		return grade;
	}

	public void setGrade(double grade)
	{
		this.grade = grade;
	}
}
