import DataModels.*;
import Model.Operations;
import org.junit.jupiter.api.*;
import static org.junit.Assert.*;

import java.util.Collections;

public class PolinomialTest {

    @Test
    public void sumTest(){
        Polinomial p1=new Polinomial();
        p1.addCoef(new MonomialInteger(3,2));
        p1.addCoef(new MonomialInteger(4,1));
        p1.addCoef(new MonomialInteger(5,0));


        Polinomial p2=new Polinomial();
        p2.addCoef(new MonomialInteger(-3,2));
        p2.addCoef(new MonomialInteger(2,1));
        p2.addCoef(new MonomialInteger(6,0));


        Polinomial result=new Polinomial();
        result.addCoef(new MonomialInteger(0,2));
        result.addCoef(new MonomialInteger(6,1));
        result.addCoef(new MonomialInteger(11,0));

        Polinomial p3= Operations.sumSub(p1,p2,(short)1);
        Collections.sort(p1.coef,Collections.reverseOrder());
        Collections.sort(p2.coef,Collections.reverseOrder());

        Collections.sort(p3.coef, Collections.reverseOrder());
        assertEquals(p3.getString(),result.getString());
        System.out.println("Test suma:("+p1.getString()+")+("
                +p2.getString()+")="+p3.getString());
    }
    @Test
    public void subTest(){
        Polinomial p1=new Polinomial();
        p1.addCoef(new MonomialInteger(5,3));
        p1.addCoef(new MonomialInteger(-2,2));
        p1.addCoef(new MonomialInteger(0,1));
        p1.addCoef(new MonomialInteger(4,0));

        Polinomial p2=new Polinomial();
        p2.addCoef(new MonomialInteger(-3,3));
        p2.addCoef(new MonomialInteger(4,1));
        p2.addCoef(new MonomialInteger(1,0));

        Polinomial result=new Polinomial();
        result.addCoef(new MonomialInteger(8,3));
        result.addCoef(new MonomialInteger(-2,2));
        result.addCoef(new MonomialInteger(-4,1));
        result.addCoef(new MonomialInteger(3,0));

        Polinomial p3= Operations.sumSub(p1,p2,(short)-1);
        Collections.sort(p1.coef,Collections.reverseOrder());
        Collections.sort(p2.coef,Collections.reverseOrder());

        Collections.sort(p3.coef, Collections.reverseOrder());
        assertEquals(p3.getString(),result.getString());
        System.out.println("Test diferenta:("+p1.getString()+")-("
                +p2.getString()+")="+p3.getString());
    }


    @Test
    public void multTest(){
        Polinomial p1=new Polinomial();
        p1.addCoef(new MonomialInteger(2,1));
        p1.addCoef(new MonomialInteger(3,0));

        Polinomial p2=new Polinomial();
        p2.addCoef(new MonomialInteger(1,2));
        p2.addCoef(new MonomialInteger(4,1));
        p2.addCoef(new MonomialInteger(3,0));

        Polinomial result=new Polinomial();
        result.addCoef(new MonomialInteger(2,3));
        result.addCoef(new MonomialInteger(11,2));
        result.addCoef(new MonomialInteger(18,1));
        result.addCoef(new MonomialInteger(9,0));

        Polinomial p3= Operations.multiplication(p1,p2);
        Collections.sort(p1.coef,Collections.reverseOrder());
        Collections.sort(p2.coef,Collections.reverseOrder());

        Collections.sort(p3.coef, Collections.reverseOrder());
        assertEquals(p3.getString(),result.getString());
        System.out.println("Test inmultire:("+p1.getString()+")*("
                +p2.getString()+")="+p3.getString());
    }

    @Test
    public void derivTest(){
        Polinomial p1=new Polinomial();
        p1.addCoef(new MonomialInteger(3,2));
        p1.addCoef(new MonomialInteger(5,1));
        p1.addCoef(new MonomialInteger(4,0));

        Polinomial result=new Polinomial();
        result.addCoef(new MonomialInteger(6,1));
        result.addCoef(new MonomialInteger(5,0));

        Polinomial p2= Operations.derivation(p1);
        Collections.sort(p1.coef,Collections.reverseOrder());

        Collections.sort(p2.coef, Collections.reverseOrder());
        assertEquals(p2.getString(),result.getString());
        System.out.println("Test derivare:("+p1.getString()+")'="+p2.getString());
    }
    @Test
    public void integTest(){
        Polinomial p1=new Polinomial();
        p1.addCoef(new MonomialInteger(5,2));
        p1.addCoef(new MonomialInteger(4,1));
        p1.addCoef(new MonomialInteger(2,0));

        Polinomial result=new Polinomial();
        result.addCoef(new MonomialDouble(1.7,3));
        result.addCoef(new MonomialInteger(2,2));
        result.addCoef(new MonomialInteger(2,1));

        Polinomial p2= Operations.integration(p1);

        Collections.sort(p1.coef, Collections.reverseOrder());
        assertEquals(p2.getString(),result.getString());
        System.out.println("Test integrare:integrala("+p1.getString()+")="+p2.getString());
    }

}
