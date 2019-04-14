package top.okiyar.qqbot.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public class Executors {
    private static ExecutorService singleThread;
    private static ExecutorService fixedThreadPool;
    private static ExecutorService cashedThreadPool;
    private static ScheduledExecutorService scheduledThreadPool;
    private static ExecutorService workStealingPool;

    private synchronized static void createSingleThreadExecutorInstance() {
        if (singleThread == null) {
            singleThread = java.util.concurrent.Executors.newSingleThreadExecutor();
        }
    }

    private synchronized static void createFixedThreadPoolInstance(int nThreads) {
        if (fixedThreadPool == null) {
            fixedThreadPool = java.util.concurrent.Executors.newFixedThreadPool(nThreads);
        }
    }

    private synchronized static void createCachedThreadPoolInstance() {
        if (cashedThreadPool == null) {
            cashedThreadPool = java.util.concurrent.Executors.newCachedThreadPool();
        }
    }

    private synchronized static void createScheduledThreadPoolInstance(int nThreads) {
        if (scheduledThreadPool == null) {
            scheduledThreadPool = java.util.concurrent.Executors.newScheduledThreadPool(nThreads);
        }
    }

    private synchronized static void createWorkStealingPoolInstance() {
        if (workStealingPool == null) {
            workStealingPool = java.util.concurrent.Executors.newWorkStealingPool();
        }
    }

    public static void newSingleThreadExecutor() {
        if (singleThread == null) {
            createSingleThreadExecutorInstance();
        } else {
            // 抛异常
        }
    }

    public static ExecutorService getSingleThreadExecutor() {
        if (singleThread == null) {
            createSingleThreadExecutorInstance();
        }
        return singleThread;
    }

    public static void newFixedThreadPool(int threadSize) {
        if (fixedThreadPool == null) {
            createFixedThreadPoolInstance(threadSize);
        } else {
            // 抛异常
        }
    }

    public static ExecutorService getFixedThreadPool() {
        if (fixedThreadPool == null) {
            // 抛异常
            createFixedThreadPoolInstance(10);
        }
        return fixedThreadPool;
    }

    public static void newCashedThreadPool() {
        if (cashedThreadPool == null) {
            createCachedThreadPoolInstance();
        } else {
            // 抛异常
        }
    }

    public static ExecutorService getCashedThreadPool() {
        if (cashedThreadPool == null) {
            createCachedThreadPoolInstance();
        }
        return cashedThreadPool;
    }

    public static void newScheduledThreadPool(int threadSize) {
        if (scheduledThreadPool == null) {
            createScheduledThreadPoolInstance(threadSize);
        } else {
            // 抛异常
        }
    }

    public static ScheduledExecutorService getScheduledThreadPool() {
        if (scheduledThreadPool == null) {
            createScheduledThreadPoolInstance(10);
        }
        return scheduledThreadPool;
    }

    public static void newWorkStealingPool() {
        if (workStealingPool == null) {
            createWorkStealingPoolInstance();
        } else {
            // 抛异常
        }
    }

    public static ExecutorService getWorkStealingPool() {
        if (workStealingPool == null) {
            createWorkStealingPoolInstance();
        }
        return workStealingPool;
    }

    public static void safeSleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
