import java.util.*;

public class MergeSort {
	private static final Random RNG = new Random(42); // random number generator

	public static class MergeSortThread extends Thread {
		private int[] a;
		private int threadCount;

		public MergeSortThread(int[] a, int threadCount) {
			this.a = a;
			this.threadCount = threadCount;
		}

		public int[] getA() {
			return a;
		}

		@Override
		public void run() {
			parallelMergeSort(a, threadCount);
		}
	}

	public static void main(String[] args) {
		int LENGTH = 1024; // initial length of array to sort
		int RUNS = 17; // how many times to grow by 2?

		for (int i = 1; i <= RUNS; i++) {
			int[] a = createRandomArray(LENGTH);

			// run the algorithm and time how long it takes
			long start = System.currentTimeMillis();
			parallelMergeSort(a, 8);
			long duration = System.currentTimeMillis() - start;

			if (!isSorted(a)) {
				throw new RuntimeException("not sorted afterward: " + Arrays.toString(a));
			}

			System.out.printf("%10d elements  =>  %6d ms%n", LENGTH, duration);
			LENGTH *= 2; // double size of array for next time
		}
	}

	public static void parallelMergeSort(int[] a, int threadCount) {
		if (threadCount <= 1) {
			mergeSort(a);
		} else if (a.length >= 2) {
			// split the array in 2 parts
			int[] left = Arrays.copyOfRange(a, 0, a.length / 2);
			int[] right = Arrays.copyOfRange(a, a.length / 2, a.length);

			// sort the halves recursively
			MergeSortThread leftThread = new MergeSortThread(left, threadCount / 2);
			MergeSortThread rightThread = new MergeSortThread(right, threadCount - threadCount / 2);

			leftThread.start();
			rightThread.start();

			// wait for the halves to be sorted
			try {
				leftThread.join();
				rightThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// merge them back together
			merge(leftThread.getA(), rightThread.getA(), a);
		}
	}

	// Arranges the elements of the given array into sorted order
	// using the "merge sort" algorithm, which splits the array in half,
	// recursively sorts the halves, then merges the sorted halves.
	// It is O(N log N) for all inputs.
	public static void mergeSort(int[] a) {
		if (a.length >= 2) {
			// split array in half
			int[] left  = Arrays.copyOfRange(a, 0, a.length / 2);
			int[] right = Arrays.copyOfRange(a, a.length / 2, a.length);

			// sort the halves
			mergeSort(left);
			mergeSort(right);

			// merge them back together
			merge(left, right, a);
		}
	}

	// Combines the contents of sorted left/right arrays into output array a.
	// Assumes that left.length + right.length == a.length.
	public static void merge(int[] left, int[] right, int[] a) {
		int j = 0;
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			if (k >= right.length || (j < left.length && left[j] < right[k])) {
				a[i] = left[j];
				j++;
			} else {
				a[i] = right[k];
				k++;
			}
		}
	}

	// Returns true if the given array is in sorted ascending order.
	public static boolean isSorted(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				return false;
			}
		}
		return true;
	}

	// Creates an array of the given length, fills it with random
	// non-negative integers, and returns it.
	public static int[] createRandomArray(int length) {
		int[] a = new int[length];
		for (int i = 0; i < a.length; i++) {
			a[i] = RNG.nextInt(1_000_000);
		}
		return a;
	}
}

/* 1 thread
 * 1024 elements  =>       1 ms
 * 2048 elements  =>       1 ms
 * 4096 elements  =>       1 ms
 * 8192 elements  =>       1 ms
 * 16384 elements  =>       2 ms
 * 32768 elements  =>       3 ms
 * 65536 elements  =>       6 ms
 * 131072 elements  =>      12 ms
 * 262144 elements  =>      23 ms
 * 524288 elements  =>      49 ms
 * 1048576 elements  =>     106 ms
 * 2097152 elements  =>     214 ms
 * 4194304 elements  =>     422 ms
 * 8388608 elements  =>     860 ms
 * 16777216 elements  =>    1808 ms
 * 33554432 elements  =>    3603 ms
 * 67108864 elements  =>    7269 ms
 *
 * 4 threads
 * 1024 elements  =>       1 ms
 * 2048 elements  =>       0 ms
 * 4096 elements  =>       1 ms
 * 8192 elements  =>       2 ms
 * 16384 elements  =>       2 ms
 * 32768 elements  =>       5 ms
 * 65536 elements  =>       4 ms
 * 131072 elements  =>       4 ms
 * 262144 elements  =>       9 ms
 * 524288 elements  =>      18 ms
 * 1048576 elements  =>      35 ms
 * 2097152 elements  =>      64 ms
 * 4194304 elements  =>     132 ms
 * 8388608 elements  =>     291 ms
 * 16777216 elements  =>     518 ms
 * 33554432 elements  =>    1039 ms
 * 67108864 elements  =>    2337 ms
 * 
 * 
 * 8 threads
 * 1024 elements  =>       1 ms
 * 2048 elements  =>       0 ms
 * 4096 elements  =>       1 ms
 * 8192 elements  =>       2 ms
 * 16384 elements  =>       3 ms
 * 32768 elements  =>       6 ms
 * 65536 elements  =>       2 ms
 * 131072 elements  =>       3 ms
 * 262144 elements  =>       7 ms
 * 524288 elements  =>      13 ms
 * 1048576 elements  =>      26 ms
 * 2097152 elements  =>      43 ms
 * 4194304 elements  =>      89 ms
 * 8388608 elements  =>     169 ms
 * 16777216 elements  =>     317 ms
 * 33554432 elements  =>     624 ms
 * 67108864 elements  =>    1445 ms
 * 
 * 
 * Für kleine Arrays lohnt es sich nicht, mehrere Threads zu verwenden, da der Overhead zu groß ist.
 * Und der Geschwindigkeitsgewinn ist nicht so groß.
 */