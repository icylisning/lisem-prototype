
class Human{ //不可以public!
	String name;
	byte gender;
	float height;
	float weight;
	int age;
	Human spouse;
	private static int counter = 0;
	
	public int getCounter() {
		return counter;
	}
	
	double calculateBMI(float height, float weight) {
		double h = (height/100)*(height/100);
		double BMI = weight/h;
		return BMI;
	}
	
	public Human() {
		counter++;
		System.out.println(counter);
	}
	
	void setAge(int num) {
		age = num;
	}
	void setSpouse(Human sps) {
		spouse = sps;
	}
	void setName(String str) {
		name = str;
	}
	int getAge() {
		return age;
	}
	Human getSpouse() {
		return spouse;
	}
	String getName() {
		return name;
	}
	
//	public Human(String name) {
//		if(name != "") {
//			this.name = name;
//		}
//	}
//	
//	public Human(String name, byte gender, float height) {
//		this.setName(name);
//	    ...
//	    ...
//	}
	
	public Human(String name, byte gender, float height, float weight, int age) {
		// TODO Auto-generated constructor stub
	    this();
		this.name = name;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
	    this.age = age;
	}
}

public class PracticeFile {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Human a = new Human();
//		a.name = "Adam";
//		a.gender = 1;
//		a.height = 170;
//		a.weight = 65;
		Human a = new Human("Adam",(byte)1,(float)170,(float)65, 40);
		Human b = new Human("Eve",(byte)2,(float)160,(float)50, 45);
//      如果你有自行撰寫建構元, Java就不會再提供預設的建構元!!!
		
		a.setSpouse(b);
		b.setSpouse(a);
		System.out.println(a.getCounter());
		System.out.println(b.getCounter());
		
	}
}
