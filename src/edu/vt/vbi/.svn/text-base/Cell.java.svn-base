package edu.vt.vbi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cell {

	int CELL_ID;
	String CELL_SHAPE;
	String CELL_DIAMETER;
	String CELL_LENGTH;
	String COLOR;
	int ORGANISM_ID;

	public Cell(Connection conn) throws SQLException {
		this.CELL_ID = getCellSeq(conn);
		this.CELL_DIAMETER ="";
		this.CELL_LENGTH = "";
		this.CELL_SHAPE = "";
		this.ORGANISM_ID=0;
	}
	
	public Cell(Connection conn, int oid) throws SQLException {
		this.CELL_ID = getCellSeq(conn);
		this.CELL_DIAMETER ="";
		this.CELL_LENGTH = "";
		this.CELL_SHAPE = "";
		this.ORGANISM_ID=oid;
	}

	private int getCellSeq(Connection conn) throws SQLException {
		String seq = "SELECT " + SchemaName.SCHEMA
				+ "CELL_SEQ.NEXTVAL FROM DUAL";
		Statement stmt = conn.createStatement();
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

	public void updateCell(Connection conn) throws SQLException {
		Statement stm = conn.createStatement();

		String sql = "INSERT INTO "
				+ SchemaName.SCHEMA
				+ "CELL ( CELL_ID,CELL_SHAPE,CELL_DIAMETER,CELL_LENGTH,COLOR,ORGANISM_ID) VALUES("
				+ this.CELL_ID + ",'" + this.CELL_SHAPE + "','"
				+ this.CELL_DIAMETER + "','" + this.CELL_LENGTH + "','"
				+ this.COLOR + "'," + this.ORGANISM_ID + " )";

		try{
			stm.executeUpdate(sql);	
			stm.close();
			}catch(SQLException e){
				System.err.println("Error in update Host ");
				throw new SQLException(this.getClass().getName());
			}
	}

	public int getCELL_ID() {
		return CELL_ID;
	}

	public void setCELL_ID(int cELLID) {
		CELL_ID = cELLID;
	}

	public String getCELL_SHAPE() {
		return CELL_SHAPE;
	}

	public void setCELL_SHAPE(String cELLSHAPE) {
		CELL_SHAPE = cELLSHAPE;
	}

	
	public String getCOLOR() {
		return COLOR;
	}

	public void setCOLOR(String cOLOR) {
		COLOR = cOLOR;
	}

	public int getORGANISM_ID() {
		return ORGANISM_ID;
	}

	public void setORGANISM_ID(int oRGANISMID) {
		ORGANISM_ID = oRGANISMID;
	}

	public String getCELL_DIAMETER() {
		return CELL_DIAMETER;
	}

	public void setCELL_DIAMETER(String cELLDIAMETER) {
		CELL_DIAMETER = cELLDIAMETER;
	}

	public String getCELL_LENGTH() {
		return CELL_LENGTH;
	}

	public void setCELL_LENGTH(String cELLLENGTH) {
		CELL_LENGTH = cELLLENGTH;
	}

}
