package kr.pe.ghp.batch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.pe.ghp.batch.mapper.web.ContentsMapper;

/**
 * @author geunhui park
 */
@Service
public class ContentsService {
	@Autowired
	private ContentsMapper mapper;

	public void updateProcessed(List<String> params) {
		mapper.updateProcessed(params);
	}
}
