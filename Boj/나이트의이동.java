import java.io.*;
import java.util.*;

public class Main {
  static int[] dx = {-2, -1, -2, -1, 1, 2, 2, 1};
  static int[] dy = {-1, -2, 1, 2, 2, 1, -1, -2};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());


    for (int i = 0; i < T; i++){
      int I = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      int startX = Integer.parseInt(st.nextToken());
      int startY = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      int endX = Integer.parseInt(st.nextToken());
      int endY = Integer.parseInt(st.nextToken());

      boolean[][] visited = new boolean[I][I];
      Queue<Pair> qu = new LinkedList<>();

      qu.offer(new Pair(startX, startY, 0));
      visited[startX][startY] = true;

      while(!qu.isEmpty()){
        Pair pair = qu.poll();
        int nowX = pair.x;
        int nowY = pair.y;
        int nowCount = pair.count;

        if (nowX == endX && nowY == endY){
          bw.write(nowCount + "\n");
        }

        for(int m = 0; m < 8; m++){
          int x = nowX + dx[m];
          int y = nowY + dy[m];

          if(x > -1 && x < I && y > -1 && y < I){
            if(!visited[x][y]){
              qu.offer(new Pair(x, y, nowCount + 1));
              visited[x][y] = true;
            }
          }
        }
      }
    }


    br.close();
    bw.flush();
    bw.close();
  }
  static class Pair {
    int x;
    int y;
    int count;
    Pair(int startX, int startY, int count){
      this.x = startX;
      this.y = startY;
      this.count = count;
    }
  }
}
