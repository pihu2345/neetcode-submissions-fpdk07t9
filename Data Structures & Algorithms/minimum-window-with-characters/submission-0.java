

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int required = map.size();
        int formed = 0;

        Map<Character, Integer> windowMap = new HashMap<>();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            if (map.containsKey(c) &&
                windowMap.get(c).intValue() == map.get(c).intValue()) {
                formed++;
            }

            // Shrink window
            while (left <= right && formed == required) {
                c = s.charAt(left);

                // Update minimum window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                // Remove from window
                windowMap.put(c, windowMap.get(c) - 1);

                if (map.containsKey(c) &&
                    windowMap.get(c) < map.get(c)) {
                    formed--;
                }

                left++;
            }

            right++; // expand window
        }

        return minLen == Integer.MAX_VALUE 
            ? "" 
            : s.substring(start, start + minLen);
    }
}