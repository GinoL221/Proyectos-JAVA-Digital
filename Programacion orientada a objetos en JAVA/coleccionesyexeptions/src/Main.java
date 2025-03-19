public class Main {
    public static void main(String[] args) {
        University university = new University("Stanford");

        university.generateStudent(1, "John");
        university.generateCourse(20, "Math");

        try{
            university.suscribeStudent(20, 1);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}