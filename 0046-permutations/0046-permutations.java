class Solution {

    // Stores all permutations
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        // Stores the current permutation being built
        List<Integer> current = new ArrayList<>();

        // Keeps track of which indices are already used
        boolean[] used = new boolean[nums.length];

        // Start backtracking
        backtrack(nums, current, used);

        // Return all permutations
        return ans;
    }

    // Recursive function
    private void backtrack(int[] nums,
                           List<Integer> current,
                           boolean[] used) {

        // Base Case:
        // If current permutation has all numbers,
        // store a COPY of it.
        if(current.size() == nums.length){

            ans.add(new ArrayList<>(current));

            return;
        }

        // Try every number
        for(int i=0;i<nums.length;i++){

            // If already used,
            // skip it.
            if(used[i])
                continue;

            // ----------------------
            // CHOOSE
            // ----------------------

            current.add(nums[i]);   // Add current number

            used[i] = true;         // Mark as used

            // Explore further
            backtrack(nums,current,used);

            // ----------------------
            // BACKTRACK
            // ----------------------

            current.remove(current.size()-1); // Remove last number

            used[i] = false;                  // Mark unused
        }
    }
}