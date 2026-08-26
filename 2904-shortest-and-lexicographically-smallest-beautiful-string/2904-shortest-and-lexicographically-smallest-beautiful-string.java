class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        int l = 0;
        int cnt = 0;

        String ans = "";

        for (int r = 0; r < n; r++) {

            if (s.charAt(r) == '1') {
                cnt++;
            }

            while (cnt > k) {
                if (s.charAt(l) == '1') {
                    cnt--;
                }
                l++;
            }

            if (cnt == k) {

                while (s.charAt(l) == '0') {
                    l++;
                }

                String curr = s.substring(l, r + 1);

                if (ans.equals("") ||
                    curr.length() < ans.length() ||
                    (curr.length() == ans.length() &&
                     curr.compareTo(ans) < 0)) {

                    ans = curr;
                }
            }
        }

        return ans;
    }
}