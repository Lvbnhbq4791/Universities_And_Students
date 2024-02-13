package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Student;
import model.University;

import java.lang.reflect.Type;
import java.util.List;

public class JsonUtil {
    private static JsonUtil classJsonUtil;
    private Gson serializer;
    private Gson deserializer;
    private JsonUtil() {
        this.serializer = new GsonBuilder().setPrettyPrinting().create();
        this.deserializer = new GsonBuilder().create();
    }

    public static JsonUtil getClassJsonUtil() {
        if (classJsonUtil == null) {
            classJsonUtil = new JsonUtil();
        }
        return classJsonUtil;
    }

    public String serializationObjectStudent(Student student) {
        return serializer.toJson(student);
    }

    public Student deserializationObjectStudent(String jsonStudent) {
        return deserializer.fromJson(jsonStudent, Student.class);
    }
    public String serializationListStudent(List<Student> listStudent) {
        return serializer.toJson(listStudent);
    }
    public List<Student> deserializationListStudent(String jsonListStudent) {
        Type itemsListType = new TypeToken<List<Student>>() {}.getType();
        return deserializer.fromJson(jsonListStudent, itemsListType);
    }
    public String serializationObjectUniversity(University university) {
        return serializer.toJson(university);
    }
    public University deserializationObjectUniversity(String jsonUniversity) {
        return deserializer.fromJson(jsonUniversity, University.class);
    }
    public String serializationListUniversity(List<University> listUniversity) {
        return serializer.toJson(listUniversity);
    }
    public List<University> deserializationListUniversity(String jsonListUniversity) {
        Type itemsListType = new TypeToken<List<University>>() {}.getType();
        return deserializer.fromJson(jsonListUniversity, itemsListType);
    }
}
