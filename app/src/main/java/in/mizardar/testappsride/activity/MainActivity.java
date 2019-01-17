package in.mizardar.testappsride.activity;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.Display;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import in.mizardar.testappsride.R;
import in.mizardar.testappsride.model.ModelWeather;
import in.mizardar.testappsride.utils.MyClient;
import in.mizardar.testappsride.utils.ServiceInterface;
import in.mizardar.testappsride.utils.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Calendar _selectedDate = Calendar.getInstance();

    private String _formattedDate;

    private AppCompatTextView mTextSelectedDate, mTextNotPrime;

    private ServiceInterface serviceInterface;

    private ModelWeather  modelWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        //get the Retrofit API Client
        serviceInterface = MyClient.getRetrofitClient().create(ServiceInterface.class);

    }

    private void initView() {

        //initialize all views
        mTextNotPrime = (AppCompatTextView) findViewById(R.id.textNotPrime);
        mTextSelectedDate = (AppCompatTextView) findViewById(R.id.textSelectedDate);


    }

    public void showDatePicker(View view) {

        final Calendar cal = Calendar.getInstance();
        int mYear = cal.get(Calendar.YEAR);
        int mMonth = cal.get(Calendar.MONTH);
        int mDay = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy EEE");

                        //set the date to a calender in millisecond
                        _selectedDate = Calendar.getInstance();
                        _selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        _selectedDate.set(Calendar.MONTH, monthOfYear);
                        _selectedDate.set(Calendar.YEAR, year);
                        Date date = new Date();
                        date.setTime(_selectedDate.getTimeInMillis());
                        _formattedDate = simpleDateFormat.format(date);
                        processData();
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void processData() {

        // check  for prime number
        if (!Utils.isPrimeNumberSelected(_selectedDate.get(Calendar.DAY_OF_MONTH))) {
            mTextNotPrime.setVisibility(View.GONE);
            getAPIData();

        } else {
            mTextNotPrime.setVisibility(View.VISIBLE);
        }

    }

    private void getAPIData() {


        Call<ModelWeather> weatherCall = serviceInterface.getWeatherDetails("Pune ,IN", getResources().getString(R.string.appID));

        weatherCall.enqueue(new Callback<ModelWeather>() {
            @Override
            public void onResponse(Call<ModelWeather> call, Response<ModelWeather> response) {

                try{

                    if (response.raw().code() == 200){

                        modelWeather = (ModelWeather) response.body();
                        setView();
                    }else {
                        Toast.makeText(MainActivity.this, getString(R.string.serverError), Toast.LENGTH_SHORT).show();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, getString(R.string.serverError), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<ModelWeather> call, Throwable t) {

                try{
                    Toast.makeText(MainActivity.this, getString(R.string.serverError), Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });

    }

    private void setView() {


    }


}