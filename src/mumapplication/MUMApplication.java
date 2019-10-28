/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mumapplication;

/**
 *
 * @author aojinadu
 */
public class MUMApplication {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		int[] a = {1, 3, 8, 26};
		int[] aa = {};
		System.out.println(isRapidlyIncreasing(aa));
	}

	static int checkedCentred(int[] a) {
		if (a.length % 2 == 0) {
			return 0;
		}
		int middle = Math.round((float) a.length / 2);
		for (int i = 0; i < a.length; i++) {
			if (i != middle - 1 && a[i] <= a[middle - 1]) {
				return 0;
			}
		}
		return 1;

	}

	static int checkEvenOdd(int[] a) {
		int x = 0, y = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				x += a[i];
			} else {
				y += a[i];
			}
		}
		return x - y;
	}

	static char[] checkLength(char[] a, int start, int len) {
		char[] b = new char[len];
		if (len < 0 || start < 0 || start + len - 1 >= a.length) {
			return null;
		}
		for (int i = start, j = 0; j < len; i++, j++) {
			b[j] = a[i];
		}
		return b;
	}

	static int nextPerfectSquare(int n) {
		int psq = n;
		for (int i = n + 1; i > n;) {
			double sq = Math.sqrt(i);
			if (sq == Math.floor(sq)) {
				psq = (int) sq;
			} else {
				i++;
			}
		}
		return psq;
	}

	public static void main() {

	}

	static int is235Array(int[] a) {
		if (a == null || a.length < 1) {
			return 0;
		}
		int ans = 0;
		int divisibleBy2 = 0, divisibleBy3 = 0, divisibleBy5 = 0, others = 0;
		for (int i = 0; i < a.length; i++) {
			boolean isNotDiv = true;
			int value = a[i];
			if (value % 2 == 0) {
				divisibleBy2++;
				isNotDiv = false;
			}
			if (value % 3 == 0) {
				divisibleBy3++;
				isNotDiv = false;
			}
			if (value % 5 == 0) {
				divisibleBy5++;
				isNotDiv = false;
			}
			if (isNotDiv) {
				others++;
			}
		}
		if (divisibleBy2 + divisibleBy3 + divisibleBy5 + others == a.length) {
			ans = 1;
		}
		return ans;
	}

	static int isRapidlyIncreasing(int[] a) {
		if (a != null && a.length > 0) {
			int current;
			for (int i = 1; i < a.length; i++) {
				current = a[i];
				int prevValue=0;
				for (int j = i - 1; j >= 0; --j) {
					 prevValue += a[j];
				}
				if (current <= 2 * prevValue) {
					return 0;
				}
			}
		} else {
			return 0;
		}
		return 1;
	}
	
	public int getFirstSmallestPositiveNumber(int[] arr) {
    // set positions of non-positive or out of range elements as free (use 0 as marker)
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] <= 0 || arr[i] > arr.length) {
            arr[i] = 0;
        }
    }

    //iterate through the whole array again mapping elements [1,n] to positions [0, n-1]
    for (int i = 0; i < arr.length; i++) {
        int prev = arr[i];
        // while elements are not on their correct positions keep putting them there
        while (prev > 0 && arr[prev - 1] != prev) {
            int next = arr[prev - 1];
            arr[prev - 1] = prev;
            prev = next;
        }
    }

    // now, the first unmapped position is the smallest element
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] != i + 1) {
            return i + 1;
        }
    }
    return arr.length + 1;
}
}
