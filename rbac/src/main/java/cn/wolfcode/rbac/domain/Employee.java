package cn.wolfcode.rbac.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 唐梦然
 * @date 2022/11/20
 * @note
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private String password;
    private String email;
    private Integer age = 0;
    private boolean admin;
    private Department dept;
    private List<Role> roles;

}
