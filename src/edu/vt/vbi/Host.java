package edu.vt.vbi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Host {
	String hostName; 
	int HOST_ID;
	int TAXONID;
	String GENDER;
	String AGE;
	String HEALTH;
	String HABIT;
	String DISEASE;
	String CELL_ARRANGEMENT;
	String CHEM_ADMINISTRATION;
	String BODY_HABITAT;
	String BODY_SITE;
	String BODY_PRODUCT;
	double TOT_MASS;
	double HEIGHT_OR_LENGTH;
	String DIET;
	String LAST_MEAL;
	String GROWTH_COND;
	String SUBSTRATE;
	String FAMILY_RELATIONSHIP;
	String INFRA_SPECIFIC_NAME;
	int INFRA_SPECIFIC_RANK;
	String GENOTYPE;
	String PHENOTYPE;
	double BODY_TEMP;
	double DRY_MASS;
	String BLOOD_PRESS_DIAST;
	String BLOOD_PRESS_SYST;
	String COLOR;
	String SHAPE;
	String BODY_TEMPERATURE;
	String SMOKER;
	String HIV_STATUS;
	String DRUG_USAGE;
	String OCCUPATION;
	String DIET_START_DATE;
	String DIET_END_DATE;
	String BLOOD_DISORDER;
	String LUNG_PULMONARY_DISORDER;
	String NOSE_THORAD_DISORDER;
	String BODY_SAMPLE_SUBSITE;
	

	public Host(Connection conn)throws SQLException{
		this.HOST_ID=getHostSeq(conn);
		TAXONID=0;
		GENDER="";
		AGE="";
		HEALTH="";
		HABIT="";
		DISEASE="";
		CELL_ARRANGEMENT="";
		CHEM_ADMINISTRATION="";
		BODY_HABITAT="";
		BODY_SITE="";
		BODY_PRODUCT="";
		TOT_MASS=0.0;
		HEIGHT_OR_LENGTH=0.0;
		DIET="";
		LAST_MEAL="";
		GROWTH_COND="";
		SUBSTRATE="";
		FAMILY_RELATIONSHIP="";
		INFRA_SPECIFIC_NAME="";
		INFRA_SPECIFIC_RANK=0;
		GENOTYPE="";
		PHENOTYPE="";
		BODY_TEMP=0.0;
		DRY_MASS=0.0;
		BLOOD_PRESS_DIAST="";
		BLOOD_PRESS_SYST="";
		COLOR="";
		SHAPE="";
		BODY_TEMPERATURE="";
		SMOKER="";
		HIV_STATUS="";
		DRUG_USAGE="";
		OCCUPATION="";
		DIET_START_DATE="";
		DIET_END_DATE="";
		BLOOD_DISORDER="";
		LUNG_PULMONARY_DISORDER="";
		NOSE_THORAD_DISORDER="";
		BODY_SAMPLE_SUBSITE="";
	}
	
	private int getHostSeq(Connection conn) throws SQLException {
		
		String seq = "SELECT "+ SchemaName.SCHEMA+"HOST_SEQ.NEXTVAL FROM DUAL";
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery(seq);
		
		int id = 0;
		
		if (rs.next()) {
			id = rs.getInt(1);
		}
		rs.close();
		stmt.close();
		
		System.out.println("sequence next Host ID= "+ id);
		return id;
	}
	
	public void	updateHost(Connection conn)throws SQLException {
		Statement stm=conn.createStatement();
		
		String sql="INSERT INTO "+SchemaName.SCHEMA+"HOST( HOST_ID,HOST_NAME, TAXONID,GENDER,AGE,HEALTH,HABIT,DISEASE,CELL_ARRANGEMENT," +
				"CHEM_ADMINISTRATION,BODY_HABITAT,BODY_SITE,BODY_PRODUCT,TOT_MASS,HEIGHT_OR_LENGTH,DIET,LAST_MEAL,GROWTH_COND," +
				"SUBSTRATE,FAMILY_RELATIONSHIP,INFRA_SPECIFIC_NAME,INFRA_SPECIFIC_RANK,GENOTYPE,PHENOTYPE,DRY_MASS," +
				"BLOOD_PRESS_DIAST,COLOR,SHAPE,BODY_TEMPERATURE,SMOKER,HIV_STATUS,DRUG_USAGE,OCCUPATION," +
				"DIET_START_DATE,DIET_END_DATE,BLOOD_DISORDER,LUNG_PULMONARY_DISORDER,NOSE_THORAD_DISORDER,BODY_SAMPLE_SUBSITE) VALUES("+
		this.HOST_ID+",'"+this.hostName+"',"+ this.TAXONID+",'"+this.GENDER+"','"+this.AGE+"','"+this.HEALTH+"','"+
		this.HABIT+"','"+this.DISEASE+"','"+this.CELL_ARRANGEMENT+"','"+this.CHEM_ADMINISTRATION+"','"+
		this.BODY_HABITAT+"','"+this.BODY_SITE+"','"+this.BODY_PRODUCT+"',"+ this.TOT_MASS+","+
		this.HEIGHT_OR_LENGTH+",'"+this.DIET+"','"+this.LAST_MEAL+"','"+this.GROWTH_COND+"','"+this.SUBSTRATE+"','"+
		this.FAMILY_RELATIONSHIP+"','"+this.INFRA_SPECIFIC_NAME+"','"+this.INFRA_SPECIFIC_RANK+"','"+this.GENOTYPE+"','"+
		this.PHENOTYPE+"',"+this.DRY_MASS+",'"+ this.BLOOD_PRESS_DIAST+"','"+
		this.COLOR+"','"+this.SHAPE+"','"+this.BODY_TEMPERATURE+"','"+ this.SMOKER+"','"+
		this.HIV_STATUS+"','"+this.DRUG_USAGE+"','"+this.OCCUPATION+"','"+this.DIET_START_DATE+"','"+this.DIET_END_DATE+"','"+
		this.BLOOD_DISORDER+"','"+this.LUNG_PULMONARY_DISORDER+"','"+this.NOSE_THORAD_DISORDER+"','"+this.BODY_SAMPLE_SUBSITE+"')";
		System.out.println(sql);
		try{
		stm.executeUpdate(sql);	
		stm.close();
		System.err.println("Successed in updating Host ");
		}catch(SQLException e){
			System.err.println("Error in update Host ");
			throw new SQLException(this.getClass().getName());
		}
	}


	public int getHOST_ID() {
		return HOST_ID;
	}

	public void setHOST_ID(int hOSTID) {
		HOST_ID = hOSTID;
	}

	public int getTAXONID() {
		return TAXONID;
	}

	public void setTAXONID(int tAXONID) {
		TAXONID = tAXONID;
	}

	public String getGENDER() {
		return GENDER;
	}

	public void setGENDER(String gENDER) {
		GENDER = gENDER;
	}

	public String getHEALTH() {
		return HEALTH;
	}

	public void setHEALTH(String hEALTH) {
		HEALTH = hEALTH;
	}

	public String getHABIT() {
		return HABIT;
	}

	public void setHABIT(String hABIT) {
		HABIT = hABIT;
	}

	public String getDISEASE() {
		return DISEASE;
	}

	public void setDISEASE(String dISEASE) {
		DISEASE = dISEASE;
	}

	public String getCELL_ARRANGEMENT() {
		return CELL_ARRANGEMENT;
	}

	public void setCELL_ARRANGEMENT(String cELLARRANGEMENT) {
		CELL_ARRANGEMENT = cELLARRANGEMENT;
	}

	public String getCHEM_ADMINISTRATION() {
		return CHEM_ADMINISTRATION;
	}

	public void setCHEM_ADMINISTRATION(String cHEMADMINISTRATION) {
		CHEM_ADMINISTRATION = cHEMADMINISTRATION;
	}

	public String getBODY_HABITAT() {
		return BODY_HABITAT;
	}

	public void setBODY_HABITAT(String bODYHABITAT) {
		BODY_HABITAT = bODYHABITAT;
	}

	public String getBODY_SITE() {
		return BODY_SITE;
	}

	public void setBODY_SITE(String bODYSITE) {
		BODY_SITE = bODYSITE;
	}

	public String getBODY_PRODUCT() {
		return BODY_PRODUCT;
	}

	public void setBODY_PRODUCT(String bODYPRODUCT) {
		BODY_PRODUCT = bODYPRODUCT;
	}

	public double getTOT_MASS() {
		return TOT_MASS;
	}

	public void setTOT_MASS(double tOTMASS) {
		TOT_MASS = tOTMASS;
	}

	public double getHEIGHT_OR_LENGTH() {
		return HEIGHT_OR_LENGTH;
	}

	public void setHEIGHT_OR_LENGTH(double hEIGHTORLENGTH) {
		HEIGHT_OR_LENGTH = hEIGHTORLENGTH;
	}

	public String getDIET() {
		return DIET;
	}

	public void setDIET(String dIET) {
		DIET = dIET;
	}

	public String getLAST_MEAL() {
		return LAST_MEAL;
	}

	public void setLAST_MEAL(String lASTMEAL) {
		LAST_MEAL = lASTMEAL;
	}

	public String getGROWTH_COND() {
		return GROWTH_COND;
	}

	public void setGROWTH_COND(String gROWTHCOND) {
		GROWTH_COND = gROWTHCOND;
	}

	public String getSUBSTRATE() {
		return SUBSTRATE;
	}

	public void setSUBSTRATE(String sUBSTRATE) {
		SUBSTRATE = sUBSTRATE;
	}

	public String getFAMILY_RELATIONSHIP() {
		return FAMILY_RELATIONSHIP;
	}

	public void setFAMILY_RELATIONSHI(String fAMILYRELATIONSHIP) {
		FAMILY_RELATIONSHIP = fAMILYRELATIONSHIP;
	}

	public String getINFRA_SPECIFIC_NAME() {
		return INFRA_SPECIFIC_NAME;
	}

	public void setINFRA_SPECIFIC_NAME(String iNFRASPECIFICNAME) {
		INFRA_SPECIFIC_NAME = iNFRASPECIFICNAME;
	}

	public int getINFRA_SPECIFIC_RANK() {
		return INFRA_SPECIFIC_RANK;
	}

	public void setINFRA_SPECIFIC_RANK(int iNFRASPECIFICRANK) {
		INFRA_SPECIFIC_RANK = iNFRASPECIFICRANK;
	}

	public String getGENOTYPE() {
		return GENOTYPE;
	}

	public void setGENOTYPE(String gENOTYPE) {
		GENOTYPE = gENOTYPE;
	}

	public String getPHENOTYPE() {
		return PHENOTYPE;
	}

	public void setPHENOTYPE(String pHENOTYPE) {
		PHENOTYPE = pHENOTYPE;
	}

	public double getBODY_TEMP() {
		return BODY_TEMP;
	}

	public void setBODY_TEMP(double bODYTEMP) {
		BODY_TEMP = bODYTEMP;
	}

	public double getDRY_MASS() {
		return DRY_MASS;
	}

	public void setDRY_MASS(double dRYMASS) {
		DRY_MASS = dRYMASS;
	}

	public String getBLOOD_PRESS_DIAST() {
		return BLOOD_PRESS_DIAST;
	}

	public void setBLOOD_PRESS_DIAST(String bLOODPRESSDIAST) {
		BLOOD_PRESS_DIAST = bLOODPRESSDIAST;
	}

	public String getBLOOD_PRESS_SYST() {
		return BLOOD_PRESS_SYST;
	}

	public void setBLOOD_PRESS_SYST(String bLOODPRESSSYST) {
		BLOOD_PRESS_SYST = bLOODPRESSSYST;
	}

	public String getCOLOR() {
		return COLOR;
	}

	public void setCOLOR(String cOLOR) {
		COLOR = cOLOR;
	}

	public String getSHAPE() {
		return SHAPE;
	}

	public void setSHAPE(String sHAPE) {
		SHAPE = sHAPE;
	}

	public String getBODY_TEMPERATURE() {
		return BODY_TEMPERATURE;
	}

	public void setBODY_TEMPERATURE(String bODYTEMPERATURE) {
		BODY_TEMPERATURE = bODYTEMPERATURE;
	}

	public String getSMOKER() {
		return SMOKER;
	}

	public void setSMOKER(String sMOKER) {
		SMOKER = sMOKER;
	}

	public String getHIV_STATUS() {
		return HIV_STATUS;
	}

	public void setHIV_STATUS(String hIVSTATUS) {
		HIV_STATUS = hIVSTATUS;
	}

	public String getDRUG_USAGE() {
		return DRUG_USAGE;
	}

	public void setDRUG_USAGE(String dRUGUSAGE) {
		DRUG_USAGE = dRUGUSAGE;
	}

	public String getOCCUPATION() {
		return OCCUPATION;
	}

	public void setOCCUPATION(String oCCUPATION) {
		OCCUPATION = oCCUPATION;
	}

	public String getDIET_START_DATE() {
		return DIET_START_DATE;
	}

	public void setDIET_START_DATE(String dIETSTARTDATE) {
		DIET_START_DATE = dIETSTARTDATE;
	}

	public String getDIET_END_DATE() {
		return DIET_END_DATE;
	}

	public void setDIET_END_DATE(String dIETENDDATE) {
		DIET_END_DATE = dIETENDDATE;
	}

	public String getBLOOD_DISORDER() {
		return BLOOD_DISORDER;
	}

	public void setBLOOD_DISORDER(String bLOODDISORDER) {
		BLOOD_DISORDER = bLOODDISORDER;
	}

	public String getLUNG_PULMONARY_DISORDER() {
		return LUNG_PULMONARY_DISORDER;
	}

	public void setLUNG_PULMONARY_DISORDER(String lUNGPULMONARYDISORDER) {
		LUNG_PULMONARY_DISORDER = lUNGPULMONARYDISORDER;
	}

	public String getNOSE_THORAD_DISORDER() {
		return NOSE_THORAD_DISORDER;
	}

	public void setNOSE_THORAD_DISORDER(String nOSETHORADDISORDER) {
		NOSE_THORAD_DISORDER = nOSETHORADDISORDER;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getAGE() {
		return AGE;
	}

	public void setAGE(String aGE) {
		AGE = aGE;
	}

	public String getBODY_SAMPLE_SUBSITE() {
		return BODY_SAMPLE_SUBSITE;
	}

	public void setBODY_SAMPLE_SUBSITE(String bODYSAMPLESUBSITE) {
		BODY_SAMPLE_SUBSITE = bODYSAMPLESUBSITE;
	}

	public void setFAMILY_RELATIONSHIP(String fAMILYRELATIONSHIP) {
		FAMILY_RELATIONSHIP = fAMILYRELATIONSHIP;
	}
}
