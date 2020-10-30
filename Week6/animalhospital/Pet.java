package animalhospital;

import java.text.ParseException;

public class Pet {

    private String petName;
    private String ownerName;
    private String petColor;
    protected int sex;

    public static final int MALE=1;
    public static final int FEMALE=2;
    public static final int SPAYED=3;
    public static final int NEUTERED=4;

    Pet(String petName,String ownerName,String petColor){
        this.petName=petName;
        this.ownerName=ownerName;
        this.petColor=petColor;

    }

    public String getPetName() {
        return this.petName;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public String getPetColor() {
        return this.petColor;
    }

    public void setSex(int sexid) {
        this.sex = sexid;
    }

    public  String getSex() {

        if(this.sex==1){
            return "Male";
        }else if(sex==2){
            return "Female";
        }else if(sex==3){
            return "Spayed";
        }
    return "Neutered";
    }

    @Override
    public String toString() {
        return this.petName+" owned by "+this.ownerName+"\nColor: "+this.getPetColor()+"\nSex: "+this.getSex();

    }


    public static  void main(String args[]) throws ParseException {
        Pet pet1=new Pet("Spot","Mary","Black and White");
        pet1.setSex(1);
        System.out.println(pet1.toString());

    }
}
