package Person;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import Materials.*;

import java.io.*;
import java.util.*;

/*
 * Student
 * Student object 
 * @ author Alp Ege Basturk
 * @ version 09.04.2016 v1
 *           23.04.2016 v2
 *           25.04.2016 v3 (xml_i/o_added)
 *
 */
@Root
public class Student extends Person 
{
    // Properties
    @ElementList
    public ArrayList<Assignment> assignments;
    
    // Constructor
    public Student( String name, String surname, int IDNumber )
    {
        super( name, surname, IDNumber);
        assignments = new ArrayList<Assignment>();
    }
    public Student()
    {
        super();
    }
    
    // Methods
    public ArrayList<Assignment> getAssignments()
    {
        return assignments;
    }
    
    public boolean addAssignment(Assignment x)
    {
        assignments.add( x );
        return true; // Will be implemented according to the Login System
    }
    
    public boolean removeAssignment( String assignmentName )
    {
        // get name, pass it to search remove if found
        int index;
        index = search( assignmentName );
        if ( index >= 0) {
            assignments.remove(index);
            return false;
        }
        return true; // Will be implemented according to the Login System
        
    }

    public boolean removeAssignment( int index)
    {
        assignments.remove(index);
        return true;
    }

    public int search( String assignmentName)
    {
        for ( int i = 0; i < assignments.size(); i++ )
        {
            if (assignments.get(i).getName().equals( assignmentName ))
            {
                return i;
            }
        }
        // Else return -1 (sentinel)
        return -1;
    }
}