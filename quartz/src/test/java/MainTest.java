import org.junit.Test;
import org.quartz.CronExpression;
import org.quartz.JobKey;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainTest {
    public MainTest() {
    }

    @Test
    public void demo1() throws ParseException {
        Date now = new Date();
        System.out.println(CronExpression.isValidExpression("*/5 * * * * ?"));
        CronExpression cronExpression = new CronExpression("*/5 * * * * ?");
        System.out.println(cronExpression);
        Date date1 = cronExpression.getTimeAfter(now);
        Date date2 = cronExpression.getNextValidTimeAfter(now);
        Date date3 = cronExpression.getNextInvalidTimeAfter(now);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(now));
        System.out.println(df.format(date1));
        System.out.println(df.format(date2));
        System.out.println(df.format(date3));
    }

    @Test
    public void demo2() {
        JobKey testJob = JobKey.jobKey("testJob", "testJobGroup");
        System.out.println(testJob);
        System.out.println(testJob.getGroup());
        System.out.println(testJob.getName());
    }
}
