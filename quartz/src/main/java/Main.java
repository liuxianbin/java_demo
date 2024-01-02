import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class Main {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("testJob", "testJobGroup").usingJobData("age", 100).build();
        Trigger t = TriggerBuilder.newTrigger().startNow().withIdentity("testTrigger", "testTriggerGroup").usingJobData("lang", "golang").withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?")).build();
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.scheduleJob(job, t);
        scheduler.start();
        JobKey testJob = JobKey.jobKey("testJob", "testJobGroup");
        System.out.println("3秒后暂停...");
        Thread.sleep(3000L);
        System.out.println("暂停...");
        scheduler.pauseJob(testJob);
        Thread.sleep(6000L);
        System.out.println("恢复...");
        scheduler.resumeJob(testJob);
        System.out.println("over");
    }
}
