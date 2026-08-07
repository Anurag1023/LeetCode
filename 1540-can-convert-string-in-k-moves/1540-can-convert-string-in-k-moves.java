class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] cnt = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int shift = (t.charAt(i) - s.charAt(i) + 26) % 26;
            cnt[shift]++;
        }

        for (int shift = 1; shift < 26; shift++) {
            if (shift + (cnt[shift] - 1) * 26 > k) {
                return false;
            }
        }

        return true;
    }
}