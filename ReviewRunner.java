class ReviewRunner {
  public static void main(String[] args) 
  {
    /* your code here, for example: */
    System.out.println(Review.sentimentVal("cute"));
    System.out.println(Review.sentimentVal("tired"));
    System.out.println(Review.sentimentVal("sophisticated"));
    System.out.println(Review.sentimentVal("stressful"));
    System.out.println(Review.sentimentVal("talented"));

    System.out.println(Review.totalSentiment("SimpleReview.txt"));
    System.out.println(Review.starRating("SimpleReview.txt"));
  }
}