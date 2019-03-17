public class Quick{

	public static void swap(int[] data, int a, int b){
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}
	/*Modify the array such that:
 *1. Only the indices from start to end inclusive are considered in range
 *2. A random index from start to end inclusive is chosen, the corresponding 
 *   element is designated the pivot element. 
 *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
 *4. all elements in range that are larger than the pivot element are placed after the pivot element.
 *@return the index of the final position of the pivot element.
 */
	public static int partition(int[] data, int start, int end){
      int piv = (int)(Math.random() * (end - start)) + start;
      if (piv != start){//make sure pivot is at the start, and update the index of the pivot
        swap(data,start,piv);
        piv = start;
        start++;//we're sorting stuff after the pivot
      }
      while (start != end){//we're gonna use start and end to control the boundaries
        if (data[start] > data[piv]){
          swap(data,start,end);
          end--;//if it's greater than the pivot, move it to the end and adjust the bound accordingly
        }
        else{//otherwise we don't need to do anything so we move on
          start++;
        }
      }
      if (data[start] <= data[piv]){
       swap(data,piv,start);
       piv = start;//if it's less than or equal to the pivot, move it to the start and adjust the bound accordingly
      }
      else {
       swap(data,piv,start-1);//otherwise we move the pivot back
       piv = start-1;
      }

      return piv;
    }

	public static int quickselect(int[] data, int k){
		int lo = 0;
		int hi = data.length - 1;//initialize your lo and hi
	  	int piv = partition(data, lo, hi);
  		while(piv != k){//we stop when we know index k is in the right spot
    	if (k < piv){
      		hi = piv - 1;//we zero in from above
    	}

	    if (k > piv){
      		lo = piv+1; //we zero in from below
    	}
    		piv = partition(data,lo,hi);
  		}
  		return data[k];
	}
	
	public static void quicksort(int[] data){
		quicksortH(data, 0, data.length - 1);
	}

	public static void quicksortH(int[] data, int start, int end){
		if(start >= end) return;
		int piv = partition(data, start, end);
		quicksortH(data, start, piv - 1);
		quicksortH(data, piv + 1, end);
	}
}
