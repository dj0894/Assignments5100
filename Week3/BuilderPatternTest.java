class Professor{

    int id;       //mandatory
    String firstName;//mandatory
    String lastName;// optional

    private Professor(int id,String firstName,String lastName){
        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public int getId(){
        return id;

    }
    public String getFirstName(){
        return firstName;
    }
    public  String getLastName(){
        return lastName;
    }

    public static class Builder{
        int id;
        String firstName;
        String lastName;

        public Builder(int id,String firstName){
            this.id=id;
            this.firstName=firstName;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder setLastName(String lastName){
            this.lastName=lastName;
            return this;
        }

        public Professor build() {

            return new Professor(id, firstName, lastName);
        }
    }

}


public class BuilderPatternTest {

    public static void main(String args[]){


        Professor prof1=new Professor.Builder(1,"Siva").build();

        System.out.println(prof1.id+" "+prof1.firstName+" " +prof1.lastName );// prof1  is created with lastName=null;

        Professor prof2=new Professor.Builder(2,"Manish").setLastName("Sood").build();

        System.out.println(prof2.id+" "+prof2.firstName+" " +prof2.lastName );// prof2  is created with lastName=Sood;
    }
}
