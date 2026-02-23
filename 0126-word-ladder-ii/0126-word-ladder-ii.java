class Solution {

    List<List<String>> ans = new ArrayList<>();
    Map<String, Integer> mpp = new HashMap<>();
    String begin;

    private void dfs(String word, List<String> seq) {
        if (word.equals(begin)) {
            Collections.reverse(seq);
            ans.add(new ArrayList<>(seq));
            Collections.reverse(seq);
            return;
        }

        int steps = mpp.get(word);
        int sz = word.length();

        char[] arr = word.toCharArray();

        for (int i = 0; i < sz; i++) {
            char original = arr[i];

            for (char ch = 'a'; ch <= 'z'; ch++) {
                arr[i] = ch;
                String newWord = new String(arr);

                if (mpp.containsKey(newWord) && mpp.get(newWord) + 1 == steps) {
                    seq.add(newWord);
                    dfs(newWord, seq);
                    seq.remove(seq.size() - 1);
                }
            }

            arr[i] = original;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> st = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();

        begin = beginWord;
        q.offer(beginWord);

        mpp.put(beginWord, 1);
        int size = beginWord.length();

        st.remove(beginWord);

        // BFS
        while (!q.isEmpty()) {
            String word = q.poll();
            int steps = mpp.get(word);

            if (word.equals(endWord)) break;

            char[] arr = word.toCharArray();

            for (int i = 0; i < size; i++) {
                char original = arr[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    arr[i] = ch;
                    String newWord = new String(arr);

                    if (st.contains(newWord)) {
                        q.offer(newWord);
                        st.remove(newWord);
                        mpp.put(newWord, steps + 1);
                    }
                }

                arr[i] = original;
            }
        }

        // DFS part
        if (mpp.containsKey(endWord)) {
            List<String> seq = new ArrayList<>();
            seq.add(endWord);
            dfs(endWord, seq);
        }

        return ans;
    }
}