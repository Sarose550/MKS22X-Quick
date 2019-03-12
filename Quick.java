public class Quick{

	public static void main(String[] args){
		int[] data = {1, 3, 5, 6, 2, 3, 8, 9};
		for(int i = 0; i < data.length; i++){
			System.out.print(data[i] + " ");
		}
		System.out.println();
		System.out.println(quickselect(data, 5));
	}
	/*Modify the array such that:
 *1. Only the indices from start to end inclusive are considered in range
 *2. A random index from start to end inclusive is chosen, the corresponding 
 *   element is designated the pivot element. 
 *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
 *4. all elements in range that are larger than the pivot element are placed after the pivot element.
 *@return the index of the final position of the pivot element.
 */
	public static int partition (int [] data, int start, int end){
		int rand = (int) (start + (end - start) * Math.random());
		int pivot = data[rand];
		for(int i = 0; i < data.length; i++){
			if((i < rand && data[i] > pivot) || (i > rand && data[i] < pivot)){//swap the pivot and the current element
				int temp = data[i];
				data[i] = pivot;
				data[rand] = temp;
				rand = i;
			}
		}
		return rand;
	}

	public static int quickselect(int[] data, int k){
		return quickselectH(data, k, 0, data.length - 1);
	}
	public static int quickselectH(int[] data, int k, int start, int end){
		int piv = partition(data, start, end);
		if(piv < k){
			return quickselectH(data, k, piv, end);
		}
		if(piv > k){
			return quickselectH(data, k, start, piv);
		}
		return data[piv];
	}
}
