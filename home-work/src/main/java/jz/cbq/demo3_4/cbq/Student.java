package jz.cbq.demo3_4.cbq;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ѧ����
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    /**
     * ѧ������
     */
    private String name;
    /**
     * ���ͶƱ��
     */
    private Integer maxCardCount;
    /**
     * ��ǰͶƱ����
     */
    private Integer currentTotalCard;
    /**
     * ͶƱ����
     */
    private Emp emp;

}
