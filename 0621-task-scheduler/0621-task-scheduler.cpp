class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        vector<int> freq(26,0);

        for(int i=0;i<tasks.size();i++){
            freq[tasks[i]-'A']++;
        }
        sort(freq.begin(),freq.end());
        int gap = freq[25]-1;
        int idle = gap*n;
        for(int i=24;i>=0;i--){
            int f=freq[i];
            idle-=min(gap,f);
        }
        if(idle>0){
            return tasks.size()+idle;
        }
        return tasks.size();
    }
};