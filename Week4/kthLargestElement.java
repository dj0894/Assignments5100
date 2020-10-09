import java.util.*;

public class kthLargestElement {
    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter number of elements in array");

        int n=sc.nextInt();
        int arr[] = new int[n];
        if(n>0) {
            System.out.println("Enter elements of array");

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println("Enter value of k");

            int k=sc.nextInt();

            Arrays.sort(arr);

            System.out.println(arr[n-k]);
        }
        else{
            System.out.println("Size of array should be greater than zero.Array is empty.");
        }



    }

}
