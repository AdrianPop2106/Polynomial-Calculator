package DataModels;

public class Monomial implements Comparable<Monomial>{
    private int grad;

    Monomial(int grad){
        this.grad=grad;
    }

    public int getGrad() {
        return grad;
    }

    @Override
    public int compareTo(Monomial m) {
        return Integer.compare(this.grad, m.getGrad());
    }
}
