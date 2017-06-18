package kr.pe.ghp.batch.mapper.repo;

import org.apache.ibatis.annotations.Param;

import kr.pe.ghp.batch.model.CronDetails;

/**
 * @author geunhui park
 */
public interface BatchRepoMapper {
	public abstract void insertTrigger(@Param("groupName") String groupName, @Param("jobName") String jobName, @Param("jobParams") String jobParams, @Param("cronExp") String cronExp);

	public abstract CronDetails selectCronDetails(@Param("groupName") String groupName, @Param("jobName") String jobName);
}
