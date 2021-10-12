package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapComparatorTest {
    public static class AComp implements Comparator<Integer> {

        //如果返回负数，认为第一个参数应该放在上面
        //如果返回正数，认为第二个参数应该放在下面
        //如果返回0，谁都行
        @Override
        public int compare(Integer arg0, Integer arg1) {
            return arg1-arg0;
        }
    }

    public static void main(String[] args){
        //如果不加比较器的化，默认PriorityQueue为小根堆
        PriorityQueue<Integer> heap=new PriorityQueue<>(new AComp());

        heap.add(5);
        heap.add(9);
        heap.add(2);
        heap.add(10);
        heap.add(78);

        while (!heap.isEmpty()){
            System.out.println(heap.poll());
        }
    }
}
