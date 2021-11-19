import java.io.*;
import java.util.*;

public class Main {
  
  static HashMap<String, Integer> map;
  static BufferedWriter bw;
  static int[] parent; 
  static int[] count;
  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    
    int T = Integer.parseInt(br.readLine());

    for(int t = 0; t < T; t++){
      int F = Integer.parseInt(br.readLine());
      parent = new int[1000001];
      count = new int[1000001];
      map = new HashMap<>();
      int index = 0;
      Arrays.fill(count, 1);

      for(int f = 0; f < F; f++){
        st = new StringTokenizer(br.readLine());
        String first = st.nextToken();
        String second = st.nextToken();

        if(map.putIfAbsent(first, index) == null){
          parent[index] = index;
          index++;
        }
        if(map.putIfAbsent(second, index) == null){
          parent[index] = index;
          index++;
        }
        
        int x = map.get(first);
        int y = map.get(second);
        // union
        bw.write(union(x, y) + "\n");
      }
    }
    br.close();
    bw.flush();
    bw.close();
  }
  // Union 집합에 합쳐주는 연산
  static int union(int x, int y){
    int pX = find(x);
    int pY = find(y);

    if(pX != pY){
      if (pX < pY){
        parent[pY] = pX;
        count[pX] += count[pY];
        return count[pX];
      } else {
        parent[pX] = pY;
        count[pY] += count[pX];
        return count[pY];
      }
    }
    return count[pX];
  }

  // Find 집합을 찾는 연산
  static int find(int index){
    if(index == parent[index]){
      return parent[index];
    } else{
      int y = find(parent[index]);
      parent[index] = y;
      return y;
    }
  }
}