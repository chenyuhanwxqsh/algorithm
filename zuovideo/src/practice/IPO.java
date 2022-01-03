package practice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    public static class Node{
        public int p;
        public int c;

        public Node(int p,int c){
            this.p=p;
            this.c=c;
        }
    }

    public static class MinCostComparator implements Comparator<Node>{

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c-o2.c;
            //复习一下，返回正数，第二个参数排在前面；返回负数，第一个参数排在前面
        }
    }

    public static class MaxProfitComparator implements Comparator<Node>
    {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.p-o2.p;
        }
    }

    /**
     *
     * @param k 最多选几个项目
     * @param w 初始资金
     * @param Profits
     * @param Capital
     * @return
     */
    public static int findMaximizedCapital(int k,int w,int[] Profits,int[] Capital){
        PriorityQueue<Node> minCostQ=new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ=new PriorityQueue<>(new MaxProfitComparator());

        //所有项目扔到被锁池中，花费组织的小根堆
        for (int i=0;i<Profits.length;i++){
            minCostQ.add(new Node(Profits[i],Capital[i]));
        }
        for (int i=0;i<k;i++){//进行K轮
            //能力所及的项目，全解锁
            while (!minCostQ.isEmpty()&&minCostQ.peek().c<=w){
                maxProfitQ.add(minCostQ.poll());
            }
            //没有项目可以选择
            if (maxProfitQ.isEmpty()){
                return w;
            }
            w+=maxProfitQ.poll().p;
        }
        return w;
    }
}
