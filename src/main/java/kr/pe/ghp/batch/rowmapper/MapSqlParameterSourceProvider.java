package kr.pe.ghp.batch.rowmapper;

import java.util.Map;

import org.springframework.batch.item.database.ItemSqlParameterSourceProvider;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

/**
 * @author geunhui park
 */
public class MapSqlParameterSourceProvider implements ItemSqlParameterSourceProvider<Map<String, String>> {
	@Override
	public SqlParameterSource createSqlParameterSource(Map<String, String> map) {
		return new MapSqlParameterSource(map);
	}
}