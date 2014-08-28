package edu.vt.vbi.ncbi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.StringTokenizer;

import edu.vt.vbi.DatabaseManager;
import edu.vt.vbi.jcvi.stec.UploadJCVISTtrapProject1;

public class UploadComments {

	Connection conn;
	String fileName = "";

	public UploadComments(String fname) {
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
		String sql = "insert into SEQUENCEMETA.NCBICOMMENT (id, comments) values(?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while (line != null) {

			parseLine(line, pstmt);
			line = br.readLine();
		}

	}

	public void parseLine(String line, PreparedStatement pstmt)
			throws SQLException {

		StringTokenizer st = new StringTokenizer(line, "\t");

		int id = 0;

		if (st.hasMoreElements()) {
			id = Integer.valueOf(st.nextToken()).intValue();
			pstmt.setInt(1, id);
		}
		if (st.hasMoreElements()) {
			String temp = st.nextToken();
			if (temp != null) {
				temp = temp.trim();
				pstmt.setString(2, temp);
				pstmt.executeUpdate();
				System.out.println("added comment in row =" + id);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String fileName="H:/sequencemetadata/NCBI/ncbicomments.txt";
		
		UploadComments p = new UploadComments(fileName);


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
