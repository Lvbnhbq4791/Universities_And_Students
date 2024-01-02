public enum StudyProfile {
    MEDICINE ("Медицина"),
    HISTORY ("История"),
    JURISPRUDENCE ("Юриспруденция"),
    ;
    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
