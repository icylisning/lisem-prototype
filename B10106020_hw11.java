import java.util.Scanner;

public class B10106020_hw11 {
	
	private int[] scrRecord = new int[11];
	public B10106020_hw11() {
		// TODO Auto-generated constructor stub
	}
	
	  public static int[] SelectionSort(int[] array) {		 
		 for (int i = 0; i < array.length-1; i++) {
			 int minInx = i;
		     int min = array[i];
		     for (int j = 1+i ; j < array.length; j++) {
		         if (min > array[j]) {
		             minInx = j;
		             min = array[j];
		         }
		     }  
		     if (minInx != i) { //switch place
		         array[minInx] = array[i];
		         array[i] = min;
		     }
		 }
		 return array;
	  }
	
	public void score(Scanner scn) {		
		//以 scrRecord[10] 做為pplCount;		
		System.out.println("Please input a student’s score:");
		int stuScore = scn.nextInt();
		
		if(stuScore<0 || stuScore>100) {
			System.out.println("Wrong score!");
			score(scn);
		}else{
			scrRecord[10] +=1;
			scrRecord[scrRecord[10]-1] = stuScore;
			theList(scn);
		}		
	}
	
	public void theList(Scanner scn) {		 
		if(scrRecord[10] == 10) {
			System.out.println("You have completed the score input!");
			step5(scn);
		}else{
			System.out.println("You have input "+ scrRecord[10] +" score information.\r\n"
					+ "Continue? Press ‘1’, ‘Y’, or ‘y’ for Yes, and ‘2’, ‘N’, or ‘n’ for No:");

			String usr = scn.next();			
			if("Y".equals(usr) || "y".equals(usr) || "1".equals(usr)){
				score(scn);
			}else if("N".equals(usr) || "n".equals(usr) || "2".equals(usr)){
				step5(scn);
			}else {
				System.out.println("Wrong Information!");
				theList(scn);
			}
		}
		
	}
	
	public void step5(Scanner scn) {
		System.out.println("What operation do you want to execute?\r\n"
				+ "Press ‘1’ to list all scores;\r\n"
				+ "Press ‘2’ to calculate the average of scores;\r\n"
				+ "Press ‘3’ to sort and list the scores (from minimum to maximum);\r\n"
				+ "Press ‘4’ to continue the score input;\r\n"
				+ "Press ‘5’ to quit this Java application.");

		int usrNum = scn.nextInt();
		
		if(usrNum==1) {
			//依序輸出所有成績
			for(int i=0; i<scrRecord[10]; i++) {
				System.out.println(scrRecord[i]);
			}
			step5(scn);
		}else if(usrNum ==2) {
			//成績平均值(取到小數點後兩位)
			double sum =0;
			for(int i=0; i<scrRecord[10]; i++) {
				sum+=scrRecord[i];
			}
			double d = sum*100.0 / (scrRecord[10] * 1.0);
			double avg = Math.round(d)/100.0;
			System.out.println(avg);
			step5(scn);
		}else if(usrNum==3) {
			//SelectionSort排序
			int count = scrRecord[10];
			int[] result = new int[count];
			for(int n=0;n<count;n++) {
				result[n]=scrRecord[n];
			}			
			result = SelectionSort(result);
			for(int i=0; i<result.length; i++) {
				System.out.println(scrRecord[i]);
			}
			step5(scn);
		}else if(usrNum==4) {
			if(scrRecord[10]==10) {
				System.out.println("You have completed the score input!");
				step5(scn);
			}else {
				score(scn);
			}
		}else if(usrNum==5) {
			System.out.println("Thank you for using this Java application! Goodbye!");
		}else {
			System.out.println("Wrong input!");
		}
	}

	public static void main(String[] args) {
		B10106020_hw11 hw=new B10106020_hw11();
		Scanner scn = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("Welcome to use this Java application!");	
		hw.score(scn);
		scn.close();
	}

}
