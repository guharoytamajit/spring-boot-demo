package demo.batch;

import org.joda.time.DateTime;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "batch")
public class MyScheduler {
	// run every 0th and 30th sec
	@Scheduled(cron = "${batch.cron}")
	public void myCornJob() {
		System.out.println("starting corn job: " + new DateTime());
		sleep(4000);
		System.out.println("corn job finished: " + new DateTime());
	}

	// fixed rate of 15sec means next job will be trigerred after 15sec the
	// previous job has started
	@Scheduled(initialDelayString = "${batch.init.delay}", fixedRateString = "${batch.fixed.rate}")
	public void myFixedRate() {
		System.out.println("starting fixed rate job: " + new DateTime());
		sleep(10000);
		System.out.println("corn fixed rate finished: " + new DateTime());
	}

	@Scheduled(initialDelayString = "${batch.init.delay}", fixedRateString = "${batch.fixed.rate}")
	public void myFixedRate2() {
		System.out.println("starting fixed rate job: " + new DateTime());
		sleep(10000);
		System.out.println("corn fixed rate finished: " + new DateTime());
	}

	@Scheduled(initialDelayString = "${batch.init.delay}", fixedRateString = "${batch.fixed.rate}")
	public void myFixedRate3() {
		System.out.println("starting fixed rate job: " + new DateTime());
		sleep(10000);
		System.out.println("corn fixed rate finished: " + new DateTime());
	}

	// fixed delay of 15sec means next job will be trigerred after 15sec the
	// previous job has finished
	@Scheduled(initialDelayString = "${batch.init.delay}", fixedDelayString = "${batch.fixed.delay}")
	public void myFixedDelay() {
		System.out.println("starting fixed delay job: " + new DateTime());
		sleep(10000);
		System.out.println("corn fixed delay finished: " + new DateTime());
	}

	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
