package edu.vt.vbi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IsolateLocation {
	int ISOLATION_ENVIRONMENT_ID;
	String LATITUDE;
	String LONGITUDE;
	String DEPTH;
	String ALTITUDE;
	String COUNTRY;
	String LOCATION_TYPE;
	int ORGANISM_ID;

	public IsolateLocation(Connection conn, int oid) throws SQLException {
		this.ISOLATION_ENVIRONMENT_ID = getIsolateLocationSeq(conn);
		this.LATITUDE = "";
		this.LONGITUDE ="";
		this.ALTITUDE = "";
		this.COUNTRY = "";
		this.LOCATION_TYPE = "";
		this.ORGANISM_ID = oid;
	}

	private int getIsolateLocationSeq(Connection conn) throws SQLException {
		String seq = "SELECT " + SchemaName.SCHEMA
				+ "ISOLATION_ENV_SEQ.NEXTVAL FROM DUAL";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(seq);
		int id = 0;
		if (rs.next()) {
			id = rs.getInt(1);
		}
		rs.close();
		stmt.close();
		System.out.println("sequence next ISOLATION_ENV_SEQ id= " + id);
		return id;
	}

	public void updateIsolateLocation(Connection conn) throws SQLException {
		Statement stm = conn.createStatement();

		String sql = "INSERT INTO "
				+ SchemaName.SCHEMA
				+ "ISOLATION_ENVIRONMENT (ISOLATION_ENVIRONMENT_ID,LATITUDE,LONGITUDE,DEPTH,ALTITUDE,COUNTRY,LOCATION_TYPE,ORGANISM_ID) VALUES("
				+ this.ISOLATION_ENVIRONMENT_ID + ",'" + this.LATITUDE + "','"
				+ this.LONGITUDE + "','" + this.DEPTH + "','" + this.ALTITUDE
				+ "','" + this.COUNTRY + "','" + this.LOCATION_TYPE + "',"
				+ this.ORGANISM_ID + " )";
		System.err.println(sql);
		try {
			stm.executeUpdate(sql);
			stm.close();
			System.err.println("Successed in updating ISOLATION_ENVIRONMENT");
		} catch (SQLException e) {
			System.err.println("Error in update ISOLATION_ENVIRONMENT");
			throw new SQLException(this.getClass().getName());
		}
	}

	public int getISOLATION_ENVIRONMENT_ID() {
		return ISOLATION_ENVIRONMENT_ID;
	}

	public void setISOLATION_ENVIRONMENT_ID(int iSOLATIONENVIRONMENTID) {
		ISOLATION_ENVIRONMENT_ID = iSOLATIONENVIRONMENTID;
	}


	public String getCOUNTRY() {
		return COUNTRY;
	}

	public void setCOUNTRY(String cOUNTRY) {
		COUNTRY = cOUNTRY;
	}

	public String getLOCATION_TYPE() {
		return LOCATION_TYPE;
	}

	public void setLOCATION_TYPE(String lOCATIONTYPE) {
		LOCATION_TYPE = lOCATIONTYPE;
	}

	public int getORGANISM_ID() {
		return ORGANISM_ID;
	}

	public void setORGANISM_ID(int oRGANISMID) {
		ORGANISM_ID = oRGANISMID;
	}

	public String getLATITUDE() {
		return LATITUDE;
	}

	public void setLATITUDE(String lATITUDE) {
		LATITUDE = lATITUDE;
	}

	public String getLONGITUDE() {
		return LONGITUDE;
	}

	public void setLONGITUDE(String lONGITUDE) {
		LONGITUDE = lONGITUDE;
	}

	public String getDEPTH() {
		return DEPTH;
	}

	public void setDEPTH(String dEPTH) {
		DEPTH = dEPTH;
	}

	public String getALTITUDE() {
		return ALTITUDE;
	}

	public void setALTITUDE(String aLTITUDE) {
		ALTITUDE = aLTITUDE;
	}

}
