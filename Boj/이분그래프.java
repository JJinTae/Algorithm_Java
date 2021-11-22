import java.io.*;
import java.util.*;

public class Main {
  static boolean isBipartite;
  static int[] visited; // 0 미방문 1 RED, 2 BLUE
  static ArrayList<ArrayList<Integer>> graph;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int K = Integer.parseInt(br.readLine());
    for (int k = 0; k < K; k++){
      st = new StringTokenizer(br.readLine());
      int V = Integer.parseInt(st.nextToken());
      int E = Integer.parseInt(st.nextToken());
      graph = new ArrayList<>();

      // 입력 초기화
      for(int i = 0; i <= V; i++){
        graph.add(new ArrayList<Integer>());
      }
      for(int i = 0; i < E; i++){
        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());

        graph.get(first).add(second);
        graph.get(second).add(first);
      }

      isBipartite = false;
      visited = new int[V+1];

      // dfs
      for(int i = 1; i <= V; i++){
        if(visited[i] == 0){
          dfs(i, 1);
        }
      }

      if(isBipartite){
        bw.write("NO\n");
      } else{
        bw.write("YES\n");
      }
    }
    br.close();
    bw.flush();
    bw.close();
  }

  static void dfs(int depth, int color){
    // 종료 조건
    if (isBipartite){
      return;
    }
    if(visited[depth] != 0){
      // 컬러값 검사
      if(visited[depth] != color){
        isBipartite = true;
      }
      return;
    }

    // 재귀 
    // 방문한적이 없다면
    visited[depth] = color;
    int nextColor = changeColor(color);

    for(int i = 0; i < graph.get(depth).size(); i++){
      int x = graph.get(depth).get(i);
      dfs(x, nextColor);
    }
  }

  static int changeColor(int color){
    if(color == 1){
      return 2;
    } else if(color == 2){
      return 1;
    } else{
      return 0;
    }
  }
}
