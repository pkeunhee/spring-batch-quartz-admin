package kr.pe.ghp.batch;

import org.junit.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import kr.pe.ghp.batch.test.BaseTestCase;

/**
 * @author geunhui park
 */
public class ContentsJobTest extends BaseTestCase {
	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	@Qualifier("contentsToEsJob")
	Job job;
	
	@Test
	public void test01() {
		JobParametersBuilder builder = new JobParametersBuilder();
		builder.addString("name", "ghp");

		try {
			jobLauncher.run(job, builder.toJobParameters());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
