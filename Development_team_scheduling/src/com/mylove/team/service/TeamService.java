package com.mylove.team.service;

import com.mylove.team.domain.Architect;
import com.mylove.team.domain.Designer;
import com.mylove.team.domain.Employee;
import com.mylove.team.domain.Programmer;

/**
 * 
 * @Description 开发团队的管理：添加、删除
 * @author Zeqing Li Email:lizeqing77@163.com
 * @version
 * @date 2022年3月30日下午9:38:08
 *
 */
public class TeamService {
	private static int counter = 1;//给memberId赋值
	private final int MAX_MEMBER = 5;//限制开发团队的人数
	private Programmer[] team = new Programmer[MAX_MEMBER];//保存开发团队
	private int total;//记录开发团队中的实际人数
	public TeamService() {
		super();
	}
	/**
	 * 
	 *@Description 获取开发团队中的所有成员
	 *@author Zeqing Li
	 *@date 2022年3月30日下午9:47:27 
	 *@return
	 */
	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for (int i = 0;i < team.length;i++) {
			team[i] = this.team[i];
		}
		return team;
	}
	/**
	 * 
	 *@Description 将指定的员工添加到开发团队中
	 *@author Zeqing Li
	 *@date 2022年3月30日下午9:50:43 
	 *@param e
	 * @throws TeamException 
	 */
	public void addMember(Employee e) throws TeamException {
//		成员已满，无法添加
		if (total >= MAX_MEMBER) {
			throw new TeamException("成员已满，无法添加");
		}
//		该成员不是开发人员，无法添加
		if (!(e instanceof Programmer)) {
			throw new TeamException("该成员不是开发人员，无法添加");
		}
//		该员工已在本开发团队中
		if (isExit(e)) {
			throw new TeamException("该员工已在本开发团队中");
		}
//		该员工已是某团队成员
//		该员工正在休假，无法添加
		Programmer p = (Programmer)e;//一定不会出现ClassCastException
		if ("BUSY".equalsIgnoreCase(p.getStatus().getNAME())) {
			throw new TeamException("该员工已是某团队成员");
		}else if ("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())) {
			throw new TeamException("该员工正在休假，无法添加");
		}
//		团队中至多只能有一名架构师
//		团队中至多只能有两名设计师
//		团队中至多只能有三名程序员
		
		//获取团队已有成员中架构师，设计师，程序员的人数；
		int numOfArch = 0,numOfDes = 0,numOfPro = 0;
		for (int i = 0;i < total;i++) {
			if (team[i] instanceof Architect) {
				numOfArch++;
			}else if (team[i] instanceof Designer) {
				numOfDes++;
			}else if (team[i] instanceof Programmer) {
				numOfPro++;
			}
		}
		
		if (p instanceof Architect) {
			if (numOfArch >=1) {
				throw new TeamException("团队中至多只能有一名架构师");
			}
		}else if (p instanceof Designer) {
			if (numOfDes >=2) {
				throw new TeamException("团队中至多只能有两名设计师");
			}
		}else if (p instanceof Programmer) {
			if (numOfPro >=3) {
				throw new TeamException("团队中至多只能有三名程序员");
			}
		}
		
		//将p添加到现有的Team中
		team[total++] = p;
		//p属性赋值
		p.setStatus(Status.BUSY);
		p.setMemberId(counter++);
		
	}
	/**
	 * 
	 *@Description 判断该成员是否已经存在团队中
	 *@author Zeqing Li
	 *@date 2022年3月30日下午9:57:46 
	 *@param e
	 *@return
	 */
	private boolean isExit(Employee e) {
		for (int i = 0;i < total;i++) {
				return team[i].getId() == e.getId();
		}
		return false;
	}
	
	public void removeMember(int memberId) {
		
	}
	
	
	
}
