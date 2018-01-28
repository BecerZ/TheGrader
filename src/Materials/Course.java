package Materials;

import Person.*;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/*
 * Course
 * Main class object, ex.: CS-102, CS-101
 * @ author Bora Ecer
 * @ version 09.04.2016 v1
 *           23.04.2016 v2
 *           25.04.2016 v3 (Alp Ege Basturk_xml_i/o_added)
 *
 */
@Root
public class Course
{
    // Properties
    @ElementList
    private ArrayList<Section> sectionList;
    @Element
    private String courseName;
    
    // Constructor
    public Course(ArrayList<Section> sectionList, String courseName)
    {
        this.sectionList = sectionList;
        this.courseName = courseName;
    }
    public Course( String courseName)
    {
        this.courseName = courseName;
        sectionList = new ArrayList<Section>();
    }
    public Course(){}

    // Methods
    // Returns the sectionList
    public ArrayList<Section> getSections()
    {
        return sectionList;
    }

    // Returns the name of the course
    public String getCourseName()
    {
        return courseName;
    }

    // Adds new section to the sectionList.
    public boolean addSection(Section section)
    {
        int sectionNumber;

        sectionNumber = section.getSectionNumber();

        // If sectionExist is false, which means section does not exist in the sectionList
        // Add the section to the list

        if(!sectionExists(sectionNumber))
        {
            sectionList.add(section);
            return true;
        }

        // There are already a section which has the same sectionNumber
        // With the new one, thus return error.
        else
        {
            return false;
        }
    }

    // Removes the selected section from the list.
    public boolean removeSection(int sectionNumber)
    {
        // The index of student which will be removed.
        int index;

        // Init
        index = 0;

        // If there is a section with given sectionNumber in sectionList.
        if (sectionExists(sectionNumber))
        {
            for(int i = 0; i < sectionList.size(); i++)
            {
                if(sectionNumber == sectionList.get(i).getSectionNumber())
                {
                    index = i;
                }
            }
            sectionList.remove(index);
            return true;
        }
        // There is not a section with given sectionNumber in sectionList. Error.
        else
        {
            return false;
        }

    }
    public boolean sectionExists(int sectionNumber)
    {

        // Boolean variable, for checking existance of section.
        Boolean sectionExist;

        // Init

        sectionExist = false;

        // For loop, which checks sectionNumber's of the student which are in the sectionList
        // If there is a section which has the given sectionNumber, sets its index and sets sectiontExist to true.
        for(int i = 0; i<sectionList.size(); i++)
        {
            if ( sectionNumber == sectionList.get(i).getSectionNumber())
            {
                sectionExist = true;
            }
        }
        return  sectionExist;
    }

    public String toString()
    {
        return this.courseName;
    }


}
