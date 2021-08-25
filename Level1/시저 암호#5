class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        char a = 'A';
        System.out.println(a + 1);
        // A ~ Z : 65 ~ 90
        // a ~ z : 97 ~ 122
        
        for (int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if (temp != ' '){
                int num = temp + n;
                if(Character.isUpperCase(temp)){ // 대문자
                    if (num > 90) num -= 26;
                }else{ // 소문자)
                    if (num > 122) num -= 26;
                }
                answer += (char)num;
                
            }else{
                answer += " ";
            }
        }
        return answer;
    }
}
