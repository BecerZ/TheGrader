package Materials;

import Person.*;

import java.util.ArrayList;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

/*
 * Course List
 * List that holds courses in the program. ex.: {CS-102, CS-101}
 * @ author Bora Ecer
 * @ version 09.04.2016 v1
 *           23.04.2016 v2
 *           25.04.2016 v3 (Alp Ege Basturk_xml_i/o_added)
 *
 */
@Root
public class CourseList 
{
    // Properties.
    @ElementList
    private ArrayList<Course> courses;
    
    // Constructor
    public CourseList(ArrayList<Course> courses)
    {
        this.courses = courses;
    }
    public CourseList( String name)
    {
        courses = new ArrayList<Course>();
    }
    public CourseList(){}

    // Methods
    // Returns the courses(ArrayList).
    public ArrayList<Course> getCourses()
    {
        return courses;
    }

    // Removes selected course from courses(ArrayList).
    public boolean removeCourse(String courseName)
    {
        // The index of course which will be removed.
        int index;

        // Init
        index = 0;

        // If there is a course with given courseName in courses(ArrayList).
        if (courseExists(courseName))
        {
            for(int i = 0; i<courses.size(); i++)
            {
                if ( courseName.equals(courses.get(i).getCourseName()))
                {
                    index = i;
                }
            }
            courses.remove(index);
            return true;
        }

        // There is not a course with given courseName in courses(ArrayList). Error.
        else
        {
            return false;
        }
    }

    //Adds given course to the courses(ArrayList).
    public boolean addCourse(Course course)
    {
        String courseName;

        // Init
        courseName = course.getCourseName();

        // If courseExist is false, which means course does not exist in the courses(ArrayList)
        // Add the new course to the courses(ArrayList)
        if (!courseExists(courseName))
        {
            courses.add(course);
            return true;
        }
        // There are already a course which has the same courseName
        // With the new one, thus return error.
        else
        {
            return false;
        }
    }

    // Method for checking a course exists in courseList, according to their courseName.
    public boolean courseExists(String courseName)
    {
        Boolean courseExist;

        // Init
        courseExist = false;

        // For loop which checks the courseNames of new section and the old ones
        // Which are already in the courses(ArrayList).
        for (int i = 0; i < courses.size(); i++)
        {
            // If the courseNames match, set courseExist to true.
            if (courseName.equals(courses.get(i).getCourseName()))
            {
                courseExist = true;
            }
        }
        return courseExist;
    }


}
