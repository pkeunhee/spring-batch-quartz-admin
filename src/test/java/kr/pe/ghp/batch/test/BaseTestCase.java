package kr.pe.ghp.batch.test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.*;

/**
 * 
 * @author geunhui park
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ 
	"file:src/main/resources/launch-context.xml", 
	"classpath*:/META-INF/spring/batch/jobs/*.xml"
})
public class BaseTestCase {
	public static Logger log = LoggerFactory.getLogger(BaseTestCase.class);
}
