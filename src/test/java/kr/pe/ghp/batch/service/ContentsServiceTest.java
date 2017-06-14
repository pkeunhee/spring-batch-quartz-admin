package kr.pe.ghp.batch.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;

import kr.pe.ghp.batch.service.ContentsService;
import kr.pe.ghp.batch.test.BaseTestCase;

public class ContentsServiceTest extends BaseTestCase {
	@Autowired
	ContentsService contentsService;

	@Test
	public void test() {
		List<String> list = Lists.newArrayList();
		list.add("10000");

		try {
			contentsService.updateProcessed(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
