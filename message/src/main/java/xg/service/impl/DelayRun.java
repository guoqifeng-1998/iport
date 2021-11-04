package xg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//项目启动完成后，执行下面任务
@Component
public class DelayRun implements CommandLineRunner {
	@Autowired
	AsyncTaskExecutor as;
	@Override
    public void run(String... strings) throws Exception {
		as.executor();
	}
}