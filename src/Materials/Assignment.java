package Materials;

import Person.*;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.*;
import java.util.*;

/*
 * Assignment
 * Abstract class for assignments
 * @ author  Bora Ecer, Alp Ege Basturk
 * @ version 09.04.2016 v1 (Alp Ege Basturk)
 *           23.04.2016 v2 (Bora Ecer)
 *           24.04.2016 v3 (Alp Ege Basturk & Bora Ecer)
 *           25.04.2016 v4 (xml_i/o added)
 *
 */
@Root
public abstract class Assignment 
{   
    // Properties
    @Element
    public String name;
    @Element
    public double maxGrade;
    @Element
    public double grade;

    
    // Constructor
    public Assignment( String name, double maxGrade)
    {
        this.name = name;
        this.maxGrade = maxGrade;
        this.grade = -1; //Default Value
    }

    public Assignment() {

    }

    public boolean setGrade(double grade)
    {
        this.grade = grade;
        return true;
    }
    
    public double getGrade() 
    {
        return grade;
    }
    
    public String getName() 
    {
        return name;
    }
    
    public boolean setMaxGrade( int maxGrade ) 
    {
        this.maxGrade = maxGrade;
        return true; // Will be implemented according to the Login System
    }
    
    public double getMaxGrade() 
    {
        return maxGrade;
    }

    public abstract ArrayList getCriterias();
    public abstract boolean addCriteria( String criteria);
    public abstract boolean addCriteria( String criteriaName, double percentage, double grade );
    public abstract boolean removeCriteria( String criteriaName);
    public abstract double calculateGrade();
    public abstract double calculateGrade( double gradeGivenByUser);
    public String toString()
    {
        return this.name;
    }
}
