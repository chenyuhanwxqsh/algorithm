package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KruskalII {

    public static class MySets{
        public HashMap<Node,List<Node>> setMap;

        //初始创建时,每一个节点都创建一个集合,集合中只有自己
        public MySets(List<Node> nodes){
            for (Node cur:nodes
                 ) {
                List<Node> set=new ArrayList<>();
                set.add(cur);
                setMap.put(cur,set);
            }
        }

        public boolean isSameSet(Node from,Node to){
            List<Node> fromSet=setMap.get(from);
            List<Node> toSet=setMap.get(to);
            return fromSet==toSet;
        }

        public void union(Node from,Node to){
            List<Node> fromSet=setMap.get(from);
            List<Node> toSet=setMap.get(to);

            for (Node toNode:toSet
                 ) {
                fromSet.add(toNode);
                setMap.put(toNode,fromSet);
            }
        }
    }
}
