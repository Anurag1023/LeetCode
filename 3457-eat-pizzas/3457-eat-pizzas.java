class Solution {
    public long maxWeight(int[] pizzas) {
        Arrays.sort(pizzas);

        int n = pizzas.length;
        int days = n / 4;
        int even = days / 2;
        int odd = days-even;

        int right = n - 1;

        long ans = 0;

        while (odd-- > 0) {
            ans += pizzas[right];
            right--;
        }
        while (even-- > 0) {
            ans += pizzas[right - 1];
            right -= 2;
        }

        return ans;
    }
}