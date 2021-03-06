package jobs;

import play.Logger;
import play.Play;
import play.jobs.Job;
import play.jobs.Every;
import play.libs.WS;
import controllers.Application;

@Every("1s")
public class KickOk extends Job {
	
	public void doJob() {
		if ("web.1".equals(Application.DYNO)) {
			Logger.info("KickOk, Host=" + Application.HOST + ", Thread=" + Thread.currentThread().getName());
			String url = "http://" + Application.HEROKU_APPLICATION_NAME + ".herokuapp.com/application/ok";
			WS.url(url).get();
		}
	}
	
}
