package inf;

//크레인 인형뽑기2

import java.util.*;
import java.io.*;
import com.sun.tools.javac.Main;

public class Basic41 {

	public int solution(int[][] boards, int[] moves)
	{
		int ans = 0;
		Stack<Integer> stack = new Stack<>();
		for (int pos : moves)
		{
			for (int i=0; i<boards.length; i++)
			{
				if (boards[i][pos-1] != 0)
				{
					int temp = boards[i][pos-1];
					boards[i][pos-1] = 0;
					if (!stack.isEmpty() && temp == stack.peek())
					{
						ans+=2;
						stack.pop();
					}
					else stack.push(temp);
					break ;
				}
			}
		}
		return ans;
	}


	public static void main(String[] args) {
		Basic41 T = new Basic41();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[][] board = new int[n][n];
		for (int i=0; i<n; i++)
		{
			for (int j=0; j<n; j++)
			{
				board[i][j] = kb.nextInt();
			}
		}
		int m = kb.nextInt();
		int[] moves = new int[m];
		for (int i=0; i<m; i++)
		{
			moves[i] = kb.nextInt();
		}
		System.out.println(T.solution(board, moves));
	}
}
