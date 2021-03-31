import java.util.Date;
import java.util.ArrayList;
//import java.io;
import java.util.Arrays;
import java.util.Random;

public class Lab2S
{
	public static void main(String[] args)
	{
		int[] array;
		int n, min_limit, max_limit;
		try
		{
			if(args[0].equals("binary") || args[0].equals("fibonachi") || args[0].equals("interpolar"))
			{
				if(args.length >= 4)
				{
					n = Integer.parseInt(args[1]);
					min_limit = Integer.parseInt(args[2]);
					max_limit = Integer.parseInt(args[3]);
					array = new int[n];
				}
				else
				{
					n = 50;
					min_limit = -250;
					max_limit = 1017;
					array = new int[n];
				}
				for(int j = 0; j < n; j++)
				{
					array[j] = (int)(Math.random()*(max_limit - min_limit + 1) + min_limit);
				}
				Arrays.sort(array);
				System.out.println(Arrays.toString(array));
				int num;
				if(args.length >= 5)
				{
					num = Integer.parseInt(args[4]);
				}
				else
				{
					num = (int)(Math.random()*(max_limit - min_limit + 1) + min_limit);
				}
				
				boolean founded = false;
				if(args[0].equals("binary"))
				{
					founded = true;
					Date start = new Date();
					binary(array, num);
					Date finish = new Date();
					System.out.print("Time (ms) consumed for search = ");
					System.out.println(finish.getTime() - start.getTime());
				}
				if(args[0].equals("fibonachi"))
				{
					founded = true;
					Date start = new Date();
					fibonachi(array, num);
					Date finish = new Date();
					System.out.print("Time (ms) consumed for search = ");
					System.out.println(finish.getTime() - start.getTime());
				}
				if(args[0].equals("interpolar"))
				{
					founded = true;
					Date start = new Date();
					interpolar(array, num);
					Date finish = new Date();
					System.out.print("Time (ms) consumed for search = ");
					System.out.println(finish.getTime() - start.getTime());
				}
			}
			else
			{
				System.out.println("Type of search isn't mentioned or mentioned incorrectly.");
				System.out.println("Types of sort: 'binary','fibonachi', 'interpolar'");
			}
			
		}
		catch(Exception ex)
		{
			System.out.println("Arguments error, input form: java Lab2 type_of_task <count_of_elements> <min_limit> <max_limit>");
		}
	}
	
	public static int binary(int[] array, int number)
	{
		int left = 0, right = array.length-1, index = -1, iter = 0;
		while(iter < array.length)
		{
			if(array[left + (right - left) / 2] == number)
			{
				index = left + (right - left) / 2;
				break;
			}
			if(array[left + (right - left) / 2] > number)
			{
				right = left + (right - left) / 2;
			}
			if(array[(right - left) / 2] < number)
			{
				left = left + (right - left) / 2;
			}
			iter++;
		}
		System.out.println("Index of " + Integer.toString(number) + " = " + Integer.toString(index));
		return index;
	}
	
	public static int fibonachi(int[] array, int number)
	{
		int index = -1, iter = 0, left = 0, right = array.length-1, i = 0;
		while(iter < array.length)
		{
			if(left + f(i) <= right)
			{
				if(array[left + f(i)] == number)
				{
					index = left + f(i);
					break;
				}
				if(array[left + f(i)] < number)
				{
					i++;
				}
				else
				{
					right = left + f(i);
					left = left + f(i-1);
					i = 0;
				}
				if(i != 0)
				{
					iter++;
				}
			}
			else
			{
				if(array[right] == number)
				{
					index = right;
					break;
				}
				if(array[right] < number)
				{
					break;
				}
				else
				{
					left = left + f(i-1);
					i = 0;
				}
				if(i != 0)
				{
					iter++;
				}
			}
		}
		System.out.println("Index of " + Integer.toString(number) + " = " + Integer.toString(index));
		return index;
	}
	
	public static int f(int num)
	{
		if(num == 0)
		{
			return 0;
		}
		if(num == 1)
		{
			return 1;
		}
		return f(num - 1) + f(num - 2);
	}
	
	public static int interpolar(int[] array, int number)
	{
		double left = 0, right = array.length-1;
		int index = -1, iter = 0;
		while(iter < array.length)
		{
			int d = (int) (left + (right - left) * (number - array[(int) left]) / (array[(int) right] - array[(int) left]));
			if(array[d] == number)
			{
				index = d;
				break;
			}
			if(array[d] > number)
			{
				right = d;
			}
			if(array[d] < number)
			{
				left = d;
			}
			iter++;
		}
		
		System.out.println("Index of " + Integer.toString(number) + " = " + Integer.toString(index));
		return index;
	}
}