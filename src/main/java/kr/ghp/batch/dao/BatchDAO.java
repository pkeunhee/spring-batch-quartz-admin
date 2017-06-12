package kr.ghp.batch.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @author geunhui park
 */
public class BatchDAO extends JdbcDaoSupport {
	public void insertTrigger(String groupName, String jobName, String jobParams, String cronExp) {
		String sql = "insert into cron_details "
			+ "(GROUP_NAME, JOB_NAME, JOB_PARAMS, CRON_EXP) "
			+ "values "
			+ "(?, ?, ?, ?) "
			+ "on duplicate key update JOB_PARAMS = ?, CRON_EXP = ?";
		getJdbcTemplate().update(sql, new Object[] {groupName, jobName, jobParams, cronExp, jobParams, cronExp});
	}
}
