package jz.cbq.demo3_4.cbq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ��ѡ��
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    /**
     * ��ѡ�� id
     */
    private Integer id;
    /**
     * ����
     */
    private String name;
    /**
     * �ѻ�Ʊ��
     */
    private Integer cardCount;
}
