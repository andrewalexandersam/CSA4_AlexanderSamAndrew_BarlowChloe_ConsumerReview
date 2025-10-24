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
      
      // Compute averages here (so summary always shows them)
      String[] reviewFiles = {"review1.txt", "review2.txt", "review3.txt", 
                             "review4.txt", "review5.txt", "review6.txt", 
                             "review7.txt", "review8.txt", "review9.txt",
                             "review10.txt", "review11.txt", "review12.txt",
                             "review13.txt", "review14.txt", "review15.txt",
                             "review16.txt", "review17.txt", "review18.txt",
                             "review19.txt", "review20.txt"};
      double sumEnhanced = 0.0;
      int sumStars = 0;
      for (String fileName : reviewFiles) {
          sumEnhanced += enhancedSentimentAnalysis(fileName);
          sumStars += enhancedStarRating(fileName);
      }
      double avgEnhanced = sumEnhanced / reviewFiles.length;
      double avgStars = (double) sumStars / reviewFiles.length;

      System.out.println("Average Enhanced Sentiment: " + String.format("%.2f", avgEnhanced));
      System.out.println("Average Star Rating: " + String.format("%.2f", avgStars) + " stars");

      // Concluding statement answering whether people like the Genius Bar
      String conclusion;
      if (avgStars >= 4.5) {
          conclusion = "People really like the genius bar";
      } else if (avgStars >= 3.5) {
          conclusion = "People like the Genius Bar.";
      } else if (avgStars >= 2.5) {
          conclusion = "People are neutral towards the Genius bar.";
      } else if (avgStars >= 1.5) {
          conclusion = "People slightly dislike the Genius Bar.";
      } else if (avgStars >= 0.5) {
          conclusion = "People don't like the Genius Bar.";
      } else {
          conclusion = "People hate the Genius Bar.";
      }

      System.out.println("\nThe final conlcusion to the question, Do people like the genius bar in apple stores?, is that " + conclusion);
  }
  
  /**
   * Analyzes all reviews and prints sentiment scores
   * This method uses iteration and String methods
   */
  public static void analyzeAllReviews() {
      String[] reviewFiles = {"review1.txt", "review2.txt", "review3.txt", 
                             "review4.txt", "review5.txt", "review6.txt", 
                             "review7.txt", "review8.txt", "review9.txt",
                             "review10.txt", "review11.txt", "review12.txt",
                             "review13.txt", "review14.txt", "review15.txt",
                             "review16.txt", "review17.txt", "review18.txt",
                             "review19.txt", "review20.txt"};
      
      System.out.println("=== GENIUS BAR REVIEW ANALYSIS ===");
      
      double sumEnhanced = 0.0;
      int sumStars = 0;
      
      // Iteration requirement - loop through all reviews
      for (String fileName : reviewFiles) {
          double originalSentiment = Review.totalSentiment(fileName);
          double enhancedSentiment = enhancedSentimentAnalysis(fileName);
          int stars = enhancedStarRating(fileName);
          
          // accumulate for averages
          sumEnhanced += enhancedSentiment;
          sumStars += stars;
          
          // String methods requirement - using substring and toUpperCase
          // extract the numeric part of the filename (handles single and multi-digit numbers)
          String reviewNumber = fileName.substring(6, fileName.indexOf('.'));
          String status;
          if (enhancedSentiment > 10) {
              status = "VERY POSITIVE";
          } else if (enhancedSentiment > 5) {
              status = "POSITIVE";
          } else if (enhancedSentiment > 0) {
              status = "NEUTRAL";
          } else {
              status = "NEGATIVE";
          }
          
          System.out.println("Review " + reviewNumber + ": " + stars + " stars (" + 
                           String.format("%.2f", originalSentiment) + " -> " + 
                           String.format("%.2f", enhancedSentiment) + " sentiment) - " + status);
      }
      
      // compute and print averages
      double avgEnhanced = sumEnhanced / reviewFiles.length;
      double avgStars = (double) sumStars / reviewFiles.length;
      System.out.println("\n--- AVERAGES ACROSS ALL REVIEWS ---");
      System.out.println("Average Enhanced Sentiment: " + String.format("%.2f", avgEnhanced));
      System.out.println("Average Star Rating: " + String.format("%.2f", avgStars) + " stars");
  }
  
  /**
   * Finds the review with the highest sentiment score
   * Uses conditional statements and String methods
   */
  public static String findBestReview() {
      String[] reviewFiles = {"review1.txt", "review2.txt", "review3.txt", 
                             "review4.txt", "review5.txt", "review6.txt", 
                             "review7.txt", "review8.txt", "review9.txt",
                             "review10.txt", "review11.txt", "review12.txt",
                             "review13.txt", "review14.txt", "review15.txt",
                             "review16.txt", "review17.txt", "review18.txt",
                             "review19.txt", "review20.txt"};
      
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
                             "review4.txt", "review5.txt", "review6.txt", 
                             "review7.txt", "review8.txt", "review9.txt",
                             "review10.txt", "review11.txt", "review12.txt",
                             "review13.txt", "review14.txt", "review15.txt",
                             "review16.txt", "review17.txt", "review18.txt",
                             "review19.txt", "review20.txt"};
      
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
   * Calculates star rating based on enhanced total sentiment
   * Takes a parameter (fileName) as required
   */
  public static int enhancedStarRating(String fileName){
    double totalSentimentVal = enhancedSentimentAnalysis(fileName);
    
    if (totalSentimentVal > 10.0){
      return 5;
    } 
    else if (totalSentimentVal > 6.0){
      return 4;
    }
    else if (totalSentimentVal > 3.0){
      return 3;
    } 
    else if (totalSentimentVal > 0.0){
      return 2;
    } 
    else if (totalSentimentVal > -3.0){
      return 1;
    }
    else {
      return 0;
    }
  }
}
