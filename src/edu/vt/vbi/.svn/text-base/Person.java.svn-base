package edu.vt.vbi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Person {
	int PERSON_ID;
	String LAST_NAME="";
	String FIRST_NAME="";
	String FULL_NAME="";
	String ROLE="";
	String PHONE="";
	String FAX="";
	String EMAIL="";
	String ORGANIZATION="";
	String COUNTRY="";

	public Person(Connection conn) throws SQLException {
		this.PERSON_ID = getPersonSeq(conn);
	}

	private int getPersonSeq(Connection conn) throws SQLException {
		String seq = "SELECT " + SchemaName.SCHEMA
				+ "Person_SEQ.NEXTVAL FROM DUAL";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(seq);
		int id = 0;
		if (rs.next()) {
			id = rs.getInt(1);
		}
		rs.close();
		stmt.close();
		System.out.println("sequence next Person id= " + id);
		return id;
	}

	public void updatePerson(Connection conn) throws SQLException {
		Statement stm = conn.createStatement();

		String sql = "INSERT INTO "
				+ SchemaName.SCHEMA
				+ "Person ( PERSON_ID,LAST_NAME,FIRST_NAME,ROLE,PHONE,FAX,EMAIL,ORGANIZATION,COUNTRY,FULL_NAME) VALUES("
				+ this.PERSON_ID + ",'" + this.LAST_NAME + "','"
				+ this.FIRST_NAME + "','" + this.ROLE + "','" + this.PHONE
				+ "','" + this.FAX + "','" + this.EMAIL + "','"
				+ this.ORGANIZATION + "','" + this.COUNTRY + "','"
				+ this.FULL_NAME + "')";
		System.out.println(sql);
	
		
		try{
		
			stm.executeUpdate(sql);	
			stm.close();
			System.out.println("update person OK");
			}catch(SQLException e){
				System.err.println("Error in update Person ");
				throw new SQLException(this.getClass().getName());
			}
		
	}
	
	public int existinDB(Connection conn) throws SQLException {
		int pid = 0;
		
		String sql = "select PERSON_ID from " + SchemaName.SCHEMA
				+ ".PERSON where FULL_NAME='" + this.FULL_NAME + "' AND ORGANIZATION='"
				+ this.ORGANIZATION + "'";
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		if (rs.next()) {
			pid = rs.getInt(1);
		}
		rs.close();
		stm.close();
		
		return pid;

	}

	public int getPERSON_ID() {
		return PERSON_ID;
	}

	public void setPERSON_ID(int pERSONID) {
		PERSON_ID = pERSONID;
	}

	public String getLAST_NAME() {
		return LAST_NAME;
	}

	public void setLAST_NAME(String lASTNAME) {
		LAST_NAME = lASTNAME;
	}

	public String getFIRST_NAME() {
		return FIRST_NAME;
	}

	public void setFIRST_NAME(String fIRSTNAME) {
		FIRST_NAME = fIRSTNAME;
	}

	public String getFULL_NAME() {
		return FULL_NAME;
	}

	public void setFULL_NAME(String fULLNAME) {
		FULL_NAME = fULLNAME;
	}

	public String getROLE() {
		return ROLE;
	}

	public void setROLE(String rOLE) {
		ROLE = rOLE;
	}

	public String getPHONE() {
		return PHONE;
	}

	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}

	public String getFAX() {
		return FAX;
	}

	public void setFAX(String fAX) {
		FAX = fAX;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getORGANIZATION() {
		return ORGANIZATION;
	}

	public void setORGANIZATION(String oRGANIZATION) {
		ORGANIZATION = oRGANIZATION;
	}

	public String getCOUNTRY() {
		return COUNTRY;
	}

	public void setCOUNTRY(String cOUNTRY) {
		COUNTRY = cOUNTRY;
	}
}