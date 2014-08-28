package edu.vt.vbi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Organism {

	int ORGANISM_ID;
	String GENUS;
	String SEROVAR_BIOVAR;
	String DOMAIN;
	String DISPLAY_NAME;
	String GRAM_STAINING;
	String SYMBIO_PHYSICAL_INTER;
	String BIOTIC_RELATIONSHIPS;
	String SYMBIOTIC_RELATIONSHIP;
	String SYMBIONT_NAME;
	String PHENOTYPES;
	String ENERGY_SOURCES;
	String OXYGEN_REQUIREMENT;
	String TEMPERATURE_RANGE;
	String TROPHIC_LEVEL;
	String GENETIC_LINEAGE;
	String ENCODED_TRAITS;
	String DISEASE;
	String TEMPERATURE_OPTIMAL;

	String GENOME_DATA;
	String SYMBIONT_TAXON_ID;
	String METABOLISM;
	String CULTURE_COLLECTION;
	String species;
	String strain;
	String taxonID;
	String sporulation;
	String salinity;
	String pH;
	String motility;

	public Organism(Connection conn) throws SQLException {
		this.ORGANISM_ID = getOrganismSeq(conn);
		GENUS = "";
		SEROVAR_BIOVAR = "";
		DOMAIN = "";
		DISPLAY_NAME = "";
		GRAM_STAINING = "";
		SYMBIO_PHYSICAL_INTER = "";
		BIOTIC_RELATIONSHIPS = "";
		SYMBIOTIC_RELATIONSHIP = "";
		SYMBIONT_NAME = "";
		PHENOTYPES = "";
		ENERGY_SOURCES = "";
		OXYGEN_REQUIREMENT = "";
		TEMPERATURE_RANGE = "";
		TROPHIC_LEVEL = "";
		GENETIC_LINEAGE = "";
		ENCODED_TRAITS = "";
		DISEASE = "";
		TEMPERATURE_OPTIMAL = "";
		GENOME_DATA = "";
		SYMBIONT_TAXON_ID = "";
		METABOLISM = "";
		CULTURE_COLLECTION = "";
	}

	private int getOrganismSeq(Connection conn) throws SQLException {
		String seq = "SELECT " + SchemaName.SCHEMA
				+ "ORGANISM_SEQ.NEXTVAL FROM DUAL";
		Statement stmt = conn.createStatement();
		System.out.println(seq);
		ResultSet rs = stmt.executeQuery(seq);
		int id = 0;
		if (rs.next()) {
			id = rs.getInt(1);
		}
		rs.close();
		stmt.close();
		System.out.println("sequence next Organism id= " + id);
		return id;
	}

	public void updateOrganism(Connection conn) throws SQLException {
		Statement stm = conn.createStatement();

		String sql = "INSERT INTO "
				+ SchemaName.SCHEMA
				+ "ORGANISM ( ORGANISM_ID,GENUS,SEROVAR_BIOVAR,DOMAIN,DISPLAY_NAME,GRAM_STAINING,"
				+ "SYMBIO_PHYSICAL_INTER,BIOTIC_RELATIONSHIPS,SYMBIOTIC_RELATIONSHIP,SYMBIONT_NAME,"
				+ "PHENOTYPES,ENERGY_SOURCES,OXYGEN_REQUIREMENT,TEMPERATURE_RANGE,TROPHIC_LEVEL,GENETIC_LINEAGE,"
				+ "ENCODED_TRAITS,DISEASE,TEMPERATURE_OPTIMAL,GENOME_DATA,SYMBIONT_TAXON_ID,"
				+ "METABOLISM,CULTURE_COLLECTION,SPECIES,STRAIN,TAXON_ID,SPORULATION,SALINITY,PH,MOTILITY) VALUES("
				+ this.ORGANISM_ID + ",'" + this.GENUS + "','"
				+ this.SEROVAR_BIOVAR + "','" + this.DOMAIN + "','"
				+ this.DISPLAY_NAME + "','" + this.GRAM_STAINING + "','"
				+ this.SYMBIO_PHYSICAL_INTER + "','"
				+ this.BIOTIC_RELATIONSHIPS + "','"
				+ this.SYMBIOTIC_RELATIONSHIP + "','" + this.SYMBIONT_NAME
				+ "','" + this.PHENOTYPES + "','" + this.ENERGY_SOURCES + "','"
				+ this.OXYGEN_REQUIREMENT + "','" + this.TEMPERATURE_RANGE
				+ "','" + this.TROPHIC_LEVEL + "','" + this.GENETIC_LINEAGE
				+ "','" + this.ENCODED_TRAITS + "','" + this.DISEASE + "','"
				+ this.TEMPERATURE_OPTIMAL + "','" + this.GENOME_DATA + "','"
				+ this.SYMBIONT_TAXON_ID + "','" + this.METABOLISM + "','"
				+ this.CULTURE_COLLECTION + "','" + this.species + "','"
				+ this.strain + "','" + this.taxonID + "','"+this.sporulation + "','"
				+ this.salinity + "','" + this.pH + "', '" + this.motility
				+ "')";

		System.out.println(sql);
		
		try {
			stm.executeUpdate(sql);
			stm.close();
			System.err.println("update organism success");
		} catch (SQLException e) {
			System.err.println("Error in update Organism ");
			throw new SQLException(this.getClass().getName());
		}
	}

	public int getORGANISM_ID() {
		return ORGANISM_ID;
	}

	public void setORGANISM_ID(int oRGANISMID) {
		ORGANISM_ID = oRGANISMID;
	}

	public String getGENUS() {
		return GENUS;
	}

	public void setGENUS(String gENUS) {
		GENUS = gENUS;
	}

	public String getSEROVAR_BIOVAR() {
		return SEROVAR_BIOVAR;
	}

	public void setSEROVAR_BIOVAR(String sEROVARBIOVAR) {
		SEROVAR_BIOVAR = sEROVARBIOVAR;
	}

	public String getDOMAIN() {
		return DOMAIN;
	}

	public void setDOMAIN(String dOMAIN) {
		DOMAIN = dOMAIN;
	}

	public String getDISPLAY_NAME() {
		return DISPLAY_NAME;
	}

	public void setDISPLAY_NAME(String dISPLAYNAME) {
		DISPLAY_NAME = dISPLAYNAME;
	}

	public String getGRAM_STAINING() {
		return GRAM_STAINING;
	}

	public void setGRAM_STAINING(String gRAMSTAINING) {
		GRAM_STAINING = gRAMSTAINING;
	}

	public String getSYMBIO_PHYSICAL_INTER() {
		return SYMBIO_PHYSICAL_INTER;
	}

	public void setSYMBIO_PHYSICAL_INTER(String sYMBIOPHYSICALINTER) {
		SYMBIO_PHYSICAL_INTER = sYMBIOPHYSICALINTER;
	}

	public String getBIOTIC_RELATIONSHIPS() {
		return BIOTIC_RELATIONSHIPS;
	}

	public void setBIOTIC_RELATIONSHIPS(String bIOTICRELATIONSHIPS) {
		BIOTIC_RELATIONSHIPS = bIOTICRELATIONSHIPS;
	}

	public String getSYMBIOTIC_RELATIONSHIP() {
		return SYMBIOTIC_RELATIONSHIP;
	}

	public void setSYMBIOTIC_RELATIONSHIP(String sYMBIOTICRELATIONSHIP) {
		SYMBIOTIC_RELATIONSHIP = sYMBIOTICRELATIONSHIP;
	}

	public String getSYMBIONT_NAME() {
		return SYMBIONT_NAME;
	}

	public void setSYMBIONT_NAME(String sYMBIONTNAME) {
		SYMBIONT_NAME = sYMBIONTNAME;
	}

	public String getPHENOTYPES() {
		return PHENOTYPES;
	}

	public void setPHENOTYPES(String pHENOTYPES) {
		PHENOTYPES = pHENOTYPES;
	}

	public String getENERGY_SOURCES() {
		return ENERGY_SOURCES;
	}

	public void setENERGY_SOURCES(String eNERGYSOURCES) {
		ENERGY_SOURCES = eNERGYSOURCES;
	}

	public String getOXYGEN_REQUIREMENT() {
		return OXYGEN_REQUIREMENT;
	}

	public void setOXYGEN_REQUIREMENT(String oXYGENREQUIREMENT) {
		OXYGEN_REQUIREMENT = oXYGENREQUIREMENT;
	}

	public String getTEMPERATURE_RANGE() {
		return TEMPERATURE_RANGE;
	}

	public void setTEMPERATURE_RANGE(String tEMPERATURERANGE) {
		TEMPERATURE_RANGE = tEMPERATURERANGE;
	}

	public String getTROPHIC_LEVEL() {
		return TROPHIC_LEVEL;
	}

	public void setTROPHIC_LEVEL(String tROPHICLEVEL) {
		TROPHIC_LEVEL = tROPHICLEVEL;
	}

	public String getGENETIC_LINEAGE() {
		return GENETIC_LINEAGE;
	}

	public void setGENETIC_LINEAGE(String gENETICLINEAGE) {
		GENETIC_LINEAGE = gENETICLINEAGE;
	}

	public String getENCODED_TRAITS() {
		return ENCODED_TRAITS;
	}

	public void setENCODED_TRAITS(String eNCODEDTRAITS) {
		ENCODED_TRAITS = eNCODEDTRAITS;
	}

	public String getDISEASE() {
		return DISEASE;
	}

	public void setDISEASE(String dISEASE) {
		DISEASE = dISEASE;
	}

	public String getGENOME_DATA() {
		return GENOME_DATA;
	}

	public void setGENOME_DATA(String gENOMEDATA) {
		GENOME_DATA = gENOMEDATA;
	}

	public String getSYMBIONT_TAXON_ID() {
		return SYMBIONT_TAXON_ID;
	}

	public void setSYMBIONT_TAXON_ID(String sYMBIONTTAXONID) {
		SYMBIONT_TAXON_ID = sYMBIONTTAXONID;
	}

	public String getMETABOLISM() {
		return METABOLISM;
	}

	public void setMETABOLISM(String mETABOLISM) {
		METABOLISM = mETABOLISM;
	}

	public String getCULTURE_COLLECTION() {
		return CULTURE_COLLECTION;
	}

	public void setCULTURE_COLLECTION(String cULTURECOLLECTION) {
		CULTURE_COLLECTION = cULTURECOLLECTION;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getStrain() {
		return strain;
	}

	public void setStrain(String strain) {
		this.strain = strain;
	}

	public String getTaxonID() {
		return taxonID;
	}

	public void setTaxonID(String taxonID) {
		this.taxonID = taxonID;
	}

	public String getSporulation() {
		return sporulation;
	}

	public void setSporulation(String sporulation) {
		this.sporulation = sporulation;
	}

	public String getSalinity() {
		return salinity;
	}

	public void setSalinity(String salinity) {
		this.salinity = salinity;
	}

	public String getpH() {
		return pH;
	}

	public void setpH(String pH) {
		this.pH = pH;
	}

	public String getTEMPERATURE_OPTIMAL() {
		return TEMPERATURE_OPTIMAL;
	}

	public void setTEMPERATURE_OPTIMAL(String tEMPERATUREOPTIMAL) {
		TEMPERATURE_OPTIMAL = tEMPERATUREOPTIMAL;
	}

	public String getMotility() {
		return motility;
	}

	public void setMotility(String motility) {
		this.motility = motility;
	}

	public static void main(String args[]) {

		Connection conn;
		try {
			conn = DatabaseManager.instance().getConnection();
			Organism o = new Organism(conn);
			o.updateOrganism(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
