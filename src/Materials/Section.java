package Materials;

import java.util.ArrayList;
import Person.*;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/*
 * Section
 * Section object. Holds students in an section. ex.: CS-102_Section-01
 * @ author Bora Ecer
 * @ version 09.04.2016 v1
 *           23.04.2016 v2
 *           25.04.2016 v3 (Alp Ege Basturk_xml_i/o_added)
 * 
 */

@Root
public class Section 
{
    //Properties.
    @ElementList
    private ArrayList<Student> studentList;
    @Element
    private int sectionNumber;
    
    //Constructor
    public Section(ArrayList<Student> studentList, int sectionNumber)
    {
        this.studentList = studentList;
        this.sectionNumber = sectionNumber;
    }
    public Section( int sectionNumber )
    {
        this.sectionNumber = sectionNumber;
        this.studentList = new ArrayList<Student>();
    }

    public Section(){}
    //Methods
    //Returns studentList.
    public ArrayList<Student> getStudents()
    {
        return studentList;
    }

    public boolean addStudent(Student student)
    {
        int studentID;
        // Init
        studentID = student.getIDNumber();
        // If new student's id does not match with id of the other students in section
        // Add student to the list.

        if (!studentExists(studentID))
        {
            studentList.add(student);
            return true;
        }

        // If it matches, error.
        else
        {
            return false;

        }
    }

    public int getSectionNumber()
    {
        return sectionNumber;
    }

    // Removes the student with student ID.
    public boolean removeStudent(int studentID)
    {
        // The index of student which will be removed.
        int index;

        // Init
        index = 0;

        // If there is a student with given Student ID in studentList.
        if (studentExists(studentID))
        {
            // If there is a student which has the given student ID, sets its index
            for (int i = 0; i<studentList.size(); i++)
            {
                if ( studentID == studentList.get(i).getIDNumber())
                {
                    index = i;
                }
            }
            studentList.remove(index);
            return true;
        }
        // There is not a student with given studentID in studentList. Error.
        else
        {
            return false;
        }
    }
    public boolean studentExists(int studentID)
    {
        // A boolean variable for existance of new student.
        Boolean studentExist;

        // Init
        studentExist= false;

        // For loop which checks IDs of the new student and the old ones in the section.
        for (int i = 0; i < studentList.size(); i++)
        {
            if(studentID == studentList.get(i).getIDNumber())
            {
                studentExist = true;
            }
        }
        return studentExist;
    }

    @Override
    public String toString() {
        return "Section " + this.sectionNumber;
    }
}
