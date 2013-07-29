package jobs;

import play.Logger;
import play.Play;
import play.jobs.Job;
import play.jobs.Every;
import play.libs.WS;
import controllers.Application;

@Every("5s")
public class KickSleep extends Job {
	
	public void doJob() {
		if ("web.1".equals(Application.DYNO)) {
			Logger.info("KickSleep, Host=" + Application.HOST + ", Thread=" + Thread.currentThread().getName());
			String url = "http://" + Application.HEROKU_APPLICATION_NAME + ".herokuapp.com/application/sleep?ms=5000";
			WS.url(url).get();
		}
	}
	
}
