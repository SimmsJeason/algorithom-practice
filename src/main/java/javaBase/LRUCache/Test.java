package javaBase.LRUCache;


public class Test {

    public static void main(String[] args) {
        LRUCache2<Integer, String> cache = new LRUCache2<>();
        cache.put(1, "a");
        cache.put(2, "b");
        cache.put(3, "c");
        cache.get(1);
        cache.put(4, "d");
        System.out.println(cache.keySet());
    }
}
