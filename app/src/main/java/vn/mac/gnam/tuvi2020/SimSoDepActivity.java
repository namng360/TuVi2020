package vn.mac.gnam.tuvi2020;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SimSoDepActivity extends AppCompatActivity {
    private RadioGroup radiogr;
    private RadioButton radio1;
    private RadioButton radio2;
    private TextView birthDay;
    private ImageButton imageButton;
    private EditText phoneNumber;
    private Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim_so_dep);
        init();
    }

    private void init() {
        radiogr = (RadioGroup) findViewById(R.id.radiogr);
        radio1 = (RadioButton) findViewById(R.id.radio1);
        radio2 = (RadioButton) findViewById(R.id.radio2);
        birthDay = (TextView) findViewById(R.id.birthDay);
        imageButton = (ImageButton) findViewById(R.id.imageButton);
        phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        btnResult = (Button) findViewById(R.id.btn_result);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get Current Date
                DatePickerDialog monthDatePickerDialog = new DatePickerDialog(SimSoDepActivity.this,
                        AlertDialog.THEME_HOLO_LIGHT, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        birthDay.setText(dayOfMonth+ "-" + month + "-" + year);
                    }
                }, 2019, 0, 0){
                    @Override
                    protected void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
//                    getDatePicker().findViewById(getResources().getIdentifier("day","id","android")).setVisibility(View.GONE);
//                    getDatePicker().findViewById(getResources().getIdentifier("month","id","android")).setVisibility(View.GONE);
                    }
                };
                monthDatePickerDialog.setTitle("Năm Sinh");
                monthDatePickerDialog.show();
            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rbMale = radio1.getText().toString();
                String rbFemale = radio2.getText().toString();
                String tvDate = birthDay.getText().toString();
                String num = phoneNumber.getText().toString();
                Intent intent = new Intent(SimSoDepActivity.this, ResultActivity.class);
                if (radio1.isChecked()){
                    intent.putExtra("nam", "https://tuvivannien.com/sim-so-dep/so-dien-thoai-" + num + "-" + rbMale + "-sinh-ngay-" + tvDate);
                }else {
                    intent.putExtra("nam", "https://tuvivannien.com/sim-so-dep/so-dien-thoai-" + num + "-" + rbFemale + "-sinh-ngay-" + tvDate);
                }
                startActivity(intent);
            }
        });
    }
}
