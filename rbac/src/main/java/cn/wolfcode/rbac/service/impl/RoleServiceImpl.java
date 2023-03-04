package cn.wolfcode.rbac.service.impl;

import cn.wolfcode.rbac.domain.Role;
import cn.wolfcode.rbac.mapper.RoleMapper;
import cn.wolfcode.rbac.service.IRoleService;
import cn.wolfcode.rbac.util.QueryObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.SetUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 唐梦然
 * @date 2022/11/18
 * @note
 */
@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> selectAll() {
        return this.roleMapper.selectAll();
    }

    @Override
    public Role selectOne(Long id) {
        return this.roleMapper.selectOne(id);
    }

    @Override
    public void deleteRoleById(Long id) {
        this.roleMapper.deleteRoleById(id);
        this.roleMapper.deleteRelation(id);
    }

    @Override
    public PageInfo<Role> selectPage(QueryObject queryObject) {
        PageHelper.startPage(queryObject.getCurrentPage(), queryObject.getPageSize());
        List<Role> roles = roleMapper.selectAll();
        return new PageInfo<>(roles);
    }

    @Override
    public void saveOrUpdate(Role role, List<Long> permissionIds) {
        try {
            if (role.getId() == null) {
                roleMapper.addRole(role);
                this.roleMapper.insertRelation(role.getId(), permissionIds);
            } else {
                roleMapper.updateRoleByID(role);
                Set<Long> permissionIdsAfter = new HashSet<>(permissionIds);
                Set<Long> permissionIdsBefore = new HashSet<>(this.roleMapper.selectPermissionIdsByRoleId(role.getId()));
                List<Long> before_after = new ArrayList<>(SetUtils.difference(permissionIdsBefore, permissionIdsAfter));
                List<Long> after_before = new ArrayList<>(SetUtils.difference(permissionIdsAfter, permissionIdsBefore));
                try {
                    this.roleMapper.deleteRoleIds(role.getId(), before_after);
                } catch (Exception e) {
                    System.out.println("此时不需要roleMapper.deleteRoleIds操作");
                }
                this.roleMapper.insertRelation(role.getId(), after_before);
            }
        } catch (Exception e) {
            System.out.println("此时不需要roleMapper.insertRelation");
        }
    }


}
