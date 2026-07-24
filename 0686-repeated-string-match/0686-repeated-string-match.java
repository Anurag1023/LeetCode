class Solution {
    public int repeatedStringMatch(String a, String b) {
        int repeat = (int)Math.ceil((float)b.length() / a.length());

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