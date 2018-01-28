package Tests;


import Person.Student;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import Materials.*;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Console Test
 * A basic console version of the app
 * @ author Alp Ege Basturk
 * @ version 23.04.2016 v1
 *           24.04.2016 v2
 *           25.04.2016 v3 (xml_i/o added)
 *
 */

public class Program_Test
{
    public static void main( String[] args) throws Exception {
        int selection;
        CourseList coursesOfTheSchool;



        coursesOfTheSchool = new CourseList( new ArrayList<Course>());
        System.out.println(coursesOfTheSchool.getCourses());
        Scanner scan = new Scanner(System.in);

        do {
            menu1(); //
            System.out.println();
            System.out.println( "Enter Selection");
            selection = scan.nextInt();
            // add Course
            if (selection == 1)
            {
                System.out.println( "Enter Course Name" );
                Scanner scan2 = new Scanner(System.in);
                String courseName = scan2.nextLine();
                coursesOfTheSchool.addCourse( new Course( courseName));
                System.out.println(coursesOfTheSchool.getCourses());
            }
            // remove Course
            else if (selection == 2)
            {
                System.out.println( "Enter Course Name" );
                Scanner scan2 = new Scanner(System.in);
                String courseName = scan2.nextLine();
                coursesOfTheSchool.removeCourse( courseName);
            }
            // get Courses// will print for now
            else if ( selection == 3)
            {
                System.out.println( coursesOfTheSchool.getCourses());
            }
            // Enter the Course object at given index
            else if (selection == 4)
            {
                // Control if empty
                if ( coursesOfTheSchool.getCourses().size() > 0)
                {
                    System.out.println( "Enter Course index" );
                    Scanner scan2 = new Scanner(System.in);
                    int index = scan2.nextInt();

                    // Get inside the course
                    enterCourse( coursesOfTheSchool.getCourses().get( index ));
                }
            }
            // XML I/O
            else if (selection == 5)
            {
                Serializer serializer = new Persister();
                File file = new File("CourseList.xml");
                serializer.write(coursesOfTheSchool, file);
            }
            else if (selection == 6)
            {
                File file = new File("CourseList.xml");
                coursesOfTheSchool = null;
                if ( file.exists() )
                    try {
                        Serializer serializer = new Persister();
                        coursesOfTheSchool = serializer.read(CourseList.class, file);
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
            }

        } while (selection != -1);
    }
    public static void enterCourse( Course course)
    {
        int selection;

        System.out.println(course.getSections());
        Scanner scan = new Scanner(System.in);

        do {
            menu2();//
            System.out.println();
            System.out.println( "Enter Selection");
            selection = scan.nextInt();
            // add section
            if (selection == 1)
            {
                System.out.println( "Enter Section Number" );
                Scanner scan2 = new Scanner(System.in);
                int sectionNumber = scan2.nextInt();
                course.addSection(new Section(sectionNumber));
            }
            // remove section
            else if (selection == 2)
            {
                System.out.println("Enter Section Number");
                Scanner scan2 = new Scanner(System.in);
                int sectionNumber = scan2.nextInt();
                course.removeSection(sectionNumber);

            }
            // get Sections// will print for now
            else if ( selection == 3)
            {
                System.out.println( course.getSections());
            }
            // Enter the Section object at given index
            else if (selection == 4)
            {
                // Control if empty
                if ( course.getSections().size() > 0)
                {
                    System.out.println( "Enter Section index" );
                    Scanner scan2 = new Scanner(System.in);
                    int index = scan2.nextInt();

                    // Get inside the selected section
                    enterSection(course.getSections().get(index));
                }
            }
            else
            {}

        } while (selection != -1);
    }

    public static void enterSection( Section section)
    {
        int selection;

        System.out.println(section.getStudents());
        Scanner scan = new Scanner(System.in);
        do {
            menu3();
            System.out.println();
            System.out.println( "Enter Selection");
            selection = scan.nextInt();
            // add Student
            if (selection == 1)
            {
                System.out.println( "Enter Student Name,surname,IDNumber" );
                Scanner scan2 = new Scanner(System.in);
                String name = scan2.next();
                String surname = scan.next();
                int studentID = scan2.nextInt();
                section.addStudent(new Student(name, surname, studentID));
            }
            // remove section
            else if (selection == 2)
            {
                System.out.println("Enter Section Name");
                Scanner scan2 = new Scanner(System.in);
                int indexOFStudent = scan2.nextInt();
                section.removeStudent(indexOFStudent);

            }
            // get Sections// will print for now
            else if ( selection == 3)
            {
                System.out.println( section.getStudents());
            }
            // Enter the Section object at given index
            else if (selection == 4)
            {
                // Control if empty
                if (section.getStudents().size() > 0)
                {
                    System.out.println( "Enter Section index" );
                    Scanner scan2 = new Scanner(System.in);
                    int index = scan2.nextInt();

                    // Get inside the selected section
                    enterStudent(section.getStudents().get(index));
                }
            }
            else
            {}

        } while (selection != -1);
    }

    public static void enterStudent( Student student)
    {
        int selection;

        System.out.println(student.getAssignments());
        Scanner scan = new Scanner(System.in);

        do {
            menu4();
            System.out.println();
            System.out.println( "Enter Selection");
            selection = scan.nextInt();
            // add assignment
            if (selection == 1)
            {
                System.out.println( "Enter assignment Name, maxGrad" );
                Scanner scan2 = new Scanner(System.in);
                String name = scan2.next();
                int grade = scan2.nextInt();
                int maxGrade = scan2.nextInt();
                student.addAssignment(new UndefinedGradedAssignment(name, maxGrade));
            }
            // remove assignment
            else if (selection == 2)
            {
                System.out.println("Enter Assignment Index");
                Scanner scan2 = new Scanner(System.in);
                int indexOFAssignment = scan2.nextInt();
                student.removeAssignment(indexOFAssignment);

            }
            // get assignments// will print for now
            else if ( selection == 3)
            {
                System.out.println( student.getAssignments());
            }
            // Enter the assignment object at given index
            else if (selection == 4)
            {
                // Control if empty
                if (student.getAssignments().size() > 0)
                {
                    System.out.println( "Enter assignment index" );
                    Scanner scan2 = new Scanner(System.in);
                    int index = scan2.nextInt();

                    // Get inside the selected section
                    enterAssignment(student.getAssignments().get(index));
                }
            }
            else
            {}

        } while (selection != -1);
    }

    public static void enterAssignment( Assignment assignment)
    {
        int selection;

        System.out.println(assignment.getName());
        Scanner scan = new Scanner(System.in);

        do {
            menu5();
            System.out.println();
            System.out.println( "Enter Selection");
            selection = scan.nextInt();
            // add assignment
            if (selection == 1)
            {
                System.out.println( "Enter new grade then max grade" );
                Scanner scan2 = new Scanner(System.in);
                int grade = scan2.nextInt();// Int to avoid possible scanner problems
                int maxGrade = scan2.nextInt();
                assignment.setGrade( grade);
                assignment.setMaxGrade(maxGrade);
            }
            // remove section
            else if (selection == 2)
            {
                System.out.println("Max Grade " + assignment.getMaxGrade() +
                        "\nGrade " + assignment.getGrade());
            }
            // get grade and maxGrade// will print for now
            else if ( selection == 3)
            {
                System.out.println( assignment.getCriterias());
            }
            // Criterias
            else if (selection == 4)
            {
                // Will be changed according to new assignment criterias
            }
            else
            {}

        } while (selection != -1);
    }

    // Menus
    private static void menu1()
    {
        System.out.println( "1.Add Course, \n2.Remove Course, \n3.Print CourseList" +
                "\n4.Enter the course at given index" +
                "\n5.Export to xml\n6.Import From xml" +
                "\n-1 to exit");
    }
    private static void menu2()
    {
        System.out.println( "1.Add Section, \n2.Remove Section, \n3.Print SectionList" +
                "\n4.Enter the section at given index" +
                "\n-1 to exit");
    }
    private static void menu3()
    {
        System.out.println( "1.Add Student, \n2.Remove Student, \n3.Print StudentList" +
                "\n4.Enter the Student at given index" +
                "\n-1 to exit");
    }
    private static void menu4()
    {
        System.out.println( "1.Add Assignment, \n2.Remove Assignment, \n3.Print AssignmentList" +
                "\n4.Enter the Assignment at given index" +
                "\n-1 to exit");
    }
    private static void menu5()
    {
        System.out.println( "1.Set Grades, \n2.Print Grade, \n3.Print CriteriaList" +
                "\n4.Enter the Assignment at given index(not implemented in the test)" +
                "\n-1 to exit");
    }
}
