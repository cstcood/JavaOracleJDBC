package com.user.role.impl;

import com.user.entity.User;
import com.user.role.RoleDao;
import com.user.role.op.NormalOperation;
import com.user.role.op.RootOperation;

public enum  RoleDaoImplement implements RoleDao {
	ROLE_1{

		@Override
		public void op(User user) {
			// TODO Auto-generated method stub
			System.out.println("root");
			RootOperation operation=new RootOperation(user);
			operation.showMenu();		
		}
	},
	
	ROLE_2{

		@Override
		public void op(User user) {
			// TODO Auto-generated method stub
			NormalOperation operation=new NormalOperation(user);
			System.out.println("normal");
			operation.showMenu();
		}
	}

}
