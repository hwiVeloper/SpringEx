package com.hwi.ex05.dao.impl;

import com.hwi.ex05.model.Team;
import com.hwi.ex05.dao.TeamDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class TeamDaoImpl extends NamedParameterJdbcDaoSupport implements TeamDao{
	public List<Team> getTeamList() throws DataAccessException{
		//콜백 인터페이스 생성
		RowMapper<Team> rowMapper = new TeamRowMapper();
		//SQL 실행
		return getJdbcTemplate().query("SELECT team_id, name FROM team", rowMapper);
	}
	
	protected class TeamRowMapper implements RowMapper<Team>{
		private List<Team> teamList = new ArrayList<Team>();
		
		public List<Team> getResults(){
			return teamList;
		}
		
		public Team mapRow(ResultSet rs, int rowNum) throws SQLException{
			//ResultSet에서 취득한 값을 객체에 넣기
			Team team = new Team();
			team.setId(rs.getInt("team_id"));
			team.setName(rs.getString("name"));
			
			return team;
		}
	}
	
	public Team getTeam(Integer teamId) throws DataAccessException{
		final String sql = "SELECT team_id, name FROM spring.team WHERE team_id = :teamId";
		SqlParameterSource parameterSource = new MapSqlParameterSource("teamId", teamId);
		return getNamedParameterJdbcTemplate().query(sql, parameterSource, new TeamResultSetExtractor());
	}

	protected class TeamResultSetExtractor implements ResultSetExtractor<Team>{
		public Team extractData(ResultSet rs) throws SQLException, DataAccessException{
			//SQL의 결과가 한 건 이상 있는지?
			if(rs.next()){
				//ResultSet에서 취득한 값을 객체에 넣기
				Team team = new Team();
				team.setId(rs.getInt("team_id"));
				team.setName(rs.getString("name"));
				return team;
			}else{
				return null;
			}
		}
	}
}
