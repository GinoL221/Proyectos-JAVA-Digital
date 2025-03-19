public class Student {
    private Integer id;
    private String name;
    private Double avegareGrades;

    public Student(Integer id, String name, Double avegareGrades) {
        this.id = id;
        this.name = name;
        this.avegareGrades = avegareGrades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", avegareGrades=" + avegareGrades +
                '}';
    }
}
