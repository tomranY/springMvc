package cn.wolfcode.rbac.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QueryObject {
    //默认显示
    private int currentPage = 1;
    private int pageSize = 5;

    //获取起始索引的方法
    public int getStartIndex() {
        //select * from department limit startIndex,pageSize
        return (currentPage - 1) * pageSize;
    }
}
