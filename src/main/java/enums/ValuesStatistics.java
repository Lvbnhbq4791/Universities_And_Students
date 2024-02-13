package enums;

public enum ValuesStatistics {
    TRAINING_PROFILE ("Профиль Обучения"),

    AVERAGE_EXAM_SCORE ("Средний балл за экзамен"),

    NUMBERS_STUDENTS ("Количество студентов"),

    NUMBERS_UNIVERSITIES ("Количество университетов");
    private String valuesStatistics;

    ValuesStatistics(String valuesStatistics) {
        this.valuesStatistics = valuesStatistics;
    }

    public String getValuesStatistics() {
        return valuesStatistics;
    }
}
