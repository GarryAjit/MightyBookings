package com.example.mvvivek.mightybookings;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ticket_info extends AppCompatActivity {

    Spinner s1,s2,s3,s4;
    Button btnDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btnDetails = (Button) findViewById(R.id.button2);
        s1 = (Spinner) findViewById(R.id.spinner);
        s2 = (Spinner) findViewById(R.id.spinner2);
        s3 = (Spinner) findViewById(R.id.spinner3);
        s4 = (Spinner) findViewById(R.id.spinner4);

        Intent i = getIntent();
        Bundle b=i.getExtras();
        final String theatre = (String) b.get("theatre");
        final String movie = (String) b.get("movie");

        btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (s1.getSelectedItem().toString().trim().equals("Select your seat class")||
                        s2.getSelectedItem().toString().trim().equals("Time Slot")||
                        s3.getSelectedItem().toString().trim().equals("No. Of Seats")||
                        s4.getSelectedItem().toString().trim().equals("Date") ) {
                    Toast.makeText(ticket_info.this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                Intent i= new Intent(ticket_info.this, user_info.class);
                String seatclass = s1.getSelectedItem().toString();
                String timeSlot = s2.getSelectedItem().toString();
                String noOfSeats = s3.getSelectedItem().toString();
                String dt = s4.getSelectedItem().toString();
                i.putExtra("theatre",theatre);
                i.putExtra("movie",movie);
                i.putExtra("seatclass",seatclass);
                i.putExtra("noOfSeats",noOfSeats);
                i.putExtra("timeSlot",timeSlot);
                i.putExtra("dt",dt);
                startActivity(i);}
            }
        });
        ArrayList<String> seatclass = new ArrayList<String>();
        seatclass.add("Select your seat class");
        seatclass.add("Upper Circle Rs.180");
        seatclass.add("Rear Circle Rs. 115");
        ArrayAdapter<String> seatlassadapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,seatclass)
        {

            @Override
            public boolean isEnabled(int position) {
                if(position==0)
                {
                    return false;

                }

                else
                {
                    return true;
                }
            }
        };
        s1.setAdapter(seatlassadapter);


        ArrayList<String> timeslot = new ArrayList<String>();
        timeslot.add("Time Slot");
        timeslot.add("11:30 AM");
        timeslot.add("02:30 PM");
        timeslot.add("05:30 PM");
        ArrayAdapter<String> timeslotadapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timeslot)
        {

            @Override
            public boolean isEnabled(int position) {
                if(position==0)
                {
                    return false;
                }

                else
                {
                    return true;
                }
            }
        };
        s2.setAdapter(timeslotadapter);


        ArrayList<String> seats = new ArrayList<String>();
        seats.add("No. Of Seats");
        seats.add("1");
        seats.add("2");
        seats.add("3");
        seats.add("4");
        seats.add("5");
        ArrayAdapter<String> seatsadapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,seats)
        {

            @Override
            public boolean isEnabled(int position) {
                if(position==0)
                {
                    return false;
                }

                else
                {
                    return true;
                }
            }
        };
        s3.setAdapter(seatsadapter);

        ArrayList<String> date = new ArrayList<String>();
        date.add("Date");
        String date1 = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        Calendar c = Calendar.getInstance();
        c.setTime(Calendar.getInstance().getTime());
        c.add(Calendar.DATE,1);
        Date d2 = c.getTime();
        String date2 = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(d2);

        Calendar c1 = Calendar.getInstance();
        c1.setTime(d2);
        c1.add(Calendar.DATE,1);
        Date d3 = c1.getTime();
        String date3 = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(d3);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(d3);
        c2.add(Calendar.DATE,1);
        Date d4 = c2.getTime();
        String date4 = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(d4);

        date.add(date1);
        date.add(date2);
        date.add(date3);
        date.add(date4);



        ArrayAdapter<String> dateadapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,date)
        {

            @Override
            public boolean isEnabled(int position) {
                if(position==0)
                {
                    return false;
                }

                else
                {
                    return true;
                }
            }
        };
        s4.setAdapter(dateadapter);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.dropdownmenu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if(id == R.id.aboutUs)
        {
            String url = "https://rootnode.co.in";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        }

        if(id == R.id.contactUs)
        {
            Intent i = new Intent(ticket_info.this,contact_us.class );
            startActivity(i);

        }

        if(id == R.id.home)
        {
            Intent i = new Intent(ticket_info.this,MainActivity.class );
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
}
