package cn.wolfcode.rbac.service;

import cn.wolfcode.rbac.domain.Role;
import cn.wolfcode.rbac.util.QueryObject;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author 唐梦然
 * @date 2022/11/18
 * @note
 */
public interface IRoleService {
    //查询所有角色
    List<Role> selectAll();

    //查询一个部门
    Role selectOne(Long id);

    //删除部门
    void deleteRoleById(Long id);

    PageInfo<Role> selectPage(QueryObject queryObject);

    void saveOrUpdate(Role role, List<Long> permissionIds);


}
