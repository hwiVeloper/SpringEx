package com.hwi.ex04.dao.impl;

import com.hwi.ex04.model.Team;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.hwi.ex04.dao.TeamDao;
import org.springframework.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class TeamDaoImpl extends JdbcDaoSupport implements TeamDao{
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
}
