package com.mycharx.rauh.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Test vo.
 *
 * @author 张卜亢
 * @date 2019.10.07 21:24:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestVo {
    private Long id;
    private String name;
}
