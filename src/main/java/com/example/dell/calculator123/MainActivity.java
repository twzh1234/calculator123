package com.example.dell.calculator123;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.common.math.BigIntegerMath;
import org.apache.commons.math3.analysis.function.Cos;
import org.apache.commons.math3.analysis.function.Log;
import org.apache.commons.math3.analysis.function.Log10;
import org.apache.commons.math3.analysis.function.Sin;
import org.apache.commons.math3.analysis.function.Acos;
import org.apache.commons.math3.analysis.function.Asin;
import org.apache.commons.math3.analysis.function.Exp;
import org.apache.commons.math3.analysis.function.Sqrt;
import org.apache.commons.math3.analysis.function.Tan;
import org.apache.commons.math3.analysis.function.Atan;
import org.apache.commons.math3.analysis.function.Log1p;

public class MainActivity extends Activity implements View.OnClickListener {
    Button multiply, divide, add, subtract, clear, delete, equal;
    Button zero, one, two, three, four, five, six, seven, eight, nine, pt;
    Button log10, ln,sin,cos,asin,acos,exp,Sqrt,tan,log1p;
    Button factotial,atan;
    EditText whatyouwant;
    boolean clr_flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zero = (Button) findViewById(R.id.bt_0);
        one = (Button) findViewById(R.id.bt_1);
        two = (Button) findViewById(R.id.bt_2);
        three = (Button) findViewById(R.id.bt_3);
        four = (Button) findViewById(R.id.bt_4);
        five = (Button) findViewById(R.id.bt_5);
        six = (Button) findViewById(R.id.bt_6);
        seven = (Button) findViewById(R.id.bt_7);
        eight = (Button) findViewById(R.id.bt_8);
        nine = (Button) findViewById(R.id.bt_9);
        pt = (Button) findViewById(R.id.bt_pt);
        add = (Button) findViewById(R.id.bt_add);
        subtract = (Button) findViewById(R.id.bt_sub);
        multiply = (Button) findViewById(R.id.bt_mul);
        divide = (Button) findViewById(R.id.bt_div);
        clear = (Button) findViewById(R.id.bt_clr);
        delete = (Button) findViewById(R.id.bt_del);
        equal = (Button) findViewById(R.id.bt_eq);
        log10 = (Button) findViewById(R.id.bt_log10);
        ln = (Button) findViewById(R.id.bt_ln);
        sin = (Button) findViewById(R.id.bt_sin);
        cos = (Button) findViewById(R.id.bt_cos);
        asin = (Button)findViewById(R.id.bt_Asin);
        acos = (Button)findViewById(R.id.bt_Acos);
        exp = (Button)findViewById(R.id.bt_exp);
        Sqrt = (Button)findViewById(R.id.bt_sqrt);
        tan = (Button)findViewById(R.id.bt_tan);
        log1p = (Button)findViewById(R.id.bt_log1p);
        atan = (Button)findViewById(R.id.bt_ATAN);
        factotial = (Button)findViewById(R.id.bt_factortial);
        whatyouwant = (EditText) findViewById(R.id.et_input);


