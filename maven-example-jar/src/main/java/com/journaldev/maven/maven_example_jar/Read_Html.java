package com.journaldev.maven.maven_example_jar;
import org.jsoup.*;
import org.jsoup.nodes.*;

public abstract class Read_Html {
	
	public abstract Document establish_connection();
	public abstract void write_csv(Document data);

}

