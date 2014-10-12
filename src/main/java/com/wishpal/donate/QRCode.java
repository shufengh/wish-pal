package com.wishpal.donate;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRCode {
	private Map hintMap;
	private int qrCodeheight = 240;
	private int qrCodewidth = 240;
	
	public QRCode() {
		this(240, 240);
		hintMap = new HashMap();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
	}
	public QRCode(int height, int width) {
		this.qrCodeheight = height;
		this.qrCodewidth = width;
	}
	
	public void encode(String qrCodeData, String filePath) {

		try {
			BitMatrix matrix = new MultiFormatWriter().encode(new String(
					qrCodeData.getBytes(Config.CHARSET), Config.CHARSET),
					BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight, hintMap);

			MatrixToImageWriter.writeToFile(matrix,
					filePath.substring(filePath.lastIndexOf('.') + 1),
					new File(filePath));
			
			System.out.println("create qrcode in " + filePath);
		} catch (WriterException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public String decode(String filePath) {
		
		try {
			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
					new BufferedImageLuminanceSource(
							ImageIO.read(new FileInputStream(filePath)))));
			Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap, hintMap);
			
			return qrCodeResult.getText();
		}  catch (IOException ex) {
			ex.printStackTrace();
		} catch (NotFoundException ex) {
			ex.printStackTrace();
		}
		return "Error";
	}
}
