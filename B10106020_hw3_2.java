import java.util.Scanner;
import java.lang.Math;

public class B10106020_hw3_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int cost = scn.nextInt();
		int inputN = scn.nextInt();
		int[] merch = new int[inputN];
		int[] ppl = new int[inputN];
		for(int i=1;i<=inputN;i++) {
			int m = scn.nextInt();
			int p = scn.nextInt();
			merch[i-1] = m;
			ppl[i-1] = p;
		}
		scn.close();
		
		double total = 0; //最後會向草地設計付多少錢
		double profit = 0; //總效益
		for (int j=0; j<ppl.length; j++) {
			if (ppl[j] == 8) { 
				total += 9*merch[j];
				profit += 8*30;
				profit += 0.1*2*merch[j]; //墊兩件,獲利一成
			}else if (ppl[j] == 9) {
				total += 9*merch[j];
				profit += 9*30;
				profit += 0.1*1*merch[j]; //墊一件,獲利一成
			}else if (ppl[j] == 18) {
				total += 20*0.8*merch[j];
				profit += 18*50;
				profit += 0.2*2*merch[j]; //墊兩件,獲利兩成
			}else if (ppl[j] == 19) {
				total += 20*0.8*merch[j];
				profit += 19*50;
				profit += 0.2*1*merch[j]; //墊一件,獲利兩成
			}else if (ppl[j] >= 20) {
				total += ppl[j]*0.8*merch[j];
				profit += ppl[j]*50;
			}else if (ppl[j] >= 10) {
				total += ppl[j]*0.9*merch[j];
				profit += ppl[j]*30;
			}else {
				total += ppl[j]*merch[j];
			}
		}
		
		System.out.println((int)Math.floor(total));
		profit = profit-cost;
		System.out.println((int)Math.floor(profit));
	}

}
