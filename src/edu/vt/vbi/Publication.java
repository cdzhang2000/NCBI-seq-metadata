package edu.vt.vbi;

public class Publication {
	int PUBLICATION_ID;
	String AUTHORS;
	String TITLE;
	int PUBMED_ID;
	String DATE;
	String PUB_JOURNAL;
	String PUB_VOLUME;
	String PUB_URL;
	int PROJECT_ID;
	public int getPUBLICATION_ID() {
		return PUBLICATION_ID;
	}
	public void setPUBLICATION_ID(int pUBLICATIONID) {
		PUBLICATION_ID = pUBLICATIONID;
	}
	public String getAUTHORS() {
		return AUTHORS;
	}
	public void setAUTHORS(String aUTHORS) {
		AUTHORS = aUTHORS;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public int getPUBMED_ID() {
		return PUBMED_ID;
	}
	public void setPUBMED_ID(int pUBMEDID) {
		PUBMED_ID = pUBMEDID;
	}
	public String getDATE() {
		return DATE;
	}
	public void setDATE(String dATE) {
		DATE = dATE;
	}
	public String getPUB_JOURNAL() {
		return PUB_JOURNAL;
	}
	public void setPUB_JOURNAL(String pUBJOURNAL) {
		PUB_JOURNAL = pUBJOURNAL;
	}
	public String getPUB_VOLUME() {
		return PUB_VOLUME;
	}
	public void setPUB_VOLUME(String pUBVOLUME) {
		PUB_VOLUME = pUBVOLUME;
	}
	public String getPUB_URL() {
		return PUB_URL;
	}
	public void setPUB_URL(String pUBURL) {
		PUB_URL = pUBURL;
	}
	public int getPROJECT_ID() {
		return PROJECT_ID;
	}
	public void setPROJECT_ID(int pROJECTID) {
		PROJECT_ID = pROJECTID;
	}
	
}
