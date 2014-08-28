package edu.vt.vbi.strep;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import edu.vt.vbi.DatabaseManager;

public class UploadVibrio {
	
	Connection conn;

	public UploadVibrio() {
		try {
			conn = DatabaseManager.instance().getConnection();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void populate() throws SQLException {
		int subpid = 65;
		int col = 1;
		conn.setAutoCommit(false);
		while (col < 13) {
			Statement st = conn.createStatement();
			String sql = "insert into SEQUENCEMETA.SEQATTRVALUE (SUBPID,ATTR_ID,ATTR_VALUE)"
					+ "(select "+ subpid+ ", attr_id, GENOME_"+ col+ "  from SEQUENCEMETA.UMD_VIBRIO_CORE su,"
					+ "SEQUENCEMETA.METADATAATTR sm where su.CATEGORY=sm.CATEGORY "
					+ "AND su.ATTR_NAME=sm.ATTR_NAME and GENOME_"+ col+ "  is not null)";
			System.out.println(sql);
			int no = st.executeUpdate(sql);
			subpid++;
			col++;
			st.close();
			System.out.println("inserted rows=" + no);
		}
		System.out.println("end updating ");
		conn.commit();
		conn.close();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UploadVibrio p = new UploadVibrio();
		try {
			p.populate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
