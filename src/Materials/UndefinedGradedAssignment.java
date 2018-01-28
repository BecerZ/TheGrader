package Materials;

import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/*
 * Predefined Graded Assignment
 * Basic assignment type for grading
 * @ authors Bora Ecer, Alp Ege Basturk
 * @ version 17.04.2016 v1 (Aziz Osman Kozhan & Emre Kuzhan)
 *           23.04.2016 v2 (Bora Ecer)
 *           24.04.2016 v3 (Bora Ecer & Alp Ege Basturk)
 *           25.04.2016 v4 (Alp Ege Basturk_xml_i/o Added)
 *
 */
@Root
public class UndefinedGradedAssignment extends Assignment
{
    @ElementList
    private ArrayList<ChecklistCriteria> criterias;

    public UndefinedGradedAssignment( String name, double maxGrade)
    {
        super( name, maxGrade);
        criterias = new ArrayList<ChecklistCriteria>();
    }
    public UndefinedGradedAssignment() {}
    // Sets the grade, according to the user's input
    public double calculateGrade(double gradeGivenByUser)
    {
        setGrade(gradeGivenByUser);
        return gradeGivenByUser;
    }
    // Adds new Criteria to criterias list
    public boolean addCriteria(String criteria)
    {
        ChecklistCriteria checklistCriteria;

        checklistCriteria = new ChecklistCriteria(criteria);
        // Init

        // If criteria does not already exist in the list
        if(!criteriaExists(checklistCriteria.getCriteria()))
        {
            // Add new criteria and return true.
            criterias.add(checklistCriteria);
            return true;
        }
        // Else criteria does already exist in the list
        else
        {
            // Return false
            return false;
        }
    }

    @Override
    public boolean addCriteria(String criteriaName, double percentage, double grade)
    {
        return false; // Not effective in this class
    }

    // Removes criteria according to the name of the criteria
    public boolean removeCriteria(String criteriaName)
    {

        // Index of criteria
        int index;

        // Init

        index = -1;

        // If criteria exists in list then remove
        if(criteriaExists( criteriaName ))
        {
            // For loop for setting the index of the criteria which will be removed.
            for ( int i = 0; i < criterias.size(); i++ )
            {
                if ( criterias.get(i).getCriteria().equals( criteriaName ))
                {
                    index = i;
                }
            }
            criterias.remove(index);
            return true;
        }
        // Else return false.
        else
        {
            return false;
        }
    }
    // Checks if criteria exists in the list or not.
    public boolean criteriaExists(String criteriaName)
    {
        boolean criteriaExist;

        // Init.
        criteriaExist = false;

        for ( int i = 0; i < criterias.size(); i++ )
        {
            if (criterias.get(i).getCriteria().equals(criteriaName))
            {
                criteriaExist = true;
            }
        }
        return criteriaExist;
    }
    public ArrayList<ChecklistCriteria> getCriterias()
    {
        return criterias;
    }
    @Override
    public double calculateGrade()
    {
        return 0;
    }
    public ChecklistCriteria getByName(String criteriaName)
    {
        ChecklistCriteria returnCriteria;

        // Init

        returnCriteria = null;

        if(criteriaExists(criteriaName))
        {
            for (int i = 0; i<criterias.size(); i++)
            {
                if(criterias.get(i).getCriteria().equals(criteriaName))
                {
                    returnCriteria =  criterias.get(i);
                }
            }
        }
        return returnCriteria;
    }
}