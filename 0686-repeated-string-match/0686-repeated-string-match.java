class Solution {
    public int repeatedStringMatch(String a, String b) {
        int repeat = (b.length() + a.length() - 1) / a.length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < repeat; i++) {
            sb.append(a);
        }

        if (sb.indexOf(b) != -1)
            return repeat;

        sb.append(a);

        if (sb.indexOf(b) != -1)
            return repeat + 1;

        return -1;
    }
}