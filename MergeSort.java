import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array : ");
        int n = sc.nextInt();
        System.out.println("Enter the elements : ");
        int arr[] = new int[n];
        for(int i = 0; i < n ;i++)
        	arr[i] = sc.nextInt();
        long start = System.nanoTime();
        MergeSort ms = new MergeSort();
        ms.sort(arr,  n,  0,  n - 1);
        long end = System.nanoTime();
        System.out.println("Array after sorting  : ");
        ms.display(arr,  n);
        System.out.println("Time complexity of merge sort in nano seconds is : " + (end - start));
	}

}

public class MergeSort {
	static int count;
	public void display(int arr[], int  n) {
		for(int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	public void merge(int arr[], int n, int low, int mid, int high) {
		int i = low, h = low, j = mid + 1, k;
		int b[] = new int[n];
		while(h <= mid && j <= high) {
			if(arr[h] <= arr[j])
				b[i++] = arr[h++];
			else
				b[i++] = arr[j++];
		}
		if(h > mid) {
			for(k = j; k <= high; k++)
				b[i++] = arr[k];
		}
		else {
			for(k = h; k <= mid; k++)
				b[i++] = arr[k];
		}
		for(k = low; k <= high; k++)
			arr[k] = b[k];
		System.out.print("pass " + (++count) + " : ");
		display(arr, n);
	}
	public void sort(int arr[], int n, int low, int high) {
		if(low < high) {
			int mid = (low + high) / 2;
			sort(arr, n, low, mid);
			sort(arr, n, mid + 1, high);
			merge(arr, n, low, mid, high);
		}
	}
}
