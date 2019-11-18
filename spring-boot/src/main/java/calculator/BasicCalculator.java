package calculator;

public class BasicCalculator {

    private int firstInput;
    private int secondInput;

    public BasicCalculator(int firstInput, int secondInput) {

        this.firstInput = firstInput;
        this.secondInput = secondInput;

    }

    public int calculate() {
        return firstInput + secondInput - secondInput;
    }

}