package com.hwi.ex05.dao;

import com.hwi.ex05.model.Player;
import org.springframework.dao.DataAccessException;

public interface PlayerDao {
	void insertPlayer(Player player) throws DataAccessException;
}
