class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parent = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        // Step 1: Initialize
        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                parent.putIfAbsent(email, email);
                emailToName.put(email, name);
            }
        }

        // Step 2: Union
        for (List<String> acc : accounts) {
            String firstEmail = acc.get(1);
            for (int i = 2; i < acc.size(); i++) {
                union(firstEmail, acc.get(i), parent);
            }
        }

        // Step 3: Group emails by root
        Map<String, List<String>> groups = new HashMap<>();

        for (String email : parent.keySet()) {
            String root = find(email, parent);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }

        // Step 4: Build result
        List<List<String>> res = new ArrayList<>();

        for (String root : groups.keySet()) {
            List<String> emails = groups.get(root);
            Collections.sort(emails);

            List<String> account = new ArrayList<>();
            account.add(emailToName.get(root));
            account.addAll(emails);

            res.add(account);
        }

        return res;
    }

    private String find(String x, Map<String, String> parent) {
        if (!parent.get(x).equals(x)) {
            parent.put(x, find(parent.get(x), parent)); // path compression
        }
        return parent.get(x);
    }

    private void union(String x, String y, Map<String, String> parent) {
        String rootX = find(x, parent);
        String rootY = find(y, parent);
        if (!rootX.equals(rootY)) {
            parent.put(rootX, rootY);
        }
    }
}