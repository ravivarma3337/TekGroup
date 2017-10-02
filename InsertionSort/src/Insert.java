
class Test {
	public void ins() {
		int[] a = { 5, 4, 1, 3, 2, 6 };
		int[] b = new int[6];
		int i, j, m;
		for (i = 0; i < 6; i++) {
			if (i == 0) {
				b[0] = a[0];
			} else if (a[i] < b[0]) {
				for (j = i; j > 0; j--) {
					b[j] = b[j - 1];
				}
				b[0] = a[i];
			}
			else if(a[i]>b[i-1]) {
				b[i] = a[i];
			}
			else {
				for(j=0; j<=i; j++) {
					if (a[i]<b[j]) {
						for(m=i; m>j; m--) {
							b[m]=b[m-1];
						}
						b[j]=a[i];
						break;
					}
				}
			}
		}
		for(i=0;i<6;i++) {
		System.out.print(b[i] + " ");
		}
	}
}

public class Insert {

	public static void main(String[] args) {
		Test t = new Test();
		t.ins();
	}

}
