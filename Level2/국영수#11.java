import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Comparable - compareTo, Comparator - compare 객체를 비교할 수 있또록 한다.
// Comparable 자기자신과 파라미터 객체 비교
// Comparator 파라미터로 들어오는 두 객체 비교
// 참고 : https://st-lab.tistory.com/243

class Student implements Comparable<Student>{
    String name;
    int korean, math, english;
    public Student (String name, int korean, int english, int math){
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }
    @Override
    public int compareTo(Student student){
        if(this.korean < student.korean){
            return 1;
        } 
        else if(this.korean == student.korean){
            if(this.english > student.english) {
                return 1;
            } 
            else if(this.english == student.english) {
                if(this.math < student.math){
                    return 1;
                } 
                else if(this.math == student.math){
                    if(this.name.compareTo(student.name) > 0){
                        return 1;
                    }
                }
            }
        }
        return -1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String name;
        int korean, english, math;
        Student student;

        int n = Integer.parseInt(br.readLine());
        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            korean = Integer.parseInt(st.nextToken());
            english = Integer.parseInt(st.nextToken());
            math = Integer.parseInt(st.nextToken());
            student = new Student(name, korean, english, math);
            students.add(student);
        }
        Collections.sort(students);
        
        for(int i = 0; i < n; i++){
            bw.write(students.get(i).name + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
