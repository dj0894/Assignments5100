public class TestCylinder {

    public static void main(String args[]){

        System.out.println("Using default constructor and setter method.");
        Circle circle=new Circle(); //method 1: default constructor and setter method;
        circle.setRadius(2);
        circle.setColor("yellow");
        System.out.println("Radius is "+ circle.getRadius()+", Color is "+circle.getColor()+", Base area is "+ circle.getArea()+"\n");

        System.out.println("Using parameterized  constructor" );
        Circle circle1=new Circle(2,"yellow");//using parameterized  constructor
        System.out.println("Radius is "+ circle1.getRadius()+", Color is "+circle1.getColor()+", Base area is "+ circle1.getArea()+"\n");

        System.out.println("Using default constructor and setter method");
        Cylinder cylinder=new Cylinder();////method 1: default constructor and setter method
        cylinder.setHeight(1);
        cylinder.setRadius(1);
        System.out.println( "Radius is "+cylinder.getRadius()+", Height is "+cylinder.getHeight()+ ", Color is "+cylinder.getColor()+ ", Base area is "+ cylinder.getArea()+", Volume is ="+cylinder.getVolume()+"\n");

        System.out.println("Using parameterized  constructor" );
        Cylinder cylinderCopy=new Cylinder(1,1);//using parameterized  constructor
        System.out.println( "Radius is "+cylinderCopy.getRadius()+", Height is "+cylinderCopy.getHeight()+ ", Color is "+cylinderCopy.getColor()+ ", Base area is "+ cylinderCopy.getArea()+", Volume is ="+cylinderCopy.getVolume()+"\n");

        //-------------------------------------

        System.out.println("Using default constructor and setter method");
        Cylinder cylinder1=new Cylinder();//method 1: default constructor and setter method
        cylinder1.setRadius(2);
        cylinder1.setHeight(5);
        System.out.println( "Radius is "+cylinder1.getRadius()+", Height is "+cylinder1.getHeight()+ ", Color is "+cylinder1.getColor()+ ", Base area is "+ cylinder1.getArea()+", Volume is ="+cylinder1.getVolume()+"\n");

        System.out.println("Using parameterized Constructor ");
        Cylinder cylinder1Copy=new Cylinder(5,2);
        System.out.println( "Radius is "+cylinder1Copy.getRadius()+", Height is "+cylinder1Copy.getHeight()+ ", Color is "+cylinder1Copy.getColor()+ ", Base area is "+ cylinder1Copy.getArea()+", Volume is ="+cylinder1Copy.getVolume()+"\n");


    }
}
