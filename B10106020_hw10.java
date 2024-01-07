import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B10106020_hw10 {

    public static boolean contains(final Integer[] arr, final int key) {
        return Arrays.asList(arr).contains(key);
    }
    
    public static String checkAB(Integer[] inputArr, Integer[] myAns) {
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
		String userStr = "Bingo!";
		if(A==4){
			return userStr;
		}else{
			userStr = (A+"A"+B+"B");
			return userStr;
		}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean repeat = true;
		int tlRound = 0;
		int win = 0;
		int lose = 0;
		int record = 0;
		while(repeat) {
			System.out.print("===Welcome to the Guessing Game===\r\n"
					+ "1: 開始遊戲\r\n"
					+ "2: 過去遊戲歷史記錄\r\n"
					+ "3: 結束遊戲\r\n"
					+ "==============================\r\n"
					+ "請輸入您的選擇(1, 2, or 3):\r\n");
			
			Scanner user = new Scanner(System.in);
			int userInput = user.nextInt();
			if(userInput==1) {
				Random rd = new Random();
				String myResult ="";
				List<Integer> al=new ArrayList<>(); //隨機產生四個不重複整數的陣列
				do{
					int n=rd.nextInt(10);
					if(al.contains(n)) 
						continue; 
					else
						al.add(n);
				}while(al.size() < 4);
				System.out.println("此輪遊戲的答案為: "+al);
				Integer[] myAns = al.toArray(new Integer[al.size()]);
				
				for(int m=1;m<11;m++) {
					boolean isIllegal=true;
					Integer[] inputArr = null;
					String theNum = "";
					while(isIllegal){
						System.out.println("第"+m+"次猜答，請輸入不重複的四位數字:");
						if(m==8 || m==9) {
							System.out.println("答案提示: X" + al.get(1) + "X"+ al.get(3));
						}
						theNum = user.next();
						Integer[] arr = new Integer[] {-1,-1,-1,-1}; //四個-1皆為物件
				        for (int i=0; i<4; i++) {     	
				          	int key = Character.getNumericValue(theNum.charAt(i));
				            if (contains(arr,key)==false){
				               	arr[i] = key;
				               	if(i==3) {		    
			        				isIllegal=false;
			        				inputArr = arr;
			                	}
				            }
				        }  
				    }
					myResult = myResult + theNum + ", " + checkAB(inputArr,myAns) + " \r\n";
					if(checkAB(inputArr,myAns)=="Bingo!") {
						System.out.println("\r\n比較結果為:\r\n"
								+  myResult
								+ "\r\n--------------------------\r\n");
						win++;
						record += m;
						break;
					}else {
						System.out.println("\r\n比較結果為:\r\n"
								+ myResult
								+ "\r\n--------------------------\r\n");
					}
					if(m==10) {
						System.out.println("已猜答超過 10 次, 失敗! 答案為: "+al);
						lose++;
						break;
					}
				}
				tlRound++;
			}else if (userInput==2) {
				if(tlRound==0) {
					System.out.println("尚無遊戲歷史記錄!\r\n");
				}else {
					System.out.println("總共遊戲次數: "+tlRound);
					System.out.println("總共猜中次數: "+win+", 平均"+record/(double)tlRound+"回合猜中");
					System.out.println("總共失敗次數: "+lose);
					System.out.println("勝率為: "+win/(double)tlRound+" \r\n");
				}
			}else if (userInput==3) {
				user.close();
				System.out.println("遊戲結束!");
				repeat = false;
			}
		}
	}
}
