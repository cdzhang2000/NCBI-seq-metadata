package edu.vt.vbi.jcvi.stec;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.vt.vbi.DatabaseManager;

public class UploadSUBProject {
	Connection conn;
	
	
	public UploadSUBProject(){
		try {
			conn=DatabaseManager.instance().getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}
		

	public void populateSeqSubProject( int pid, int endNumber, String prefix) throws SQLException{
		int subpid=getMaxSubpid()+1;
		int col=1;				
		conn.setAutoCommit(false);		
		String sql="insert into SEQUENCEMETA.SEQSUBPROJECT (PID, SUBPID, NAME)VALUES(?,?,?)";		
		PreparedStatement pst=conn.prepareStatement(sql);
		int no=1;
		while(col<=endNumber){
		pst.setInt(1, pid);
		pst.setInt(2,subpid);
		String temp=prefix+col;
		pst.setString(3, temp);
		pst.executeUpdate();
		System.out.println("inserted rows="+ no);
		col++;
		subpid++;
		no++;
		}
		System.out.println("end updating ");
		conn.commit();
		conn.close();
	}
	
	
	private int getMaxSubpid() throws SQLException{
		int maxpid=0;
		
		Statement stmt=conn.createStatement();
		String sql="select max(subpid) from SEQUENCEMETA.SEQSUBPROJECT";
		ResultSet rs=stmt.executeQuery(sql);
		if(rs.next()){
			maxpid=rs.getInt(1);
		}	
		return maxpid;		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UploadSUBProject p=new UploadSUBProject();
		try {
			int pid=9;		
			int endNumber=383;
			String prefix="GENOME";		
			p.populateSeqSubProject(pid,  endNumber, prefix);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
}
