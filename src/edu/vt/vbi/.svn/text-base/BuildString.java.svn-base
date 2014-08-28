package edu.vt.vbi;

import java.sql.Connection;
import java.util.StringTokenizer;

public class BuildString {
	
	
	public BuildString() {
	
	}
	
	public static void printString(String headers){
		
		StringBuffer  sql=new StringBuffer();
		
		StringTokenizer st=new StringTokenizer(headers, "\t");
		String temp="";
		
		while(st.hasMoreElements()){
		temp=st.nextToken().trim();
		temp=temp.replaceAll(" ", "_");
		sql.append(temp+" varchar2(4000),\n");	
		}		
		sql.append(")");
		
		System.out.println(sql.toString());
	}
	
public static void printString2(String headers){
		
		StringBuffer  sql=new StringBuffer();
		
		StringTokenizer st=new StringTokenizer(headers, "\t");
		String temp="";
		
		while(st.hasMoreElements()){
		temp=st.nextToken().trim();
	
		sql.append(temp+" \"TRIM(:"+temp+")\",\n");	
		}				
		System.out.println(sql.toString());
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String f="Category	ATTR_ID	51085	51087	51089	51091	51093	51095	51097	51099	51101	51103	51105	51107	51109	51111	51113	51115	51117	51119	51121	51123	51125	51127	51129	51131	51133	51135	51137	66215	66217	66219	66221	66223	66225	66227	66229	66231	66233	66235	66237	66239	66241	66243	66245	66247	66249	66251	66253	66255	66257	genome1	genome2	genome3	genome4	genome5	genome6	genome7	genome8	genome9	genome10	genome11	genome12	genome13	genome14";
		
		BuildString.printString(f);
		
		//String f2="";
		//BuildString.printString2(f);

	}

}
