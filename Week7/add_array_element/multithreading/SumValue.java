package add_array_element.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class SumValue implements Callable<Long> {

    int arr[];
    int start;
    int end;

    SumValue(int[] arr, int start, int end){
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


    /*get sum of an array using 4 threads*/
    static long sum(int[] arr, int start, int end) {
       // System.out.println("Thread"+Thread.currentThread().getName());
        int sum=0;
        for(int i=start;i<=end;i++){
            sum=sum+arr[i];
        }
        //System.out.println(sum);
        return sum;

    }

    @Override
    public Long call() throws Exception {

        return  sum(arr, start, end);
    }
}

class Main{

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //int[] arr={10,11,21,10,10,10,1,1,2,2};
        int[] arr = new int[4000000];

       SumValue.generateRandomArray(arr);

        int blockSize=10000;

        int noOfBlocks=(int)Math.ceil(((double)arr.length/blockSize));

        //System.out.println(" NoOfBlocks "+noOfBlocks);

        ExecutorService executor= Executors.newFixedThreadPool(4);

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

            future=executor.submit(new SumValue(arr, start, end));
            //System.out.println("future object innarray"+future.get());
            // Waiting for future object to complete
            while(!future.isDone()){

                Thread.yield();// Pass control to other threads if there is any waiting time for CPU
            }

            futureObjectList.add(future.get());

            //System.out.println(futureObjectList);
        }

        Long totalSum=0L;

        for(int i=0;i<futureObjectList.size();i++){


            totalSum=totalSum+futureObjectList.get(i); // to get the total sum

        }

        System.out.println("Total sum = "+totalSum);
    }
}