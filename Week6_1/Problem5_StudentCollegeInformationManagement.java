public class Problem5_StudentCollegeInformationManagement {
    static class Student {
        String name;
        double attendance;
        static String collegeName = "SRM Institute of Science and Technology";
        static int studentCount = 0;

        Student(String name, double attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++;
        }

        static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }
    }

    public static void main(String[] args) {
        new Student("Abhinav", 90);
        new Student("Ravi", 85);
        Student.printCollegeInfo();
    }
}
