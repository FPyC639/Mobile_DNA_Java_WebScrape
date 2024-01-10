package com.journaldev.maven.maven_example_jar;
import java.util.*;
import org.jsoup.nodes.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	System.out.println("Please declare a year that you would like to research:\t");
    	Scanner sc = new Scanner(System.in);
    	String year = sc.nextLine();
    	System.out.println("Please declare research query:\t");
    	String query = sc.nextLine();
    	sc.close();
        Helper a1 = new Helper();
        a1.setter_url("https://mobilednajournal.biomedcentral.com/articles");
        try {
			a1.setter_year(year);
		} catch (Exception e) {
			throw new Exception("Enter a Year from 2010 to 2023.");
		}
        try {
        	a1.setter_query(query);
        } catch (Exception e) {
        	throw new Exception("Enter a valid search query.");
        }
        Document doc = a1.establish_connection();
        a1.write_csv(doc);
    }
}
