package kr.pe.ghp.batch.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import kr.pe.ghp.batch.test.BaseTestCase;
import kr.pe.ghp.batch.util.PropertiesUtils;
import kr.pe.ghp.batch.util.SpringContextHolder;

/**
 * @author geunhui park
 */
public class BatchRepoServiceTest extends BaseTestCase {

	@Autowired
	BatchRepoService batchRepoService;

	@Test
	public void test() {
		System.out.println("start");
		String contents = PropertiesUtils.getProperty("es.index.contents");
		System.out.println(PropertiesUtils.propertiesMap);
		System.out.println("b");

		BatchRepoService service = null;
		try {
			service = SpringContextHolder.getBean(BatchRepoService.class);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

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
