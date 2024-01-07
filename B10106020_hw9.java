import java.util.ArrayList;
import java.util.Scanner;

class E{
	int value,layers;
	E parent;
	E(int value,int layers){
		this.layers = layers;
		this.value = value;
	}	
	ArrayList<E> children = new ArrayList<>();
}

public class B10106020_hw9 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = Integer.parseInt(scn.nextLine());
		ArrayList<E> tree = new ArrayList<>();
		
		//建立結點
		for(int i = 0;i <= n;i++) {
			tree.add(new E(i,0));
		}
		
		//建立樹的關係
		for(int i = 1;i <= n;i++) {
			String[] eachln = scn.nextLine().split(" ");
			int input = Integer.parseInt(eachln[0]);
			if(input > 0)
				tree.get(i).layers = -1;
			for(int j = 1;j <= input;j++) {
				int lineNum = Integer.parseInt(eachln[j]);
				tree.get(i).children.add(tree.get(lineNum));
				tree.get(lineNum).parent = tree.get(i);
			}
		}
		String[] lastln = scn.nextLine().split(" ");
		
		//葉結點獨立出來
		ArrayList<Integer>leaf = new ArrayList<>();
		int root = 0;
		for(int i = 1;i <= n;i++) {
			if(tree.get(i).parent == null)
				root = i;
			if(tree.get(i).layers == 0)
				leaf.add(tree.get(i).value);
		}
		
		//把葉結點跑一次更新
		for(int i = 0;i < leaf.size();i++) {
			int x = leaf.get(i);
			int now = tree.get(x).value;
			while(true){
				if(tree.get(now).parent == null)
					break;
				if(tree.get(now).parent.layers <tree.get(now).layers+1) {
					tree.get(now).parent.layers =tree.get(now).layers+1;
				}
				//跳下一個
				now = tree.get(now).parent.value;
			}
		}
		
		long ans = 0;
		for(int i = 1;i <= n;i++) {
			ans+=tree.get(i).layers;
		}
		
		scn.close();
		System.out.println(root); //root node編號
		System.out.println(tree.get(root).layers); //根節點的高度
		System.out.println(ans); //H(T)
		int ansNum = 0;
		for(int t=0;t<lastln.length;t++) {
			ansNum = Integer.valueOf(lastln[t]);
			System.out.println(tree.get(ansNum).layers);
		}
	}
}
