class Solution {
    public String smallestPalindrome(String s) {
        int[] arr = new int[26];

        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < arr[i] / 2; j++) {
                left.append((char) ('a' + i));
            }

            if ((arr[i] & 1) == 1) {
                middle = (char) ('a' + i);
            }
        }

        StringBuilder right = new StringBuilder(left).reverse();

        if (middle != 0) {
            left.append(middle);
        }

        left.append(right);

        return left.toString();
    }
}