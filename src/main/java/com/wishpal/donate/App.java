package com.wishpal.donate;

import static spark.Spark.*;

import org.slf4j.impl.SimpleLogger;

import spark.Request;
import spark.Response;
import spark.Route;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.setProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "INFO");

        staticFileLocation("/");

        //Heroku will pass $PORT to the app. The default port is 4567
        String portStr = System.getenv("PORT");
        if(portStr != null) setPort(Integer.parseInt(portStr));

    	
        get(new Route("/") {
        	@Override
        	public Object handle(Request req, Response resp) {
        		return "hello nihao";
        	}
        });
    }
}
