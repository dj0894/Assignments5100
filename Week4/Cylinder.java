public class Cylinder extends Circle {

    private double height=1.0;
    private double volume=0.0;
    private double surfaceArea=0.0;

    Cylinder(){}

    Cylinder(double height){
        this.height=height;
    }


    Cylinder(double height, double radius){

        this.height=height;
        setRadius(radius);



    }

    Cylinder(double height, double radius, String color){
        this.height=height;
        super.setRadius(radius);
        super.setColor(color);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume(){
       volume= super.getArea()*height;
       return volume;
    }

    @Override
    public double getArea() {

        surfaceArea=2*pi*getRadius()*(getRadius()+getHeight());

        return surfaceArea;
    }
}


