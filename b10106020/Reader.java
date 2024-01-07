package b10106020;
import java.util.Scanner;

public class Reader {
	protected String name;
	protected String ID;

	public Reader() {
		// TODO Auto-generated constructor stub
	}
	
	public Reader(String s) {
        this.name = s;
    }

	public void register() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("***開始進行借閱證註冊***\n輸入申請人姓名: ");
		String name = scanner.next();
		System.out.println("輸入申請人出生年月日 (YYYY/MM/DD): ");
		String date = scanner.next();
		System.out.println("借閱證申請完成!\n 借閱證號碼為: ");
		scanner.close();
	}

}
