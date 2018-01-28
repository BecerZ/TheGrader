package Tests;


import Person.Student;
import XML_I_O.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

import Materials.Assignment;
import Materials.UndefinedGradedAssignment;

/*
 * Initial xml tests
 * Basic tests for xml_i/o
 * @ author Alp Ege Basturk
 * @ version 25.04.2016 v1
 *
 */

public class XML_Tests
{
    public static void main(String[] args) throws Exception {
        Student student1 = new Student( "Nail", "Ak?nc?", 1001);
        student1.addAssignment(new UndefinedGradedAssignment("x", 100));

        //xmlInOut.saveOut(student1, "student1");

        XMLEncoder encoder = null;
        try{
            encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream("student1.xml")));
        }catch(FileNotFoundException fileNotFound){
            System.out.println("ERROR: While Creating or Opening the File");
        }
        encoder.writeObject(student1);
        encoder.close();

        // Xml input
        XMLDecoder decoder=null;
        try {
            decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream("student1.xml")));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found");
        }
        Student student2 =  (Student)decoder.readObject();
        System.out.println(student2.getAssignments());

    }
}
