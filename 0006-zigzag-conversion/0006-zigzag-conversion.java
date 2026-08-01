class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder[] row = new StringBuilder[numRows];
        int n = s.length();

        for (int i = 0; i < numRows; i++) {
            row[i] = new StringBuilder();
        }

        int i = 0;

        while (i < n) {

            // Down
            for (int ind = 0; ind < numRows && i < n; ind++) {
                row[ind].append(s.charAt(i++));
            }

            // Diagonal Up
            for (int ind = numRows - 2; ind > 0 && i < n; ind--) {
                row[ind].append(s.charAt(i++));
            }
        }

        StringBuilder ans = new StringBuilder();

        for (StringBuilder sb : row) {
            ans.append(sb);
        }

        return ans.toString();
    }
}