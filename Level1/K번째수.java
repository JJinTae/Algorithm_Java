import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < commands.length; i++){
            list = new ArrayList();
            for (int j = commands[i][0]-1; j < commands[i][1]; j++){
                list.add(array[j]);
            } // for j
            list.sort(Comparator.naturalOrder());
            answer[i] = list.get(commands[i][2]-1);
        } // for i
        
        
        return answer;
    }
}
