import java.util.Arrays;

class Student{
    int id;
    String name;

    Student(int id, String name){
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name){
        this.name=name;
    }
}

class Course{

    static String name;
    static int numberOfStudent;
    static int capacity=10;

    static Student[] registeredStudents=new Student[capacity];

    Course(String name){
        this.name=name;
    }


    public String getName(){
        return name;

    }

    public int getNumberOfStudent(){
        return numberOfStudent;
    }

    public static Student[] getRegisteredStudents(){

        for(int i=0;i<numberOfStudent;i++){
            System.out.println(registeredStudents[i].getId()+" "+registeredStudents[i].getName());

        }
        return registeredStudents;

    }

    public static boolean isFull() {

        if (numberOfStudent <=capacity) {
            return false;
        } else {
            return true;
        }

    }
    public static void registerStudent(Student student){
        if(isFull()){
            System.out.println("Hello "+ student.name+"!!  You cannot register for class as class is full");
        }else {

            registeredStudents[numberOfStudent] = new Student(student.getId(), student.getName());
            numberOfStudent++;
            //System.out.println("");
        }
    }

}

public class Test {

    public static void main(String[] args) {

        Course course1 = new Course("Maths");
        Student student1 = new Student(121, "Meena");
        Student student2 = new Student(122, "Jason");
        Student student3 = new Student(123, "Tina");
        Student student4 = new Student(124, "Jeff");
        Student student5 = new Student(125, "Manish");
        Student student6 = new Student(126, "Alma");
        Student student7 = new Student(127, "Leone");

        //adding students one by one
      course1.registerStudent(student1);


      //adding students in one go
       Arrays.asList(student2, student3,student4,student5,student6,student7).stream().forEach
                    (student -> course1.registerStudent(student));

       System.out.println("Students registered in  "+ course1.getName());

       course1.getRegisteredStudents();



    }
}