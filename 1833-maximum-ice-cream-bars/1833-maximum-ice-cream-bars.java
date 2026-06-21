class Solution {
    public int maxIceCream(int[] costs, int coins) {
        TreeMap<Integer, Integer> mp = new TreeMap<>();

        for (int cost : costs) {
            mp.put(cost, mp.getOrDefault(cost, 0) + 1);
        }

        int cnt = 0;

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int cost = entry.getKey();
            int freq = entry.getValue();

            int canBuy = Math.min(freq, coins / cost);

            cnt += canBuy;
            coins -= canBuy * cost;

            if (coins < cost) break;
        }

        return cnt;
    }
}