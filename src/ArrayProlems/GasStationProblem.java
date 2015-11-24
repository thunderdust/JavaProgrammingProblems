package ArrayProlems;

/* There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i 
 * to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise 
 * return -1. */

public class GasStationProblem {

	public int canCompleteCircuit(int[] gas, int[] cost) {

		int sumRemaining = 0;
		int total = 0;
		int startStation = 0;

		for (int i = 0; i < gas.length; i++) {
			int remaining = gas[i] - cost[i];
			// if sum remaining of (i-1) >= 0, continue
			if (sumRemaining >= 0) {
				sumRemaining += remaining;
			}
			// otherwise, reset start index to be current
			else {
				sumRemaining = remaining;
				startStation = i;
			}
			total += remaining;
		}
		if (total >= 0) {
			return startStation;
		} else {
			return -1;
		}
	}
}
