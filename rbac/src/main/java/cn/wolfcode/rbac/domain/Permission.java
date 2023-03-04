package cn.wolfcode.rbac.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 唐梦然
 * @date 2022/11/19
 * @note
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    private Long id;
    private String name;
    private String expression;
}
