import com.google.gson.annotations.SerializedName;

public class University {
    @SerializedName("Индетификатор")
    String id;
    @SerializedName("Полное имя")
    String fullName;
    @SerializedName("Сокращенное имя")
    String shortName;
    @SerializedName("Дата создания")
    int yearOfFoundation;
    @SerializedName("Основной профиль")
    StudyProfile mainProfile;

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public University setId(String id) {
        this.id = id;
        return this;
    }

    public University setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public University setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    @Override
    public String toString() {
        return "University: "+
                "id - " + id + ", " +
                "fullName - " + fullName + ", " +
                "shortName - " + shortName + ", " +
                "yearOfFoundation - " + yearOfFoundation + ", " +
                "mainProfile - " + mainProfile.getProfileName();
    }
}
