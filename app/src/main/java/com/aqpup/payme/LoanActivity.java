package com.aqpup.payme;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Person;


public class LoanActivity extends ActionBarActivity {

    final private int nLoan = 10;
    private ArrayList<Person> listPerson;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);

        context = this;
        ListView lvLoan = (ListView)findViewById(R.id.lvLoan);
        ImageButton ibAddLoan = (ImageButton)findViewById(R.id.ibAddLoan);
        listPerson = new ArrayList<Person>();

        loadData();

        final LoanAdapter loanAdapter = new LoanAdapter(context,listPerson);

        lvLoan.setAdapter(loanAdapter);


        ibAddLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(context);
                dialog.setTitle("Añadir Prestamo");
                dialog.setContentView(R.layout.dialog_add_loan);

                Button bClear = (Button) dialog.findViewById(R.id.bClear);
                Button bAddLoan = (Button) dialog.findViewById(R.id.bAddLoan);
                final EditText etName = (EditText) dialog.findViewById(R.id.etAddName);
                final EditText etAmount = (EditText) dialog.findViewById(R.id.etAddAmount);
                final EditText etDateLoan = (EditText) dialog.findViewById(R.id.etAddDateLoan);

                bClear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        etName.setText("");
                        etAmount.setText("");
                        etDateLoan.setText("");
                    }
                });

                bAddLoan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Convert to String to Date
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        String dateInString = etDateLoan.getText().toString();

                        try {

                            Date date = formatter.parse(dateInString);
                            Person person = new Person(etName.getText().toString(), date, Double.valueOf(etAmount.getText().toString()));
                            loanAdapter.add(person);

                            loanAdapter.notifyDataSetChanged();

                            dialog.dismiss();

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                });

                dialog.show();
            }
        });


    }

    public void loadData(){

        // Date(int year, int month, int day)
        for (int i = 0; i < nLoan; i++){
            listPerson.add(new Person("Jesus", new Date(2015, 12, 12), 100.00));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_loan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
