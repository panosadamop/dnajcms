package com.dnacreative.module.user.controller.admin;

import com.dnacreative.module.user.model.Permission;
import com.dnacreative.module.user.model.Role;
import com.dnacreative.module.user.model.User;
import com.dnacreative.module.user.service.RoleService;
import com.dnacreative.module.user.service.SecurityService;
import com.dnacreative.module.user.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/admin/acl")
public class AclController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;
    
    @Autowired
    private RoleService roleService;

	private final String MODULE_TEMPLATE_ROOT = "admin/module/user/";

    
	/*
	 * 
	 * roleIndex
	 * roleCreate
	 */
	
	
    /**
     * list all roles
     */
    @RequestMapping(value = "/roleIndex", method = RequestMethod.GET)
    public String roleIndex(Model model) {
        
    	List<Role> roles = roleService.findAllRoles();
            	
        model.addAttribute("roles",roles);

        return MODULE_TEMPLATE_ROOT + "roleIndex";
    
    }
    
    /**
     * show all permissions and permissions that a role has
     */
    @RequestMapping(value = "/rolePermission/{id}", method = RequestMethod.GET)
    public String rolePermission(Model model, @PathVariable int id) {
        
    	Role role = roleService.findRoleAndPermissionByRoleId(id);
    	
    	List<Permission> permissions = roleService.findAllPermissions();
    	
    	model.addAttribute("role",role);
    	model.addAttribute("permissions",permissions);
    	
    	return MODULE_TEMPLATE_ROOT + "rolePermission";
    }
    
    @RequestMapping(value = "/rolePermissionUpdate/{id}", method = RequestMethod.POST)
    public String rolePermissionUpdate(@PathVariable int id, @ModelAttribute("role") Role role, BindingResult bindingResult) {
        
    	
    /*	
    	System.out.println(role);
    	System.out.println(role.getPermissions());
    	System.out.println(role.getName());
    	System.out.println(role.getTitle());
    	System.out.println(role.getUsers());
    	System.out.println(role.getId());
*/
    	
    	if (bindingResult.hasErrors()) {
        	return "redirect:/admin/acl/rolePermission/" + id;
        } else {

        	roleService.updatePermissionRole(role);
        	
			return "redirect:/admin/category/index";
        }
    	
    }
    
    /**
     * a view to show what roles belong to user
     */
    @RequestMapping(value = "/roleUser/{userId}", method = RequestMethod.GET)
    public String roleUser(@PathVariable long userId, Model model) 
    {
    	User user = userService.findUserAndRolesByUserId(userId);
    	
    	List<Role> roles = roleService.findAllRoles();

    	model.addAttribute("user",user);
    	model.addAttribute("roles",roles);
    	
    	return MODULE_TEMPLATE_ROOT + "roleUser";
    }
    
    @RequestMapping(value = "/roleUserUpdate/{id}", method = RequestMethod.POST)
    public String roleUserUpdate(@PathVariable long id, @ModelAttribute("user") User user, BindingResult bindingResult) {
    	
    	if (bindingResult.hasErrors()) {
        	return "redirect:/admin/acl/roleUser/" + id;
        } else {

        	roleService.updateUserWithRoles(user);
        	
			return "redirect:/admin/roleUser/index";
        }
    	
    }
    
    
}
