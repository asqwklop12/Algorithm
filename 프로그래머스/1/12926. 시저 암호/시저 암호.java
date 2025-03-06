class Solution {
     public String solution(String s, int n) {
        StringBuilder builder = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            // 공백은 점프한다.
            if (c == (char) 32) {
                builder.append(" ");
                continue;
            }

            int i = c + n;
            if (('a' <= c && c <= 'z') && 'z' < i) {
                builder.append((char) ((i - 'a') % 26 + 'a'));
                continue;
            }

            if (('A' <= c && c <= 'Z') && 'Z' < i) {
                builder.append((char) ((i - 'A') % 26 + 'A'));
                continue;
            }


            builder.append((char) (i));
        }
        return builder.toString();
    }
}