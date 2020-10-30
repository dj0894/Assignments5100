package animalhospital;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Cat extends Pet implements Boardable {

    private String hairLength;
    private Date boardingStartDate;
    private Date endDate;

    Cat(String petName, String ownerName, String petColor,String hairLength) {
        super(petName, ownerName, petColor);
        this.hairLength=hairLength;
    }


    public String getHairLength() {
        return hairLength;
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

        return "CAT:\n"+this.getPetName()+" owned by "+this.getOwnerName()+"\nColor: "+this.getPetColor()+"\nSex: "+super.getSex()+"\nHair: "+this.getHairLength();
    }

    public static  void main(String args[]) throws ParseException {
        Cat cat1=new Cat("Tom","Bob","black","short");
        cat1.setSex(3);
        System.out.println(cat1.toString());
        cat1.setBoardStart(7,20,1994);
        cat1.setBoardEnd(7,20,1995);

        System.out.println(cat1.boarding(8,20,1994));



    }
}
