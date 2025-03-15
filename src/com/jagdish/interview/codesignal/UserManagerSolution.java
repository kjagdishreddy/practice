package com.jagdish.interview.codesignal;

import java.util.*;

class UserManager {
    private HashMap<String, User> users = new HashMap<>();
    private HashMap<String, List<String>> activities = new HashMap<>();

    public boolean addUser(String userId, String name) {
        if (users.containsKey(userId)) {
            return false;
        }
        users.put(userId, new User(userId, name));
        activities.put(userId, new ArrayList<>());
        return true;
    }

    public User getUser(String userId) {
        return users.getOrDefault(userId, null);
    }

    public boolean deleteUser(String userId) {
        if (users.containsKey(userId)) {
            users.remove(userId);
            activities.remove(userId);
            return true;
        }
        return false;
    }

    public boolean addActivity(String userId, String activity) {
        // TODO: Add the activity to the user's list if the user exists
        if (users.containsKey(userId)) {
            if(activities.containsKey(userId)) {
                activities.get(userId).add(activity);
            } else {
                List<String> activitiesList = new ArrayList<>();
                activitiesList.add(activity);
                activities.put(userId, activitiesList);
            }
            return true;
        }
        return false;
    }

    public List<String> getActivities(String userId) {
        // TODO: Retrieve the list of activities for a given user if the user exists
        if (activities.containsKey(userId)) {
            return activities.get(userId);
        }
        return new ArrayList<>();
    }

    public List<Map<String, Object>> topNUsersByActivities(int n) {
        // TODO: Get top 'n' users by activity count, sorted descending. In case of ties, use userId in ascending order. Return as list of maps with userId, name, and activityCount
        List<Map<String, Object>> result = new ArrayList<>();

        List<User> sortedUsers = new ArrayList<>(users.values());
        sortedUsers.sort((u1, u2) ->{
            int count1 = activities.get(u1.getId()).size();
            int count2 = activities.get(u2.getId()).size();
            if (count1 != count2) {
                return Integer.compare(count2, count1);
            }
            return u1.getId().compareTo(u2.getId());
        });

        for (int i = 0; i < Math.min(n, sortedUsers.size()); i++) {
            User user = sortedUsers.get(i);
            Map<String, Object> userMap = new HashMap<>();
            userMap.put("userId", user.getId());
            userMap.put("name", user.getName());
            userMap.put("activityCount", activities.get(user.getId()).size());
            result.add(userMap);
        }

        return result;
    }
}

class User {
    private String id;
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

// Example usage
public class UserManagerSolution {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();

        System.out.println(userManager.addUser("user1", "Alice")); // True
        System.out.println(userManager.addUser("user1", "Bob")); // False
        System.out.println(userManager.addUser("user2", "Charlie")); // True

        System.out.println(userManager.addActivity("user1", "Activity1")); // True
        System.out.println(userManager.addActivity("user2", "Activity2")); // True
        System.out.println(userManager.addActivity("user3", "Activity3")); // False

        System.out.println(userManager.getActivities("user1")); // [Activity1]
        System.out.println(userManager.getActivities("user3")); // []

        List<Map<String, Object>> topUsers = userManager.topNUsersByActivities(2);
        for (Map<String, Object> user : topUsers) {
            System.out.println(user.get("userId") + ": " + user.get("name") + " - " + user.get("activityCount") + " activities");
        }
        // Expecting user1 and user2 details

        System.out.println(userManager.deleteUser("user1")); // True
        System.out.println(userManager.getUser("user1") == null); // True
    }
}