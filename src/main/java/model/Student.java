package model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Student {
    @SerializedName("Фамилия И.О.")
    String fullName;
    @SerializedName("ID Университета")
    String universityId;
    @SerializedName("Номер курса")
    int currentCourseNumber;
    @SerializedName("Средний балл на экзамене")
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
        return "objects.Student: "+
                "fullName - " + fullName + ", " +
                "universityId - " + universityId + ", " +
                "currentCourseNumber - " + currentCourseNumber + ", " +
                "avgExamScore - " + avgExamScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return currentCourseNumber == student.currentCourseNumber && Float.compare(avgExamScore, student.avgExamScore) == 0 && Objects.equals(fullName, student.fullName) && Objects.equals(universityId, student.universityId);
    }
}
