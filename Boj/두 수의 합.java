import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        
        int start = 0;
        int end = Integer.parseInt(br.readLine());
        int[] arr = new int[end];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < end; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int findNum = Integer.parseInt(br.readLine());
        end -= 1;
        while(start < end){
            int sum = arr[start] + arr[end];

            if(sum == findNum){
                answer++;
                start++;
                end--;
            } else if (sum < findNum){
                start++;
            } else if(sum > findNum){
                end--;
            }
        }

        bw.write(answer + "");

        bw.flush();
        bw.close();
        br.close();

        
    }
}