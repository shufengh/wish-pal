
import static spark.Spark.get;
import static spark.Spark.post;

import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.setPort;
import static spark.Spark.staticFileLocation;
import spark.template.freemarker.FreeMarkerRoute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.impl.SimpleLogger;

import com.wishpal.donate.*;
import com.wishpal.util.*;

public class App {
	public static String DOMAIN_NAME;

	public static void setUp() {
		System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "INFO");
		staticFileLocation("/");

		// Heroku will pass $PORT to the app. The default port is 4567
		String portStr = System.getenv("PORT");
		if (portStr != null) setPort(Integer.parseInt(portStr));

		String domainName = System.getenv("DOMAIN_NAME");
		if (domainName == null) DOMAIN_NAME = "http://wishpal.herokuapp.com";
		else DOMAIN_NAME = "http://127.0.0.1:4567";
	}
	
	public static void main(String[] args) {
		setUp();

		final ModifyData o = new ModifyData();
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


				Map<String, Object> viewObjects = new HashMap<String, Object>();
				viewObjects.put("templateName", "wishItem.ftl");
				viewObjects.put("imgPath", qrcode.encode(codeData));

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
        get(new FreeMarkerRoute("/search") {
            @Override
            public Object handle(Request request, Response response) {
                    Map<String, Object> viewObjects = new HashMap<String, Object>();

                    return modelAndView(viewObjects,"search.ftl");
                   }


        });

        post(new Route("/update") {
            @Override
            public Object handle(Request request, Response response) {
                String SWCID = request.queryParams("WCID");
                int id = Integer.parseInt(SWCID);
                o.update(id);

                response.redirect("/search");
                return "";
            }
        });

        post(new FreeMarkerRoute("/read") {
            @Override
            public Object handle(Request request, Response response) {
                String sid = request.queryParams("searchFilter");
                int id = 0;
                if (sid != null){

                     id = Integer.parseInt(sid);
                }
                List<Item> itemList = new ArrayList<Item>();
                itemList = o.readAll(id);
//              StringBuilder sb = new StringBuilder();
                for(Item i:itemList){
//                  sb.append("WishCardID: "+ i.WishCardID);
//                  sb.append(" AgencyCode: "+i.AgencyCode);
//                  sb.append(" AgencyZone: "+ i.AgencyZone);
//                  sb.append(System.getProperty("line.separator"));
                }
//                Integer id = Integer.parseInt(request.params(":id"));
//              ArrayList<Integer> test = new ArrayList<Integer>();
//              test.add(1);
//              test.add(2);
                Map<String, Object> viewObjects = new HashMap<String, Object>();

                viewObjects.put("records", itemList);



                return modelAndView(viewObjects, "searchResult.ftl");
            }
        });

        get(new FreeMarkerRoute("/print/:id") {
            @Override
            public Object handle(Request request, Response response) {
                String SWICD = request.params(":id");
                Integer WCID = Integer.parseInt(SWICD.replaceAll(",", ""));
                Item item = o.readOne(WCID);
                Map<String, Object> viewObjects = new HashMap<String, Object>();

                viewObjects.put("record",item);

                return modelAndView(viewObjects,"printResult.ftl");
            }
        });
	}
}
//=======
//import spark.Route;
//import spark.template.freemarker.FreeMarkerRoute;
///**
// * Hello world!
// *
// */
//public class App
//{
//    public static void main( String[] args ) {
//
//    	final ModifyData o = new ModifyData();
//
//        System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "INFO");
//
//        staticFileLocation("/");
//
//        //Heroku will pass $PORT to the app. The default port is 4567
//        String portStr = System.getenv("PORT");
//        if(portStr != null) setPort(Integer.parseInt(portStr));
//
//
//        get(new Route("/a") {
//        	@Override
//        	public Object handle(Request req, Response resp) {
//        		List<Item> itemList = new ArrayList<Item>();
//        		itemList = o.readAll(1);
//        		StringBuilder sb = new StringBuilder();
//        		for(Item i:itemList){
//        			sb.append("WishCardID: "+ i.WishCardID);
//        			sb.append(" AgencyCode: "+i.AgencyCode);
//        			sb.append(" AgencyZone: "+ i.AgencyZone);
//        			sb.append(System.getProperty("line.separator"));
//        		}
//
//        		return sb.toString();
//        	}
//        });
//
//
//        get(new FreeMarkerRoute("/search") {
//            @Override
//            public Object handle(Request request, Response response) {
//                	Map<String, Object> viewObjects = new HashMap<String, Object>();
//
//            		return modelAndView(viewObjects,"search.ftl");
//                   }
//
//
//        });
//
//        post(new Route("/update") {
//            @Override
//            public Object handle(Request request, Response response) {
//                String SWCID = request.queryParams("WCID");
//                int id = Integer.parseInt(SWCID);
//                o.update(id);
//
//                response.redirect("/search");
//                return "";
//            }
//        });
//
//        post(new FreeMarkerRoute("/read") {
//            @Override
//            public Object handle(Request request, Response response) {
//            	String sid = request.queryParams("searchFilter");
//            	int id = 0;
//            	if (sid != null){
//
//            		 id = Integer.parseInt(sid);
//            	}
//            	List<Item> itemList = new ArrayList<Item>();
//        		itemList = o.readAll(id);
////        		StringBuilder sb = new StringBuilder();
//        		for(Item i:itemList){
////        			sb.append("WishCardID: "+ i.WishCardID);
////        			sb.append(" AgencyCode: "+i.AgencyCode);
////        			sb.append(" AgencyZone: "+ i.AgencyZone);
////        			sb.append(System.getProperty("line.separator"));
//        		}
////                Integer id = Integer.parseInt(request.params(":id"));
////        		ArrayList<Integer> test = new ArrayList<Integer>();
////        		test.add(1);
////        		test.add(2);
//                Map<String, Object> viewObjects = new HashMap<String, Object>();
//
//                viewObjects.put("records", itemList);
//
//
//
//                return modelAndView(viewObjects, "searchResult.ftl");
//            }
//        });
//
//        get(new FreeMarkerRoute("/print/:id") {
//            @Override
//            public Object handle(Request request, Response response) {
//            	String SWICD = request.params(":id");
//                Integer WCID = Integer.parseInt(SWICD.replaceAll(",", ""));
//                Item item = o.readOne(WCID);
//                Map<String, Object> viewObjects = new HashMap<String, Object>();
//
//                viewObjects.put("record",item);
//
//                return modelAndView(viewObjects,"printResult.ftl");
//            }
//        });
//
//    }
//
//
//
//
//>>>>>>> Joe
//}
