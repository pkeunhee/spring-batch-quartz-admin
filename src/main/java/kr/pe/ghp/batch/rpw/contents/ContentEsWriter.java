package kr.pe.ghp.batch.rpw.contents;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.util.CollectionUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Delete;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import kr.pe.ghp.batch.service.ContentsService;
import kr.pe.ghp.batch.util.PropertiesUtils;
import kr.pe.ghp.batch.util.SpringContextHolder;

/**
 * @author geunhui park
 */
public class ContentEsWriter implements ItemWriter<Map<String, String>> {
	private static Logger logger = LoggerFactory.getLogger(ContentEsWriter.class);

	private String URL_ES = PropertiesUtils.getProperty("es.url");
	private String INDEX = PropertiesUtils.getProperty("es.index.contents");

	@Override
	public void write(List<? extends Map<String, String>> items) throws Exception {
		logger.debug("write start");

		String type = "life";

		List<String> idList = Lists.newArrayList();
		JestClient client = getClient();

		for (Map<String, String> item : items) {
			String id = item.get("id");

			Map<String, Object> map = Maps.newHashMap();
			map.put("title", item.get("title"));
			map.put("category", item.get("category"));
			map.put("content", item.get("content"));

			String txType = (String) item.get("type");
			boolean insertOrUpdate = "I".equals(txType) || "U".equals(txType);
			boolean delete = "D".equals(txType);

			logger.debug(map.toString());

			try {
				DocumentResult result = null;
				if (insertOrUpdate) { // 신규 or 업데이트
					result = client.execute(new Index.Builder(map).index(INDEX).type(type).id(id).build());
				} else if (delete) { // 삭제
					result = client.execute(new Delete.Builder(id).index(INDEX).type(type).build());
				}

				if (result.isSucceeded()) {
					idList.add(id);
				}
				logger.debug(result.toString());
			} catch (Exception e) {
				logger.error(e.toString(), e);
			}
		}

		if (!CollectionUtils.isEmpty(idList)) {
			// 처리 완료로 업데이트
			ContentsService contentsService = SpringContextHolder.getBean(ContentsService.class);
			contentsService.updateProcessed(idList);
		}
	}

	private JestClient getClient() {
		JestClientFactory factory = new JestClientFactory();
		factory.setHttpClientConfig(new HttpClientConfig.Builder(URL_ES).multiThreaded(true).build());
		return factory.getObject();
	}
}