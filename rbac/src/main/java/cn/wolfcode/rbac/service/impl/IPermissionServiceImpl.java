package cn.wolfcode.rbac.service.impl;

import cn.wolfcode.rbac.domain.Permission;
import cn.wolfcode.rbac.mapper.PermissionMapper;
import cn.wolfcode.rbac.service.IPermissionService;
import cn.wolfcode.rbac.util.QueryObject;
import cn.wolfcode.rbac.util.RequiredPermission;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author 唐梦然
 * @date 2022/11/20
 * @note
 */
@Service
public class IPermissionServiceImpl implements IPermissionService {
    @Autowired
    PermissionMapper permissionMapper;
    @Autowired
    private ApplicationContext ctx;

    @Override
    public List<Permission> selectAll() {
        return this.permissionMapper.selectAll();
    }

    @Override
    public PageInfo<Permission> selectPage(QueryObject queryObject) {
        PageHelper.startPage(queryObject.getCurrentPage(), queryObject.getPageSize());
        List<Permission> permissions = this.permissionMapper.selectAll();
        return new PageInfo<>(permissions);
    }

    //懒得写，拷的老师的
    @Override
    public void reload() {
        List<Permission> permissions = this.permissionMapper.selectAll();
        Set<String> set = new HashSet();
        Iterator<Permission> var3 = permissions.iterator();
        while (var3.hasNext()) {
            Permission p = (Permission) var3.next();
            set.add(p.getExpression());
        }

        Map<String, Object> ctrlsMap = this.ctx.getBeansWithAnnotation(Controller.class);
        Collection<Object> controllers = ctrlsMap.values();
        Iterator var5 = controllers.iterator();

        while (var5.hasNext()) {
            Object controller = var5.next();
            Method[] ms = controller.getClass().getDeclaredMethods();
            Method[] var8 = ms;
            int var9 = ms.length;

            for (int var10 = 0; var10 < var9; ++var10) {
                Method m = var8[var10];
                RequiredPermission ann = (RequiredPermission) m.getDeclaredAnnotation(RequiredPermission.class);
                if (ann != null) {
                    String exp = ann.value()[0];
                    String name = ann.value()[1];
                    if (!set.contains(exp)) {
                        Permission p = new Permission();
                        p.setName(name);
                        p.setExpression(exp);
                        this.permissionMapper.addPermission(p);
                    }
                }
            }
        }

    }

    public void addPermission(Permission permission) {
        this.permissionMapper.addPermission(permission);
    }

    @Override
    public void delete(Long id) {
        this.permissionMapper.deletePermissionById(id);
    }
}
