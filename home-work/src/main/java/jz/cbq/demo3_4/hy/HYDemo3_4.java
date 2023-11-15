package jz.cbq.demo3_4.hy;

import java.util.HashSet;
import java.util.Scanner;

/**
 * HYDemo3_4
 *
 * @author CBQ
 * @date 2023/11/16 0:15
 * @since 1.0.0
 */
public class HYDemo3_4 {
    private static final int MAX_COUNT = 100;
    private static int currentCount = 0;
    private static HashSet<Voter> voters;
    private static int okCount = 0;
    private static int noCount = 0;

    /**
     * 投票
     * @param voter voter
     */
    public static void VoterFor(Voter voter) {
        if (currentCount == MAX_COUNT) {
            System.out.println("投票结束");
            return;
        }
        if (voters.stream().map(Voter::getName).toList().contains(voter.getName())) {
            System.out.println("请勿重复投票");
        } else {
            currentCount++;
            voters.add(voter);
            System.out.println("感谢你的支持");
        }

        if (voter.getAnswer().equals("同意")) {
            okCount++;
        } else if (voter.getAnswer().equals("不同意")) {
            noCount++;
        } else {
            System.out.println("你输入有误！");
        }
    }


    /**
     * 结果
     */
    public static void printVoterResult() {
        System.out.println("==================================");
        System.out.println("当前的投票总数为：" + currentCount + " 票");
        System.out.println("参与的学生结果如下：");
        System.out.println("----------------------------");
        voters.forEach(voter -> System.out.println(voter.getName() + " 意见: " + voter.getAnswer()));
        System.out.println("----------------------------");
        System.out.println("当前同意的的票数 " + okCount + " 票");
        System.out.println("当前不同意的的票数 " + noCount + " 票");
        System.out.println("==================================");
    }


    public static void main(String[] args) {
        voters = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        String flag;
        for (int i = 0; i < MAX_COUNT; i++) {
            Voter voter = new Voter();
            System.out.println("请输入投票人的信息：");
            voter.setName(sc.next());
            System.out.println("请输入你的意见");
            voter.setAnswer(sc.next());
            VoterFor(voter);
            System.out.println("是否继续投票（是/否）");
            flag = sc.next();
            if (flag.equals("否")) {
                break;
            }

        }
        printVoterResult();
    }
}
