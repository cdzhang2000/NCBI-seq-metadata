package edu.vt.vbi.strep;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import edu.vt.vbi.DatabaseManager;

public class UploadStrep {
	Connection conn;
	
	public UploadStrep(){
		try {
			conn=DatabaseManager.instance().getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	
	public void populate() throws SQLException{
		int subpid=59;
		int col=1;		
		conn.setAutoCommit(false);
		while(col<7){
			Statement st=conn.createStatement();
			String sql="insert into SEQUENCEMETA.SEQATTRVALUE (SUBPID,ATTR_ID,ATTR_VALUE)" +
			"(select '"+subpid+"', attr_id, GENOME_"+col+" from SEQUENCEMETA.UMD_STREP_CORE SU," +
					"SEQUENCEMETA.METADATAATTR sm where SU.CATEGORY=sm.CATEGORY " +
					"AND SU.ATTR_NAME=sm.ATTR_NAME and GENOME_"+col+" is not null)";
			int no=st.executeUpdate(sql);
			subpid++;
			col++;
			st.close();
			System.out.println("inserted rows="+ no);
		}
		System.out.println("end updating ");
		conn.commit();
		conn.close();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UploadStrep p=new UploadStrep();
		try {
			p.populate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
