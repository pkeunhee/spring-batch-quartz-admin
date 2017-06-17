package kr.pe.ghp.batch.mapper.web;

import java.util.List;

import javax.annotation.Resource;

/**
 * @author geunhui park
 */
//@Resource(name = "webScanner")
public interface ContentsMapper {
	public abstract void updateProcessed(List<String> params);
}
