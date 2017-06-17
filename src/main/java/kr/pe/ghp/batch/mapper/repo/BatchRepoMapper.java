package kr.pe.ghp.batch.mapper.repo;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;

/**
 * @author geunhui park
 */
//@Resource(name = "repoScanner")
public interface BatchRepoMapper {
	public abstract void insertTrigger(@Param("groupName") String groupName, @Param("jobName") String jobName, @Param("jobParams") String jobParams, @Param("cronExp") String cronExp);
}
