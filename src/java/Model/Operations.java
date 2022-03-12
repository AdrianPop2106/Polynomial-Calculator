package Model;
import DataModels.*;
import java.util.Collections;

public  class Operations {

    public static Polinomial sumSub(Polinomial p1, Polinomial p2, short op){
        Polinomial rezultat=new Polinomial();
        Collections.sort(p1.coef);
        Collections.sort(p2.coef);
        int i=0,j=0;
        while(i<p1.coef.size() && j<p2.coef.size()){
            if(p1.coef.get(i).getGrad()<p2.coef.get(j).getGrad()) {
                rezultat.addCoef(p1.coef.get(i));
                i++;
                continue;
            }
            else  if(p1.coef.get(i).getGrad()>p2.coef.get(j).getGrad()) {
                rezultat.addCoef(new MonomialInteger(((MonomialInteger)p2.coef.get(j)).getCoef()*op,p2.coef.get(j).getGrad()));
                j++;
                continue;
            }
            else rezultat.addCoef(new MonomialInteger(((MonomialInteger)p1.coef.get(i)).getCoef()+(((MonomialInteger)p2.coef.get(j)).getCoef()*op),p1.coef.get(i).getGrad()));
            i++;
            j++;
        }
        while(i< p1.coef.size()){
            rezultat.addCoef(p1.coef.get(i));
            i++;
        }
        while(j< p2.coef.size()){
            rezultat.addCoef(new MonomialInteger(((MonomialInteger)p2.coef.get(j)).getCoef()*op,p2.coef.get(j).getGrad()));
            j++;
        }
        return rezultat;
    }

    public static Polinomial multiplication(Polinomial p1, Polinomial p2){
        Polinomial produs=new Polinomial();
        for(Monomial i:p1.coef)
            for(Monomial j:p2.coef)
                produs.addCoef(new MonomialInteger(((MonomialInteger)i).getCoef()*((MonomialInteger)j).getCoef(),
                        i.getGrad()+j.getGrad()));
        return produs;
    }

    public static Polinomial division(){
        Polinomial cat=new Polinomial();
        return cat;
    }

    public static Polinomial derivation(Polinomial p){
        Polinomial derivat=new Polinomial();
        for(Monomial i:p.coef){
            if(i.getGrad()==0)
                if(p.coef.size()==1){
                    derivat.addCoef(new MonomialInteger(0,0));
                    continue;
                }

            derivat.addCoef(new MonomialInteger(((MonomialInteger)i).getCoef()*i.getGrad(),i.getGrad()-1));
        }
        return derivat;
    }

    public static Polinomial integration(Polinomial p){
        Polinomial integrat=new Polinomial();
        for(Monomial i:p.coef)
            if(((MonomialInteger)i).getCoef()%(i.getGrad()+1)!=0)
                integrat.addCoef(new MonomialDouble(((float)((MonomialInteger)i).getCoef())/(i.getGrad()+1),
                    i.getGrad()+1));
            else
                integrat.addCoef(new MonomialInteger(((MonomialInteger)i).getCoef()/(i.getGrad()+1),
                        i.getGrad()+1));
        return integrat;
    }
}
