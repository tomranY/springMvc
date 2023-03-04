package cn.wolfcode.rbac.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 唐梦然
 * @date 2022/11/20
 * @note
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuzzyQuery {
    private String keyword;
    private Long deptId;
}
