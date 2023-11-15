package jz.cbq.demo3_4.cbq;

import java.util.*;

/**
 * CBQDemo3_4
 *
 * @author CBQ
 * @date 2023/11/16 0:23
 * @since 1.0.0
 */
public class CBQDemo3_4 {
    private static final int MAX_COUNT = 100;
    private static final Scanner sc = new Scanner(System.in);
    private static Integer cardCount = 0;
    private static Map<String, Student> cartedStudents;
    private static List<Emp> empList;
    private static List<Student> studentList;

    public static void main(String[] args) {
        String name = "";
        int choise;
        Student student = null;
        cartedStudents = new HashMap<>();
        empList = new ArrayList<>();
        List<Integer> empIdList = new ArrayList<>();
        studentList = new ArrayList<>();
        initData(empList, empIdList, studentList);

        while (cardCount <= MAX_COUNT) {
            menu();
            System.out.println("请输入要进行的操作 (1-3)：");
            choise = sc.nextInt();
            switch (choise) {
                case 1:
                    System.out.println("请输入名称：");
                    name = sc.next();
                    student = login(name);
                    if (student != null) {
                        System.out.println("登录成功");
                        showInfo(student);
                    } else {
                        System.out.println("登录失败");
                    }
                    break;
                case 2:
                    if (student != null) {
                        showInfo(student);
                    } else {
                        System.out.println("请先进行登录操作");
                    }
                    break;
                case 3:
                    if (student != null) {
                        System.out.println("-----------------------");
                        empList.forEach(System.out::println);
                        System.out.println("-----------------------");
                        if (cartedStudents.containsKey(name) && student.getMaxCardCount() == 0) {
                            System.out.println("已经投过票 | 投票次数已用完");
                        } else {
                            System.out.println("请选择 (id)");
                            choise = sc.nextInt();
                            if (empIdList.contains(choise)) {
                                doCard(choise - 1, student);
                                System.out.println(student.getName() + " 投票成功,投票对象为 " + student.getEmp().getName() + " 该候选者当前有：" + student.getEmp().getCardCount() + " 票" + " 您的剩余票数为：" + student.getMaxCardCount());
                            } else {
                                System.out.println("选择参数错误 (id),请重新选择 ");
                            }
                        }
                    } else {
                        System.out.println("请先进行登录操作");
                    }
                    break;
                default:
                    System.out.println("switch-case 解析错误");
                    break;
            }
        }

    }


    /**
     * 初始化数据
     *
     * @param empList   候选者 list
     * @param empIdList 候选者 idList
     */
    private static void initData(List<Emp> empList, List<Integer> empIdList, List<Student> studentList) {
        empList.add(new Emp(1, "Jack", 0));
        empList.add(new Emp(2, "Smith", 0));
        empList.add(new Emp(3, "Mike", 0));

        studentList.add(new Student("cbq", 4, cardCount, null));
        studentList.add(new Student("cb", 4, cardCount, null));

        empList.forEach(emp -> empIdList.add(emp.getId()));

    }

    /**
     * 菜单
     */
    private static void menu() {
        System.out.println("-----------------");
        System.out.println("1- 登录");
        System.out.println("2- 查看当前信息");
        System.out.println("3- 投票");
        System.out.println("------------------");
    }

    /**
     * 登录
     *
     * @param name 名称
     * @return student
     */
    private static Student login(String name) {
        for (Student student : studentList) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    /**
     * print 当前 student 信息
     *
     * @param student student
     */
    private static void showInfo(Student student) {
        System.out.println(student.getName() + " 您还有：" + student.getMaxCardCount() + " 票 ");
    }

    /**
     * 投票
     *
     * @param choose  选择
     * @param student 学生信息
     */
    private static void doCard(int choose, Student student) {
        student.setCurrentTotalCard(cardCount++);
        student.setEmp(empList.get(choose));
        student.setMaxCardCount(student.getMaxCardCount() - 1);
        empList.get(choose).setCardCount(empList.get(choose).getCardCount() + 1);

        if (student.getMaxCardCount() == 0) {
            cartedStudents.put(student.getName(), student);
        }
    }
}
