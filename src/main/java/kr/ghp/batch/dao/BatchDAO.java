package kr.ghp.batch.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @author geunhui park
 */
public class BatchDAO extends JdbcDaoSupport {

	public void insertTrigger() {
		String sql = "";
		getJdbcTemplate().update(sql, new Object[] {});
	}
}
