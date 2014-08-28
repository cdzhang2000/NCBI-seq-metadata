package edu.vt.vbi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Project {

	private String NAME;
	private String TYPE;
	private int PROJECT_ID;
	private String SUBMITTED_TO_REPOSITORY;
	private String COMPLETION_DATE;
	private String SEQUENCING_CENTER;
	private String SEQUENCING_STATUS;
	private String SEQUENCE_LINK;
	private String SEQENCE_AVAILABILITY;
	private String PROJECT_STATUS;

	public Project(Connection conn) throws SQLException {
		this.PROJECT_ID = getProjectSeq(conn);
		NAME = "";
		TYPE = "";
		SUBMITTED_TO_REPOSITORY = "";
		COMPLETION_DATE = "";
		SEQUENCING_CENTER = "";
		SEQUENCING_STATUS = "";
		SEQUENCE_LINK = "";
		SEQENCE_AVAILABILITY = "";
		PROJECT_STATUS = "";
	}

	private int getProjectSeq(Connection conn) throws SQLException {

		String seq = "SELECT " + SchemaName.SCHEMA
				+ "PROJECT_SEQ.NEXTVAL FROM DUAL";

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(seq);

		int id = 0;

		if (rs.next()) {
			id = rs.getInt(1);
		}
		rs.close();
		stmt.close();

		System.out.println("sequence next Project ID= " + id);
		return id;
	}

	public void updateProject(Connection conn) throws SQLException {
		Statement stm = conn.createStatement();

		String sql = "INSERT INTO "
				+ SchemaName.SCHEMA
				+ "PROJECT( PROJECT_ID, NAME,TYPE,SUBMITTED_TO_REPOSITORY,COMPLETION_DATE,SEQUENCING_CENTER,"
				+ "SEQUENCING_STATUS,SEQUENCE_LINK,SEQENCE_AVAILABILITY,PROJECT_STATUS) VALUES("+this.PROJECT_ID +",'"
				+ this.NAME + "','" + this.TYPE + "','"
				+ this.SUBMITTED_TO_REPOSITORY + "','" + this.COMPLETION_DATE
				+ "','" + this.SEQUENCING_CENTER + "','"
				+ this.SEQUENCING_STATUS + "','" + this.SEQUENCE_LINK + "','"
				+ this.SEQENCE_AVAILABILITY + "','" + this.PROJECT_STATUS
				+ "')";
		System.out.println(sql);
		try {
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			System.err.println("Error in update Host ");
			throw new SQLException(this.getClass().getName());
		}
	}

	public int existinDB(Connection conn) throws SQLException {
		int pid = 0;

		String sql = "select Project_id from " + SchemaName.SCHEMA
				+ ".project where NAME='" + this.NAME + "' AND TYPE='"
				+ this.TYPE + ", ADN PROJECT_STATUS='" + this.PROJECT_STATUS
				+ "'";
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		if (rs.next()) {
			pid = rs.getInt(1);
		}
		rs.close();
		stm.close();
		
		return pid;

	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getTYPE() {
		return TYPE;
	}

	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}

	public int getPROJECT_ID() {
		return PROJECT_ID;
	}

	public void setPROJECT_ID(int pROJECTID) {
		PROJECT_ID = pROJECTID;
	}

	public String getSUBMITTED_TO_REPOSITORY() {
		return SUBMITTED_TO_REPOSITORY;
	}

	public void setSUBMITTED_TO_REPOSITORY(String sUBMITTEDTOREPOSITORY) {
		SUBMITTED_TO_REPOSITORY = sUBMITTEDTOREPOSITORY;
	}

	public String getCOMPLETION_DATE() {
		return COMPLETION_DATE;
	}

	public void setCOMPLETION_DATE(String cOMPLETIONDATE) {
		COMPLETION_DATE = cOMPLETIONDATE;
	}

	public String getSEQUENCING_CENTER() {
		return SEQUENCING_CENTER;
	}

	public void setSEQUENCING_CENTER(String sEQUENCINGCENTER) {
		SEQUENCING_CENTER = sEQUENCINGCENTER;
	}

	public String getSEQUENCING_STATUS() {
		return SEQUENCING_STATUS;
	}

	public void setSEQUENCING_STATUS(String sEQUENCINGSTATUS) {
		SEQUENCING_STATUS = sEQUENCINGSTATUS;
	}

	public String getSEQUENCE_LINK() {
		return SEQUENCE_LINK;
	}

	public void setSEQUENCE_LINK(String sEQUENCELINK) {
		SEQUENCE_LINK = sEQUENCELINK;
	}

	public String getSEQENCE_AVAILABILITY() {
		return SEQENCE_AVAILABILITY;
	}

	public void setSEQENCE_AVAILABILITY(String sEQENCEAVAILABILITY) {
		SEQENCE_AVAILABILITY = sEQENCEAVAILABILITY;
	}

	public String getPROJECT_STATUS() {
		return PROJECT_STATUS;
	}

	public void setPROJECT_STATUS(String pROJECTSTATUS) {
		PROJECT_STATUS = pROJECTSTATUS;
	}
	

	public static void main(String args[]) {

		Connection conn;
		try {
			conn = DatabaseManager.instance().getConnection();
			Project o = new Project(conn);
			o.updateProject(conn);
		} catch (Exception e) {
	
			e.printStackTrace();
		}
	}

}
