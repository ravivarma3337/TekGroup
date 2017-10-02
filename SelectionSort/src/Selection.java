class Select {
	void sort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++)
				if (arr[j] < arr[min])
					min = j;
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;

		}
	}

	void print(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}

public class Selection {
	void test() {
		Select ob = new Select();
		int arr[] = { 10, 9, 8, 7, 6 };
		ob.sort(arr);
		System.out.println("Sorted array : ");
		ob.print(arr);
	}

	public static void main(String[] args) {
		Selection s = new Selection();
		s.test();
	}

}
