package com.hwi.ex05.ui;

import java.util.List;

import com.hwi.ex05.model.Team;
import com.hwi.ex05.dao.TeamDao;

public class SelectTeamUi extends AbstractUi {

    private TeamDao teamDao;

    public void setTeamDao(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public void show() {
        //팀 목록을 보여준다.
        showTeamList(this.teamDao.getTeamList());
        System.out.println("Enter키를 누르면 돌아갑니다.");
        getInputedString();
    }

    protected void showTeamList(List<Team> teamList) {
        System.out.println("--------------------");
        System.out.println("팀 목록입니다.");
        System.out.println("ID   팀명");
        for (Team team : teamList) {
        	//ID, 팀명을 출력한다.
        	System.out.printf("%d  %s%n", team.getId(), team.getName());
		}
    }
}
