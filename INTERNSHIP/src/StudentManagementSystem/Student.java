package StudentManagementSystem;
    public class Student {
        private String name;
        private int rollNumber;
        private String grade;

        public Student(String name, int rollNumber, String grade) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public int getRollNumber() {
            return rollNumber;
        }

        public String getGrade() {
            return grade;
        }

        @Override
        public String toString() {
            return rollNumber + "," + name + "," + grade;
        }

        public static Student fromString(String line) {
            String[] parts = line.split(",");
            return new Student(
                    parts[1],
                    Integer.parseInt(parts[0]),
                    parts[2]
            );
        }
    }

