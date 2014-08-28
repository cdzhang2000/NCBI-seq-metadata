package edu.vt.vbi.jcvi.stec;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.vt.vbi.DatabaseManager;

public class UploadJcviStec {
	Connection conn;
	
	public UploadJcviStec(){
		try {
			conn=DatabaseManager.instance().getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}
	

	public void populateAttrValue(int pid) throws SQLException{
				
		conn.setAutoCommit(false);
		String subprosql="SELECT SUBPID, NAME FROM SEQUENCEMETA.SEQSUBPROJECT WHERE PID="+pid;			
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(subprosql);		
		int subpid=0;
		String colName="";				
		while(rs.next()){
		
			subpid=rs.getInt("SUBPID");
			colName=rs.getString("NAME");		
			
			updateATTVALUETable(subpid, colName);
		
		}		
		System.out.println("end updating ");
		rs.close();
		conn.commit();
		conn.close();
	}
	
	
	private void updateATTVALUETable(int subpid, String colName) throws SQLException{
		
		String sql="insert into SEQUENCEMETA.SEQATTRVALUE (SUBPID,ATTR_ID, ATTR_VALUE)" +
		"(select '"+subpid+"', attr_id,"+colName +" from SEQUENCEMETA.JCVI_STEC_CORE SU," +
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
		UploadJcviStec p=new UploadJcviStec();
		int pid=5;
		try {
			p.populateAttrValue(pid);
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
