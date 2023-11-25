package com.journaldev.maven.maven_example_jar;
import org.jsoup.nodes.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Helper a1 = new Helper();
        a1.setter_url("https://mobilednajournal.biomedcentral.com/articles");
        a1.setter_year("2019");
        Document doc = a1.establish_connection();
        a1.write_csv(doc);
    }
}
