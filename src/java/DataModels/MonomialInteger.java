package DataModels;

public class MonomialInteger extends Monomial {
    private int coef;

    public MonomialInteger(int coef, int grad){
        super(grad);
        this.coef=coef;
    }

    public int getCoef(){return coef;}

    public void addCoef(int i){ coef+=i; }

}
