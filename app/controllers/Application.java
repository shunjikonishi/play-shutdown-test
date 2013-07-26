package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {
	
	private static final String HEROKU_APP_NAME = System.getenv("HEROKU_APPLICATION_NAME");
	private static final String HEROKU_API_KEY  = System.getenv("HEROKU_API_KEY");
	
	public static void index() {
		render();
	}
	
	public static void ok() {
		Logger.info("OK");
		renderText("OK");
	}
	
	public static void sleep(int ms) {
		Logger.info("Start sleeping for " + ms + "ms, Thread=" + Thread.currentThread().getName());
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Logger.info("End sleeping, Thread=" + Thread.currentThread().getName());
		renderText("Sleep " + ms + "ms");
	}

}