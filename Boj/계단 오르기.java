import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{

    // 참고 https://st-lab.tistory.com/132

    static Integer dp[];
    static int stairs[];


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());

        dp = new Integer[n + 1];
        stairs = new int [n + 1];

        for (int i = 1; i <= n; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = stairs[0];
        dp[1] = stairs[1];

        if(n >= 2){
            dp[2] = stairs[1] + stairs[2];
        }

        bw.write(find(n) + "");


        bw.flush();
        bw.close();
        br.close();
    }

    static int find(int N){
        if(dp[N] == null){
            dp[N] = Math.max(find(N - 2), find(N - 3) + stairs[N - 1]) + stairs[N];
        }

        return dp[N];
    }

}