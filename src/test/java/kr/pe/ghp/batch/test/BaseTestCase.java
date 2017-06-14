package kr.pe.ghp.batch.test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ 
	//"file:src/main/resources/META-INF/spring/batch/override/override-ctx.xml", 
	//"file:src/test/resources/test-data-source-context.xml",
	//"file:src/test/resources/test-execution-context.xml"
	"file:src/main/resources/launch-context.xml"
	
})
public class BaseTestCase {
	public static Logger log = LoggerFactory.getLogger(BaseTestCase.class);
}
