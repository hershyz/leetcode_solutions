class Solution {
    
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        
        int maxDiffIndex = 0;
        
        for (int i = 0; i < nums1.length; i++) {
            if (Math.abs(nums1[i] - nums2[i]) > Math.abs(nums1[maxDiffIndex] - nums2[maxDiffIndex])) {
                maxDiffIndex = i;
            }
        }
        
        int minDiff = getAbsDiff(nums1, nums2);
        for (int i = 0; i < nums1.length; i++) {
            int curr = nums1[i];
            int[] newNums1 = new int[nums1.length];
            for (int j = 0; j < nums1.length; j++) {
                newNums1[j] = nums1[j];
            }
            newNums1[maxDiffIndex] = curr;
            int currDiff = getAbsDiff(newNums1, nums2);
            if (currDiff < minDiff) {
                minDiff = currDiff;
            }
        }
        
        return minDiff;
    }
    
    public int getAbsDiff(int[] nums1, int[] nums2) {
        int total = 0;
        for (int i = 0; i < nums1.length; i++) {
            total += Math.abs(nums1[i] - nums2[i]);
        }
        return total;
    }
}
