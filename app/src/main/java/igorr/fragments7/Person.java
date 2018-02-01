package igorr.fragments7;

/**
 * Created by Igorr on 29.01.2018.
 */

public class Person {
    private String name;
    private String telNumber;
    private int photoId;

    public void setName(String name) {
        this.name = name;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public int getPhotoId() {
        return photoId;
    }

    public String getName() {
        return name;
    }

    public String getTelNumber() {
        return telNumber;
    }

    //Случайный номер
    public static String generateRandTel() {
        String ret = "8 9";
        Double gen = Math.random();

        for (int i = 0; i < 3; i++) {
            ret = ret.concat(gen.toString().substring(i + 2, 2 * i + 4));
            ret += " ";
        }
        return ret;
    }

    //Конструктор класса
    public Person(String name, String telNumber, int photoId) {
        this.name = name;
        this.telNumber = telNumber;
        this.photoId = photoId;
    }
}
