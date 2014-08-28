package edu.vt.vbi.mgrast;

import java.io.*;

public class PrintFile {
	BufferedWriter bw;
	String out = "S:\\czhang\\output.txt";
	String out2 = "S:\\czhang\\output2.txt";
	Gunzipper rz;

	BufferedWriter bw2;
	
	public PrintFile() throws IOException {
		File outputFile = new File(out);
		this.bw = new BufferedWriter(new FileWriter(outputFile));
		String header = "Folder \t File Name\t Size \n";
		bw.write(header);
		
		File outputFile2 = new File(out2);
		this.bw2 = new BufferedWriter(new FileWriter(outputFile2));
		String header2 = "Zip File \t File Name\t Size \n";
		bw2.write(header2);
		
		rz = new Gunzipper();
	}

	public void printFile(File f) throws IOException {
		visitAllDirsAndFiles(f);
		closeFile();
	}

	// Process all files and directories under dir
	public void visitAllDirsAndFiles(File dir) throws IOException {

		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				visitAllDirsAndFiles(new File(dir, children[i]));
			}
		} else {
			// System.out.println(dir.getAbsolutePath()+dir.getName()+"\t size= "+dir.length());
			String subdirect = dir.getPath();
			String fileName = dir.getName();
			long size = dir.length();
			String folder = getSubDir(subdirect);

			String path = folder + "\t" + fileName + "\t" + size + "\n";
			System.out.println(path);
			if (!path.contains("raw") && !path.contains("DS_Store")) {
				this.bw.write(path);

				if (path.contains("gz")) {
					this.rz.readTarGZ(dir, bw2);
				}
			}
		}
	}

	private void closeFile() throws IOException {
		bw.flush();
		bw.close();
		bw2.flush();
		bw2.close();
	}

	private String getSubDir(String subdir) {
		int index = subdir.indexOf("\\", 20);
		int last = subdir.lastIndexOf("\\");
		if (last > index) {
			String temp = subdir.substring(index + 1, last);
			return temp;
		} else {
			return "";
		}
	}

	public static void main(String[] args) {

		String in = "S:\\czhang\\metagenomes";

		PrintFile pf;
		try {

			pf = new PrintFile();
			File file = new File(in);
			pf.printFile(file);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public BufferedWriter getBw2() {
		return bw2;
	}

	public void setBw2(BufferedWriter bw2) {
		this.bw2 = bw2;
	}

}
