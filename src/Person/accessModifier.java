package Person;

import java.io.*;
import java.util.*;

import Materials.*;

/*
 * Access Modifier
 * Details for access rights of person objects
 * @ author Alp Ege Basturk
 * @ version 09.04.2016 v1
 * 
 */
public interface accessModifier {
    
    static final int STUDENT_LEVEL = 0;
    static final int ASSISTANT_LEVEL = 1;
    static final int INSTRUCTOR_LEVEL = 2;
    
    int getAccessLevel();
    void setAccessLevel(int accessLevel);
    
}
