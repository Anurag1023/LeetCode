class Solution {
    public String maximumNumber(String num, int[] change) {
        char[] arr = num.toCharArray();

        boolean started = false;

        for (int i = 0; i < arr.length; i++) {
            int digit = arr[i] - '0';

            if (change[digit] > digit) {
                arr[i] = (char) (change[digit] + '0');
                started = true;
            } 
            else if (change[digit] == digit && started) {
                continue;
            } 
            else {
                if (started) {
                    break;
                }
            }
        }

        return new String(arr);
    }
}