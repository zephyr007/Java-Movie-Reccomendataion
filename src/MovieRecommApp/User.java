package MovieRecommApp;

public class User {
    public int Id;
    public int age;
    public char gender;
    public String occ;
    public double zip;

    public User(int id, int age, char gender, String occ, double zip) {
        Id = id;
        this.age = age;
        this.gender = gender;
        this.occ = occ;
        this.zip = zip;
    }

    public int getId() {
        return Id;
    }

    public int getAge() {
        return age;
    }

    public char getGender() {
        return gender;
    }

    public String getOcc() {
        return occ;
    }

    public double getZip() {
        return zip;
    }
}
