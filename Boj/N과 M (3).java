import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static BufferedWriter bw;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[M+1];
        
        dfs(1);

        br.close();
        bw.flush();
        bw.close();
    }
    
    static void dfs(int cur) throws IOException{
        if(cur > M){
            for(int i = 1; i <= M; i++){
                bw.write(arr[i] + " ");
            }
            bw.newLine();
            return;
        }
        
        for(int i = 1; i <= N; i++){
            arr[cur] = i;
            dfs(cur + 1);
        }
    }    
    
}