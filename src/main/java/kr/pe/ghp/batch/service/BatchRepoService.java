package kr.pe.ghp.batch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.ghp.batch.mapper.repo.BatchRepoMapper;


/**
 * 
 * @author geunhui park
 *
 */
@Service
public class BatchRepoService {
	@Autowired
	BatchRepoMapper mapper;

	public void addTrigger(String groupName, String jobName, String jobParams, String cronExp) {
		mapper.insertTrigger(groupName, jobName, jobParams, cronExp);
	}
}
