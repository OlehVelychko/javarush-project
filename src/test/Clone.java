package test;

public class Clone implements Cloneable {
    int x;

    public Clone(int x) {
        this.x = x;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

/*
    @Override
    public String toString() {
        return "It was me " + x;
    }
*/

}
