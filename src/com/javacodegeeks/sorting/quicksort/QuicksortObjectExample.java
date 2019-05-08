package com.javacodegeeks.sorting.quicksort;

import com.javacodegeeks.entity.Employee;

public class QuicksortObjectExample<T extends Comparable<T>> {

	private T []a;
	public static void main(String[] args) {
		
		Employee []employees = new Employee[5];
		Employee employee = new Employee("John","Carter",5658);
		employees[0] = employee;
		employee = new Employee("Mary","Carter",7412);
		employees[1] = employee;
		employee = new Employee("Alex","Lumb",1158);
		employees[2] = employee;
		employee = new Employee("David","Jhonson",1254);
		employees[3] = employee;
		employee = new Employee("Shaun","Smith",4587);
		employees[4] = employee;
		
		QuicksortObjectExample<Employee>ex = new QuicksortObjectExample<>();
		// Assigned array
		ex.a = employees;
		
		
		// prints the given array
		ex.printArray();
		
		// sort the array
		ex.sort();
		
		System.out.println("");
		
		//prints the sorted array
		ex.printArray();
		
	}
	
	// This method sort an array internally it calls to quickSort 
	public void sort(){
		int left = 0;
		int right = a.length-1;
			
		quickSort(left, right);
	}
	
	// This method is used to sort the array using quicksort algorithm.
	// It takes left and the right end of the array as two cursors.
	private void quickSort(int left,int right){
		
		// If both cursor scanned the complete array quicksort exits
		if(left >= right)
			return;
		
		// Pivot using median of 3 approach
		T pivot = getMedian(left, right);
		int partition = partition(left, right, pivot);
		
		// Recursively, calls the quicksort with the different left and right parameters of the sub-array
		quickSort(0, partition-1);
		quickSort(partition+1, right);
	}
	
	// This method is used to partition the given array and returns the integer which points to the sorted pivot index
	private int partition(int left,int right,T pivot){
		int leftCursor = left-1;
		int rightCursor = right;
		while(leftCursor < rightCursor){
			while(((Comparable<T>)a[++leftCursor]).compareTo(pivot) < 0);
			while(rightCursor > 0 && ((Comparable<T>)a[--rightCursor]).compareTo(pivot) > 0);
			if(leftCursor >= rightCursor){
				break;
			}else{
				swap(leftCursor, rightCursor);
			}
		}
		swap(leftCursor, right);
		return leftCursor;
	}
	
	public T getMedian(int left,int right){
		int center = (left+right)/2;
		
		if(((Comparable<T>)a[left]).compareTo(a[center]) > 0)
			swap(left,center);
		
		if(((Comparable<T>)a[left]).compareTo(a[right]) > 0)
			swap(left, right);
		
		if(((Comparable<T>)a[center]).compareTo(a[right]) > 0)
			swap(center, right);

		swap(center, right);
		return a[right];
	}
	
	// This method is used to swap the values between the two given index
	public void swap(int left,int right){
		T temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}
	
	public void printArray(){
		for(T i : a){
			System.out.println(i+" ");
		}
	}
	
}
