package JustAlgosy;
import java.util.Scanner;
public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Length Of Array: ");
        int n = scanner.nextInt();
        System.out.println("Number to find: ");
        int key = scanner.nextInt();
        int low=0;
        int high =n-1;
        int[] array = new int[n];
        System.out.println("fill sorted array with "+n+ " symbols: ");
        for(int i=0;i<array.length-1;i++)
            array[i]=scanner.nextInt();
        System.out.println(binarySearch(array,key,low,high));
    }
    public static int binarySearch(int[] arr,int key,int low,int high){
        int mid = low+(high-low)/2;

        if(arr[mid]<key){
            low = mid+1;
            return binarySearch(arr,key,low,high);
        }
        else if(arr[mid]>key){
            high = mid-1;
            return binarySearch(arr,key,low,high);
        }
        else if(arr[mid] ==key){
            return mid;
        }
        else return -1; //if we will not find our number
    }
}
