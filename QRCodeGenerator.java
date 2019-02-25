package com.projectbarcode.qrecode_gen;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * Hello world!
 *
 */
public class QRCodeGenerator 
{
	private static String QRCODE_PATH="C:\\Users\\ASUS\\Desktop\\QRCODE-SERVER\\";

	public String writeQRCode(BarcodeRequestBody objBRB) throws Exception {
		String qrcode =QRCODE_PATH + objBRB.getUsername() + "-QRCODE.png";
		QRCodeWriter writer =new QRCodeWriter();
		BitMatrix objBitMatrix = writer.encode(objBRB.getUsername() + "\n" + objBRB.getAccountNo() + "\n"
		+ objBRB.getAccountType() + "\n" +
		objBRB.getMobileno(), BarcodeFormat.QR_CODE, 350, 350);
	Path path = FileSystems.getDefault().getPath(qrcode);
	MatrixToImageWriter.writeToPath(objBitMatrix, "PNG" , path);
		return "QR Code generated successfully.....";
	}
	
	public String readQRCode(String qrcodeImage) throws Exception
	{
		BufferedImage objbufferedImage =	ImageIO.read(new File (qrcodeImage));
		LuminanceSource objluminanceSource = new BufferedImageLuminanceSource(objbufferedImage);
		BinaryBitmap objbiBinaryBitmap = new BinaryBitmap(new HybridBinarizer(objluminanceSource));
		Result result = new MultiFormatReader().decode(objbiBinaryBitmap);
		return result.getText();
				}
	
    public static void main( String[] args ) throws Exception
    {
      QRCodeGenerator codegenerator = new QRCodeGenerator();
		/*
		 * System.out.println(codegenerator.writeQRCode(new
		 * BarcodeRequestBody("Sushant Mishra" , "9619471258", "Scienece" , "12")));
		 */
      
      System.out.println(codegenerator.readQRCode(QRCODE_PATH + ""));
    }
}
