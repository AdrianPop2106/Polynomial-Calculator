import Controller.Listeners;
import DataModels.MonomialDouble;
import DataModels.MonomialInteger;
import DataModels.Polinomial;
import View.GUI;


public class Main {
    public static void main(String[] args){
        GUI v=new GUI();
        new Listeners(v);
        v.visible();
    }
}
