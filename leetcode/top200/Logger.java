package top200;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Logger {

    HashMap<String, Integer> map;
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<>();
    }
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message) && Math.abs(map.get(message) - timestamp) < 10) {
            return false;
        }
        map.put(message, timestamp);
        return true;
    }
}
