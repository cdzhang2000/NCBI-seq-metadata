package edu.vt.vbi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sequencing {
	int SEQUENCE_ID;
	double GC_PERCENTAGE;
	String LIBRARY_METHOD;
	int NUMBER_READS;
	String VECTOR;
	int SEQUENCE_DEPTH;
	String GENE_CALLING_METHOD;
	String ANNOTATION_SOURCE;
	int CONTIG_COUNT;
	double ESTIMATED_SIZE;
	int GENE_COUNT_ORF;
	int CHROMOSOME_COUNT;
	int PLASMID_COUNT;
	String LIBRARY_SCREEN;
	double LIBRARY_SIZE;
	int TARGET_GENE;
	int TARGET_SUBFRAGMENT;
	String PCR_PRIMERS;
	String MULTIPLEX_IDENTIFIERS;
	String ADAPTERS;
	String PCR_CONDITIONS;
	String SEQUENCE_QUALITY_CHECK;
	String ASSEMBLY_NAME;
	String STANDARD_OPERATING_PROCEDURES;
	int SINGLET_COUNT;
	String SEQUENCING_COUNTRY;
	int SEQUENCE_SOURCE_ID;
	String SEQUENCING_QUALITY;
	int READS_COUNT;
	String sequenceStatus;

	public Sequencing(Connection conn) throws SQLException {
		this.SEQUENCE_ID = getSequencingSeq(conn);
	}
	
	public Sequencing(Connection conn, int seqSourceId) throws SQLException {
		this.SEQUENCE_ID = getSequencingSeq(conn);
		this.SEQUENCE_SOURCE_ID=seqSourceId;
	}

	private int getSequencingSeq(Connection conn) throws SQLException {
		String seq = "SELECT " + SchemaName.SCHEMA
				+ "Sequencing_SEQ.NEXTVAL FROM DUAL";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(seq);
		int id = 0;
		if (rs.next()) {
			id = rs.getInt(1);
		}
		rs.close();
		stmt.close();
		System.out.println("sequence next Sequencing id= " + id);
		return id;
	}

	public void updateSequencing(Connection conn) throws SQLException {
		Statement stm = conn.createStatement();

		String sql = "INSERT INTO "
				+ SchemaName.SCHEMA
				+ "Sequencing  ( SEQUENCE_ID,GC_PERCENTAGE,LIBRARY_METHOD,NUMBER_READS,VECTOR,SEQUENCE_DEPTH,GENE_CALLING_METHOD,ANNOTATION_SOURCE,"
				+ "CONTIG_COUNT,ESTIMATED_SIZE,GENE_COUNT_ORF,LIBRARY_SCREEN,LIBRARY_SIZE,TARGET_GENE,SEQUENCE_QUALITY_CHECK,ASSEMBLY_NAME,"
				+ "SEQUENCE_SOURCE_ID, SEQUENCING_STATUS,SEQUENCING_QUALITY,READS_COUNT) VALUES("
				+ this.SEQUENCE_ID + "," + this.GC_PERCENTAGE + ",'"
				+ this.LIBRARY_METHOD + "','" + this.NUMBER_READS + "','"
				+ this.VECTOR + "'," + this.SEQUENCE_DEPTH + ",'"
				+ this.GENE_CALLING_METHOD + "','" + this.ANNOTATION_SOURCE
				+ "'," + this.CONTIG_COUNT + ",'" + this.ESTIMATED_SIZE + "',"
				+ this.GENE_COUNT_ORF + ",'" + this.LIBRARY_SCREEN + "',"
				+ this.LIBRARY_SIZE + "," + this.TARGET_GENE + ",'"
				+ this.SEQUENCE_QUALITY_CHECK + "','" + this.ASSEMBLY_NAME
				+ "'," + this.SEQUENCE_SOURCE_ID + ",'"+this.sequenceStatus+"','"
				+ this.SEQUENCING_QUALITY + "','" + this.READS_COUNT + "')";
		System.err.println(sql);
		try{
			stm.executeUpdate(sql);	
			stm.close();
			System.err.println("Successed in update Sequencing ");
			}catch(SQLException e){
				System.err.println("Error in update Sequencing ");
				throw new SQLException(this.getClass().getName());
			}
	}

	public int getSEQUENCE_ID() {
		return SEQUENCE_ID;
	}

	public void setSEQUENCE_ID(int sEQUENCEID) {
		SEQUENCE_ID = sEQUENCEID;
	}

	public double getGC_PERCENTAGE() {
		return GC_PERCENTAGE;
	}

	public void setGC_PERCENTAGE(double gCPERCENTAGE) {
		GC_PERCENTAGE = gCPERCENTAGE;
	}

	public String getLIBRARY_METHOD() {
		return LIBRARY_METHOD;
	}

	public void setLIBRARY_METHOD(String lIBRARYMETHOD) {
		LIBRARY_METHOD = lIBRARYMETHOD;
	}

	public int getNUMBER_READS() {
		return NUMBER_READS;
	}

	public void setNUMBER_READS(int nUMBERREADS) {
		NUMBER_READS = nUMBERREADS;
	}

	public String getVECTOR() {
		return VECTOR;
	}

	public void setVECTOR(String vECTOR) {
		VECTOR = vECTOR;
	}

	public String getGENE_CALLING_METHOD() {
		return GENE_CALLING_METHOD;
	}

	public void setGENE_CALLING_METHOD(String gENECALLINGMETHOD) {
		GENE_CALLING_METHOD = gENECALLINGMETHOD;
	}

	public String getANNOTATION_SOURCE() {
		return ANNOTATION_SOURCE;
	}

	public void setANNOTATION_SOURCE(String aNNOTATIONSOURCE) {
		ANNOTATION_SOURCE = aNNOTATIONSOURCE;
	}


	public double getESTIMATED_SIZE() {
		return ESTIMATED_SIZE;
	}

	public void setESTIMATED_SIZE(double eSTIMATEDSIZE) {
		ESTIMATED_SIZE = eSTIMATEDSIZE;
	}

	public int getGENE_COUNT_ORF() {
		return GENE_COUNT_ORF;
	}

	public void setGENE_COUNT_ORF(int gENECOUNTORF) {
		GENE_COUNT_ORF = gENECOUNTORF;
	}

	public int getCHROMOSOME_COUNT() {
		return CHROMOSOME_COUNT;
	}

	public void setCHROMOSOME_COUNT(int cHROMOSOMECOUNT) {
		CHROMOSOME_COUNT = cHROMOSOMECOUNT;
	}

	public int getPLASMID_COUNT() {
		return PLASMID_COUNT;
	}

	public void setPLASMID_COUNT(int pLASMIDCOUNT) {
		PLASMID_COUNT = pLASMIDCOUNT;
	}

	public String getLIBRARY_SCREEN() {
		return LIBRARY_SCREEN;
	}

	public void setLIBRARY_SCREEN(String lIBRARYSCREEN) {
		LIBRARY_SCREEN = lIBRARYSCREEN;
	}

	public double getLIBRARY_SIZE() {
		return LIBRARY_SIZE;
	}

	public void setLIBRARY_SIZE(double lIBRARYSIZE) {
		LIBRARY_SIZE = lIBRARYSIZE;
	}

	public int getTARGET_GENE() {
		return TARGET_GENE;
	}

	public void setTARGET_GENE(int tARGETGENE) {
		TARGET_GENE = tARGETGENE;
	}

	public int getTARGET_SUBFRAGMENT() {
		return TARGET_SUBFRAGMENT;
	}

	public void setTARGET_SUBFRAGMENT(int tARGETSUBFRAGMENT) {
		TARGET_SUBFRAGMENT = tARGETSUBFRAGMENT;
	}

	public String getPCR_PRIMERS() {
		return PCR_PRIMERS;
	}

	public void setPCR_PRIMERS(String pCRPRIMERS) {
		PCR_PRIMERS = pCRPRIMERS;
	}

	public String getMULTIPLEX_IDENTIFIERS() {
		return MULTIPLEX_IDENTIFIERS;
	}

	public void setMULTIPLEX_IDENTIFIERS(String mULTIPLEXIDENTIFIERS) {
		MULTIPLEX_IDENTIFIERS = mULTIPLEXIDENTIFIERS;
	}

	public String getADAPTERS() {
		return ADAPTERS;
	}

	public void setADAPTERS(String aDAPTERS) {
		ADAPTERS = aDAPTERS;
	}

	public String getPCR_CONDITIONS() {
		return PCR_CONDITIONS;
	}

	public void setPCR_CONDITIONS(String pCRCONDITIONS) {
		PCR_CONDITIONS = pCRCONDITIONS;
	}

	public String getSEQUENCE_QUALITY_CHECK() {
		return SEQUENCE_QUALITY_CHECK;
	}

	public void setSEQUENCE_QUALITY_CHECK(String sEQUENCEQUALITYCHECK) {
		SEQUENCE_QUALITY_CHECK = sEQUENCEQUALITYCHECK;
	}

	public String getASSEMBLY_NAME() {
		return ASSEMBLY_NAME;
	}

	public void setASSEMBLY_NAME(String aSSEMBLYNAME) {
		ASSEMBLY_NAME = aSSEMBLYNAME;
	}

	public String getSTANDARD_OPERATING_PROCEDURES() {
		return STANDARD_OPERATING_PROCEDURES;
	}

	public void setSTANDARD_OPERATING_PROCEDURES(
			String sTANDARDOPERATINGPROCEDURES) {
		STANDARD_OPERATING_PROCEDURES = sTANDARDOPERATINGPROCEDURES;
	}

	public int getSINGLET_COUNT() {
		return SINGLET_COUNT;
	}

	public void setSINGLET_COUNT(int sINGLETCOUNT) {
		SINGLET_COUNT = sINGLETCOUNT;
	}

	public String getSEQUENCING_COUNTRY() {
		return SEQUENCING_COUNTRY;
	}

	public void setSEQUENCING_COUNTRY(String sEQUENCINGCOUNTRY) {
		SEQUENCING_COUNTRY = sEQUENCINGCOUNTRY;
	}

	public int getSEQUENCE_SOURCE_ID() {
		return SEQUENCE_SOURCE_ID;
	}

	public void setSEQUENCE_SOURCE_ID(int sEQUENCESOURCEID) {
		SEQUENCE_SOURCE_ID = sEQUENCESOURCEID;
	}

	public String getSEQUENCING_QUALITY() {
		return SEQUENCING_QUALITY;
	}

	public void setSEQUENCING_QUALITY(String sEQUENCINGQUALITY) {
		SEQUENCING_QUALITY = sEQUENCINGQUALITY;
	}


	public String getSequenceStatus() {
		return sequenceStatus;
	}

	public void setSequenceStatus(String sequenceStatus) {
		this.sequenceStatus = sequenceStatus;
	}

	public int getSEQUENCE_DEPTH() {
		return SEQUENCE_DEPTH;
	}

	public void setSEQUENCE_DEPTH(int sEQUENCEDEPTH) {
		SEQUENCE_DEPTH = sEQUENCEDEPTH;
	}

	public int getCONTIG_COUNT() {
		return CONTIG_COUNT;
	}

	public void setCONTIG_COUNT(int cONTIGCOUNT) {
		CONTIG_COUNT = cONTIGCOUNT;
	}

	public int getREADS_COUNT() {
		return READS_COUNT;
	}

	public void setREADS_COUNT(int rEADSCOUNT) {
		READS_COUNT = rEADSCOUNT;
	}

}
