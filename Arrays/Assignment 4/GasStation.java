class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasInTank = 0;
        int tg = 0;
        int tc = 0;
        for (int i = 0; i < gas.length; i++) {
            tg += gas[i];
            tc += cost[i];
        }
        if (tg < tc)
            return -1;
        // Choosing the starting position
        int startPos = 0;
        for (int i = 0; i < gas.length; i++) {
            gasInTank += gas[i];
            gasInTank -= cost[i];
            if (gasInTank < 0) {
                startPos = i + 1;
                gasInTank = 0;
            }
        }
        return startPos;
    }
}