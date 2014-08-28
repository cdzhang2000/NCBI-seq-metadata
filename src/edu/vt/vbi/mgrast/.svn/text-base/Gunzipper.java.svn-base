package edu.vt.vbi.mgrast;

import java.io.*;
import java.util.zip.*;

import com.ice.tar.TarEntry;
import com.ice.tar.TarInputStream;

public class Gunzipper {
	
	private InputStream in;
	private String OUTPUT = "/home/czhang/mg-rast/output";

	public void unzip(File fileTo) throws IOException {
		OutputStream out = new FileOutputStream(fileTo);
		try {
			in = new GZIPInputStream(in);
			byte[] buffer = new byte[65536];
			int noRead;
			while ((noRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, noRead);
			}
		} finally {
			try {
				out.close();
			} catch (Exception e) {
			}
		}
	}

	public void readGZip(File file) throws IOException {

		InputStream in = new FileInputStream(file);
		GZIPInputStream gzip = new GZIPInputStream(in);
		TarInputStream tin = new TarInputStream(gzip);
		TarEntry tarEntry = tin.getNextEntry();
		System.out.println("----------start zip file ---------");
		while (tarEntry != null) {
			// File destPath = new File(dest.toString() + File.separatorChar +
			// tarEntry.getName());
			if (tarEntry.isDirectory()) {
				// destPath.mkdir();
				System.out.print(tarEntry.getName());
			} else {
				System.out.println(tarEntry.getName());
			}
			tarEntry = tin.getNextEntry();
		}
		tin.close();
		tin = null;
		System.out.println("---------- end zip file ---------");
	}

	public void readTarGZ(File file, BufferedWriter bw2) throws IOException {

		InputStream in = new FileInputStream(file);
		GZIPInputStream gzip = new GZIPInputStream(in);
		TarInputStream tin = new TarInputStream(gzip);
		TarEntry tarEntry = tin.getNextEntry();
		System.out.println("----------start zip file ---------");
		while (tarEntry != null) {
			StringBuffer line = new StringBuffer(file.getPath() + "\t");
			// File destPath = new File(dest.toString() + File.separatorChar +
			// tarEntry.getName());
			if (tarEntry.isDirectory()) {
				// destPath.mkdir();
				String fname = tarEntry.getName();
				System.out.print(fname);
				line.append(fname + "\t" + tarEntry.getSize());
			} else {
				System.out.println(tarEntry.getName());
				line.append(tarEntry.getName() + "\t" + tarEntry.getSize()
						+ "\n");
				bw2.write(line.toString());
			}
			tarEntry = tin.getNextEntry();
		}
		tin.close();
		tin = null;
		System.out.println("---------- end zip file ---------");
	}

	public void close() {
		try {
			in.close();
		} catch (Exception e) {
		}
	}
}
