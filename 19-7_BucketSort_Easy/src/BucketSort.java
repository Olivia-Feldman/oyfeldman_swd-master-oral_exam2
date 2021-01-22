import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author oyfeldman
 * Bucketsort class that implements the distribution and gathering pass of the bucket algirithm
 */
public class BucketSort {

    /**
     * The sort method creates a new linked list that stores values in a bucket
     *
     * @param array array to be sorted
     * @param size size of the array
     */
    public void Sort(int array[], int size) {

        /**
         * creates a new list array of the size of the array passed -1
         */
        List<Integer>[] buckets = new List[size];
        /**
         * assigns a list to each index of buckets
         */
        for (int i = 0; i < size; i++) {

            buckets[i] = new LinkedList<>();
        }


        //assigning elements to bucket row and using hash to map the index
        for (int num : array) {
            buckets[hash(num, size)].add(num);
        }

        //sorts the bucket array  in ascending order
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
        int index = 0;
        // Merge buckets to get sorted array
        for(List<Integer> bucket : buckets){
            for(int num : bucket){
                array[index++] = num;
            }
        }

    }

    /**
     * hash function to find correct index in buckets array
     * @param num int value from array
     * @param size size is n-1 of thr array
     * @return return index number for buckets
     */
    public static int hash(int num, int size ){

        return num/size;

    }



}
