package jz.cbq.demo3_4.cbq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 候选者
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    /**
     * 候选者 id
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 已获票数
     */
    private Integer cardCount;
}
