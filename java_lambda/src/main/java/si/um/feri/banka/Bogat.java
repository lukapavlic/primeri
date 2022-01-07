package si.um.feri.banka;

public abstract class Bogat {

    protected OpazovalecBogatasev opazovalec;

    public void setOpazovalec(OpazovalecBogatasev opazovalec) {
        this.opazovalec = opazovalec;
    }

    public abstract void doniraj(String namen, double znesek);

}
