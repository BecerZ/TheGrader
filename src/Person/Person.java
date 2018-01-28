package Person;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import Materials.*;

import java.io.*;
import java.util.*;

/*
 * Person
 * Person abstract class which is humans in the program
 * @ author Alp Ege Basturk
 * @ version 09.04.2016 v1
 *           23.04.2016 v2
 *           25.04.2016 v3 (xml_i/o_added)
 *
 */
@Root
public abstract class Person 
{
    //Properties
    @Element
    public String name;
    @Element
    public String surname;
    @Element
    public int IDNumber;
    
    // Constructor
    public Person( String name, String surname, int IDNumber)
    {
        this.name = name;
        this.surname = surname;
        this.IDNumber = IDNumber;
    }

    public Person() {}

    // Methods
    public String getName() 
    {
        return name;
    }
    
    public String getSurname() 
    {
        return surname;
    }
    
    public int getIDNumber() 
    {
        return IDNumber;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + IDNumber;
    }
}
