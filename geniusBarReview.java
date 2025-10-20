public class geniusBarReview {

  public static void main(String[] args) 
  {
      // Analyze all reviews and provide comprehensive feedback
      analyzeAllReviews();
      
      // Find the best and worst reviews
      String bestReview = findBestReview();
      String worstReview = findWorstReview();
      
      System.out.println("\n=== REVIEW ANALYSIS SUMMARY ===");
      System.out.println("Best Review: " + bestReview);
      System.out.println("Worst Review: " + worstReview);
      
      // Generate detailed report for each review
      generateDetailedReport("review1.txt");
      generateDetailedReport("review2.txt");
  }
  
  /**
   * Analyzes all reviews and prints sentiment scores
   * This method uses iteration and String methods
   */
  public static void analyzeAllReviews() {
      String[] reviewFiles = {"review1.txt", "review2.txt", "review3.txt", 
                             "review4.txt", "review5.txt", "review6.txt"};
      
      System.out.println("=== GENIUS BAR REVIEW ANALYSIS ===");
      
      // Iteration requirement - loop through all reviews
      for (int i = 0; i < reviewFiles.length; i++) {
          String fileName = reviewFiles[i];
          double originalSentiment = Review.totalSentiment(fileName);
          double enhancedSentiment = enhancedSentimentAnalysis(fileName);
          int stars = Review.starRating(fileName);
          
          // String methods requirement - using substring and toUpperCase
          String reviewNumber = fileName.substring(6, 7); // Extract number from "reviewX.txt"
          String status;
          if (enhancedSentiment > 5) {
              status = "VERY POSITIVE";
          } else if (enhancedSentiment > 0) {
              status = "POSITIVE";
          } else if (enhancedSentiment > -5) {
              status = "NEUTRAL";
          } else {
              status = "NEGATIVE";
          }
          
          System.out.println("Review " + reviewNumber + ": " + stars + " stars (" + 
                           String.format("%.2f", originalSentiment) + " -> " + 
                           String.format("%.2f", enhancedSentiment) + " sentiment) - " + status);
      }
  }
  
  /**
   * Finds the review with the highest sentiment score
   * Uses conditional statements and String methods
   */
  public static String findBestReview() {
      String[] reviewFiles = {"review1.txt", "review2.txt", "review3.txt", 
                             "review4.txt", "review5.txt", "review6.txt"};
      
      String bestFile = reviewFiles[0];
      double bestSentiment = enhancedSentimentAnalysis(bestFile);
      
      // Iteration requirement - enhanced for loop
      for (String fileName : reviewFiles) {
          double currentSentiment = enhancedSentimentAnalysis(fileName);
          
          // Conditional statement requirement
          if (currentSentiment > bestSentiment) {
              bestSentiment = currentSentiment;
              bestFile = fileName;
          }
      }
      
      // String method requirement - using replace
      return bestFile.replace(".txt", "").replace("review", "Review ");
  }
  
  /**
   * Finds the review with the lowest sentiment score
   * Uses conditional statements and compound Boolean expressions
   */
  public static String findWorstReview() {
      String[] reviewFiles = {"review1.txt", "review2.txt", "review3.txt", 
                             "review4.txt", "review5.txt", "review6.txt"};
      
      String worstFile = reviewFiles[0];
      double worstSentiment = enhancedSentimentAnalysis(worstFile);
      
      // Iteration requirement
      for (String fileName : reviewFiles) {
          double currentSentiment = enhancedSentimentAnalysis(fileName);
          
          // Compound Boolean expression requirement - find lowest sentiment (not just negative)
          if (currentSentiment < worstSentiment) {
              worstSentiment = currentSentiment;
              worstFile = fileName;
          }
      }
      
      // String method requirement - using replace
      return worstFile.replace(".txt", "").replace("review", "Review ");
  }
  
  /**
   * Enhanced sentiment analysis that better detects negative sentiment
   * Takes a parameter (fileName) as required
   */
  public static double enhancedSentimentAnalysis(String fileName) {
      String text = Review.textToString(fileName).toLowerCase();
      String[] words = text.split(" ");
      double totalSentiment = 0;
      
      // Negative words that should contribute negative sentiment
      String[] negativeWords = {"terrible", "awful", "horrible", "bad", "worst", "hate", "disappointed", 
                               "frustrated", "angry", "upset", "annoyed", "scam", "incompetent", 
                               "unprofessional", "rude", "slow", "useless", "waste", "negative"};
      
      // Negation words that flip sentiment
      String[] negationWords = {"not", "no", "never", "nothing", "nobody", "nowhere", "neither", "nor"};
      
      // Check for negative words and negation patterns
      for (int i = 0; i < words.length; i++) {
          String word = words[i].replaceAll("[^a-zA-Z]", ""); // Remove punctuation
          
          // Check for negative words
          for (String negWord : negativeWords) {
              if (word.contains(negWord)) {
                  totalSentiment -= 2.0; // Strong negative impact
              }
          }
          
          // Check for negation patterns (negation word followed by positive word)
          if (i < words.length - 1) {
              for (String negWord : negationWords) {
                  if (word.equals(negWord)) {
                      // Check if next word might be positive
                      String nextWord = words[i + 1].replaceAll("[^a-zA-Z]", "");
                      if (nextWord.length() > 0) {
                          totalSentiment -= 1.5; // Negation reduces sentiment
                      }
                  }
              }
          }
      }
      
      // Add original sentiment analysis
      totalSentiment += Review.totalSentiment(fileName);
      
      return totalSentiment;
  }

  /**
   * Generates a detailed report for a specific review file
   * Takes a parameter (fileName) as required
   */
  public static void generateDetailedReport(String fileName) {
      double originalSentiment = Review.totalSentiment(fileName);
      double enhancedSentiment = enhancedSentimentAnalysis(fileName);
      int stars = Review.starRating(fileName);
      
      System.out.println("\n--- Detailed Report for " + fileName + " ---");
      System.out.println("Original Sentiment: " + String.format("%.2f", originalSentiment));
      System.out.println("Enhanced Sentiment: " + String.format("%.2f", enhancedSentiment));
      System.out.println("Star Rating: " + stars + " stars");
      
      // Use enhanced sentiment for assessment
      String assessment;
      if (enhancedSentiment > 5) {
          assessment = "EXCELLENT service experience";
      } else if (enhancedSentiment > 0) {
          assessment = "POSITIVE service experience";
      } else if (enhancedSentiment > -5) {
          assessment = "NEUTRAL service experience";
      } else {
          assessment = "NEGATIVE service experience";
      }
      
      System.out.println("Assessment: " + assessment);
      
      // String method requirement - using contains
      String reviewText = Review.textToString(fileName);
      if (reviewText.toLowerCase().contains("genius bar")) {
          System.out.println("Note: Mentions Genius Bar specifically");
      }
  }
}
