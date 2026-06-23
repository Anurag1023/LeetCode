class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if(n==0) return;
        if(m==0){ 
            for(int i=0;i<n;i++){
                nums1[i]=nums2[i];
            }
            return;
        }

        int ptr1 = m-1, ptr2 = n-1;

        for(int i=m+n-1;i>=0;i--){
            if(nums1[ptr1]>nums2[ptr2]){
                nums1[i]=nums1[ptr1--];
            }else{
                nums1[i]=nums2[ptr2--];
            }

            if(ptr2<0) return;
            if(ptr1<0){
                for(int j=i-1;j>=0;j--){
                    nums1[j]=nums2[ptr2--];
                }
                return;
            }
        }

    }
}