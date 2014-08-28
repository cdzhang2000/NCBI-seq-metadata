package edu.vt.vbi.mgrast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public class ReadZip {
	
	
	public void readZipinfo(File file){
		try {			
			ZipFile zf = new ZipFile(file);
			Enumeration entries = zf.entries();
			System.out.println("start zip file");
			while (entries.hasMoreElements()) {
				ZipEntry ze = (ZipEntry) entries.nextElement();
				System.out.println(ze.getName()+"\t"+ze.getSize() );		
			}
			System.out.println("end zip file");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public void readZipinfo(String fileName){
		try {
			
			ZipFile zf = new ZipFile(fileName);
			Enumeration entries = zf.entries();
			System.out.println("start zip file");
			while (entries.hasMoreElements()) {
				ZipEntry ze = (ZipEntry) entries.nextElement();
				System.out.println(ze.getName()+"\t"+ze.getSize() );		
			}
			System.out.println("end zip file");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		String in = "S:\\czhang\\metagenomes\\16\\16.gz";
		//File file=new File(in);
		ReadZip rz=new ReadZip();
		rz.readZipinfo(in);
		
		
	}
}
