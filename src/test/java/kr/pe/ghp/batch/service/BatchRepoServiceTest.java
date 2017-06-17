package kr.pe.ghp.batch.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.pe.ghp.batch.test.BaseTestCase;

/**
 * 
 * @author geunhui park
 *
 */
public class BatchRepoServiceTest extends BaseTestCase {

	@Autowired
	BatchRepoService batchRepoService;

	@Test
	public void test() {
		String groupName = "test1";
		String jobName = "job1";
		String jobParams = "name=ghp";
		String cronExp = "* * * * * ?";

		try {
			batchRepoService.addTrigger(groupName, jobName, jobParams, cronExp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
