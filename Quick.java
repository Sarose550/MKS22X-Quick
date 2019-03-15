public class Quick{

	public static void main(String[] args){
		int[] data = {1, 3, 5, 6, 2, 3, 8, 9};
		for(int i = 0; i < data.length; i++){
			System.out.print(data[i] + " ");
		}
		System.out.println();
		partition(data, 0, 8);
		for(int j = 0; j < data.length; j++){
			System.out.print(data[j] + " ");
		}
		//System.out.println(quickselect(data, 5));
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
		int temp1 = data[rand];
		data[rand] = data[start];
		data[start] = temp1;//swap the first element with the pivot
		int place = start;
		for(int i = 0; i < data.length; i++){
			if(data[i] <= pivot){
				int temp = data[i];
				data[i] = data[place];
				data[place] = temp;
				place++;
			}

			for(int j = 0; j < data.length; j++){
				System.out.print(data[j] + " ");
			}

			System.out.println();
		}
		int temp2 = data[place-1];
		data[place-1] = pivot;
		data[start] = temp2;
		return place;
	}

	public static int quickselect(int[] data, int k){
		return quickselectH(data, k, 0, data.length - 1);
	}
	public static int quickselectH(int[] data, int k, int start, int end){
		if(start == end) return data[k];
		int piv = partition(data, start, end);
		if(piv < k){
			return quickselectH(data, k, piv+1, start);
		}
		if(piv > k){
			return quickselectH(data, k, end, piv);
		}
		return data[piv];
	}
}
