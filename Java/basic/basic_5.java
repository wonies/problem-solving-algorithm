package basic;

import java.util.Scanner;

public class basic_5 {

	public static void id_num_switch(String str, int cur)
	{
		char ch = str.charAt(7);
		int num = ch - '0';
		int num1 = str.charAt(0) - '0';
		int num2 = str.charAt(1) - '0';
		int year = num1 * 10 + num2;
		int age;

		switch(num)
		{
			case 1:
			case 2:
				year += 1900;
				age = 2019 - year + 1;
				System.out.println(age + (num == 1 ? " M" : " W"));
				break;
			case 3:
			case 4:
				year += 2000;
				age = 2019 - year + 1;
				System.out.println(age + (num == 3 ? " M" : " W"));
				break;
		}

	}

	public static void id_num(String str, int cur)
	{
		char ch = str.charAt(7);
		int num = ch - '0';
		int num1, num2;
		int year = 0;
		int age = 0;
		num1 = str.charAt(0) - '0';
		num2 = str.charAt(1) - '0';
		year = num1 * 10 + num2;
		if (num == 1)
		{

			age = 100 -year +1;
			System.out.println(age + " M");
		}
		else if (num == 2)
		{
			age = 100 -year +1;
			System.out.println(age + " W");
		}
		else if (num == 3)
		{
			age = cur - year +1;
			System.out.println(age + " M");
		}
		else if (num == 4)
		{
			age = cur - year +1;
			System.out.println(age + " W");
		}
	}




	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		id_num(str, 19);
		id_num_switch(str, 19);
	}
}
