package com.hwi.ex05.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUi extends AbstractUiTemplate {
	private SelectTeamUi selectTeamUi;
	private InsertPlayerUi insertPlayerUi;
	
	public void setSelectTeamUi(SelectTeamUi selectTeamUi){
		this.selectTeamUi = selectTeamUi;
	}
	
	public void setInsertPlayerUi(InsertPlayerUi insertPlayerUi){
		this.insertPlayerUi = insertPlayerUi;
	}
	
	protected void showMenu() {
        System.out.println("--------------------");
        System.out.println("선수 명단 메뉴");
        System.out.println("");
        System.out.println("1.종료");
        System.out.println("2.팀 목록");
        System.out.println("3.선수 추가");
        System.out.println("");
        System.out.println("번호를 입력한 후 Enter키를 눌러주세요.");
    }

    protected int getMaxMenuNumber() {
        return 3;
    }

    protected int getMinMenuNumber() {
        return 1;
    }

    protected void execute(int number) {
        switch (number) {
        case 1:
            // 1.종료
            System.out.println("종료되었습니다.");
            System.exit(0);
        case 2:
            // 2.팀 목록
            this.selectTeamUi.show();
            break;
        case 3:
        	// 3.선수 추가
        	this.insertPlayerUi.show();
        	break;
        }
    }

    public static void main(String[] args) {
        // 스프링 설정 파일 읽기
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MenuUi menuUi = context.getBean(MenuUi.class);
        while (true) {
            menuUi.show();
        }
    }
}
