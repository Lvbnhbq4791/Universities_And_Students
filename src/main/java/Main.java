public class Main {
    public static void main(String[] args) {
        University university = new University()
                .setId("4791")
                .setFullName("Российский Государственный Университет")
                .setShortName("РГУ")
                .setYearOfFoundation(1855)
                .setMainProfile(StudyProfile.HISTORY);
        System.out.println(university);
        Student student = new Student()
                .setFullName("Иванов Иван Иванович")
                .setUniversityId("4791")
                .setCurrentCourseNumber(156)
                .setAvgExamScore(8.5F);
        System.out.println(student);
    }
}
