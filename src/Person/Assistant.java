package Person;

import org.simpleframework.xml.Root;

import Materials.*;

import java.io.*;
import java.util.*;

/*
 * Assistant
 * Assistant object
 * @ author Alp Ege Basturk
 * @ version 09.04.2016 v1
 *           23.04.2016 v2
 *           25.04.2016 v3 (xml_i/o_added)
 *
 */
@Root
public class Assistant extends User 
{
    // Properties
    
    // Constructor
    public Assistant( String name, String surname, int IDNumber, String password)
    {
        super(name, surname, IDNumber, password);
        setAccessLevel( ASSISTANT_LEVEL );
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
