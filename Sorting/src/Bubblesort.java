class Ary {
	public void md() {
		int[] numbers = { 6, 2, 3, 5, 1, 4, 0 };
		int i, j;
		for (i = 0; i < 7; i++) {
			for (j = i+1; j < 7; j++) {
				if (numbers[i] > numbers[j]) {
					int temp;
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		for(i=0 ; i < 7; i++)
		System.out.println("Sorted Array : " + numbers[i]);
	}
}

public class Bubblesort {

	public static void main(String[] args) {
		Ary a = new Ary();
		a.md();
	}

}
