package edu.vt.vbi;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class IsolatePerson {

	int PERSON_ID;
	String COLLECTION_DATE;
	String COLLECTION_PURPOSE;
	String COLLECTION_METHOD;
	int ORGANISM_ID;

	public IsolatePerson(int oid, int personid) {
		this.PERSON_ID = personid;
		this.ORGANISM_ID = oid;
	}

	public void updateIsolatePerson(Connection conn) throws SQLException {
		Statement stm = conn.createStatement();
		String sql = "INSERT INTO "
				+ SchemaName.SCHEMA
				+ "ISOLATE_PERSON(PERSON_ID,COLLECTION_DATE,COLLECTION_PURPOSE,COLLECTION_METHOD,ORGANISM_ID) VALUES("
				+ this.PERSON_ID + ",'" + this.COLLECTION_DATE + "','"
				+ this.COLLECTION_PURPOSE + "','" + this.COLLECTION_METHOD
				+ "'," + this.ORGANISM_ID + ")";
		try {
			stm.executeUpdate(sql);
			stm.close();
		} catch (SQLException e) {
			System.err.println("Error in update IsolatePerson  ");
			throw new SQLException(this.getClass().getName());
		}
	}
}
