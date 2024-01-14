public enum ValuesStudent {
    UNIVERSITY_ID("ID Университета"),
    FULL_NAME("Полное имя"),
    CURRENT_COURSE_NUMBER("Курс"),
    AVG_EXAM_SCORE("Средний балл");
    private String valuesStudent;

    ValuesStudent(String valuesStudent) {
        this.valuesStudent = valuesStudent;
    }

    public String getValuesStudent() {
        return valuesStudent;
    }
}
