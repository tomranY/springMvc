package cn.wolfcode.rbac;

import cn.wolfcode.rbac.domain.Permission;
import cn.wolfcode.rbac.service.IPermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 唐梦然
 * @date 2022/11/20
 * @note
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PermissionServiceTest {
  @Autowired
  IPermissionService permissionService;
  @Test
  public void addPermissionTest(){
    Permission permission = new Permission(null, "删库跑路", "run:delete");
    this.permissionService.addPermission(permission);
  }
}
