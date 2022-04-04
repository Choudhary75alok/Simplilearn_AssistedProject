package practiceProj_Lis;

public class LisEx {

	static int max_Ref; // stores the LIS

	static int _lis(int arr[], int n) {
		if (n == 1)
			return 1;
		int res, max_ending_here = 1;

		for (int i = 1; i < n; i++) {
			res = _lis(arr, i);
			if (arr[i - 1] < arr[n - 1] && res + 1 > max_ending_here)
				max_ending_here = res + 1;
		}

		if (max_Ref < max_ending_here)
			max_Ref = max_ending_here;

		return max_ending_here;
	}

	static int lis(int arr[], int n) {

		max_Ref = 1;

		_lis(arr, n);

		return max_Ref;
	}

	public static void main(String args[]) {
		int arr[] = { 12, 56, 39, 58, 67, 35, 49, 76 };
		int n = arr.length;
		System.out.println("Length of lis is " + lis(arr, n) + "\n");
	}
}
