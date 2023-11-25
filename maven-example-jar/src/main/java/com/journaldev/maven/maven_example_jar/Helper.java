package com.journaldev.maven.maven_example_jar;
import com.journaldev.maven.maven_example_jar.Read_Html;

import java.io.Console;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.jsoup.*;
import org.jsoup.nodes.*;


public class Helper extends Read_Html{
	
	private String url;
	private String year;

	public Helper() {
		super();
	}
	
	public Helper(String url, String year) {
		this.url = url;
		this.year = year;
	}
	
	public void setter_url(String url) {
		this.url = url;
	}
	
	public void setter_year(String year) {
		this.year = year;
	}

	@Override
	public Document establish_connection() {
		try {
			Connection connect = Jsoup.connect(this.url);
			connect.data("query", this.year);
            connect.data("volume", "");
            connect.data("searchType", "");
            connect.data("tab","keyword");
            
            Document doc = connect.get();
            
            return doc;
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	@Override
	public void write_csv(Document data) {
		List<Element> ls_title = data.getElementsByClass("c-listing__title");
		String csvFileName = "data.txt";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFileName))) {
            writer.write("Index;Title\n");
            for(int count = 1; count < ls_title.size()+1; count++) {
            	writer.write(String.valueOf(count) + ";" + ls_title.get(count-1).text().strip() + "\n");
            }
            System.out.println("Data has been written to " + csvFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
}