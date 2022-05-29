import java.util.ArrayList;
import java.util.Scanner;
class XORQuestion{
    public static int combination(int arr[], int data[], int start, int end, int index, int r, int sum){ 
            if(index == r){ 
                    String l = "0";
                    for(int j = 0; j < r; j++){
                           String a = Integer.toBinaryString(data[j]);
                           l = getXOR(l,a);
                    }
                    sum = sum + Integer.parseInt(l,2);
            } 
            for(int i = start; i <= end && end - i + 1 >= r - index; i++){ 
                    data[index] = arr[i]; 
                    sum = combination(arr, data, i+1, end, index+1, r, sum); 
            } 
            return sum;
    } 
    static String addZeros(String str, int n){
        for (int i = 0; i < n; i++){
            str = "0" + str;
        }
        return str;
    }
    static String getXOR(String a, String b){
     
        int aLen = a.length();
        int bLen = b.length();
        if (aLen > bLen){
            b = addZeros(b, aLen - bLen);
        }
        else if (bLen > aLen){
            a = addZeros(a, bLen - aLen);
        }
     
        int len = Math.max(aLen, bLen);
        String res = "";
         
        for (int i = 0; i < len; i++){
            if (a.charAt(i) == b.charAt(i))
                res += "0";
            else
                res += "1";
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sr = new Scanner(System.in);
        int n = sr.nextInt();
        int a[] = new int [n];
        int sum = 0;
        for(int i=0;i<n;i++){
            a[i] = sr.nextInt();
            sum = sum + a[i];
        }
        int data [] = new int[n];
        
        for(int i = 2; i<=n; i++){
            sum = combination(a,data,0,n-1,0,i,sum);
        }
        System.out.print(sum);
    }
}