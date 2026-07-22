class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Step 1: Initialize our three pointers
        int i = m - 1;       // Pointer for valid elements in nums1
        int j = n - 1;       // Pointer for nums2
        int k = m + n - 1;   // Pointer for the placement slot in nums1
        
        // Step 2: Compare and merge while both arrays have elements left
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--; // Move nums1 pointer left
            } else {
                nums1[k] = nums2[j];
                j--; // Move nums2 pointer left
            }
            k--; // Move the placement pointer left
        }
        
        // Step 3: Clean up any remaining elements in nums2
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}