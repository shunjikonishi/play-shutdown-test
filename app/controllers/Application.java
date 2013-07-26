package controllers;

import play.*;
import play.mvc.*;

import java.util.*;
import java.net.InetAddress;

import models.*;

public class Application extends Controller {
	
	private static final String HEROKU_APP_NAME = System.getenv("HEROKU_APPLICATION_NAME");
	private static final String HEROKU_API_KEY  = System.getenv("HEROKU_API_KEY");
	
	private static final String HOST;
	
	static {
		String s = null;
		try {
			s = InetAddress.getLocalHost().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		HOST = s;
	}
	
	public static void index() {
		String appname = HEROKU_APP_NAME;
		String host = HOST;
		render(host, appname);
	}
	
	public static void ok() {
		Logger.info("OK, Host=" + HOST + ", Thread=" + Thread.currentThread().getName());
		renderText("OK");
	}
	
	public static void sleep(int ms) {
		Logger.info("Start sleeping for " + ms + "ms, Host=" + HOST + ", Thread=" + Thread.currentThread().getName());
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Logger.info("End sleeping, Host=" + HOST + ", Thread=" + Thread.currentThread().getName());
		renderText("Sleep " + ms + "ms");
	}

}