        //设置按钮的点击事件
        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        pt.setOnClickListener(this);
        add.setOnClickListener(this);
        subtract.setOnClickListener(this);
        multiply.setOnClickListener(this);
        divide.setOnClickListener(this);
        clear.setOnClickListener(this);
        delete.setOnClickListener(this);
        equal.setOnClickListener(this);
        log10.setOnClickListener(this);
        ln.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        asin.setOnClickListener(this);
        acos.setOnClickListener(this);
        exp.setOnClickListener(this);
        Sqrt.setOnClickListener(this);
        tan.setOnClickListener(this);
        log1p.setOnClickListener(this);
        atan.setOnClickListener(this);
        factotial.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String str = whatyouwant.getText().toString();
        switch (v.getId()) {
            case R.id.bt_0:
            case R.id.bt_1:
            case R.id.bt_2:
            case R.id.bt_3:
            case R.id.bt_4:
            case R.id.bt_5:
            case R.id.bt_6:
            case R.id.bt_7:
            case R.id.bt_8:
            case R.id.bt_9:
            case R.id.bt_pt:
                if (clr_flag) {
                    clr_flag = false;
                    str = "";
                    whatyouwant.setText("");
                }
                whatyouwant.setText(str + ((Button) v).getText());
                break;
            case R.id.bt_add:
            case R.id.bt_sub:
            case R.id.bt_mul:
            case R.id.bt_div:
            case R.id.bt_ln:
            case R.id.bt_log10:
            case R.id.bt_sin:
            case R.id.bt_cos:
            case R.id.bt_Acos:
            case R.id.bt_Asin:
            case R.id.bt_exp:
            case R.id.bt_sqrt:
            case R.id.bt_tan:
            case R.id.bt_log1p:
            case R.id.bt_factortial:
            case R.id.bt_ATAN:
                if (str.contains("+") || str.contains("-") || str.contains("×") || str.contains("÷")) {
                    str = str.substring(0, str.indexOf(" "));
                }
                if (clr_flag) {
                    clr_flag = false;
                    str = "";
                    whatyouwant.setText("");
                }
                whatyouwant.setText(str + " " + ((Button) v).getText() + " ");
                break;
            case R.id.bt_clr:
                if (clr_flag)
                    clr_flag = false;
                str = "";
                whatyouwant.setText("");
                break;
            case R.id.bt_del:
                if (clr_flag) {
                    clr_flag = false;
                    str = "";
                    whatyouwant.setText("");
                } else if (str != null && !str.equals("")) {
                    whatyouwant.setText(str.substring(0, str.length() - 1));
                }
                break;
            case R.id.bt_eq:
                getResult();
                break;


        }
    }

    private void getResult() {
        String exp = whatyouwant.getText().toString();
        if (exp == null || exp.equals("")) return;
        if (!exp.contains(" ")) {
            return;
        }
        if (clr_flag) {
            clr_flag = false;
            return;
        }
        clr_flag = true;
        String temp = exp.substring(exp.indexOf(" ") + 1, exp.length());
        String s1 = exp.substring(0, exp.indexOf(" "));
        String op = temp.substring(0, temp.indexOf(" "));
        String s2 = temp.substring(temp.indexOf(" ") + 1, temp.length());
        double cnt = 0;
        if (!s1.equals("") && !s2.equals("")) {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            if (op.equals("+")) {
                cnt = d1 + d2;
            }
            if (op.equals("-")) {
                cnt = d1 - d2;
            }
            if (op.equals("×")) {
                cnt = d1 * d2;
            }
            if (op.equals("÷")) {
                if (d2 == 0) cnt = 0;
                else cnt = d1 / d2;
            }
            if (!s1.contains(".") && !s2.contains(".") && !op.equals("÷")) {
                int res = (int) cnt;
                whatyouwant.setText(res + "");
            } else {
                whatyouwant.setText(cnt + "");
            }
        } else if (!s1.equals("") && s2.equals("")) {
            double d1 = Double.parseDouble(s1);
            if (op.equals("+")) {
                cnt = d1;
            }
            if (op.equals("-")) {
                cnt = d1;
            }
            if (op.equals("×")) {
                cnt = 0;
            }
            if (op.equals("÷")) {
                cnt = 0;
            }
            if (op.equals("log10")) {
                Log10 a = new Log10();
                cnt = a.value(d1);
            }
            if (op.equals("ln")){
                Log a = new Log();
                cnt = a.value(d1);
            }
            if (op.equals("cos")){
                Cos a = new Cos();
                cnt = a.value(d1);
            }
            if (op.equals("sin")){
                Sin a = new Sin();
                cnt = a.value(d1);
            }
            if (op.equals("Asin")){
                Asin a = new Asin();
                cnt = a.value(d1);
            }
            if (op.equals("Acos")){
                Acos a = new Acos();
                cnt = a.value(d1);
            }

            if (op.equals("e^x")){
                Exp a = new Exp();
                cnt = a.value(d1);
            }
            if(op.equals("log1p")){
                Log1p a = new Log1p();
                cnt = a.value(d1);
            }
            if(op.equals("sqrt")){
                Sqrt a = new Sqrt();
                cnt = a.value(d1);
            }
            if(op.equals("tan")){
                Tan a = new Tan();
                cnt = a.value(d1);
            }
            if(op.equals("ATAN")){
                Atan a = new Atan();
                cnt = a.value(d1);
            }
            if(op.equals("!")){
                int t = (int)d1;
                cnt = BigIntegerMath.factorial(t).intValue();
            }
            if (!s1.contains(".")) {
                int res = (int) cnt;
                whatyouwant.setText(res + "");
            } else {
                whatyouwant.setText(cnt + "");
            }
        } else if (s1.equals("") && !s2.equals("")) {
            double d2 = Double.parseDouble(s2);
            if (op.equals("+")) {
                cnt = d2;
            }
            if (op.equals("-")) {
                cnt = 0 - d2;
            }
            if (op.equals("×")) {
                cnt = 0;
            }
            if (op.equals("÷")) {
                cnt = 0;
            }
            if (op.equals("log10")) {
                Log10 a = new Log10();
                cnt = a.value(d2);
            }
            if (op.equals("ln")){
                Log a = new Log();
                cnt = a.value(d2);
            }
            if (op.equals("cos")){
                Cos a = new Cos();
                cnt = a.value(d2);
            }
            if (op.equals("sin")){
                Sin a = new Sin();
                cnt = a.value(d2);
            }
            if (op.equals("Asin")){
                Asin a = new Asin();
                cnt = a.value(d2);
            }
            if (op.equals("Acos")){
                Acos a = new Acos();
                cnt = a.value(d2);
            }

            if (op.equals("e^x")){
                Exp a = new Exp();
                cnt = a.value(d2);
            }
            if(op.equals("log1p")){
                Log1p a = new Log1p();
                cnt = a.value(d2);
            }
            if(op.equals("sqrt")){
                Sqrt a = new Sqrt();
                cnt = a.value(d2);
            }
            if(op.equals("tan")){
                Tan a = new Tan();
                cnt = a.value(d2);
            }
            if(op.equals("ATAN")){
                Atan a = new Atan();
                cnt = a.value(d2);
            }
            if(op.equals("!")){
                int t = (int)d2;
                cnt = BigIntegerMath.factorial(t).intValue();
            }
            if (!s2.contains(".")) {
                int res = (int) cnt;
                whatyouwant.setText(res + "");
            } else {
                whatyouwant.setText(cnt + "");
            }
        } else {
            whatyouwant.setText("");
        }
    }
}
