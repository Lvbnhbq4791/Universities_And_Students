package model;

import enums.StudyProfile;

public class Statistics {
    StudyProfile trainingProfile;
    float averageExamScore;
    int numbersStudents;
    int numbersUniversities;
    String namesUniversities;

    public Statistics() {
        this.trainingProfile = trainingProfile;
        this.averageExamScore = averageExamScore;
        this.numbersStudents = numbersStudents;
        this.numbersUniversities = numbersUniversities;
        this.namesUniversities = namesUniversities;
    }

    public StudyProfile getTrainingProfile() {
        return trainingProfile;
    }

    public float getAverageExamScore() {
        return averageExamScore;
    }

    public int getNumbersStudents() {
        return numbersStudents;
    }

    public int getNumbersUniversities() {
        return numbersUniversities;
    }

    public String getNamesUniversities() {
        return namesUniversities;
    }

    public Statistics setTrainingProfile(StudyProfile trainingProfile) {
        this.trainingProfile = trainingProfile;
        return this;
    }

    public Statistics setAverageExamScore(float averageExamScore) {
        this.averageExamScore = averageExamScore;
        return this;
    }

    public Statistics setNumbersStudents(int numbersStudents) {
        this.numbersStudents = numbersStudents;
        return this;
    }

    public Statistics setNumbersUniversities(int numbersUniversities) {
        this.numbersUniversities = numbersUniversities;
        return this;
    }

    public Statistics setNamesUniversities(String namesUniversities) {
        this.namesUniversities = namesUniversities;
        return this;
    }

    @Override
    public String toString() {
        return "Профиль = " + trainingProfile + '\n' +
                "Средний балл = " + averageExamScore + '\n' +
                "Кол-во Студентов = " + numbersStudents + '\n' +
                "Кол-во Универ-в = " + numbersUniversities + '\n' +
                "Названия Универ-в = " + namesUniversities;



    }
}
