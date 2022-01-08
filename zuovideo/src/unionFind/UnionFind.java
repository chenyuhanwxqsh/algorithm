package unionFind;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFind {
    //样本进来会包一层，叫做元素
    public static class Element<V>{
        public V value;

        public Element(V value){
            this.value=value;
        }
    }

    public static class UnionFindSet<V>{
        //并查集结构的第一张表是，样本对应自己的元素表
        public HashMap<V,Element<V>> elementMap;
        //key 某个元素 value 该元素的父
        public HashMap<Element<V>,Element<V>> fatherMap;
        //key 某个集合的代表元素 value 该集合的大小
        public HashMap<Element<V>,Integer> sizeMap;

        //并查集初始化时要求把样本都给我
        public UnionFindSet(List<V> list){
            elementMap=new HashMap<>();
            fatherMap=new HashMap<>();
            sizeMap=new HashMap<>();
            for (V value:list
                 ) {
                Element<V> element=new Element<>(value);
                elementMap.put(value,element);
                fatherMap.put(element,element);
                sizeMap.put(element,1);
            }
        }

        //给定一个element,往上一直找，把代表元素返回
        public Element<V> findHead(Element<V> element){
            Stack<Element<V>> path=new Stack<>();
            while (element!=fatherMap.get(element)){
                path.push(element);
                element=fatherMap.get(element);
            }
            //扁平化的优化,将沿途路过的所有元素的father都设为了代表元素
            while (!path.isEmpty()){
                fatherMap.put(path.pop(), element);
            }
            return element;
        }

        public boolean isSameSet(V a,V b){
            if (elementMap.containsKey(a)&&elementMap.containsKey(b)){
                return findHead(elementMap.get(a))==findHead(elementMap.get(b));
            }
            return false;
        }

        public void union(V a,V b){
            if (elementMap.containsKey(a)&&elementMap.containsKey(b)) {
                Element<V> aFather = findHead(elementMap.get(a));
                Element<V> bFather = findHead(elementMap.get(b));

                if (aFather != bFather) {
                    Element<V> biggerV = sizeMap.get(aFather) >= sizeMap.get(bFather) ? aFather : bFather;
                    Element<V> smallerV = biggerV == aFather ? bFather : aFather;

                    sizeMap.put(biggerV, sizeMap.get(biggerV) + sizeMap.get(smallerV));
                    sizeMap.remove(smallerV);
                    fatherMap.put(smallerV, biggerV);
                }
            }
        }
    }
}
