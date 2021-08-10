import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] people1 = {1, 2, 3, 4, 5};
        int[] people2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] people3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] count = {0, 0, 0};
        
        for (int i = 0; i < answers.length; i++){
            if(answers[i] == people1[i % people1.length])
                count[0]++;
            if(answers[i] == people2[i % people2.length])
                count[1]++;
            if(answers[i] == people3[i % people3.length])
                count[2]++;
        }
        
        int max = Math.max(count[0], Math.max(count[1], count[2]));
        System.out.println(max);
        
        List<Integer> list = new ArrayList();
        for (int i = 0; i < count.length; i++){
            if (count[i] == max) list.add(i+1);
        }
        System.out.println(list);
        
        int[] answer = new int[list.size()];
        
        for (int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
