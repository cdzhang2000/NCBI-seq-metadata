package edu.vt.vbi.umd;

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
	
	public static void replace(String s, int startNumber, String prefix){
		
		StringBuffer  sql=new StringBuffer();
		
		StringTokenizer st=new StringTokenizer(s, "\t");
		String temp="";		
		int c=0;
		while(st.hasMoreElements()){			
		temp=st.nextToken();
		sql.append(prefix);
		sql.append(startNumber+"\t");
		startNumber++;
		c++;
		System.out.println(temp);
		}
		System.out.println("total no= "+c);
		System.out.println(sql.toString());
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String f="DOMAIN	ORGANISM NAME	STRAIN	SEROVAR/BIOVAR	CULTURE COLLECTION	TYPE STRAIN	PROJECT STATUS	AVAILABILITY	SEQUENCING CENTERS	COMPLETION DATE	PUBLICATION	NCBI TAXON_ID	NCBI PROJECT ID	GENBANK ACCESSIONS	REFSEQ ACCESSIONS	SEQUENCING STATUS	CHROMOSOMES	PLASMIDS	CONTIGS	SIZE	GC CONTENT	ISOLATION SITE	ISOLATION SOURCE	ISOLATION COMMENTS	COLLECTION DATE	ISOLATION COUNTRY	GEOGRAPHIC LOCATION	LATITUDE	LONGITUDE	ALTITUDE	DEPTH	HOST NAME	HOST GENDER	HOST AGE	HOST HEALTH	GRAM STAIN	CELL SHAPE	MOTILITY	SPORULATION	TEMPERATURE RANGE	OPTIMAL TEMPERATURE	SALINITY	OXYGEN REQUIREMENT	HABITAT	HOST	DISEASE	COMMENT";
		
		BuildString.printString(f);
		
		//String f2="";
		//BuildString.printString2(f);
		//BuildString.replace(f, 15, "genome");
	}

}
