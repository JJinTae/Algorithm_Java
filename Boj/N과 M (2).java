import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int M;
    static int[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[M+1];
        
        comb(1, 1);

        br.close();
        bw.flush();
        bw.close();
    }
    
    static void comb(int cur, int at){
        // 종료조건
        if (cur > M){
            for(int i = 1; i <= M; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        
        // 재귀
        for(int i = at; i <= N; i++){
            arr[cur] = i;
            comb(cur+1, i+1);
        }
    }
}
