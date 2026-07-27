public class Students {

    int id;
    String name;
    int age;
    String course;
    String gender;

    /**
     * Creates a student object
     * @param id student id
     * @param name student name
     * @param age student age
     * @param course student course
     * @param gender student gender
     */
    public Students(int id, String name, int age, String course, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.gender = gender;
    }

    /**
     * Converts student data into a string
     * @return student data
     */
    public String toString() {
        return id + "," + name + "," + age + "," + course  + "," + gender;
    }
}
