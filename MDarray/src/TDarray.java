import java.util.Scanner;

public class TDarray {

	private int row = 4;
	private int col = 3;
	private int[][] matrix;

	public TDarray(int trow, int tcol) {

		this.row = trow;
		this.col = tcol;
	}

	public TDarray(int trow, int tcol, int[][] m) {

		this.row = trow;
		this.col = tcol;
		this.matrix = m;
	}

	public int[][] fill() {
		int[][] data = new int[row][col];
		Scanner in = new Scanner(System.in);
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				System.out.println("enter the elementss for the Matrix : ");
				data[row][col] = in.nextInt();
			}
			System.out.println();
		}

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				System.out.print(data[row][col]+" ");
			}
			System.out.println(" ");
		}
		return data;
	}

	public static void main(String[] args) {
		int[][] ma = new int[4][3];
		TDarray t = new TDarray(4, 3, ma);
		t.fill();

	}

}
