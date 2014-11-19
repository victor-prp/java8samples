package functional.executiongarantue;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Function;


/**
 * @author victorp
 */
public class Access {
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private List<String> data = new LinkedList<>();

    public void executeSafely(Function<List<String>, ?> fun){
        lock.writeLock().lock();
        try{
           fun.apply(data);
        }finally {
            lock.writeLock().unlock();
        }
    }


    public static void main(String... args) {
        Access access = new Access();

        //before java 1.8
        access.executeSafely(new Function<List<String>, Object>() {
            @Override
            public Object apply(List<String> data) {
                data.add("not java 8 style");
                return null;
            }
        });

        //with java 1.8
        access.executeSafely( data -> data.add("java 8"));
    }
}
