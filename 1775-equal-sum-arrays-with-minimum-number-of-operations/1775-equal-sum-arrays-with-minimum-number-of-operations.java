class Solution {
    public int minOperations(int[] nums1, int[] nums2) {

        int sum1 = 0, sum2 = 0;

        for (int x : nums1) sum1 += x;
        for (int x : nums2) sum2 += x;

        // Ensure nums1 has the smaller sum
        if (sum1 > sum2) {
            return minOperations(nums2, nums1);
        }

        int diff = sum2 - sum1;

        int[] changes = new int[6];

        // Increase nums1
        for (int x : nums1) {
            changes[6 - x]++;
        }

        // Decrease nums2
        for (int x : nums2) {
            changes[x - 1]++;
        }

        int operations = 0;

        // Use largest possible change first
        for (int change = 5; change >= 1; change--) {

            while (changes[change] > 0 && diff > 0) {
                diff -= change;
                changes[change]--;
                operations++;
            }

            if (diff <= 0) {
                return operations;
            }
        }

        return -1;
    }
}