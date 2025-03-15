package com.jagdish.interview.codesignal;

import java.util.HashMap;
import java.util.Map;

class Review {
    private String text;
    private int rating;
    private boolean flagged;

    public Review(String text, int rating, boolean flagged) {
        this.text = text;
        this.rating = rating;
        this.flagged = flagged;
    }

    public String getText() { return text; }
    public int getRating() { return rating; }
    public boolean isFlagged() { return flagged; }
}

class ReviewManager {
    private HashMap<String, HashMap<String, Review>> reviews = new HashMap<>();

    public void addReview(String productId, String reviewId, String reviewText, int rating) {
        reviews.putIfAbsent(productId, new HashMap<>());
        reviews.get(productId).put(reviewId, new Review(reviewText, rating, false));
    }

    public Review getReview(String productId, String reviewId) {
        return reviews.containsKey(productId) && reviews.get(productId).containsKey(reviewId) ? reviews.get(productId).get(reviewId) : null;
    }

    public boolean deleteReview(String productId, String reviewId) {
        if (reviews.containsKey(productId) && reviews.get(productId).containsKey(reviewId)) {
            reviews.get(productId).remove(reviewId);
            if (reviews.get(productId).isEmpty()) {
                reviews.remove(productId);
            }
            return true;
        }
        return false;
    }

    public Map<String, Object> aggregateReviews(String productId) {
        if (!reviews.containsKey(productId)) {
            return null;
        }

        int totalReviews = 0;
        int inappropriateReviews = 0;
        int sumRatings = 0;

        for (Review review : reviews.get(productId).values()) {
            totalReviews++;
            sumRatings += review.getRating();
            if (review.isFlagged()) {
                inappropriateReviews++;
            }
        }

        if (totalReviews == 0) {
            return null;
        }

        Map<String, Object> stats = new HashMap<>();
        stats.put("totalReviews", totalReviews);
        stats.put("inappropriateReviews", inappropriateReviews);
        stats.put("averageRating", (double) sumRatings / totalReviews);

        return stats;
    }

    public Map<String, Integer> getReviewsInRatingRange(String productId, int minRating, int maxRating) {
        // TODO: Return aggregated statistics for all product reviews falling within the given rating range.
        // The output should contain the total number of reviews within the range and the average rating.
        // Return `null` if no reviews exist for the product within this rating range.
        if (!reviews.containsKey(productId)) {
            return null;
        }

        int totalInRange = 0;
        int sumRatings = 0;

        for (Review review : reviews.get(productId).values()) {
            if (review.getRating() >= minRating && review.getRating() <= maxRating) {
                totalInRange++;
                sumRatings += review.getRating();
            }
        }

        if (totalInRange == 0) {
            return null;
        }

        Map<String, Integer> stats = new HashMap<>();
        stats.put("totalReviewsInRange", totalInRange);
        stats.put("averageRatingInRange", sumRatings / totalInRange);

        return stats;
    }
}

// Example usage
public class ProductReviewsSolution {
    public static void main(String[] args) {
        ReviewManager reviewManager = new ReviewManager();

        reviewManager.addReview("P1", "R1", "Great product!", 5);
        reviewManager.addReview("P1", "R2", "Not bad", 3);
        reviewManager.addReview("P1", "R3", "Could be better", 2);

        System.out.println("Aggregate Reviews for P1:");
        Map<String, Object> aggregate = reviewManager.aggregateReviews("P1");
        if (aggregate != null) {
            aggregate.forEach((key, value) -> System.out.println(key + ": " + value));
        }

        System.out.println("-----------");
        System.out.println("Reviews in rating range 3 to 5 for P1:");
        Map<String, Integer> filtered = reviewManager.getReviewsInRatingRange("P1", 3, 5);
        if (filtered != null) {
            filtered.forEach((key, value) -> System.out.println(key + ": " + value));
        }
    }
}