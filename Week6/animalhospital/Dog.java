package animalhospital;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dog extends Pet implements Boardable {

    private String size;
    private Date boardingStartDate;
    private Date endDate;




    Dog(String petName, String ownerName, String petColor,String size) {
        super(petName, ownerName, petColor);
        this.size=size;

    }

    public String getSize() {
        return size;
    }



    @Override
    public void setBoardStart(int month, int day, int year) throws ParseException {
        SimpleDateFormat sd=new SimpleDateFormat("mm-dd-yyyy");

        this.boardingStartDate=sd.parse(month+"-"+day+"-"+year);
    }

    @Override
    public void setBoardEnd(int month, int day, int year) throws ParseException {
        SimpleDateFormat sd=new SimpleDateFormat("mm-dd-yyyy");
        this.endDate=sd.parse(month+"-"+day+"-"+year);
    }

    @Override
    public boolean boarding(int month, int day, int year) throws ParseException {
        SimpleDateFormat sd=new SimpleDateFormat("mm-dd-yyyy");
        Date date=sd.parse(month+"-"+day+"-"+year);

        if(this.boardingStartDate.compareTo(date)<=0&&this.endDate.compareTo(date)>=0){
            return true;
        }


        return false;
    }

    @Override
    public String toString() {

        StringBuilder sb=new StringBuilder("DOG:\n"+getPetName()+" owned by "+getOwnerName()+"\nColor: "+getPetColor()+"\nSex: "+getSex()+"\nSize: "+getSize());
        return  sb.toString();
    }

    public static  void main(String args[]) throws ParseException {
        Dog dog1=new Dog("Spot","Susan","white","medium");
        dog1.setSex(3);
        System.out.println(dog1.toString());
        dog1.setBoardStart(7,20,1994);
        dog1.setBoardEnd(7,20,1995);
        System.out.println(dog1.boarding(7,20,1995));


    }
}
