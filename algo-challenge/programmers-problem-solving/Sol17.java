package study;
//예상대진표

import java.io.*;
import java.util.*;

class Sol17 {
		public int solution(int n, int a, int b)
		{
			int round = 0;
			while(a != b)
			{
				a = (a + 1) / 2;
				b = (b + 1) / 2;
				round++;
			}
			return round;

			// int round = 0;
			//         int player1 = findpow(a);
			//         int player2 = findpow(b);
			//         if (Math.abs(player1 - player2) > 0)
			//         {
			//             return Math.max(player1, player2);
			//         }
			//         else
			//         {
			//            int val = (int) Math.pow(2, findpow(n));
			//             while (val > 1) {
			//                 if (a <= val / 2 && b > val / 2)
			//                     return round + 1;  //

			//                 a = (a + 1) / 2;
			//                 b = (b + 1) / 2;
			//                 val /= 2;
			//                 round++;
			//             }
			//         }
			//         return round;
			//             while (a != b)
			//             {
			//                 a = (a + 1) / 2;
			//                 b = (b + 1) / 2;
			//                 round++;
			//             }
			//             return round;

			//         // }
			//         // return round;
		}

		// public int findpow(int n)
		// {
		//     int pow = 1;
		//     int res = 0;
		//     while (pow * 2 <= n)
		//     {
		//         pow*=2;
		//         res++;
		//     }
		//     if (n - pow > 0)
		//         return res + 1;
		//     return res;
		// }

}
