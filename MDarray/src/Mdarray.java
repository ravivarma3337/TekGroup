class Test {
	public void ar() {
		int[][] number = new int[4][3];

		number[0][0] = 10;
		number[1][0] = 40;
		number[0][1] = 20;
		
		number[1][1] = 50;
		number[0][2] = 30;
		number[1][2] = 60;

		number[2][0] = 70;
		number[3][0] = 100;
		number[2][1] = 80;
		
		number[3][1] = 110;
		number[2][2] = 90;
		number[3][2] = 120;

		int row = 4;
		int col = 3;
		int i, j;

		for (i = 0; i < row; i++) {
			for (j = 0; j < col; j++) {
				System.out.print(number[i][j] + " ");
			}
			System.out.println(" ");
		}
	}
}

public class Mdarray {

	public static void main(String[] args) {
		Test t = new Test();
		t.ar();
	}

}
