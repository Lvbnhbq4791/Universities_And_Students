public class Student {
    String fullName;
    String universityId;
    int currentCourseNumber;
    float avgExamScore;

    public String getFullName() {
        return fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public Student setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    public Student setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }

    public Student setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    @Override
    public String toString() {
        return "Student:" + '\n' +
                "fullName - " + fullName + '\n' +
                "universityId - " + universityId + '\n' +
                "currentCourseNumber - " + currentCourseNumber + '\n' +
                "avgExamScore - " + avgExamScore;
    }
}
