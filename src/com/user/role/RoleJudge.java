package com.user.role;

import com.user.entity.User;
import com.user.role.impl.RoleDaoImplement;

public class RoleJudge {
	public void judge(User user)
	{
		 RoleDaoImplement.valueOf("ROLE_"+user.getId()).op(user);
	}
}
