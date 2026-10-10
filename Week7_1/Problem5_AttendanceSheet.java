public class Problem5_AttendanceSheet {
    static class AttendanceSheet {
        private final String[] names;
        private int count = 0;

        AttendanceSheet(int capacity) {
            names = new String[capacity];
        }

        void markPresent(String name) {
            if (isPresent(name)) return;
            if (count < names.length) names[count++] = name;
        }

        int getPresentCount() {
            return count;
        }

        boolean isPresent(String name) {
            for (int i = 0; i < count; i++) {
                if (names[i].equals(name)) return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");
        System.out.println(sheet.getPresentCount());
        System.out.println(sheet.isPresent("Ben"));
        System.out.println(sheet.isPresent("Chen"));
    }
}
