package jz.cbq.demo3_4.cbq;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    /**
     * 学生姓名
     */
    private String name;
    /**
     * 最大投票数
     */
    private Integer maxCardCount;
    /**
     * 当前投票总数
     */
    private Integer currentTotalCard;
    /**
     * 投票对象
     */
    private Emp emp;

}
