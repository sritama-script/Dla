class Solution {
    public List<Integer> grayCode(int n) {
        // Base case: for n=0, only one code exists: 0
        if (n == 0) {
            List<Integer> base = new ArrayList<>();
            base.add(0);
            return base;
        }

        // Recursively get the Gray Code list for n-1 bits
        List<Integer> prev = grayCode(n - 1);

        // This will hold the full Gray Code list for n bits
        List<Integer> result = new ArrayList<>(prev);

        // The bit to prepend: 1 followed by (n-1) zeros = 2^(n-1)
        int addBit = 1 << (n - 1); // left shift to get the nth bit value

        // Reflect: iterate the previous list in REVERSE order
        // and add the new high bit to each element
        for (int i = prev.size() - 1; i >= 0; i--) {
            result.add(addBit + prev.get(i)); // prefix '1' by adding 2^(n-1)
        }

        // result now has 2^n elements, each differing by exactly one bit
        return result;
    }
}