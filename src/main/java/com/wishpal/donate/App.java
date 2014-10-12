package com.wishpal.donate;

import static spark.Spark.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.impl.SimpleLogger;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.freemarker.FreeMarkerRoute;

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

public class App {
	public static final String URL = "http://127.0.0.1:4567";

	public static void main(String[] args) {
		System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "INFO");

		staticFileLocation("/");

		// Heroku will pass $PORT to the app. The default port is 4567
		String portStr = System.getenv("PORT");
		if (portStr != null)
			setPort(Integer.parseInt(portStr));

		get(new Route("/hello") {
			@Override
			public Object handle(Request req, Response resp) {
				return "hello nihao";
			}
		});

		get(new FreeMarkerRoute("/") {
			@Override
			public Object handle(Request request, Response response) {
				Map<String, Object> viewObjects = new HashMap<String, Object>();
				viewObjects.put("templateName", "wishItem.ftl");
				viewObjects.put("imgPath", "");

				return modelAndView(viewObjects, "index.ftl");
			}
		});

		post(new FreeMarkerRoute("/submit") {
			@Override
			public Object handle(Request req, Response resp) {
				String name = req.queryParams("name");
				String codeData = URL + "/update/" + name;
				String imgPath = "src/main/resources/image/" + name + ".png";
				
				try {
					System.out.println(new java.io.File(".").getCanonicalPath());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				createQRCode(codeData, imgPath);
				
				Map<String, Object> viewObjects = new HashMap<String, Object>();
				viewObjects.put("templateName", "wishItem.ftl");
				viewObjects.put("imgPath", "image/" + name + ".png");

				return modelAndView(viewObjects, "index.ftl");
			}
		});

		get(new FreeMarkerRoute("/update/:name") {
			@Override
			public Object handle(Request req, Response resp) {
				String userName = req.params(":name");
				if (userName == null) userName = "Amigo";
				Map<String, Object> viewObjects = new HashMap<String, Object>();
				viewObjects.put("templateName", "codeResult.ftl");
				viewObjects.put("userName", userName);

				return modelAndView(viewObjects, "index.ftl");
			}
		});
	}

	public static void createQRCode(String qrCodeData, String filePath) {

		String charset = "UTF-8"; // or "ISO-8859-1"
		Map hintMap = new HashMap();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		int qrCodeheight = 240;
		int qrCodewidth = 240;

		try {
			BitMatrix matrix = new MultiFormatWriter().encode(new String(
					qrCodeData.getBytes(charset), charset),
					BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight, hintMap);

			MatrixToImageWriter.writeToFile(matrix,
					filePath.substring(filePath.lastIndexOf('.') + 1),
					new File(filePath));
			System.out.println("create qrcode in" + filePath);
		} catch (WriterException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static String readQRCode(String filePath) {
		String charset = "UTF-8"; // or "ISO-8859-1"
		Map hintMap = new HashMap();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		
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
