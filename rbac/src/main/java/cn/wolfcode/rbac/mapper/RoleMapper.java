package cn.wolfcode.rbac.mapper;

import cn.wolfcode.rbac.domain.Permission;
import cn.wolfcode.rbac.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 唐梦然
 * @date 2022/11/18
 * @note
 */
public interface RoleMapper {
    //查询所有角色
    List<Role> selectAll();

    //查询一个角色
    Role selectOne(Long id);

    //通过角色id查询权限id
    List<Long> selectPermissionIdsByRoleId(Long id);

    List<Permission> selectByRoleId(Long id);

    //新增角色
    void addRole(Role role);

    //删除角色
    void deleteRoleById(Long id);

    //删除关系表
    void deleteRelation(Long id);

    //删除权限与角色关系
    void deleteRoleIds(@Param("roleId") Long roleId, @Param("permissionIds") List<Long> permissionIds);

    //修改部门
    void updateRoleByID(Role role);

    //增加角色与关系
    void insertRelation(@Param("roleId") Long roleId, @Param("permissionIds") List<Long> permissionIds);
}
