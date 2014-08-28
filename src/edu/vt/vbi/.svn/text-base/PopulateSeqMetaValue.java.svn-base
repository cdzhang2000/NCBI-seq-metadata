package edu.vt.vbi;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PopulateSeqMetaValue {

	Connection conn;
	public PopulateSeqMetaValue(){
		try {
			conn=DatabaseManager.instance().getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	
	public void populate() throws SQLException{
		int subpid=6;
		int col=1;		
		conn.setAutoCommit(false);
		while(col<54){
			Statement st=conn.createStatement();
			String sql="insert into SEQUENCEMETA.SEQATTRVALUE (SUBPID,ATTR_ID,ATTR_VALUE)" +
			"(select '"+subpid+"', attr_id, GENOME_"+col+" from SEQUENCEMETA.UMD_ECOLI_CORE SU," +
					"SEQUENCEMETA.METADATAATTR sm where SU.CATAGORY=sm.CATAGORY " +
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
		PopulateSeqMetaValue p=new PopulateSeqMetaValue();
		try {
			p.populate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
