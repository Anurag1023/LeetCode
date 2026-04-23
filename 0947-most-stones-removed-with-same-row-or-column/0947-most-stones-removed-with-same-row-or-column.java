class Solution {
    class DisjointSet{

        Map<Integer, Integer> parent = new HashMap<>();

        public int findParent(int node){
            if(!parent.containsKey(node)){
                parent.put(node,node);
            }
            if(parent.get(node)!=node){
                parent.put(node,findParent(parent.get(node)));
            }
            return parent.get(node);
        }

        public void unionByParent(int u,int v){
            int pu = findParent(u);
            int pv = findParent(v);

            if(pu!=pv){
                parent.put(pu,pv);
            }
        }

    }

    public int removeStones(int[][] stones) {
         
        DisjointSet ds = new DisjointSet();

        int maxRow = 0;
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
        }

        // connect row and column
        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + maxRow + 1;
            ds.unionByParent(row, col);
        }

        // count unique components
        HashSet<Integer> components = new HashSet<>();

        for (int[] stone : stones) {
            components.add(ds.findParent(stone[0]));
        }

        return stones.length - components.size();

    }
}