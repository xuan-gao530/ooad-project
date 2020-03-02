package cars;

public abstract class Cars {

    String category;
    String license;

    public String getcategory(){return category;}
    public String getLicense(){return license;}
    public String getDescription(){         //getDescription is already implemented for us
        return category+":"+ license;}
    public abstract double cost(int nightnum);
}
