package Person;

import org.simpleframework.xml.Element;

import Materials.*;

import java.io.*;
import java.util.*;

/*
 * User
 * User abstract class, humans which has the right to use the program
 * @ author Alp Ege Basturk
 * @ version 09.04.2016 v1
 *           25.04.2016 v2 (xml_i/o_added)
 * 
 */

public abstract class User extends Person implements accessModifier 
{
    // Properties
    @Element
    public int accessLevel;
    @Element
    public String password;
    
    
    // Constructor
    public User(String name, String surname,int IDNumber, String password)
    {
        super(name, surname, IDNumber);
        this.password = password;
    }
    
    
    // Methods
    public int getAccessLevel() 
    {
        return accessLevel;
    }
    
    public void setAccessLevel(int accessLevel) 
    {
        this.accessLevel = accessLevel;
    }
    
    public void setPassword(String newPassword)
    {
        password = newPassword;
    }
    
    public String getPassword()
    {
        return password;
    }
    
}
