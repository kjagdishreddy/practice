package com.jagdish.interview.codesignal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public Integer findMinElement(int[] array) {
        // If array is empty, return null
        if (array.length == 0) {
            return null;
        }

        // Initialize min to first element
        int min = array[0];

        // Iterate through the array to find the minimum value
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i]; // Update min if a smaller element is found
            }
        }

        return min; // Return the minimum value
    }

    public static void main(String[] args) {
        /*
        Solution finder = new Solution();

        System.out.println(finder.findMinElement(new int[]{3, 1, 4, 1, 5, 9})); // Output: 1
        System.out.println(finder.findMinElement(new int[]{10, -2, 0, 5})); // Output: -2
        System.out.println(finder.findMinElement(new int[]{})); // Output: null
        System.out.println(finder.findMinElement(new int[]{7})); // Output: 7

         */

        Map<String, Integer> fruitPrices = new HashMap<>();
        fruitPrices.put("Apple", 100);
        fruitPrices.put("Banana", 50);
        fruitPrices.put("Cherry", 200);

        fruitPrices.forEach((key, value) -> System.out.println(key + "-" + value));

        System.out.println("----");
        fruitPrices.entrySet().forEach(System.out::println);

        System.out.println("----");
        // Filtering
        fruitPrices.entrySet().stream()
                .filter(entry -> entry.getValue() > 50) // Filter values greater than 50
                .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

    }
}

class InventoryManager {
    private Map<String, Integer> inventory;

    public InventoryManager() {
        inventory = new HashMap<>();
    }

    public void addProduct(String productId, int quantity) {
        inventory.put(productId, inventory.getOrDefault(productId, 0) + quantity);
    }

    public void removeProduct(String productId, int quantity) {
        // TODO: Implement the method that decreases the quantity of the product.
        // If the quantity becomes zero or negative, remove the product from the inventory.


        if(inventory.containsKey(productId)) {
            int newQuantity = inventory.get(productId) - quantity;
            if (newQuantity <= 0) {
                inventory.remove(productId);
            } else {
                inventory.put(productId, newQuantity);
            }
        }
    }

    public Map<String, Integer> getInventory() {
        return new HashMap<>(inventory);
    }
}
