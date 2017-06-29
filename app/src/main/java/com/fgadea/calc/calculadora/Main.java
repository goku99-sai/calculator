package com.fgadea.calc.calculadora;

import android.content.pm.ActivityInfo;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {

    private TextView display;
    private double num1 = 0;
    private double num2 = 0;
    private double result = 0;
    private boolean second = false;
    private String defalutDisp = null;
    private String operator = "";
    private String lastOp = "";
    private boolean clear = false;
    private List<Double> nums = new ArrayList<>();
    private List<String> operators = new ArrayList<>();
    private double lastNop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        display = (TextView) findViewById(R.id.display);
        display.setText("");
        setDefalutDisp(display.getText().toString());

    }
    public void b0(View v){
        if(clear) {
            display.setText(defalutDisp);
            clear = false;
        }
            display.setText(display.getText()+ "0");


    }
    public void b1(View v){
        if(clear) {
            display.setText(defalutDisp);
            clear = false;
        }
            display.setText(display.getText()+ "1");

    }
    public void b2(View v){
        if(clear) {
            display.setText(defalutDisp);
            clear = false;
        }
            display.setText(display.getText()+ "2");



    }
    public void b3(View v){
        if(clear) {
            display.setText(defalutDisp);
            clear = false;
        }
            display.setText(display.getText()+ "3");

    }

    public void b4(View v){
        if(clear) {
            display.setText(defalutDisp);
            clear = false;
        }
            display.setText(display.getText()+ "4");

    }

    public void b5(View v){
        if(clear) {
            display.setText(defalutDisp);
            clear = false;
        }
            display.setText(display.getText()+ "5");


    }

    public void b6(View v){

        if(clear) {
            display.setText(defalutDisp);
            clear = false;
        }
            display.setText(display.getText()+ "6");


    }
    public void b7(View v){

        if(clear) {
            display.setText(defalutDisp);
            clear = false;
        }
            display.setText(display.getText()+ "7");


    }

    public void b8(View v){

        if(clear) {
            display.setText(defalutDisp);
            clear = false;
        }
            display.setText(display.getText()+ "8");


    }
    public void b9(View v){
        if(clear) {
            display.setText(defalutDisp);
            clear = false;
        }
            display.setText(display.getText()+ "9");


    }

    public void bPunto(View v){
        if(clear) {
            display.setText(defalutDisp);
            clear = false;
        }
        if(display.getText().toString().equals(defalutDisp) || display.getText().toString().equals("-"));
        else{
            display.setText(display.getText()+ ".");
        }



    }
    public void bMul(View v){
        if(display.getText().toString().equals(defalutDisp) || display.getText().toString().equals("-"));
        else{
            nums.add(Double.parseDouble(display.getText().toString()));
            operators.add("*");
            lastOp = "*";
            clear = true;
        }

    }

    public void bSub(View v){
        if(display.getText().toString().equals(defalutDisp) || display.getText().toString().equals("-")){
            if(clear) {
                display.setText(defalutDisp);
                clear = false;
            }
            display.setText("-");
        }else{
            nums.add(Double.parseDouble(display.getText().toString()));
            operators.add("-");
            lastOp = "-";
            clear = true;
        }

    }
    public void bAdd(View v){
        if(display.getText().toString().equals(defalutDisp) || display.getText().toString().equals("-"));
        else{
            nums.add(Double.parseDouble(display.getText().toString()));
            operators.add("+");
            lastOp = "+";
            clear = true;
        }

    }
    public void bEqu(View v){
        if(display.getText().toString().equals(defalutDisp) || display.getText().toString().equals("-"));
        else{
            if(nums.isEmpty()){
                nums.add(getResult());
                nums.add(lastNop);
                if(operators.isEmpty()) operators.add(lastOp);
            }else {
                nums.add(Double.parseDouble(display.getText().toString()));
                lastNop = Double.parseDouble(display.getText().toString());
            }
            setResult(operar());
            display.setText("" + getResult());
            clear = true;
        }


    }
    public void bDiv(View v){
        if(display.getText().toString().equals(defalutDisp) || display.getText().toString().equals("-"));
        else{
            nums.add(Double.parseDouble(display.getText().toString()));
            operators.add("/");
            lastOp = "/";
            clear = true;
        }
    }
    public void bAc(View v){
        setSecond(false);
        nums.clear();
        operators.clear();
        setResult(0);
        display.setText(getDefalutDisp());
    }

    private double operar() {
        double result = Double.MAX_VALUE, n2 =1;
        String operador = "";
        while (!nums.isEmpty()){
            if(result == Double.MAX_VALUE) result = nums.remove(0);
            n2 = nums.remove(0);
            operador = operators.remove(0);
            if(operador.equals("*")){
                result = result * n2;
            }else if(operador.equals("/")){
                result = result / n2;
            }else if(operador.equals("+")){
                result = result + n2;
            }else if(operador.equals("-")){
                result = result - n2;
            }

        }
        return result;
    }
    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public boolean isSecond() {
        return second;
    }

    public void setSecond(boolean second) {
        this.second = second;
    }

    public String getDefalutDisp() {
        return defalutDisp;
    }

    public void setDefalutDisp(String defalutDisp) {
        this.defalutDisp = defalutDisp;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
