package com.act.common;

import java.io.Serializable;
import java.util.StringTokenizer;

/**
 * The person name generic class, per HL7 standard
 * 
 * @author Geena Renjan
 *
 */
public class PersonName implements Serializable{
	
	private static final long serialVersionUID = -866357532758521486L;
	
	//Name
	private String name;
	
	//Name in the format LName^FName^MName^Prefix^Suffix
	public PersonName(String name) {
		this.name = name;
	}
//	public String getLastName() {
//		return lName;
//	}
//	public void setLastName(String lName) {
//		this.lName = lName;
//	}
//	public String getFirstName() {
//		return fName;
//	}
//	public void setFirstName(String fName) {
//		this.fName = fName;
//	}
//	public String getPrefix() {
//		return preName;
//	}
//	public void setPrefix(String preName) {
//		this.preName = preName;
//	}
//	public String getSuffix() {
//		return suName;
//	}
//	public void setSuffix(String suName) {
//		this.suName = suName;
//	}
//	public String getMiddleName() {
//		return MName;
//	}
//	public void setMiddleName(String mName) {
//		MName = mName;
//	}

	public String getFormattedName(){
		if (name == null)
			return "";
		
		StringTokenizer tok = new StringTokenizer(name, "^");
		String sFormatName = "";
		while (tok.hasMoreTokens()){
			sFormatName += tok.nextToken();
			sFormatName += " ";
		}
		return sFormatName;
	}
	
	public static String getFormattedName(String name){
		if (name == null)
			return "";
		
		StringTokenizer tok = new StringTokenizer(name, "^");
		String sFormatName = "";
		while (tok.hasMoreTokens()){
			sFormatName += tok.nextToken();
			sFormatName += " ";
		}
		return sFormatName;
	}
	public String toString(){
		return name;
	}
	
	public String getLastName(){
		if (name == null)
			return "";
		
		return (name.substring(0, name.indexOf("^")));
	}

	public String getFName() {
		String[] cnsl_names = new String[3];
		System.out.println("The full name of the counselee is " + name);
		StringTokenizer st = new StringTokenizer(name, "^");
		int t = 0;
		while(st.hasMoreTokens()){
			cnsl_names[t] = st.nextToken();
			t++;
		}
		return (String)cnsl_names[1];
	}
	
	public String getMName() {
		String[] cnsl_names = new String[3];
		StringTokenizer st = new StringTokenizer(name, "^");
		int t = 0;
		while(st.hasMoreTokens()){
			cnsl_names[t] = st.nextToken();
			t++;
		}
		return (String)cnsl_names[2];
	}

}
