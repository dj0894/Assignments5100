public class IceCream extends DessertItem {

    private int icecreamCost;

    public int getIcecreamCost() {
        return icecreamCost;
    }

    public void setIcecreamCost(int icecreamCost) {
        this.icecreamCost = icecreamCost;
    }


    public IceCream(){}

    public IceCream(String name, int icecreamCost){
        this.setName(name);
        this.icecreamCost=icecreamCost;
    }

    @Override
    public  int  getCost() {
        return  Math.round(icecreamCost);
    }

    @Override
    public String toString() {
        return name.substring(0,Math.min(name.length(), DessertShoppe.ITEM_NAME_MAX_LENGTH))+" " +DessertShoppe.cents2dollarsAndCents(getCost())+"\n";
    }
}
