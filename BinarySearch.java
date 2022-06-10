package exp1;

import java.util.Scanner;

public class BinarySearch {
	static int a[] = new int[100];
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of array : ");
		n = sc.nextInt();
		System.out.println("Enter the elements in to array : ");
		for(int i = 1; i <= n; i++)
			a[i] = sc.nextInt();
	    sort(a, n);
	    System.out.println("Elements after sorting : ");
	    display(a, n);
	    int ch = 0;
	    int result = 0;
	    long startTime, stopTime;
	    do {
	    	System.out.print("Enter the element to be search : ");
		    int ele = sc.nextInt();
	    	System.out.println("Binary search using \n1 - iteration\n2 - recurssion\n3 - exit");
		    ch = sc.nextInt();
		    switch(ch) {
		        case 1:startTime = System.nanoTime();
		        	   result = IBS(a, n, ele);
		        	   stopTime = System.nanoTime();
		       		   System.out.println("time in nano seconds : " + (stopTime - startTime));
			           if(result == 0)
			    	       System.out.println("Element not found");
			           else
			    	       System.out.println("Element foud at index " + result);
			           break;
		        case 2:startTime = System.nanoTime();
		        	   result = RBS(a,1,  n, ele);
		        	   stopTime = System.nanoTime();
		       		   System.out.println("time in nano seconds : " + (stopTime - startTime));
			           if(result == 0)
			    	       System.out.println("Element not found");
			           else
			    	       System.out.println("Element foud at index " + result);
			           break;
		        case 3: return;
		    }
	    }while(ch < 4);
	}
	static int IBS(int a[], int n, int ele) {
		int mid = -1, low = 1, high = n + 1;
		while(low <= high) {
			mid = (low + high) / 2;
			if( ele < a[mid])
				high = (mid - 1);
			else if(ele > a[mid])
				low = (mid + 1);
			else {
				break;
			}
		}
		if(low <= high)
			return mid;
		return 0;
	}
	static int RBS(int a[], int low, int high, int ele) {
		if(low < high) {
		int mid = (low + high) / 2;
		if(a[mid] == ele)
			return mid;
		else if(a[mid] > ele)
			return RBS(a, low, mid - 1, ele);
		else if(a[mid] < ele)
			return RBS(a, mid + 1, high, ele);
		}
		return 0;
	}
	static void sort(int a[], int n) {
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n - i; j++) {
				if(a[j + 1] <= a[j]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
	static void display(int a[], int n) {
		for(int i = 1; i <= n;i++)
			System.out.println(a[i]);
		System.out.println();
	}
}
