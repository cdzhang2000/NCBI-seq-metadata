package edu.vt.vbi;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ProjectOrganism {

	
	
	int PROJECT_ID;
	int ORGANISM_ID;
	String CO_ISOLATED_ORGANISMS="";
	String ISOLATE_PHENOTYPE="";
	String ISOLATE_GENOTYPE="";
	String ISOLATE_TREATMENT="";
	

	public ProjectOrganism(int pid, int oid) {
		this.PROJECT_ID = pid;
		this.ORGANISM_ID = oid;
	}

	public void updateProjectOrganism(Connection conn) throws SQLException {
		Statement stm = conn.createStatement();
		String sql = "INSERT INTO "
				+ SchemaName.SCHEMA
				+ "PROJECT_ORGANISM(PROJECT_ID,ORGANISM_ID,CO_ISOLATED_ORGANISMS,ISOLATE_PHENOTYPE," +
						"ISOLATE_GENOTYPE,ISOLATE_TREATMENT) VALUES("
				+ this.PROJECT_ID + "," + this.ORGANISM_ID+ ",'"
				+ this.CO_ISOLATED_ORGANISMS + "','" + this.ISOLATE_PHENOTYPE+"','"+
				this.ISOLATE_GENOTYPE+"','"+this.ISOLATE_TREATMENT+"')";
		System.out.println(sql);
		try {
			stm.executeUpdate(sql);
			stm.close();
			System.out.println("sucessed in updating Project_organism");
		} catch (SQLException e) {
			System.err.println("Error in update ProjectOrganism");
			throw new SQLException(this.getClass().getName());
		}
	}

	public int getPROJECT_ID() {
		return PROJECT_ID;
	}

	public void setPROJECT_ID(int pROJECTID) {
		PROJECT_ID = pROJECTID;
	}

	public int getORGANISM_ID() {
		return ORGANISM_ID;
	}

	public void setORGANISM_ID(int oRGANISMID) {
		ORGANISM_ID = oRGANISMID;
	}

	public String getCO_ISOLATED_ORGANISMS() {
		return CO_ISOLATED_ORGANISMS;
	}

	public void setCO_ISOLATED_ORGANISMS(String cOISOLATEDORGANISMS) {
		CO_ISOLATED_ORGANISMS = cOISOLATEDORGANISMS;
	}

	public String getISOLATE_PHENOTYPE() {
		return ISOLATE_PHENOTYPE;
	}

	public void setISOLATE_PHENOTYPE(String iSOLATEPHENOTYPE) {
		ISOLATE_PHENOTYPE = iSOLATEPHENOTYPE;
	}

	public String getISOLATE_GENOTYPE() {
		return ISOLATE_GENOTYPE;
	}

	public void setISOLATE_GENOTYPE(String iSOLATEGENOTYPE) {
		ISOLATE_GENOTYPE = iSOLATEGENOTYPE;
	}

	public String getISOLATE_TREATMENT() {
		return ISOLATE_TREATMENT;
	}

	public void setISOLATE_TREATMENT(String iSOLATETREATMENT) {
		ISOLATE_TREATMENT = iSOLATETREATMENT;
	}
	
}
