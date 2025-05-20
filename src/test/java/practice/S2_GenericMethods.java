package practice;

public class S2_GenericMethods {

	public static void main(String[] args) {

		int sum =add(10,20);
		System.out.println(sum);
		System.out.println(add(sum,30));
		System.out.println(add(30,40));
		System.out.println(add(40,sum));
		
		int res=add(40,50);
		System.out.println(res);
		
	}

	public static int add(int a, int b)
	{
		int c = a+b;
		return c;
	}
}
