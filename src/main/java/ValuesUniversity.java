public enum ValuesUniversity {
    ID("ID"),
    FULL_NAME("Полное имя"),
    SHORT_NAME("Короткое имя"),
    YEAR_OF_FOUNDATION("Год основания"),
    PROFILE_NAME("Профиль обучения");
    private String valuesUniversity;

    ValuesUniversity(String valuesUniversity) {
        this.valuesUniversity = valuesUniversity;
    }

    public String getValuesUniversity() {
        return valuesUniversity;
    }
}
