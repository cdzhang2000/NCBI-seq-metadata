package edu.vt.vbi;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SequenceOrganism {
	
	int ORGANISM_ID;
	int SEQUENCE_SOURCE_ID;
	
	public SequenceOrganism(int oid, int sid){
		this.ORGANISM_ID=oid;
		this.SEQUENCE_SOURCE_ID=sid;
	}
	
	public void updateSequenceSource(Connection conn) throws SQLException {
		Statement stm = conn.createStatement();
		String sql = "INSERT INTO "
				+ SchemaName.SCHEMA
				+ "SEQUENCE_ORGANISM( ORGANISM_ID,SEQUENCE_SOURCE_ID) VALUES("
				+ this.ORGANISM_ID + "," + this.SEQUENCE_SOURCE_ID +" )";
		try {
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			System.err.println("Error in update SEQUENCE_ORGANISM  ");
			throw new SQLException(this.getClass().getName());
		}
	}
}
