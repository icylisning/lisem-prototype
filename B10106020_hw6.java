import java.util.Scanner;
import java.util.Arrays;

public class B10106020_hw6 {
	
	public static boolean contains(final Integer[] arr, final int key) { //改為整數物件之陣列
		return Arrays.asList(arr).contains(key);
    }
	
	public static void main(String[] args) {		
		Scanner numScn = new Scanner(System.in);
		boolean isIllegal=true;
		Integer[] myAns = null;
		while(isIllegal){
			System.out.println("請輸入不重複的四位數字:");
			String theNum = numScn.next();
			if (theNum.length() != 4) {
	            System.out.println("illegal input");
	            continue;
	        }else{
	        	Integer[] arr = new Integer[] {-1,-1,-1,-1}; //四個-1皆為物件
	            for (int i=0; i<4; i++) {     	
	            	int key = Character.getNumericValue(theNum.charAt(i));
	                if (contains(arr,key)==false){
	                	arr[i] = key;
	                	if(i==3) {		    
	        				isIllegal=false;
	        				myAns = arr;
	                	}
	                }else{
	                    System.out.println("illegal input: repeated numbers");
	                    break;
	                }
	            }
	        }
	    }
		System.out.println("答案已記錄");
		
		for(int m=1;m<11;m++) {
			isIllegal=true;
			Integer[] inputArr = null;
			while(isIllegal){
				System.out.println("遊戲開始，請輸入不重複的四位數字:");
				String theNum = numScn.next();
				
				if (theNum.length() != 4) {
		            System.out.println("數字不可重複");
		            continue;
		        }else{
		        	Integer[] arr = new Integer[] {-1,-1,-1,-1}; //四個-1皆為物件
		            for (int i=0; i<4; i++) {     	
		            	int key = Character.getNumericValue(theNum.charAt(i));
		                if (contains(arr,key)==false){
		                	arr[i] = key;
		                	if(i==3) {		    
		        				isIllegal=false;
		        				inputArr = arr;
		                	}
		                }else{
		                    System.out.println("數字不可重複");
		                    break;
		                }
		            }
		        }
		    }			
			int A=0,B=0;
			boolean check[]=new boolean[4]; //紀錄每個位數是否檢查過
			Arrays.fill(check, false);

			for(int i=0;i<4;i++){ //有幾個A
				if(myAns[i] == inputArr[i]){
					A++;
					check[i]=true;
				}
				for(int j=0;j<4;j++){ //有幾個B
					if(!check[j] && myAns[j] == inputArr[i]){
						B++;
						check[j]=true;
						break;
					}
				}
			}
			
			//Output
			if(A==4){
				System.out.println("Bingo!");
				break;
			}
			else{
				System.out.println(A+"A"+B+"B");
			}
			System.out.println("共可猜10次，這是第"+m+"次");
			if(m==10) {
				System.out.println("Game Over!");
			}
		}
		numScn.close();
	}
}
