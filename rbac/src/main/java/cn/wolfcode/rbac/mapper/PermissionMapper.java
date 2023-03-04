package cn.wolfcode.rbac.mapper;

import cn.wolfcode.rbac.domain.Permission;

import java.util.List;

/**
 * @author 唐梦然
 * @date 2022/11/20
 * @note
 */
public interface PermissionMapper {

    List<Permission> selectAll();

    void addPermission(Permission permission);

    void deletePermissionById(Long id);
}
