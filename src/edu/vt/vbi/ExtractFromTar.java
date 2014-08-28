package edu.vt.vbi;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPInputStream;

import com.ice.tar.TarEntry;
import com.ice.tar.TarInputStream;

/**
 * javac -classpath /home/czhang/lib/tar.jar ./edu/vt/vbi/mgrast/*.java
 * @author czhang
 *
 */

public class ExtractFromTar {

	private String OUTPUT = "/home/czhang/output";

	// Process all files and directories under dir
	public void visitAllDirsAndFiles(File dir) throws Exception {

		if (dir.isDirectory()) {
			String[] children = dir.list();
			String temp = "";
			for (int i = 0; i < children.length; i++) {
				temp = (String) children[i];

				if (!temp.contains("raw")&& !temp.contains("processed")) { // escape the raw directory
					visitAllDirsAndFiles(new File(dir, children[i]));
				}
			}
		} else {
			String subdirect = dir.getPath();
			String fileName = dir.getName();
			long size = dir.length();
			String folder = getSubDir(subdirect);
			String path = folder + "\t" + fileName + "\t" + size + "\n";
			System.out.println(path);
			if (!path.contains("raw") && !path.contains("DS_Store")) {
				if (path.contains("gz")) {
					File dest = new File(OUTPUT);
					untarBaseUpgradeFile(dir, dest);
				}
			}
		}
	}

	private String getSubDir(String subdir) {
		int index = subdir.indexOf("\\");
		int last = subdir.lastIndexOf("\\");
		if (last > index) {
			String temp = subdir.substring(index + 1, last);
			return temp;
		} else {
			return "";
		}
	}

	private void untarBaseUpgradeFile(File tarFile, File dest) throws Exception {
		dest.mkdir();
		TarInputStream tin = new TarInputStream(new GZIPInputStream(
				new FileInputStream(tarFile)));

		TarEntry tarEntry = tin.getNextEntry();
		String fileName = "";

		while (tarEntry != null) {
			fileName = tarEntry.getName();
			
			System.out.println(" file separater= "+ File.separatorChar);

			File destFile = new File(dest.toString() + File.separatorChar
					+ fileName);
			if (tarEntry.isDirectory()) {
				
				if (!destFile.exists()) {
					boolean f = destFile.mkdir();
					if (f) {
						System.out.println("dest file name= "
								+ destFile.toString());
					} else {
						System.out.println("make dir failed ="
								+ destFile.toString());
					}
				}
			} else if (fileName.contains("900")) {

				System.out.println("dest file name= " + destFile.toString());
				if (tin.getRecordSize() > 100) {
					FileOutputStream fout = new FileOutputStream(destFile);
					tin.copyEntryContents(fout);
					fout.flush();
					fout.close();
				}
			}
			tarEntry = tin.getNextEntry();
		}
		tin.close();
		tin = null;
	}

	public static void main(String[] args) {

		String in = "/home/czhang/metagenomes";

		try {
			ExtractFromTar eft = new ExtractFromTar();
			File dir = new File(in);

			eft.visitAllDirsAndFiles(dir);

		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
