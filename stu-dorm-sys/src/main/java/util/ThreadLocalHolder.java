package util;

public class ThreadLocalHolder {

    private static final ThreadLocal<Integer> COUNT = new ThreadLocal<>();

    //提供对外的方法,获取
    public static ThreadLocal<Integer> get() {
        return COUNT;
    }
}
