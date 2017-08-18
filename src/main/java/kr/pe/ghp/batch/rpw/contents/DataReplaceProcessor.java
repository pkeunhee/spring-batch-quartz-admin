package kr.pe.ghp.batch.rpw.contents;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * @author geunhui park
 */
public class DataReplaceProcessor implements ItemProcessor<Map<String, String>, Map<String, String>> {
	private static Logger logger = LoggerFactory.getLogger(DataReplaceProcessor.class);

	@Override
	public Map<String, String> process(Map<String, String> map) throws Exception {
		logger.info("process");
		map.put("content", StringUtils.replace(map.get("content"), "/temp/", "/all2/"));
		return map;
	}
}