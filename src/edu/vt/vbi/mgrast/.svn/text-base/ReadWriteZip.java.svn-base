package edu.vt.vbi.mgrast;

import java.io.File;
import java.io.IOException;

public class ReadWriteZip {
	
	private Gunzipper rz;

	
	// Process all files and directories under dir
		public void visitAllDirsAndFiles(File dir) throws IOException {

			if (dir.isDirectory()) {
				String[] children = dir.list();
				String temp="";
				for (int i = 0; i < children.length; i++) {
					temp=(String)children[i];
					
					if(!temp.contains("raw")){ //escape the raw directory
					visitAllDirsAndFiles(new File(dir, children[i]));
					}
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
					if (path.contains("gz")) {						
						rz.readGZip(dir);
					}
				}
			}
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
}
