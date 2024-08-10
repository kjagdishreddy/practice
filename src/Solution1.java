import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

class Solution1 {

    public static void main(String[] args) {
        List<Integer> grades = new ArrayList<Integer>();
        grades.add(73);
        grades.add(67);
        grades.add(38);
        grades.add(33);
        List<Integer> roundedGrades = gradingStudents(grades);

        for(int grade : roundedGrades) {
            System.out.println(grade);
        }
    }
    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        List<Integer> roundGrades = new ArrayList<Integer>();
        for (int grade : grades) {
            if (grade < 38 ) {
                roundGrades.add(grade);
            } else {
                int mod = grade % 5;
                if (mod % 5 < 3) {
                    int add = 5 - grade % 5 ;
                    grade = grade + add;
                    roundGrades.add(grade);
                } else {
                    roundGrades.add(grade);
                }
            }
            roundGrades.add(grade);
        }
        return roundGrades;

    }

}