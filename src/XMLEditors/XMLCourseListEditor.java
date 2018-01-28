package XMLEditors;

/*
 * @Author: Alp Ege Baþtürk
 * @Edited by Bora Ecer
 * 
 */

import java.io.File;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import Materials.CourseList;

public class XMLCourseListEditor 
{
	// Properties
	private Serializer serializer;
	private File file; 
	private CourseList courses;
	
	// Constructor
	public XMLCourseListEditor(CourseList courses)
	{
		this.courses = courses;
		serializer = new Persister();
		file = new File("CourseList.xml");
	}
	// Saves courses to given file
	public void saveToXML() 
	{
		try
		{
			serializer.write(courses, file);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	// Takes input from saved xml files
	public CourseList inputFromXML()
	{
		
		if ( file.exists() )
		{
			courses = null;
			try 
			{
				courses = serializer.read(CourseList.class, file);
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return courses;
	}
}
