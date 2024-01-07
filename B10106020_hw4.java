import java.util.Scanner;

public class B10106020_hw4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("請輸入大於零的整數:");
		Scanner theScn = new Scanner(System.in);
		int num = theScn.nextInt();
		theScn.close();
		
		int sum=0, i=0;
		do{ //do-while 迴圈
			i++;
			sum += i;
			System.out.println("i="+i+", sum="+sum);
		}while(sum<=num);
		
		int total=0, j=0;
		while(total <= num) { //while 迴圈
			j++;
			total += j;
			System.out.println("j="+j+", sum="+total);
		}
		
		System.out.println("The sum will be greater than "+total+" when you add from 1 to "+j);
	}

}
