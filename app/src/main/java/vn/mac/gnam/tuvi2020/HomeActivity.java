package vn.mac.gnam.tuvi2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }


    public void saoChieuMenh(View view) {
        Intent intent = new Intent(HomeActivity.this, SaoChieuMenhActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Sao Chieu Menh", Toast.LENGTH_SHORT).show();
    }

    public void trangPhuc(View view) {
        Intent intent = new Intent(HomeActivity.this, TrangPhucMayManActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Trang Phuc", Toast.LENGTH_SHORT).show();
    }

    public void simSoDep(View view) {
        Intent intent = new Intent(HomeActivity.this, SimSoDepActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Sim So Dep", Toast.LENGTH_SHORT).show();
    }
}
