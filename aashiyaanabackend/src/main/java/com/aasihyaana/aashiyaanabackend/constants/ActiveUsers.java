package com.aasihyaana.aashiyaanabackend.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code ActiveUsers} class maintains the users that are currently active/logged in.
 * 
 * @author Viraj Dhumal
 * @since version 1
 */
public class ActiveUsers {

    /**
     * The {@code Map<Integer, String>} holds the active users' used id and username. 
     */
    private static Map<Integer, String> users = new HashMap<Integer, String>();

    /**
     * When new user logins, that new user's user id and username is recorded through this static method.
     * @param userId
     * @param username
     * @return User Id that has been added.
     */
    public static Integer addNewActiveUser(Integer userId, String username) {
        users.put(userId, username);
        return userId;
    }

    /**
     * Returns a {@code Boolean} value, checks if user is still logged in or not.
     * @param userId
     * @return True if user is logged in / active, else false.
     */
    public static Boolean checkUserActive(Integer userId) {
        return users.containsKey(userId);
    }

    /**
     * When user logout, that user is removed from active users map.
     * @param userId
     */
    public static void removeActiveUser(Integer userId) {
        users.remove(userId);
    }
}
