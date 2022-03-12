package Controller;

import DataModels.*;
import View.GUI;
import Model.Operations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Listeners {
    GUI v;

    public Listeners(GUI v){
        this.v=v;
        v.addButtonListener(new SumListener(),0);
        v.addButtonListener(new SubstractionListener(),1);
        v.addButtonListener(new MultiplicationListener(),2);
        v.addButtonListener(new DerivationListener(),4);
        v.addButtonListener(new IntegrationListener(),5);
    }

    private Matcher returnMatcher(String text) throws Exception {
        int i=32;
        if(text.equals(""))
            throw new Exception("Polinom inexistent");
        while(i<123){
            if(text.indexOf((char)i)!=-1 && (!Character.isDigit((char)i) && (char)i!='x' && (char)i!='X'
                    && (char)i!='X' && (char)i!='*' && (char)i!='^' && (char)i!='+' && (char)i!='-'))
                throw new Exception("Polinom invalid");
            i++;
        }
        String Pattern="([+-]*)([0-9]*)(\\**[xX])*(\\^[0-9])*";
        Pattern pattern= java.util.regex.Pattern.compile(Pattern);
        return pattern.matcher(text);
    }

    private Polinomial getPolinomials(int nr) throws Exception{
        Polinomial p=new Polinomial();
        int coef,grad;
        Matcher matcher;
            if (nr == 1)
                matcher = returnMatcher(v.getPolinomial1());
            else
                matcher = returnMatcher(v.getPolinomial2());
        while(matcher.find() ){
            if(matcher.group(2).equals("") && matcher.group(3)==null)
                continue;
            if(matcher.group(2).equals(""))
                coef=1;
            else
                coef=Integer.parseInt(matcher.group(2));
            if(matcher.group(1).equals("-"))
                coef*=-1;
            if(matcher.group(3)==null)
                    grad=0;
            else
                if(matcher.group(4)==null)
                    grad=1;
                else
                    grad=Integer.parseInt(matcher.group(4).substring(1));
            p.addCoef(new MonomialInteger(coef,grad));
        }
        return p;
    }

    class SumListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polinomial p1;
            Polinomial p2;
            try {
                p1 = getPolinomials(1);
                p2 = getPolinomials(2);
            } catch (Exception ex) { v.setResult(ex.getMessage()); return;}
                Polinomial rez = Operations.sumSub(p1, p2, (short) 1);
                v.setResult(rez.getString());
            }
        }

    class SubstractionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polinomial p1;
            Polinomial p2;
            try {
                p1 = getPolinomials(1);
                p2 = getPolinomials(2);
            } catch (Exception ex) {v.setResult(ex.getMessage()); return;}
                Polinomial rez = Operations.sumSub(p1, p2, (short) -1);
                v.setResult(rez.getString());
            }
        }

    class MultiplicationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polinomial p1;
            Polinomial p2;
            try {
                p1 = getPolinomials(1);
                p2 = getPolinomials(2);
            } catch (Exception ex) { v.setResult(ex.getMessage()); return;}
                Polinomial rez = Operations.multiplication(p1, p2);
                v.setResult(rez.getString());
            }
        }

    class IntegrationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polinomial p1;
            try {
                p1 = getPolinomials(1);
            } catch (Exception ex) { v.setResult(ex.getMessage()); return;}
                Polinomial rez = Operations.integration(p1);
                v.setResult(rez.getString());
            }
        }

    class DerivationListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Polinomial p1;
            try {
                p1 = getPolinomials(1);
            } catch (Exception ex) { v.setResult(ex.getMessage());return;}
                Polinomial rez = Operations.derivation(p1);
                v.setResult(rez.getString());
            }
        }
}