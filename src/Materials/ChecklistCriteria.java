package Materials;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.lang.String;

/*
 * CheckListCriteria
 * Checklist Criteria class which will be used for UndefinedGradedAssignment class.
 * @ author Bora Ecer
 * @ version 25.04.2016 v1 
 * 
 */

@Root
public class ChecklistCriteria 
{
	@Element
	private String criteria;
	@Element
	private boolean checked;
	
	//Full Constructor.
	public ChecklistCriteria( String criteria )
	{
		this.criteria = criteria;
		this.checked = false; // Default setted
	}

	public boolean isChecked() 
	{
		return checked;
	}

	public void setChecked(boolean checked) 
	{
		this.checked = checked;
	}

	public String getCriteria() 
	{
		return criteria;
	}
	

}
