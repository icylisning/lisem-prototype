import java.util.Scanner;
public class B10106020_hw12 {

	public B10106020_hw12() {
		// TODO Auto-generated constructor stub
	}
	
	public void manual(Scanner bingo) {
		System.out.println("請輸入數列以產生賓果盤 A，範圍為 1~25 之不重複整數，中間以空格區分:");
		int[][] aCheck = new int[5][5];
		int aLine = 0;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				aLine = bingo.nextInt();
				aCheck[i][j] = aLine;
			}
		}
		System.out.println("以下為您所輸入之賓果盤 A:");
		//以二維陣列呈現
		
		System.out.println("請輸入數列以產生賓果盤 B，範圍為 1~25 之不重複整數，中間以空格區分:");
		int[][] bCheck = new int[5][5];
		int bLine = 0;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				bLine = bingo.nextInt();
				bCheck[i][j] = bLine;
			}
		}
		System.out.println("以下為您所輸入之賓果盤 B:");
		//以二維陣列呈現
		
		System.out.println("請輸入賓果叫號數列，範圍為 1~25 之不重複整數，中間以空格區分:");
		int[] order = new int[25];
		for(int i=0;i<25;i++) {
			order[i] = bingo.nextInt();
		}
		
		
	}
	
	public void autoGen(Scanner bingo) {
		//
	}

	public static void main(String[] args) {
		B10106020_hw12 hw=new B10106020_hw12(); //超級重要!
		
		System.out.println("===Welcome to the Bingo Game==="
				+ "1: 由玩家自行手動輸入資料"
				+ "2: 由系統亂數產生遊戲資料"
				+ "3: 結束遊戲"
				+ "==================================");
		System.out.println("請輸入您的選擇 (1, 2, or 3):");
		Scanner bingo = new Scanner(System.in);
		String usrInput = bingo.next();
		if("1".equals(usrInput)) {
			hw.manual(bingo);
		}else if ("2".equals(usrInput)) {
			hw.autoGen(bingo);
		}else if ("3".equals(usrInput)) {
			System.out.println("遊戲結束, bye bye!");
		}else {
			System.out.println("輸入錯誤，輸入格式錯誤，請重新輸入!");
			//重新print請輸入選擇那行
		}
		bingo.close();
	}

}
