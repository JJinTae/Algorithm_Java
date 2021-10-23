class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        
        // table 초기화
        int num = 1;
        int[][] table = new int[rows][columns];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                table[i][j] = num++;
            }
        }
        
        for(int i = 0; i < queries.length; i++){
            int nowX = queries[i][0] - 1;
            int nowY = queries[i][1] - 1;
            
            int startX = queries[i][0] - 1;
            int startY = queries[i][1] - 1;
            int endX = queries[i][2] - 1;
            int endY = queries[i][3] - 1;
            
            int temp = table[startX][startY];
            int before = 0;
            for (int a = startY + 1; a <= endY; a++){
                before = table[startX][a];
                table[startX][a] = temp;
                temp = before;
                System.out.println(table[startX][a] + " ");
            }
            
            for (int b = startX + 1; b <= endX; b++){
                before = table[b][endY];
                table[]
            }
        }
        
        
        
        
        return answer;
    }
}