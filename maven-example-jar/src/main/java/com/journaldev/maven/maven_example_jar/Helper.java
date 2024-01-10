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
	private String query;

	public Helper() {
		super();
	}
	
	public Helper(String url, String year) {
		this.url = url;
		this.year = year;
	}
	
	public Helper(String url, String query, String year) {
		this.url = url;
		this.query = query;
		this.year = year;
	}
	
	public void setter_url(String url) {
		this.url = url;
	}
	
	public void setter_query(String query) {
		this.query = query;
	}
	
	public void setter_year(String year) throws Exception {
		switch(year) {
		case "2010":
			this.year = "1";
			break;
		case "2011":
			this.year = "2";
			break;
		case "2012":
			this.year = "3";
			break;
		case "2013":
			this.year = "4";
			break;
		case "2014":
			this.year = "5";
			break;
		case "2015":
			this.year = "6";
			break;
		case "2016":
			this.year = "7";
			break;
		case "2017":
			this.year = "8";
			break;
		case "2018":
			this.year = "9";
			break;
		case "2019":
			this.year = "10";
			break;
		case "2020":
			this.year = "11";
			break;
		case "2021":
			this.year = "12";
			break;
		case "2022":
			this.year = "13";
			break;
		case "2023":
			this.year = "14";
			break;
		default:
			throw new Exception("Insert Year from 2010 to 2023.");
		}
	}

	@Override
	public Document establish_connection() {
		try {
			Connection connect = Jsoup.connect(this.url);
			connect.data("query", this.query);
            connect.data("volume", this.year);
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