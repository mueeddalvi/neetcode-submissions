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
        int fleets = 1, flag = 0;
        double prevTime, currTime;
        prevTime = currTime = 0;
        for (Map.Entry<Integer, Integer> k : map.entrySet()) {
            currTime = (double)(target - k.getKey()) / k.getValue();
            if (flag == 0) {
                //This block only for first map entry
                prevTime = currTime;
                flag = 1;
            } else {
                if (currTime > prevTime) {
                    fleets++;
                    prevTime = currTime;
                }
            }
        }

        return fleets;
    }
}
