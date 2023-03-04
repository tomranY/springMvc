package cn.wolfcode.rbac.controller;

import cn.wolfcode.rbac.domain.Permission;
import cn.wolfcode.rbac.service.IPermissionService;
import cn.wolfcode.rbac.util.QueryObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author 唐梦然
 * @date 2022/11/20
 * @note
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    IPermissionService permissionService;

    //分页查询
    @RequestMapping(value = "/list")
    public String selectPage(Model model, QueryObject queryObject) {
        //获取员工分页信息
        PageInfo<Permission> pageInfo = permissionService.selectPage(queryObject);
        model.addAttribute("permissions", pageInfo.getList());
        model.addAttribute("pageInfo", pageInfo);
        return "permission/list";
    }

    //重新加载
    @RequestMapping({"/reload"})
    public String reload() throws Exception {
        try {
            this.permissionService.reload();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/permission/list";
    }

    @RequestMapping({"/delete"})
    public String delete(Long id) throws Exception {
        this.permissionService.delete(id);
        return "redirect:/permission/list";
    }

}
