class Test {
	public void ar() {
		int[] values;
		values = new int[5];
		values[0] = 10;
		values[1] = 20;
		values[2] = 30;
		values[3] = 40;
		values[4] = 50;
		System.out.print(values[0] + " ");
		System.out.print(values[1] + " ");
		System.out.print(values[2] + " ");
		System.out.print(values[3] + " ");
		System.out.print(values[4] + " " + "\n");

		for (int i = 0; i < values.length; i++) {
			System.out.print(values[i] + " ");
		}

		int[] numbers = { 1, 2, 3, 4 };
		for (int i = 0; i < numbers.length; i++)
			System.out.print("\n" + numbers[i] + " ");
	}
}

public class Array {

	public static void main(String[] args) {
		Test t = new Test();
		t.ar();

	}

}
