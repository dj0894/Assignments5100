public  class   Sundae extends IceCream{

    private static String toppingName;
    private static double toppingCost;

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public double getToppingCost() {
        return toppingCost;
    }

    public void setToppingCost(double toppingCost) {
        this.toppingCost = toppingCost;
    }

    public Sundae(String name, int icecreamCost, String toppingName, int toppingCost){
        this.setName(name);
        this.setIcecreamCost(icecreamCost);
        this.toppingName=toppingName;
        this.toppingCost=toppingCost;

    }


    @Override
    public int  getCost() {

        //System.out.println("Sundae Cost "+(int) Math.round(super.getCost()+(toppingCost)));
        return (int) (super.getCost()+(toppingCost));
    }

    @Override
    public String toString() {
        String sundaeName=toppingName+" Sundae with "+"\n"+super.name.substring(0,Math.min(name.length(),DessertShoppe.ITEM_NAME_MAX_LENGTH));
        return sundaeName+" "+DessertShoppe.cents2dollarsAndCents(getCost())+"\n";
    }
}
