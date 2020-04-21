package demo.lock;

import redis.clients.jedis.Jedis;

import java.util.concurrent.atomic.AtomicInteger;

public class RedisDistributedLock {
    private static final String LOCK_SUCCESS = "OK";

    private static final String SET_IF_NOT_EXIST = "NX";

    private static final String SET_WITH_EXPIRE_TIME = "PX";

    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(1);
        int i = ai.incrementAndGet();
        System.out.println(i);
        System.out.println(Integer.MAX_VALUE);
    }

    public static boolean tryGetDistributedLock(Jedis jedis, String lockKey, String value, int expireTime) {
        String result = jedis.set(lockKey, value, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }
}
