package vn.mac.gnam.tuvi2020;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SaoChieuMenhActivity extends AppCompatActivity {
    private RadioGroup radiogr;
    private RadioButton radio1;
    private RadioButton radio2;
    private TextView birthYear;
    private ImageButton imageButton1;
    private TextView buildingYear;
    private ImageButton imageButton2;
    private Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sao_chieu_menh);
        init();
    }

    private void init() {

        radiogr = (RadioGroup) findViewById(R.id.radiogr);
        radio1 = (RadioButton) findViewById(R.id.radio1);
        radio2 = (RadioButton) findViewById(R.id.radio2);
        birthYear = (TextView) findViewById(R.id.birthYear);
        imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
        buildingYear = (TextView) findViewById(R.id.buildingYear);
        imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        btnResult = (Button) findViewById(R.id.btn_result);

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog monthDatePickerDialog = new DatePickerDialog(SaoChieuMenhActivity.this,
                        AlertDialog.THEME_HOLO_LIGHT, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        birthYear.setText(year+"");
                    }
                }, 2019, 0, 0){
                    @Override
                    protected void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
                        getDatePicker().findViewById(getResources().getIdentifier("day","id","android")).setVisibility(View.GONE);
                        getDatePicker().findViewById(getResources().getIdentifier("month","id","android")).setVisibility(View.GONE);
                    }
                };
                monthDatePickerDialog.setTitle("Năm Sinh");
                monthDatePickerDialog.show();
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog monthDatePickerDialog = new DatePickerDialog(SaoChieuMenhActivity.this,
                        AlertDialog.THEME_HOLO_LIGHT, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        buildingYear.setText(year+"");
                    }
                }, 2019, 0, 0){
                    @Override
                    protected void onCreate(Bundle savedInstanceState) {
                        super.onCreate(savedInstanceState);
                        getDatePicker().findViewById(getResources().getIdentifier("day","id","android")).setVisibility(View.GONE);
                        getDatePicker().findViewById(getResources().getIdentifier("month","id","android")).setVisibility(View.GONE);
                    }
                };
                monthDatePickerDialog.setTitle("Năm Xem");
                monthDatePickerDialog.show();
            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String rbMale = radio1.getText().toString();
                String rbFemale = radio2.getText().toString();
                String tvBirthYear = birthYear.getText().toString();
                String tvBuildingYear = buildingYear.getText().toString();
                Intent intent = new Intent(SaoChieuMenhActivity.this, ResultActivity.class);
                if (radio1.isChecked()){
                    intent.putExtra("nam", "https://tuvivannien.com/sao-chieu-menh/nam-sinh-" + tvBirthYear + "-nam-xem-" + tvBuildingYear + "-gioi-tinh-" + rbMale);
                }else {
                    intent.putExtra("nam", "https://tuvivannien.com/sao-chieu-menh/nam-sinh-" + tvBirthYear + "-nam-xem-" + tvBuildingYear + "-gioi-tinh-" + rbFemale);
                }
                startActivity(intent);
            }
        });
    }
}
