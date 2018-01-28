

package Materials;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;

/*
 * Predefined Graded Assignment
 * Basic assignment type for grading
 * @ authors Bora Ecer, Alp Ege Basturk
 * @ version 17.04.2016 v1 (Aziz Osman Kozhan & Emre Kuzhan)
 *           24.04.2016 v2 (Bora Ecer & Alp Ege Basturk)
 *           25.04.2016 v3 (Alp Ege Basturk_xml_i/o added)
 */

@Root
public class PredefinedGradedAssignment extends Assignment 
{   
   // Properties
   @ElementList
   ArrayList <PredefinedCriteria> criterias;
   
   //Constructor
   public PredefinedGradedAssignment( String name, double maxGrade)
   {
      super( name, maxGrade);
      criterias = new ArrayList<PredefinedCriteria>();
   }
   public PredefinedGradedAssignment(){}

   public double calculateGrade()
   {
      double finalGrade;
      double criteriaPercentage;
      double criteriaGrade;

      // Init
      finalGrade = 0;
      criteriaPercentage = 0;

      for (int i = 0; i < criterias.size(); i++)
      {
         criteriaPercentage = criterias.get(i).getPercentage();
         criteriaGrade = criteriaPercentage * criterias.get(i).getGrade();

         finalGrade = finalGrade + criteriaGrade;
      }
      setGrade(finalGrade);
      return finalGrade;
   }

   // Have to be here, can be used for allowing manual grading in the future for generalization
   public double calculateGrade(double gradeGivenByUser)
   {
      setGrade(gradeGivenByUser);
      return gradeGivenByUser;
   }


   // Adds criteria with a setted grade.
   public boolean addCriteria( String criteriaName, double percentage, double grade )
   {
      // If criteria does not exists
      if(!criteriaExists(criteriaName))
      {
         PredefinedCriteria newCriteria = new PredefinedCriteria(criteriaName, percentage);
         //set Grade
         newCriteria.setGrade(grade);
         criterias.add(newCriteria);
         return true;
      }
      else
      {
         return false;
      }
   }
   public boolean addCriteria(String criteriaName)
   {
      return false; // Not effective in this class
   }

   // Default criteria, graded with -1, which is default grade.
   public boolean addCriteria( String criteriaName, double persentage)
   {
      // If criteria does not exists
      if(!criteriaExists(criteriaName))
      {
         PredefinedCriteria newCriteria = new PredefinedCriteria(criteriaName, persentage);
         criterias.add(newCriteria);
         return true;
      }
      else
      {
         return false;
      }
   }

   // Removes criteria with index
   public boolean removeCriteria( int index)
   {
      if ( index < criterias.size() )
      {
         criterias.remove( index );
         return true;
      }
      else
      {
         return false;
      }
   }

   // Removes criteria with criteriaName
   public boolean removeCriteria(String criteriaName)
   {
      // Index of criteria
      int index;

      // Init

      index = -1;

      // If criteria exists in list then remove
      if(criteriaExists(criteriaName))
      {
         for ( int i = 0; i < criterias.size(); i++ )
         {
            if (criterias.get(i).getCriteria().equals(criteriaName))
            {
               index = i;
            }
         }
         criterias.remove(index);
         return true;
      }
      // Else return false.
      else
      {
         return false;
      }
   }

   public ArrayList<PredefinedCriteria> getCriterias()
   {
      return criterias;
   }

   public boolean criteriaExists(String criteriaName)
   {
      boolean criteriaExist;

      // Init

      criteriaExist = false;

      for ( int i = 0; i < criterias.size(); i++ )
      {
         if (criterias.get(i).getCriteria().equals(criteriaName))
         {
            criteriaExist = true;
         }
      }
      return criteriaExist;
   }
}