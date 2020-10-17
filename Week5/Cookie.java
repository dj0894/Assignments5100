public class Cookie extends DessertItem {

    private static int cookieNumber;
    private static double prizePerDozen;

    public Cookie(String name, int cookieNumber, double prizePerDozen){
        this.setName(name);
        this.cookieNumber=cookieNumber;
        this.prizePerDozen=prizePerDozen;
    }



    public static int getCookieNumber() {
        return cookieNumber;
    }

    public void setCookieNumber(int cookieNumber) {
        this.cookieNumber = cookieNumber;
    }


    public static double getPrizePerDozen() {
        return prizePerDozen;
    }

    public void setPrizePerDozen(double prizePerDozen) {
        this.prizePerDozen = prizePerDozen;
    }

    @Override
    public int getCost() {

        return (int) Math.round((prizePerDozen*cookieNumber/12));

    }

    @Override
    public String toString() {
        return  getCookieNumber()+" @ "+(getPrizePerDozen()/100)+" /dz. \n"
                +name.substring(0, Math.min(name.length(), DessertShoppe.ITEM_NAME_MAX_LENGTH)) +" "+DessertShoppe.cents2dollarsAndCents(getCost())+"\n";

    }
}
