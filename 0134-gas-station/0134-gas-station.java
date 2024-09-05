class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalFuel = 0;
        int currentFuel = 0; 
        int start = 0; 

        for (int i = 0; i < gas.length; i++) {
            int fuelGain = gas[i] - cost[i]; 
            totalFuel += fuelGain; 
            currentFuel += fuelGain; 

            if (currentFuel < 0) {
                start = i + 1;
                currentFuel = 0;
            }
        }

        return totalFuel >= 0 ? start : -1;
    }
}
