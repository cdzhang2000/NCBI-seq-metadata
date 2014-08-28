package edu.vt.vbi;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class OrganismHost {
	int	HOST_ID;
	int ORGANISM_ID;
	

	public OrganismHost(int oid, int hid){
		this.ORGANISM_ID=oid;
		this.HOST_ID=hid;
	}
	
	public void updateOrganismHost(Connection conn) throws SQLException {
		Statement stm = conn.createStatement();
		String sql = "INSERT INTO "
				+ SchemaName.SCHEMA
				+ "ORGANISM_HOST( ORGANISM_ID,HOST_ID) VALUES("
				+ this.ORGANISM_ID + "," + this.HOST_ID +" )";
		try {
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			System.err.println("Error in update ORGANISM_HOST ");
			throw new SQLException(this.getClass().getName());
		}
	}
}
