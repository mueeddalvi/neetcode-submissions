class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length, r = -1, l = 1, mid = -1, num = 0, res = 0;
        long count = 0;

        for (int x : piles) {
            r = Math.max(r, x);
            l = Math.min(l, x);
        }
        res = r;
        while (l <= r) {
            mid = (l + r) / 2;
            count = 0;
            for (int x : piles) {
                count += (int) Math.ceil((double) x / mid);
            }

            if (count <= h) {
                res = mid;
                r = ((l + r) / 2) - 1;
            } else {
                l = ((l + r) / 2) + 1;
            }
        }
        return res;
    }
}
