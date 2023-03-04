package cn.wolfcode.rbac;

import org.apache.commons.collections4.SetUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 唐梦然
 * @date 2022/11/26
 * @note
 */
public class CommonsTest {
  @Test
  public void demo02() {
    List<Long> list1 = new ArrayList<>();
    list1.add(1L);
    list1.add(2L);
    list1.add(3L);
    list1.add(4L);


    List<Long> list2 = new ArrayList<>();
    list2.add(1L);
    list2.add(2L);
    list2.add(5L);
    list2.add(6L);
    // 将List集合转换为Set集合
    // before:[1,2,3,4]
    // after:[1,2,5,6]
    System.out.println("list1"+list1);
    System.out.println("list2"+list2);

    Set<Long> before = new HashSet<>(list1);
    Set<Long> after = new HashSet<>(list2);
    System.out.println("before"+before);
    System.out.println("after"+after);
    // different方法 取出两个集合之间不同的值
    // different(a,b)  计算出a,b两个集合的不同，并取出a中的差值
    // before_after: [3,4]
    SetUtils.SetView<Long> before_after = SetUtils.difference(before, after);
    // after_before: [5,6]
    SetUtils.SetView<Long> after_before = SetUtils.difference(after, before);
    Set<Long> longs = before_after.toSet();
    List<Long> longs1 = new ArrayList<>(longs);
    System.out.println("before_after:" +longs1);
    System.out.println("after_before:" + after_before);

    System.out.println(list1.removeAll(list2));
    System.out.println(list1);

  }
}
