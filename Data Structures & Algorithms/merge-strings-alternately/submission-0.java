public class Solution {
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;
        int n1 = word1.length(), n2 = word2.length();

        // Merge characters alternately
        while (i < n1 && j < n2) {
            result.append(word1.charAt(i++));
            result.append(word2.charAt(j++));
        }

        // Append remaining characters (if any)
        while (i < n1) {
            result.append(word1.charAt(i++));
        }

        while (j < n2) {
            result.append(word2.charAt(j++));
        }

        return result.toString();
    }
}