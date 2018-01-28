package Tests;

import Person.*;

import java.util.ArrayList;

import Materials.*;

/*
 * Person Tests
 * Basic Tests for Person classes
 * @ author Alp Ege Basturk
 * @ version 23.04.2016 v1
 *           25.04.2016 v2
 *
 */

public class Person_Tests
{
    public static void main(String[] args)
    {
        // Person
        Student a;
        Assistant Aytek;
        Instructor David;


        Aytek = new Assistant( "Aytek", "Aman", 1111, "admin1234");

        System.out.println( Aytek.getName());
        System.out.println( Aytek.getSurname());
        System.out.println( Aytek.getPassword());
        System.out.println(Aytek.getIDNumber());
        System.out.println(Aytek.getAccessLevel());
        // Password Change
        Aytek.setPassword("admin5678");
        System.out.println("New Password " + Aytek.getPassword());
        // Change access Level
        Aytek.setAccessLevel(5);
        System.out.println(Aytek.getAccessLevel());

        // Instructor
        System.out.println();
        System.out.println( "___________________________________________" );
        //
        // Instructor
        David = new Instructor( "David", "Davenport", 333, "admin999");

        System.out.println( David.getName());
        System.out.println( David.getSurname());
        System.out.println( David.getPassword());
        System.out.println(David.getIDNumber());
        System.out.println( David.getAccessLevel());
        // Password Change
        David.setPassword("admin000");
        System.out.println("New Password " + David.getPassword());
        // Change access Level
        David.setAccessLevel( 5);
        System.out.println(David.getAccessLevel());


        // Student creation
        System.out.println();
        System.out.println( "___________________________________________" );
        //

        Student Nail;

        Nail  = new Student( "Nail", "Ak?nc?", 10001);
        // Basic name, surname etc. tests
        System.out.println(Nail.getName());
        System.out.println(Nail.getSurname());
        System.out.println(Nail.getIDNumber());

        // Print the assignments list for test_ Empty Here
        System.out.println( Nail.getAssignments());

        // Add assignment, then print
        Assignment x;
        Assignment y;
        Assignment z;
        x = new UndefinedGradedAssignment( "x", 100 );
        y = new UndefinedGradedAssignment( "y", 100 );
        z = new UndefinedGradedAssignment( "z", 100 );
        Nail.addAssignment(x);
        Nail.addAssignment(y);
        Nail.addAssignment(z);

        // Print the assignments list for test_ Filled Here
        System.out.println("Assignments added at this point " + Nail.getAssignments());

        // Remove assignments
        System.out.println(Nail.removeAssignment(0));
        System.out.println(Nail.removeAssignment( "z"));
        System.out.println("2 Assignments removed at this point " + Nail.getAssignments());

        // End of student tests
        System.out.println();
        System.out.println( "___________________________________________" );
        // Start of assignment tests inside the person object
        // We have assignment y left for the Student

        ArrayList<Assignment> tempList;
        Assignment            tempAssignment;
        tempList = Nail.getAssignments();
        // Working on the last assignment
        tempAssignment = tempList.get(tempList.size() - 1);

        // Start work on the temps
        System.out.println( tempAssignment.getCriterias()); // Empty at this point
        System.out.println("Current Grade is " + tempAssignment.getGrade());
        System.out.println("Max Grade is " + tempAssignment.getMaxGrade());

        tempAssignment.setMaxGrade(101);
        tempAssignment.setGrade(55);
        System.out.println("New Current Grade is " + tempAssignment.getGrade());
        System.out.println("New Max Grade is " + tempAssignment.getMaxGrade());

        // Add/remove criteria tests
        tempAssignment.addCriteria( "Compiles");
        tempAssignment.addCriteria( "Indentation");
        System.out.println( tempAssignment.getCriterias()); // Not empty at this point
        tempAssignment.removeCriteria("Compiles");
        System.out.println( tempAssignment.getCriterias()); // Compiles removed empty at this point
        // End of add/remove tests

        System.out.println( tempAssignment.calculateGrade( 45)); // User gave 45
    }
}
