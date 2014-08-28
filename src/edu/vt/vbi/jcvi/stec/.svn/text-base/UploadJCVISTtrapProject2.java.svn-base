package edu.vt.vbi.jcvi.stec;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.vt.vbi.DatabaseManager;

public class UploadJCVISTtrapProject2 {
	Connection conn;

	public UploadJCVISTtrapProject2() {
		try {
			conn = DatabaseManager.instance().getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void populateAttrValue(int pid, String tableName) throws SQLException{
				
		conn.setAutoCommit(false);
		String subprosql="SELECT SUBPID, NAME FROM SEQUENCEMETA.SEQSUBPROJECT WHERE PID="+pid;			
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(subprosql);		
		int subpid=0;
		String colName="";				
		while(rs.next()){
		
			subpid=rs.getInt("SUBPID");
			colName=rs.getString("NAME");					
			updateATTVALUETable(subpid, colName, tableName);
		
		}		
		System.out.println("end updating ");
		rs.close();
		conn.commit();
		conn.close();
	}
	
	
	private void updateATTVALUETable(int subpid, String colName, String tempTableName) throws SQLException{
		
		String sql="insert into SEQUENCEMETA.SEQATTRVALUE (SUBPID,ATTR_ID, ATTR_VALUE)" +
		"(select '"+subpid+"', attr_id,"+colName +" from SEQUENCEMETA."+tempTableName+"  SU," +
				"SEQUENCEMETA.METADATAATTR sm where SU.CATEGORY=sm.CATEGORY " +
				"AND SU.ATTR_NAME=sm.ATTR_NAME and "+colName+" is not null)";
		
		System.out.println(sql);
		Statement st2=conn.createStatement();				
		int no=st2.executeUpdate(sql);
		System.out.println("inserted rows="+ no);
		st2.close();
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		UploadJCVISTtrapProject2 p=new UploadJCVISTtrapProject2();
		int pid=7;
		
		String tableName="JCVI_STRAP_PROJ2";
		
		try {
			p.populateAttrValue(pid, tableName);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
