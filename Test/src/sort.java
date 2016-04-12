import java.util.Arrays;

public class sort {
	public static void main(String[] args) {

	/*	int[] a = new int[] { 1, 2, 3, 6, 5, 7, 9, 8, 4 };
		int temp;
		//Arrays.sort(a);
		for (int i = 0; i < a.length-1; i++) {
			for (int j = 0; j < a.length-i-1; j++) {
				if (a[j] > a[j+1]) {
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}

			}

		}
		for(int k=0;k<a.length;k++){
			System.out.print(a[k]+",");
		}
*/
		 String str="http://127.0.0.1/img20150909123jpg";
		 String a[] = str.split("/");
		 System.out.println(a[3].substring(3));
	}
}
