package com.softuni.entity;

public class WeightConverse {
    private double value;
    private String leftOperand;
    private String rightOperand;

    public WeightConverse(double value, String leftOperand, String rightOperand) {
        this.value = value;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public double calculations(){
        double result;
        switch (this.leftOperand){
            case "gram":
                switch (this.rightOperand){
                    case "gram":
                        result = this.value;
                        break;
                    case "kilogram":
                        result = this.value / 1000;
                        break;
                    case "ton":
                        result = this.value / 1000000;
                        break;
                        default:
                            result = 0;
                            break;
                }
                break;
            case "kilogram":
                switch (this.rightOperand){
                    case "gram":
                        result = this.value * 1000;
                        break;
                    case "kilogram":
                        result = this.value;
                        break;
                    case "ton":
                        result = this.value / 1000;
                        break;
                    default:
                        result = 0;
                        break;
                }
                break;
            case "ton":
                switch (this.rightOperand){
                    case "gram":
                        result = this.value * 1000000;
                        break;
                    case "kilogram":
                        result = this.value * 1000;
                        break;
                    case "ton":
                        result = this.value;
                        break;
                    default:
                        result = 0;
                        break;
                }
                break;
                default:
                    result = 0;
                    break;

        }
        return result;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getLeftOperand() {
        return leftOperand;
    }

    public void setLeftOperand(String leftOperand) {
        this.leftOperand = leftOperand;
    }

    public String getRightOperand() {
        return rightOperand;
    }

    public void setRightOperand(String rightOperand) {
        this.rightOperand = rightOperand;
    }
}
