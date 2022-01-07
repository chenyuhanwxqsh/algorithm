package hashMap;

import java.util.HashMap;

public class RandomPool {
    public static class Pool<K>{
        private HashMap<K,Integer> keyIndexMap;
        private HashMap<Integer,K> indexKeyMap;
        private int size;

        public Pool() {
            this.keyIndexMap=new HashMap<K,Integer>();
            this.indexKeyMap=new HashMap<Integer, K>();
            this.size=0;
        }

        public void insert(K key){
            if (!this.keyIndexMap.containsKey(key)){
                this.keyIndexMap.put(key,this.size);
                this.indexKeyMap.put(this.size++,key);
            }
        }

        public void delete(K key){
            if (this.keyIndexMap.containsKey(key)){
                int deleteIndex= keyIndexMap.get(key);
                K lastKey=indexKeyMap.get(--size);

                this.keyIndexMap.remove(key);
                this.indexKeyMap.remove(size);
                keyIndexMap.put(lastKey,deleteIndex);
                indexKeyMap.put(deleteIndex,lastKey);
            }
        }

        public K getRandom(){
            if (this.size==0){
                return null;
            }
            int randomIndex=(int) (Math.random()*this.size);//0~size-1
            return indexKeyMap.get(randomIndex);
        }
    }

    public static void main(String[] args) {
        Pool<String> pool=new Pool<>();
        pool.insert("chen");
        pool.insert("yu");
        pool.insert("han");
        System.out.println(pool.getRandom());
    }
}
