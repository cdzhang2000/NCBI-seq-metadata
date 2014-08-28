package edu.vt.vbi;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ProjectContactPerson {
	
	int PROJECT_ID;
	int PERSON_ID;
	

	public ProjectContactPerson(int projectid, int personid){
		this.PERSON_ID=personid;
		this.PROJECT_ID=projectid;
	}
	
	public void updateProjectContactPerson(Connection conn) throws SQLException {
		Statement stm = conn.createStatement();
		String sql = "INSERT INTO "
				+ SchemaName.SCHEMA
				+ "PROJECT_CONTACT_PERSON(PROJECT_ID,PERSON_ID) VALUES("
				+ this.PROJECT_ID+ "," + this.PERSON_ID +" )";
		try {
			stm.executeUpdate(sql);
			stm.close();
			System.out.println("successed in updating ProjectContactPerson");
		} catch (SQLException e) {
			System.err.println("Error in update ProjectContactPerson  ");
			throw new SQLException(this.getClass().getName());
		}
	}
}