
import java.util.Vector;

public class Checkout{

    Vector<DessertItem> vector=new Vector<DessertItem>();

    public Checkout(){ }

    public int numberOfItems(){
        //System.out.println(vector);
        return vector.size();


    }

    public void enterItem(DessertItem item){
        vector.add(item);

    }

    public void clear(){
        vector.clear();
    }


    public int totalCost() {
        int sum = 0;
        //returns total cost of items in cents(without tax)
        for (int i = 0; i < vector.size(); i++) {
            //System.out.println(vector.get(i).getCost());
            sum = sum + vector.get(i).getCost();
        }

        //System.out.println("total cost "+sum);

        return sum;
    }
    public int totalTax(){
        //System.out.println("total Tax: "+(int)Math.round(totalCost()*(DessertShoppe.TAX_RATE/100)));
        return (int)Math.round(totalCost()*(DessertShoppe.TAX_RATE/100));
    }



    @Override
    public String toString() {

       StringBuilder output=new StringBuilder();

        System.out.println(DessertShoppe.STORE_NAME);
        System.out.println("----------------------");


        for(int i=0;i<vector.size();i++){

            if(vector.get(i) instanceof Candy) {
                output = output.append(vector.get(i).toString());
            } else if(vector.get(i) instanceof IceCream){
                output=output.append(vector.get(i).toString());
            }else if(vector.get(i) instanceof Cookie){
                output=output.append(vector.get(i).toString());
            }else if(vector.get(i) instanceof Sundae){
                output=output.append(vector.get(i).toString());

            }

        }

        output=output.append( "\n"+"Tax "+DessertShoppe.cents2dollarsAndCents(totalTax())+"\n"+"Total Cost "+DessertShoppe.cents2dollarsAndCents(totalCost()+totalTax()));



        return new String(output);
    }
}

