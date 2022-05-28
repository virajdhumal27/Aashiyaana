package com.aasihyaana.aashiyaanabackend.constants;

import java.util.HashMap;
import java.util.Map;

public class ActiveUsers {
    private static Map<Integer, String> users = new HashMap<Integer, String>();
    private static Integer userId = 0;

    public static Integer addNewActiveUser(String username) {
        userId++;
        users.put(userId, username);
        return userId;
    }

    public static Boolean checkUserActive(Integer userId) {
        return users.containsKey(userId);
    }

    public static void removeActiveUser(Integer userId) {
        users.remove(userId);
    }
}
