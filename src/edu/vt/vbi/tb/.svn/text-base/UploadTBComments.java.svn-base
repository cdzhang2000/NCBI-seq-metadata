package edu.vt.vbi.tb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;

import edu.vt.vbi.DatabaseManager;

public class UploadTBComments {

	Connection conn;
	String fileName = "";

	public UploadTBComments(String fname) {
		try {
			conn = DatabaseManager.instance().getConnection();
			fileName = fname;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
	}

	public void load() throws SQLException, IOException {
		
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while (line != null) {

			updateComment(line);
			line = br.readLine();
		}

		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateComment(String line) throws SQLException {

		StringTokenizer st = new StringTokenizer(line, "\t");

		Statement stmt = conn.createStatement();

		String colName = "";

		String comment = "";

		if (st.hasMoreElements()) {
			colName = st.nextToken().trim();
			
		}
		if (st.hasMoreElements()) {
			comment = st.nextToken();
			if (comment != null) {
				comment = comment.trim();
				comment=comment.replace("\"", "");
				comment=comment.replace("\'", "");
				String sql = " UPDATE SEQUENCEMETA.TB_CORE SET " + colName
						+ " = '" + comment + "' WHERE ID=52 ";
				System.out.println(sql);
				stmt.executeUpdate(sql);
		
			}
		}
		stmt.close();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String fileName = "H:/sequencemetadata/TB/TBcomments.txt";

		UploadTBComments p = new UploadTBComments(fileName);

		try {
			p.load();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
