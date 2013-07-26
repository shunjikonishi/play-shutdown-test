package jobs;

import play.Logger;
import play.Play;
import play.jobs.Job;
import play.jobs.OnApplicationStop;
import controllers.Application;

@OnApplicationStop
public class OnStop extends Job {
	
	public void doJob() {
		Logger.info("OnApplicationStop, Host=" + Application.HOST + ", Thread=" + Thread.currentThread().getName());
	}
	
}
