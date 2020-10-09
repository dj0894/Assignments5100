public class Circle {

    private double radius=1.0;
    private String color="red";
    final double pi = 3.14;
    private double area=0.0;

    public  Circle(){}

    public Circle(double radius){
        this.radius=radius;

    }
    public Circle(double radius, String color){
        this.radius=radius;
        this.color=color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
     public double getArea(){
        area=pi*getRadius()*getRadius();
        return area;
     }

    public double getArea(double radius,String color){
        area=pi*getRadius()*getRadius();
        return area;
    }


}
