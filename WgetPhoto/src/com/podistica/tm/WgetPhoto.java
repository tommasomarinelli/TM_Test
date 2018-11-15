package com.podistica.tm;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class WgetPhoto {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
	
		try {
			for(int i =1;i<=672;i++) {
				try {
					String filename= "2.2018.02.18-"+i+".jpg";
					URL website = new URL("http://www.fotoincorsa.com/wp-content/uploads/2018/02/"+filename);
					ReadableByteChannel rbc = Channels.newChannel(website.openStream());
					FileOutputStream fos;
					String dir = "C:\\Users\\tomma\\Desktop\\Cisalfa Duathlon\\";
					fos = new FileOutputStream(dir+filename);
					fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
					System.out.println("Salvato file:"+filename);
				}catch (Exception e) {
					continue;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
