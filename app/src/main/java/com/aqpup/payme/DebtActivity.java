package com.aqpup.payme;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

import model.Person;


public class DebtActivity extends ActionBarActivity {

    final private int nLoan = 10;
    private ArrayList<Person> listPerson;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debt);

        context = this;
        ListView lvDebt = (ListView)findViewById(R.id.lvDebt);
        listPerson = new ArrayList<Person>();

        loadData();

        DebtAdapter loanAdapter = new DebtAdapter(context, listPerson);
        lvDebt.setAdapter(loanAdapter);

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
        getMenuInflater().inflate(R.menu.menu_debt, menu);
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
