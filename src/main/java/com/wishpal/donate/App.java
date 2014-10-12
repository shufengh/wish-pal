package com.wishpal.donate;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.impl.SimpleLogger;

import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerRoute;

public class App {
	public static String DOMAIN_NAME;

	public static void setUp() {
		System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "INFO");		
		staticFileLocation("/");

		// Heroku will pass $PORT to the app. The default port is 4567
		String portStr = System.getenv("PORT");
		if (portStr != null) setPort(Integer.parseInt(portStr));
		
		String domainName = System.getenv("DOMAIN_NAME");
		if (domainName == null) DOMAIN_NAME = "http://wishpal.heroku.com";
		else DOMAIN_NAME = "127.0.0.1:4567";


	}
	public static void main(String[] args) {
		setUp();
		
		final QRCode qrcode = new QRCode();
		
		
		
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
				
				
				if (name == null || name == "") name = "Amigo"; 
				
				String codeData = DOMAIN_NAME + "/update/" + name;
				String imgPath = Config.PUBLIC + "/image/" + name + ".png";
				
				qrcode.encode(codeData, imgPath);
				
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
}
