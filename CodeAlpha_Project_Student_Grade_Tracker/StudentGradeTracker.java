import java.util.*;

public class StudentGradeTracker {

    public static ArrayList<Integer> students(Scanner obj){
        System.out.print("Enter Number of Students : ");
        int students = obj.nextInt();
        ArrayList <Integer> studentsMarks = new ArrayList<>(students+1);
        for (int i = 0,j = 1; i < students; i++, j++) {
            System.out.print("Enter Marks for Student "+j+" : ");
            int marks = obj.nextInt();
            studentsMarks.add(marks);
        }
        System.out.println();
        return studentsMarks;
    }

    public static int maxMarks(ArrayList<Integer> marks){
        Collections.sort(marks);
        int maxMarks = marks.get(marks.size()-1);
        return maxMarks;
    }

    public static int minMarks(ArrayList<Integer> marks){
        Collections.sort(marks);
        int minMarks = marks.get(0);
        return minMarks;
    }

    public static double averageMarks(ArrayList<Integer> marks){
        int sum = 0;
        for (int mark : marks) {
            sum = sum + mark;
        }
        int length = marks.size();

        if (length == 0) {
            return 0;
        } else {
            double averageMarks = (double) sum / length;
            return averageMarks;
        }

    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        ArrayList <Integer> marks = students(obj);
        int maxMarks = maxMarks(marks);
        int minMarks = minMarks(marks);
        double averageMarks = averageMarks(marks);
        System.out.println("The average marks are : "+averageMarks);
        System.out.println("The maximum marks are : "+maxMarks);
        System.out.println("The minimum marks are : "+minMarks);
        obj.close();
    }


}
