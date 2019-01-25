package com.dnacreative.module.user.service;

import java.util.List;

import com.dnacreative.module.user.model.Permission;
import com.dnacreative.module.user.model.Role;
import com.dnacreative.module.user.model.User;

public interface RoleService {

	List<Role> findAllRoles();

	Role findRoleAndPermissionByRoleId(int id);

	List<Permission> findAllPermissions();

	void updatePermissionRole(Role entityForm);

	void updateUserWithRoles(User user);
}
