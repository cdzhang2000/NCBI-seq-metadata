package edu.vt.vbi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SequenceSource {
	int SEQUENCE_SOURCE_ID;
	double VOLUME_SAMPLE = 0.0d;
	String SAMPLING_STRATEGY = "";
	String PROPAGATION = "";
	int PROJECT_ID = 0;

	public SequenceSource(Connection conn) throws SQLException {
		this.SEQUENCE_SOURCE_ID = getSequenceSourceSeq(conn);
	}

	public SequenceSource(Connection conn, int pid) throws SQLException {
		this.SEQUENCE_SOURCE_ID = getSequenceSourceSeq(conn);
		this.PROJECT_ID = pid;
	}

	private int getSequenceSourceSeq(Connection conn) throws SQLException {
		String seq = "SELECT " + SchemaName.SCHEMA
				+ "Sequence_Source_SEQ.NEXTVAL FROM DUAL";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(seq);
		int id = 0;
		if (rs.next()) {
			id = rs.getInt(1);
		}
		rs.close();
		stmt.close();
		System.out.println("sequence next Sequence Source id= " + id);
		return id;
	}

	public void updateSequenceSource(Connection conn) throws SQLException {
		Statement stm = conn.createStatement();

		String sql = "INSERT INTO "
				+ SchemaName.SCHEMA
				+ "SEQUENCE_SOURCE( SEQUENCE_SOURCE_ID,VOLUME_SAMPLE,SAMPLING_STRATEGY,PROPAGATION,PROJECT_ID) VALUES("
				+ this.SEQUENCE_SOURCE_ID + "," + this.VOLUME_SAMPLE + ",'"
				+ this.SAMPLING_STRATEGY + "','" + this.PROPAGATION + "',"
				+ this.PROJECT_ID + " )";
		System.out.println(sql);
		try {
			stm.executeUpdate(sql);
			stm.close();
			System.out.println("successed in updating SequenceSource");
		} catch (SQLException e) {
			System.err.println("Error in update SequenceSource  ");
			throw new SQLException(this.getClass().getName());
		}
	}

	public int getSEQUENCE_SOURCE_ID() {
		return SEQUENCE_SOURCE_ID;
	}

	public void setSEQUENCE_SOURCE_ID(int sEQUENCESOURCEID) {
		SEQUENCE_SOURCE_ID = sEQUENCESOURCEID;
	}

	public double getVOLUME_SAMPLE() {
		return VOLUME_SAMPLE;
	}

	public void setVOLUME_SAMPLE(double vOLUMESAMPLE) {
		VOLUME_SAMPLE = vOLUMESAMPLE;
	}

	public String getSAMPLING_STRATEGY() {
		return SAMPLING_STRATEGY;
	}

	public void setSAMPLING_STRATEGY(String sAMPLINGSTRATEGY) {
		SAMPLING_STRATEGY = sAMPLINGSTRATEGY;
	}

	public String getPROPAGATION() {
		return PROPAGATION;
	}

	public void setPROPAGATION(String pROPAGATION) {
		PROPAGATION = pROPAGATION;
	}

	public int getPROJECT_ID() {
		return PROJECT_ID;
	}

	public void setPROJECT_ID(int pROJECTID) {
		PROJECT_ID = pROJECTID;
	}
}
