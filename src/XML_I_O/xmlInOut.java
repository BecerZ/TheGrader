package XML_I_O;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 * Attempted import/export class
 * attempted helper class for xml i/o
 * @ author Alp Ege Basturk
 * @ version 25.04.2016 v1
 *
 */
public class xmlInOut
{
    public static void saveOut( Object o, String filename) throws Exception
    {
        XMLEncoder encoder = new XMLEncoder( new BufferedOutputStream( new FileOutputStream(filename + ".xml")));
        encoder.writeObject(o);
        encoder.close();
    }

    public static Object takeIn( String filename) throws Exception
    {
        XMLDecoder decoder = new XMLDecoder( new BufferedInputStream( new FileInputStream( filename)));
        Object o = decoder.readObject();
        decoder.close();
        return o;
    }
}