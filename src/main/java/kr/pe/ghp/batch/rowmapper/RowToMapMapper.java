package kr.pe.ghp.batch.rowmapper;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.google.common.collect.Maps;

/**
 * ResultSet을 Map으로 변환
 * @author geunhui park
 *
 */
public class RowToMapMapper implements RowMapper<Map<String, String>> {
	private static Logger logger = LoggerFactory.getLogger(RowToMapMapper.class);

	@Override
	public Map<String, String> mapRow(ResultSet rs, int rowNum) throws SQLException {
		Map<String, String> result = Maps.newHashMap();

		ResultSetMetaData metaData = rs.getMetaData();
		int colCount = metaData.getColumnCount();
		for (int i = 1; i <= colCount; i++) {
			result.put(metaData.getColumnLabel(i), rs.getString(i));
			//logger.debug("#[" + rowNum + "] " + result);
		}

		return result;
	}
}
