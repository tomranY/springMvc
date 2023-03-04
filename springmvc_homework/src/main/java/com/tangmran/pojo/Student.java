package com.tangmran.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 唐梦然
 * @date 2023-02-28
 * @note
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
  private String name;
  private Long id;
  private String classroom;
  private Long score;
}
