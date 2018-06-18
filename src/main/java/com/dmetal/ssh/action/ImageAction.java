package com.dmetal.ssh.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class ImageAction {
	
	private InputStream img;
	
	public InputStream getImg() {
		return img;
	}
	public void setImg(InputStream img) {
		this.img = img;
	}
	public byte[] createPngImage() throws IOException {
		BufferedImage img=new BufferedImage(200,100,BufferedImage.TYPE_3BYTE_BGR);
		img.setRGB(100, 50, 0xffffff);
		ByteArrayOutputStream buf=new ByteArrayOutputStream();
		ImageIO.write(img, "png", buf);
		buf.close();
		return buf.toByteArray();
		
	}
	public String execute() throws IOException {
		byte[] data=createPngImage();
		img=new ByteArrayInputStream(data);
		return "success";
	}
	
}
