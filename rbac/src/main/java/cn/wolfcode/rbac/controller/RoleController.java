package cn.wolfcode.rbac.controller;

import cn.wolfcode.rbac.domain.Role;
import cn.wolfcode.rbac.service.IPermissionService;
import cn.wolfcode.rbac.service.IRoleService;
import cn.wolfcode.rbac.util.QueryObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 唐梦然
 * @date 2022/11/18
 * @note
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IPermissionService permissionService;

    //查询所有角色
    @RequestMapping("/list")
    public String selectAll(Model model, QueryObject queryObject) {
        PageInfo<Role> rolePageInfo = this.roleService.selectPage(queryObject);
        model.addAttribute("roles", rolePageInfo.getList());
        model.addAttribute("pageInfo", rolePageInfo);
        return "role/list";
    }

    //角色编辑请求
    @RequestMapping("/input")
    public String input(Model model, Long id) {
        model.addAttribute("role", this.roleService.selectOne(id));
        model.addAttribute("permissions", this.permissionService.selectAll());
        return "role/input";
    }

    //新增or修改角色  后返回查询
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Role role, @RequestParam(value = "permissionIds", required = false) List<Long> permissionIds) {
        roleService.saveOrUpdate(role, permissionIds);
        return "redirect:/role/list";
    }

    //删除角色
    @RequestMapping("/delete")
    public String deleteRoleById(Long id) {
        roleService.deleteRoleById(id);
        return "redirect:/role/list";
    }
}
