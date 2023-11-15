package jz.cbq.demo3_4.hy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Voter
 *
 * @author CBQ
 * @date 2023/11/16 0:47
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Voter {
    /**
     * 姓名
     */
    private String name;
    /**
     * 意见
     */
    private String answer;
}
