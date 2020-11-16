package max_array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class MaxArray implements Callable<Long> {

    int arr[];
    int start;
    int end;

    MaxArray(int[] arr, int start, int end){
        this.arr=arr;
        this.start=start;
        this.end=end;
    }

    static void generateRandomArray(int[] arr) {
        Random rd = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt();
        }
    }


    /*get max of sub array*/
    static long max(int[] arr, int start, int end) {
        int max=arr[0];
        for(int i=start;i<=end;i++){
           if(max<arr[i]){
               max=arr[i];
           }
        }
        //System.out.println("max = "+ max);
        return max;

    }

    @Override
    public Long call() throws Exception {

        return  max(arr, start, end);
    }
}

class Main{

    public static void main(String[] args) throws ExecutionException, InterruptedException {

       // int[] arr={-1,-3,-6,9,7,8,5};
        int[] arr = new int[4000000];
        MaxArray.generateRandomArray(arr);

        int blockSize=1000;

        int noOfBlocks=(int)Math.ceil(((double)arr.length/blockSize));

        //System.out.println(" NoOfBlocks "+noOfBlocks);

        ExecutorService executor= Executors.newFixedThreadPool(5);

        List<Long> futureObjectList=new ArrayList<>();

        Future<Long> future = null;

        int start=0;
        int end;
        for(int i=1;i<=noOfBlocks;i++) {

            start = (i - 1) * blockSize;
            end = start + blockSize - 1;

            if (end >=arr.length) {
                end = arr.length - 1;
            }

            future=executor.submit(new MaxArray(arr, start, end));
            //System.out.println("future object innarray"+future.get());
            // Waiting for future object to complete
            while(!future.isDone()){

                Thread.yield();// Pass control to other threads if there is any waiting time for CPU
            }

            futureObjectList.add(future.get());

           // System.out.println(futureObjectList);
        }

        Long maxValue=futureObjectList.get(0);

        for(int i=1;i<futureObjectList.size();i++){

            if(maxValue<futureObjectList.get(i)){
                maxValue=futureObjectList.get(i);
            }

        }

        System.out.println("Max value in Array = "+maxValue);
    }
}
