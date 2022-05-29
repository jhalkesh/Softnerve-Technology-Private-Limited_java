import java.util.*;
public class Leader{
   public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int[] arr = new int[n];
      for(int i = 0; i<n; i++){
         arr[i] = sc.nextInt();
      }
      for(int i = 0; i<n/2;i++){
         int a = arr[i];
         arr[i] = arr[n-i-1];
         arr[n-i-1] = a;
      }
      int max= -1000;
      for(int i = 0; i<n; i++){
         if(arr[i]>max){
            System.out.print(arr[i]+" ");
            max = arr[i];
         }
      }
   }
}