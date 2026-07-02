class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        if (n == 1)
            return 1;

        // position - speed
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            map.put(position[i], speed[i]);
        }

        int fleets = 0;
        double prevTime = -1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            double time = (double) (target - entry.getKey()) / entry.getValue();

            if (time > prevTime) {
                fleets++;
                prevTime = time;
            }
        }

        return fleets;
    }
}
