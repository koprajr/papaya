package models;

public class SampleEquation extends Equation {
    public SampleEquation(Long id, String name) {
        super(id, name);
    }

    @Override
    public Integer solve() {
        return 1;
    }
}
