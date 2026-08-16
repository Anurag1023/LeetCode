class Solution {
    public String countAndSay(int n) {
        String s = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder next = new StringBuilder();

            int j = 0;

            while (j < s.length()) {
                char ch = s.charAt(j);
                int count = 0;

                while (j < s.length() && s.charAt(j) == ch) {
                    count++;
                    j++;
                }

                next.append(count).append(ch);
            }

            s = next.toString();
        }

        return s;
    }
}