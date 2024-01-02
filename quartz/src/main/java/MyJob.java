import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyJob implements Job {
    public void execute(JobExecutionContext context) {
        String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("time ：" + data);
        System.out.println(context.getJobDetail());
    }
}
