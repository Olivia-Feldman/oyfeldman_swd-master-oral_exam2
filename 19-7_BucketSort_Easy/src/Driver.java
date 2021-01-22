import java.util.Arrays;

/**
 * Driver class
 */
public class Driver {
    /**
     *
     * @param args  main method that call BucketSort Class
     */
    public static void main(String[] args){
        /**
         * creates new object of BucketSort class
         */
        BucketSort test = new BucketSort();
        /**
         *  test array to pass ot function
         */
        int [] array  = new int[]{29,25,3,49,9,37,21,43,100,5,78,99};
        // calling the sort method and passing the n-1 size and array
        test.Sort(array,array.length-1);

        //printing out the bucket sorted array.
        System.out.println(Arrays.toString(array));




    }


}
