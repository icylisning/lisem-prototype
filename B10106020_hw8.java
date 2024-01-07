import java.util.Scanner;
import java.util.Arrays;

public class B10106020_hw8 {

	public static int sales_num(int[][] merch) {  // 計算所有商品所有日子合計總銷售金額
		int S = 0;
		for(int i=0;i<merch.length;i++) {
			for(int j=0;j<merch[i].length;j++) {
				S += merch[i][j];
			}
		}
		return S;
	}
	
	public static int[] daily_sales(int[][] merch) {  //每日銷售金額 (欄加總)
		int len = merch[0].length;
		int[] dailySales = new int[len];
		for(int i=0;i<merch.length;i++) {
			for(int j=0;j<merch[i].length;j++) {
				dailySales[j] += merch[i][j];
			}
		}
		return dailySales;
	}
	
	public static float daily_avg(int[][] merch) {  //平均每日銷售金額
		int[] borrow = daily_sales(merch);
		int total = 0;
		for(int i=0; i<borrow.length; i++) {
			total += borrow[i];
		}
		float AD = total/borrow.length;
		return AD;
	}
	
	public static int[] goods_sales(int[][] allMerch) {  //各商品總銷售金額
		int n = allMerch.length;
		int[] merchTotal = new int[n];
		for(int i=0;i<allMerch.length;i++) {
			for(int j=0;j<allMerch[i].length;j++) {
				merchTotal[i] += allMerch[i][j];
			}
		}
		return merchTotal;
	}
	
	public static int[] goods_avg(int[][] merch) {  //各項商品平均每日銷售金額
		int dayLen = merch.length;
		int[] dailyAvg = new int[dayLen];
		for(int i=0;i<merch.length;i++) {
			for(int j=0;j<merch[i].length;j++) {
				dailyAvg[i] += merch[i][j];
			}
		}
		for(int i=0; i<dailyAvg.length; i++) {
			dailyAvg[i] = dailyAvg[i]/merch[0].length;
		}
		return dailyAvg;
	}
	
	public static int best_day(int[][] dayMerch){  //平均銷售金額最高為星期幾（𝑊）

		int[] bestTemp = daily_sales(dayMerch);
		int[] bestSales = new int[7];
		int count = 0;		
		for(int j=0;j<bestTemp.length;j++) {
			count = (j/7)+1;
			if ((j+1)%7==1) {
				bestSales[0] = (bestSales[0]+bestTemp[j])/count;
			}else if ((j+1)%7==2) {				
				bestSales[1] = (bestSales[1]+bestTemp[j])/count;
			}else if ((j+1)%7==3) {
				bestSales[2] = (bestSales[2]+bestTemp[j])/count;
			}else if ((j+1)%7==4) {
				bestSales[3] = (bestSales[3]+bestTemp[j])/count;
			}else if ((j+1)%7==5) {
				bestSales[4] = (bestSales[4]+bestTemp[j])/count;
			}else if ((j+1)%7==6) {
				bestSales[5] = (bestSales[5]+bestTemp[j])/count;
			}else if ((j+1)%7==0) {
				bestSales[6] = (bestSales[6]+bestTemp[j])/count;
			}			
		}
        int temp = bestSales[0];
        int w = 7;
        for (int j=0; j<7; j++) {
            if (bestSales[j] > temp) {
                temp = bestSales[j];
                w=j+1;
            }
        }
		return w;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		String[] firstln = scn.nextLine().split(","); //第一行的兩個整數n和t
		int n = Integer.parseInt(firstln[0]);
		int t = Integer.parseInt(firstln[1]);
		
		String[] secondln = scn.nextLine().split(","); //第二行的n個整數		
		int[] ds = new int[n];
		for(int i=0; i<ds.length; i++) {
			ds[i] = Integer.parseInt(secondln[i]);
		}
		
		int[][] merch = new int[n][t];
		int myItem = 0;
		for(int i=0;i<n;i++) {
			String[] eachln = scn.nextLine().split(",");
			for (int j=0;j<t;j++) {
				myItem = Integer.parseInt(eachln[j])*ds[i];
				merch[i][j] = myItem;
			}
		}
		
		String[] text = scn.nextLine().split(","); //1-6的執行數字
		scn.close();
		int[] record = new int[text.length];
		for(int i=0; i<text.length; i++) {
			record[i] = Integer.parseInt(text[i]);
		}
		
		if (Arrays.stream(record).anyMatch(i -> i == 1)) {
			System.out.println(sales_num(merch));
		}
        if (Arrays.stream(record).anyMatch(i -> i == 2)) {
        	int thisLen = daily_sales(merch).length;
        	for(int i=0; i<thisLen; i++) {
        		if (i==thisLen-1) {
        			System.out.println(daily_sales(merch)[i]);
        		}else {
        			System.out.print(daily_sales(merch)[i]+",");	
        		}
        	}
        	
		}
        if (Arrays.stream(record).anyMatch(i -> i == 3)) {
        	System.out.println((int)daily_avg(merch));
		}
        if (Arrays.stream(record).anyMatch(i -> i == 4)) {
        	int thisLen = goods_sales(merch).length;
        	for(int i=0; i<thisLen; i++) {
        		if (i==thisLen-1) {
        			System.out.println(goods_sales(merch)[i]);
        		}else {
        			System.out.print(goods_sales(merch)[i]+",");	
        		}
        	}
		}
        if (Arrays.stream(record).anyMatch(i -> i == 5)) {
        	int thisLen = goods_avg(merch).length;
        	for(int i=0; i<thisLen; i++) {
        		if (i==thisLen-1) {
        			System.out.println(goods_avg(merch)[i]);
        		}else {
        			System.out.print(goods_avg(merch)[i]+",");	
        		}
        	}
		}
        if (Arrays.stream(record).anyMatch(i -> i == 6)) {
        	System.out.println(best_day(merch));
		}	
        
	}
	
}