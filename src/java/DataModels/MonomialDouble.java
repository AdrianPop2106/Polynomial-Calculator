package DataModels;

public class MonomialDouble extends Monomial {
    private double coef;

    public MonomialDouble(double coef, int grad){
        super(grad);
        this.coef=coef;
    }

    public void addCoef(double i){ coef+=i; }

    public double getCoef(){return coef;}
}
