package tree;

import java.util.List;

public class MaxHappyBase {
    public static class Employee{
        public int happy;//这名员工带来的快乐值
        public List<Employee> nexts;//这名员工的直接下级
    }

    public static int maxHappy(Employee boss){
        Info headInfo=process(boss);
        return Math.max(headInfo.joinMaxHappy,headInfo.notJoinMaxHappy);
    }

    public static class Info{
        public int joinMaxHappy;
        public int notJoinMaxHappy;

        public Info(int joinMaxHappy, int notJoinMaxHappy) {
            this.joinMaxHappy = joinMaxHappy;
            this.notJoinMaxHappy = notJoinMaxHappy;
        }
    }

    public static Info process(Employee ee){
        if (ee.nexts.isEmpty()){//基层员工
            return new Info(ee.happy,0);
        }
        int joinHappy= ee.happy;//ee来的情况下，整棵树的最大快乐值
        int notJoinHappy=0;//ee不来的情况下，整棵树的最大快乐值
        for (Employee next: ee.nexts
             ) {
            Info info=process(next);
            notJoinHappy+=Math.max(info.joinMaxHappy,info.notJoinMaxHappy);
            joinHappy+=info.notJoinMaxHappy;
        }
        return new Info(joinHappy,notJoinHappy);
    }
}
