public class Candy extends DessertItem {
    private  double weight;
    private  double pricePerPound;


    public  double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPricePerPound() {

        return pricePerPound/100;
    }

    public void setPricePerPound(int pricePerPound) {
        this.pricePerPound = pricePerPound;
    }



    public Candy(String name, double weight, double pricePerPound){

        this.setName(name);
        this.weight=weight;
        this.pricePerPound=pricePerPound;
    }


    @Override
    public int getCost() {

        return (int)Math.round(weight*pricePerPound);

    }



    @Override
    public String toString() {
        return weight+" lbs. @ "+DessertShoppe.cents2dollarsAndCents((int)pricePerPound)+"/ lb." +
                " \n"+name.substring(0, Math.min(name.length(), DessertShoppe.ITEM_NAME_MAX_LENGTH))+" "
                + DessertShoppe.cents2dollarsAndCents(getCost())+"\n";
    }
}
