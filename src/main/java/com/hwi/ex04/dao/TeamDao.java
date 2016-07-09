package com.hwi.ex04.dao;

import java.util.List;
import com.hwi.ex04.model.Team;
import org.springframework.dao.DataAccessException;

public interface TeamDao {
	List<Team> getTeamList() throws DataAccessException;
}
