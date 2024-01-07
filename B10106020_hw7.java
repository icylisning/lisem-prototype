import java.util.Scanner;

public class B10106020_hw7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String firstNum = scn.nextLine();
		int cellNum = Integer.parseInt(firstNum);
		String secondNum=scn.nextLine();
		int dir = Integer.parseInt(secondNum);
		
		int[][] myArr = new int[cellNum][cellNum];
		int myNum=0;
		
		for(int i=0;i<cellNum;i++) {
			String inputLine =scn.nextLine();
			String[] temp = inputLine.split(" ");
			for (int j=0;j<cellNum;j++) {
				myNum = Integer.parseInt(temp[j]);
				myArr[i][j] = myNum;
			}
		}
		scn.close();
		       
        int[] output = doLoop(cellNum, dir, myArr);
        for(int i=0; i<output.length; i++) {
        	System.out.print(output[i]);
        }
	}

	
//      ORIGINAL CODE BELOW

//      int row = cellNum/2, col =cellNum/2;
//		System.out.print(myArr[row][col]);
//		int clCount = 1;
//		while (clCount < cellNum*cellNum) { //11223344+4 or 1122+2 (cellNum-1)*2+1
//			if (dir == 0){
//				//col-1, row-1, (col+1)*2, (row+1)*2, (col-1)*3, (row-1)*3, ...
//				for(int i=1; i<cellNum; i++) { //1234
//					for(int j=0; j<i*2; j++) { //
//						if (j<=i && i%2==1) {
//							col-=1;
//						}else if(j>i && i%2==0) {
//							row-=1;
//						}else if(j<=i && i%2==1) {
//							col+=1;
//						}else if(j>i && i%2==0) {
//							row+=1;
//						}
//					    System.out.print(myArr[row][col]);
//					}
//				}
//				clCount+=1;				
//			}else if(dir == 1) {
//				//row-1, col+1, row+2, col-2, row-3...
//			}else if (dir ==2) {
//				//col+1, row+1, col-2, row-2, ...
//			}else if (dir ==3) {
//				//row+1, col-1, row-2, col+2, ...
//			}else if (dir == 4) {
//				//col-1, row+1, col+2, row-2, col-3...
//			}
//		}
	
    public static int[] doLoop(int cellNum, int startDir, int[][] myArr) {
        int[] output = new int[cellNum * cellNum];
        String[] output_Dir = new String[cellNum * cellNum];
        // 0:左 , 1:上 , 2:右 , 3:下
        String[] dirLoop = new String[] {"左", "上", "右", "下"};
        int dirStep = startDir;
        int numStep = 1; // 1,1,2,2,3,3,4,4,5,5...
        int numStepLoop = 0;
        int clCount = 0;
        int posI = (cellNum - 1) / 2;  //row
        int posJ = (cellNum - 1) / 2;  //col
        output[clCount] = myArr[posI][posJ];  //center starting point
        String dirChk = "左";
        while (clCount < cellNum * cellNum) {
        	if (dirStep==4) { //左，下，右，上
        		dirStep=0;
        		dirLoop = new String[] {"左", "下", "右", "上"};
        	}
            dirStep = dirStep % 4;
            dirChk = dirLoop[dirStep];
            for (int iiStep = 1; iiStep <= numStep; iiStep++) {
                clCount++;
                if (clCount >= cellNum * cellNum) {
                    break;
                }
                if ("左".equals(dirChk)) { //col-1
                    posJ -= 1;
                }
                else if ("上".equals(dirChk)) { //row-1
                    posI -= 1;
                }
                else if ("右".equals(dirChk)) { //col+1
                    posJ +=1;
                }
                else if ("下".equals(dirChk)) { //row+1
                    posI += 1;
                }
                output_Dir[clCount] = dirChk;
                output[clCount] = myArr[posI][posJ];
            }
            numStepLoop++; // 每兩次重複，就重來
            if (numStepLoop > 1) {
                numStepLoop = numStepLoop % 2;
                numStep += 1; // 重複次數 +1
            }
            dirStep += 1; // 跳下一個方向
        }

        return output;
    }

}
