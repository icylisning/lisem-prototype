import java.util.Scanner;
import java.util.Arrays;

public class B10106020_hw5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ary = {11, 22, 33, 44, 55, 66, 77, 88, 99};
		Scanner myScn = new Scanner(System.in); //System.in為靜態物件
		int newNum = 0;
		
		do {
			System.out.println("Please input a number to locate its array index:");			
			int myNum = myScn.nextInt();
            boolean hadFind = false; //用於判斷陣列內是否有此整數!
            
			for(int i=0; i<ary.length; i++) {
				int myIndex = Arrays.binarySearch(ary,myNum);
				if(myIndex>=0 && myIndex<=ary.length-1) {
					System.out.println("The array index of the number is: "+myIndex);
					hadFind = true;
					break;
				}
			}
			if(!hadFind) {
				System.out.println("The number ("+myNum+") cannot be located in the array!");
			}
			
			System.out.println("Continue the program? input 1 (for Yes) or 2 (for No):");
			newNum = myScn.nextInt(); //若關閉第一個scanner，也會把System.in一併關掉
		}while(newNum == 1);
		
		myScn.close();
		System.out.println("Thank you!");
	}

}
