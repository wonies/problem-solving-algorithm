public class Sol93 {
	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;
		int i = n - 1;

		while (i >= 0) {
			if (deliveries[i] == 0 && pickups[i] == 0) {
				i--;
				continue;
			}


			answer += (i + 1) * 2L;

			int dCap = cap;
			int pCap = cap;
			int j = i;

			while (j >= 0 && (dCap > 0 || pCap > 0)) {

				if (deliveries[j] > 0) {
					int deliverNow = Math.min(deliveries[j], dCap);
					deliveries[j] -= deliverNow;
					dCap -= deliverNow;
				}

				if (pickups[j] > 0) {
					int pickupNow = Math.min(pickups[j], pCap);
					pickups[j] -= pickupNow;
					pCap -= pickupNow;
				}

				j--;
			}

			while (i >= 0 && deliveries[i] == 0 && pickups[i] == 0) {
				i--;
			}
		}

		return answer;
	}
}
