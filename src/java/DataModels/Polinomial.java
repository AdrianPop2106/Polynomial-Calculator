package DataModels;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Polinomial {
    public List<Monomial> coef;
    private final static DecimalFormat df = new DecimalFormat("0.0");

    public Polinomial(){
        coef= new ArrayList<>();
    }

    public void addCoef(Monomial m){
        boolean unic=true;
        for(Monomial i:coef)
            if(i.compareTo(m)==0){
               if(i instanceof MonomialInteger)
                   ((MonomialInteger) i).addCoef(((MonomialInteger)m).getCoef());
               else
                   ((MonomialDouble) i).addCoef(((MonomialDouble)m).getCoef());
                unic=false;
                break;
            }
        if(unic)
            coef.add(m);
    }

    private String addIntToString(String text,MonomialInteger m){
        if (!text.equals("") && m.getCoef() > 0)
            text += '+';
        if ((m).getCoef() == -1)
            text += "-";
        if ((m).getCoef() != 1 && m.getCoef() != -1)
                text = text + m.getCoef();
        if (m.getGrad() == 0) {
            if ((m.getCoef() == 1 || m.getCoef() == -1))
                text = text + 1;
        }
        else
        {
            if (m.getCoef() != 1 && m.getCoef() != -1)
                text += "*";
            text += "X";
        }
        if (m.getGrad() > 1)
            text += "^" + m.getGrad();
        return text;
    }

    private String addDoubleToString(String text,MonomialDouble m){
        if (!text.equals("") && m.getCoef() > 0)
            text += '+';
        if (m.getCoef() == -1)
            text += "-";
        if (m.getCoef() != 1 && m.getCoef() != -1)
                text = text + df.format(m.getCoef());
        if (m.getGrad() == 0) {
            if ((m).getCoef() == 1 || m.getCoef() == -1)
                text = text + 1;
        }
        else
        {
            if (m.getCoef() != 1 && m.getCoef() != -1)
                text += "*";
            text += "X";
        }
        if (m.getGrad() > 1)
            text += "^" + m.getGrad();
        return text;
    }

    public String getString(){
        Collections.sort(coef,Collections.reverseOrder());
        String polin ="";
        boolean zero=true;
        for (Monomial i : coef){
            if(i instanceof MonomialInteger) {
                if (((MonomialInteger) i).getCoef() == 0)
                    continue;
                polin=addIntToString(polin,(MonomialInteger) i);
                zero=false;
            }
            else {
                if (((MonomialDouble) i).getCoef() == 0.0)
                    continue;
                polin=addDoubleToString(polin,(MonomialDouble) i);
                zero=false;
            }
        }
        if(zero)
            return "0";
        else
            return polin;
    }
}
