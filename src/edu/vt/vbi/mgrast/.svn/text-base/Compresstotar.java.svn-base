package edu.vt.vbi.mgrast;

import java.io.*;
import java.util.List;

import com.ice.tar.TarEntry;
import com.ice.tar.TarOutputStream;

public class Compresstotar {

	String ROOT_BACKUP_FOLDER="S:\\czhang\\metagenomes";
	String LOGS_BACKUP_FOLDER="S:\\czhang\\metagenomes";
	
	private File compressFilesToTarFile(List<File> files) throws Exception {
		 TarEntry tarEntry = null;
		 File tarFile = new File(ROOT_BACKUP_FOLDER
		 +File.separator
		 +LOGS_BACKUP_FOLDER
		 +File.separator
		 +buildGeneratedTarFileName());
		 tarFile.createNewFile();
		 OutputStream outputStream = new FileOutputStream(tarFile);
		TarOutputStream tarOutputStream = new TarOutputStream(outputStream);
		 for(File file : files)
		 {
		 tarEntry = new TarEntry(file);
		 tarOutputStream.putNextEntry(tarEntry);
		 tarOutputStream.write(getBytesFromFile(file));
		 tarOutputStream.closeEntry();
		 } tarOutputStream.close();
		 return tarFile;
		 }
		 
		private String buildGeneratedTarFileName() {
		// TODO Auto-generated method stub
		return null;
	}

		private static byte[] getBytesFromFile(File file) throws Exception {
		 InputStream is = new FileInputStream(file);
		 // Get the size of the file
		 long length = file.length();
		 if (length > Integer.MAX_VALUE) {
		 // File is too large
		 }
		 // Create the byte array to hold the data
		 byte[] bytes = new byte[(int)length];
		 // Read in the bytes
		 int offset = 0;
		 int numRead = 0;
		 while (offset < bytes.length
		 &&  (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
		 offset += numRead;
		 }
		 // Ensure all the bytes have been read in
		 if (offset < bytes.length){
		 throw new Exception("Could not completely read the file "+file.getName());
		 }
		 // Close the input stream and return bytes
		 is.close();
		 return bytes;
		 }
}
