package com.javacodegeeks.sorting.quicksort;

public class QuicksortExample {

	private static int []a;
	public static void main(String[] args) {
		// Get an random generated array
		a = getArray();


		// prints the given array
		printArray();
		
		// sort the array
		sort();
		
		System.out.println("");
		
		//prints the sorted array
		printArray();
		
	}
	
	// This method sort an array internally it calls to quickSort
    // søtter left variablen til at være 0 og right variablen til at være længden af a arrayet -1
    // derefter kaldes metoden quicksort
	public static void sort(){
		int left = 0;
		int right = a.length-1;
			
		quickSort(left, right);
	}
	
	// This method is used to sort the array using quicksort algorithm.
	// It takes left and the right end of the array as two cursors.


	private static void quickSort(int left,int right){
		
		// If both cursor scanned the complete array quicksort exits
        // først lavet metoden et check på om left er større eller = right værdien (ved første kald af metoden er left=0 og right =9), hvis left er større eller = right lukkes metoden.
        if(left >= right)
			return;
		
		// For the simplicity, we took the right most item of the array as a pivot
        // Pivot variablen sættes til at være den værdi i arrayet som ligger længst til højre (a[9])
		int pivot = a[right];

		// Partition variablen sættes = mpartition metoden og left right og pivot variablen sendes til metoden
		int partition = partition(left, right, pivot);
		
		// Recursively, calls the quicksort with the different left and right parameters of the sub-array
		quickSort(0, partition-1);
		quickSort(partition+1, right);
	}
	
	// This method is used to partition the given array and returns the integer which points to the sorted pivot index
	private static int partition(int left,int right,int pivot){
		int leftCursor = left-1;
		int rightCursor = right;
		System.out.println("rightcurser(variabel oprettet)="+rightCursor);
		System.out.println("leftcurser(variable oprettet)="+leftCursor);
		while(leftCursor < rightCursor){
			while(a[++leftCursor] < pivot); //false
			System.out.println("leftcurser while loop a[++leftcurser]<pivot("+pivot+").... leftcurser="+leftCursor+" a[leftcurser]="+a[leftCursor]);
			while(rightCursor > 0 && a[--rightCursor] > pivot);// false
			System.out.println("rightcurser while loop a[--rightcurser]>pivot("+pivot+").... rightcurser="+rightCursor+" a[rightcurser]="+a[rightCursor]);
			if(leftCursor >= rightCursor){
				break;
			}else{
				swap(leftCursor, rightCursor);
			}
		}
		System.out.println("before swap leftcurser="+leftCursor+" right="+right);
		swap(leftCursor, right);
		return leftCursor;
	}

	// a[0]=82, a[1]=15,  a[2]=39, a[3]=78,  a[4]=78, a[5]=16, a[6]=7, a[7]=26, a[8]=7, a[9]=74

	// pivot = 74
	// left = 0 right = 9
	/*
	leftcurser = left-1 = -1
	rightcurser = 9

	while kører så længe leftcurser er mindre end rightcurser
		(ny while lykke starter i ovenstående while lykke)
		i denne while lykke bliver leftcurerser+1 så længe værdien i arrayet a[1+leftcurser] er mindre en pivot
		dvs. i ovenstående tilfælde hvor a[0]=82 siden 82 er større end 74 bliver leftcurser plusset med 1 leftcurser er nu 1, og næste while lykke startes.
		denne while lykke tester om rightcurser er større end 0(rightcurser = 9) og at a[8](a[8]=7) er større end pivot (pivot = 74), denne gang er resultatet falsk og næste linje kode startes.

		dette er en if sætning som laver et check om leftcurser(leftcurser = 0) værdien er større eller lig med rightcurser(rightcurser = 8) værdien, hvis left curser værdien er størst sker der intet,
		hvis rightcurser værdien er størst laves et swap(de 2 værdier i arraypladserne bliver byttet om) altså a[left](a[0]=82) bliver byttet om med a[right](a[9]=74).
		i dette tilfælde er leftcurser værdien(leftcurser = 0) lavere end rightcurser værdien(rightcurser = 8) og et swap bliver lavet.

		swap metoden bliver kaldt med værdierne leftcurser(0) og rightcurser(8), en temp integer variabel bliver lavet med værdien af a[leftcurser]/a[left] (a[left/leftcurser]=a[0]=82), så temp=82.
		a[left/leftcurser](a[0]=82) bliver sat til at være lig med 74 og a[right/rightcurser](a[9]=74) bliver sat til at være lig med 82, ved at sætte den lig temp variablen.

	*/
	// This method is used to swap the values between the two given
    // swap methoden bytter om på left og right værdier i arrayet a
	public static void swap(int left,int right){
		int temp = a[left];
		a[left] = a[right]; //a[left] = a[0] = 82 & a[right] = a[9] = 74
		a[right] = temp;

	}

	// printer arrayet
	public static void printArray(){
		for(int i : a){
			System.out.print(i+" ");
		}
	}

	// laver et array med 10 random værdier mellem 1 og 100 og returnere det.
	public static int[] getArray(){
		int size=10;
		int []array = new int[size];
		int item = 0;
		/*for(int i=0;i<size;i++){
			item = (int)(Math.random()*100); 
			array[i] = item;
		}*/
		array[0]=82;
		array[1]=15;
		array[2]=39;
		array[3]=78;
		array[4]=78;
		array[5]=16;
		array[6]=7;
		array[7]=26;
		array[8]=7;
		array[9]=74;

		// a[0]=82, a[1]=15,  a[2]=39, a[3]=78,  a[4]=78, a[5]=16, a[6]=7, a[7]=26, a[8]=7, a[9]=74
		return array;
	}

}
