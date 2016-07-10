package com.hwi.ex05.dao;

import java.util.List;
import com.hwi.ex05.model.Team;
import org.springframework.dao.DataAccessException;

public interface TeamDao {
	List<Team> getTeamList() throws DataAccessException;
    Team getTeam(Integer teamId) throws DataAccessException;
}
