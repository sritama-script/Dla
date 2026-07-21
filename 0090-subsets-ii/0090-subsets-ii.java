class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        // Stores all unique subsets
        List<List<Integer>> result = new ArrayList<>();

        // Sort the array so that duplicate elements come together.
        // This helps us skip duplicate subsets easily.
        Arrays.sort(nums);

        // Start backtracking from index 0 with an empty subset.
        backtrack(0, nums, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int index, int[] nums,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // Every subset formed is a valid answer.
        // Create a new copy because 'current' keeps changing.
        result.add(new ArrayList<>(current));

        // Try choosing every element starting from 'index'
        for (int i = index; i < nums.length; i++) {

            // If the current number is the same as the previous number
            // AND both are being considered at the same recursive level,
            // skip it to avoid duplicate subsets.
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            // Choose the current element
            current.add(nums[i]);

            // Move to the next index
            backtrack(i + 1, nums, current, result);

            // Undo the choice (Backtracking)
            // Remove the last inserted element so that
            // we can explore the next possibility.
            current.remove(current.size() - 1);
        }
    }
}