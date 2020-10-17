

public class DessertShoppe {
    public final static double TAX_RATE=6.507;
  public  static String STORE_NAME="M & M Dessert Shoppe";
  public static final int ITEM_NAME_MAX_LENGTH=40;

  public static String cents2dollarsAndCents(int cents){
        double intermediate=(double)cents/100;
        String cent2Dollar=""+intermediate;
        return cent2Dollar;
    }


}
