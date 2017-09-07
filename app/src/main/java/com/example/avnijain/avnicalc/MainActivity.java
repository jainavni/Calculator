package com.example.avnijain.avnicalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button b0;
    Button dot;
    Button equal;
    Button mul;
    Button div;
    Button add;
    Button sub;
    Button del;
    TextView t1;
    TextView t2;

    int op;
    Double n1=0.0,n2,res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = (TextView)findViewById(R.id.Text1);
        t2 = (TextView)findViewById(R.id.Text2);

         b1 = (Button)findViewById(R.id.one);
         b2 = (Button)findViewById(R.id.two);
         b3 = (Button)findViewById(R.id.three);
         b4 = (Button)findViewById(R.id.four);
         b5 = (Button)findViewById(R.id.five);
         b6 = (Button)findViewById(R.id.six);
         b7 = (Button)findViewById(R.id.seven);
         b8 = (Button)findViewById(R.id.eight);
         b9 = (Button)findViewById(R.id.nine);
         b0 = (Button)findViewById(R.id.zero);
         dot = (Button)findViewById(R.id.dot);
         add = (Button)findViewById(R.id.add);
         sub= (Button)findViewById(R.id.sub);
         mul= (Button)findViewById(R.id.mul);
         div= (Button)findViewById(R.id.div);
       del= (Button)findViewById(R.id.del);
       equal= (Button)findViewById(R.id.equal);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        dot.setOnClickListener(new View.OnClickListener()
        {  @Override
            public void onClick(View view) {
                String txt = t2.getText().toString();
            //   if(txt.length()==0)
                if(txt.isEmpty()) {
                    txt = "0.0";
                    t2.setText(txt);
                }
                if (!txt.contains(".")) {
                    t2.append(".");
                }
            }
        });
        del.setOnClickListener(new View.OnClickListener()
        {
          @Override
          public void onClick(View view) {
                        delt();

          }});


        del.setOnLongClickListener(new View.OnLongClickListener()
        {

            @Override
            public boolean onLongClick(View view) {
               reset();
                return false;
            }


        });

        add.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                String str =t2.getText().toString();
                String str2= t1.getText().toString();
              if(str2.endsWith("+")||str2.endsWith("-")||str2.endsWith("*")||str2.endsWith("/")){
                  str2 = str2.substring(0, str2.length() - 1);
                 // str2 = t1.getText().toString();
              }
                if(str.length()!=0) {
                    n1 = Double.parseDouble(str);
                    op = 1;
                    t1.setText(n1+"+");
                    t2.setText("");
                }
                else if(str2.length()!=0)
                {
                    n1 = Double.parseDouble(str2);
                    op = 1;
                    t1.setText(n1+"+");
                    t2.setText("");

                }

            }
        });
        sub.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {

                String str =t2.getText().toString();
                String str2= t1.getText().toString();
                if(str2.endsWith("+")||str2.endsWith("-")||str2.endsWith("*")||str2.endsWith("/")){
                    str2 = str2.substring(0, str2.length() - 1);
                    //str2 = t1.getText().toString();
                }
                if(str.length()!=0) {
                    n1 = Double.parseDouble(str);
                    op = 2;
                    t1.setText(n1+"-");
                    t2.setText("");
                }
                else if(str2.length()!=0)
                {
                    n1 = Double.parseDouble(str2);
                    op = 2;
                    t1.setText(n1+"-");
                    t2.setText("");

                }
            }
        });
        mul.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {

                String str =t2.getText().toString();
                String str2= t1.getText().toString();
                if(str2.endsWith("+")||str2.endsWith("-")||str2.endsWith("*")||str2.endsWith("/")){
                    str2 = str2.substring(0, str2.length() - 1);
                    //str2 = t1.getText().toString();
                }
                if(str.length()!=0) {
                    n1 = Double.parseDouble(str);
                    op = 3;
                    t1.setText(n1+"*");
                    t2.setText("");
                }
                else if(str2.length()!=0)
                {
                    n1 = Double.parseDouble(str2);
                    op = 3;
                    t1.setText(n1+"*");
                    t2.setText("");

                }
            }
        });
        div.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {

                String str = t2.getText().toString();
                String str2= t1.getText().toString();
                if(str.isEmpty()&&str2.isEmpty())
                    return;
                if(str2.endsWith("+")||str2.endsWith("-")||str2.endsWith("*")||str2.endsWith("/")) {
                    str2 = str2.substring(0, str2.length() - 1);
                    //str2 = t1.getText().toString();
                }
                if(str.length()!=0) {
                    n1 = Double.parseDouble(str);
                    op = 4;
                    t1.setText(n1+"/");
                    t2.setText("");
                }
                else if(str2.length()!=0 )
                {
                    n1 = Double.parseDouble(str2);
                    op = 4;
                    t1.setText(n1+"/");
                    t2.setText("");

                }

            }
        });

        equal.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view) {

                String str = t2.getText().toString();
                String str1 = t1.getText().toString();
                if (str1.isEmpty()) {
                    t1.setText(str);
                    t2.setText("");
                    n1 = Double.parseDouble(str);
                } else {
                    if (str.length() != 0) {
                        n2 = Double.parseDouble(str);

                        if (op == 1)
                            res = n1 + n2;
                        else if (op == 2)
                            res = n1 - n2;
                        else if (op == 3)
                            res = n1 * n2;
                        else if (op == 4)
                            res = n1 / n2;
                        t1.setText("" + res);
                        t2.setText("");
                        op = 0;
                    }
                }
            }
        });
  }

    private void reset() {
        t1.setText("");
        t2.setText("");
        n1=0.0;
        n2=0.0;
        op=0;
    }

    private void delt() {
        String str1 = t1.getText().toString();
        String str2 = t2.getText().toString();
        Log.i("Avni",str1);
        if(str1.equalsIgnoreCase("Infinity")) {
            Log.i("Avni",str1);
            reset();
        }
        else {
            if (str2.length() > 0) {
                str2 = str2.substring(0, str2.length() - 1);
//                  if (str2.equals(""))
//                      str2 = "";
                t2.setText(str2);
            } else if (str1.length() > 0) {
                str1 = str1.substring(0, str1.length() - 1);
                t1.setText("");
                t2.setText(str1);
            }
        }
    }

    @Override
    public void onClick(View v) {
        int ch=0;

          if (v.getId() == b1.getId())
              ch = 1;
          else if (v.getId() == b2.getId())
              ch = 2;
          else if (v.getId() == b3.getId())
              ch = 3;

          else if (v.getId() == b4.getId())
              ch = 4;
          else if (v.getId() == b5.getId())
              ch = 5;
          else if (v.getId() == b6.getId())
              ch = 6;

          else if (v.getId() == b7.getId())
              ch = 7;
          else if (v.getId() == b8.getId())
              ch = 8;
          else if (v.getId() == b9.getId())
              ch = 9;
          else if (v.getId() == b0.getId())
              ch = 0;

          String str = t2.getText().toString();
        if(str.equals("0")) {
            if (ch == 0)
                str = "0";
            else
                str = Integer.toString(ch);
        }else
            str = str + Integer.toString(ch);
        t2.setText(str);

//          if (str.contains(".")&&str.length() != 0) {
//              n1 = Double.parseDouble(str);
//              t2.setText("" + n1 + ch);
//          } else if(str.length()!=0) {
//              int a = Integer.parseInt(str);
//              t2.setText("" + a + ch);
//          }else
//              t2.setText("" + ch);

      }





    }
