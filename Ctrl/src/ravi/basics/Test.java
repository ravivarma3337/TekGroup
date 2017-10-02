package ravi.basics;

class T1 {
	public void abc() {
		int x, y;
		y = 20;
		for (x = 0; x < 10; x++) {
			System.out.println("This is x : " + x);
			System.out.println("This is y : " + y);
			y = y - 2;
		}
	}
}

public class Test {

	public static void main(String[] args) {

		T1 q = new T1();
		q.abc();

	}

}
