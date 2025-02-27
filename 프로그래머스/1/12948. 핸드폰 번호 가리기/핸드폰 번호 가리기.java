class Solution {
  public String solution(String phone_number) {
     int removeIndx = phone_number.length() - 4;
     String maskedIn = phone_number.substring(0,removeIndx);
     String masked =  "*".repeat(maskedIn.length());
     String news = phone_number.substring(removeIndx); 
      return masked + news;
  }
}