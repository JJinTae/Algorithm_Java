import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static Long[][] dp;
    static int N;
    final static long MOD = 1000000000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dp = new Long[N + 1][10];

        for(int i = 0; i < 10; i++){
            dp[1][i] = 1L;
        }

        long result = 0;
        for(int i = 1; i <= 9; i++){
            result += recur(N, i);

        }
        bw.write((result % MOD) + "");

        // 10 다음에는 1만 올 수 있고 19 다음에는 0만 올 수 있다.
        // 그 외에는 +1 -1 모두 올 수 있다.
        bw.flush();
        bw.close();
        br.close();
    }

    // digit은 자릿수, val은 자릿값
    public static long recur(int digit, int val){

        if(digit == 1){
            return dp[digit][val];
        }

        if(dp[digit][val] == null){
            if(val == 0){
                dp[digit][val] = recur(digit - 1, 1);
            } else if(val == 9){
                dp[digit][val] = recur(digit - 1, 8);
            } else{
                dp[digit][val] = recur(digit - 1, val - 1 ) + recur(digit - 1, val + 1);
            }
        }
        return dp[digit][val] % MOD;

    }
}
