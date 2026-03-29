package ntu.ngodinhtrihau.appmonan1;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import ntu.ngodinhtrihau.appmonan1.MonAn;
import ntu.ngodinhtrihau.appmonan1.MonAnAdapter;
import ntu.ngodinhtrihau.appmonan1.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Tìm listview
        ListView lvDSMonAn = findViewById(R.id.lvDSMonAn);

        // Chuẩn bị nguồn dữ liệu
        ArrayList<MonAn> dsMonAn = new ArrayList<>();
        dsMonAn.add( new MonAn("Cơm Tấm Sườn", 25000, "Mô tả ở đây", R.drawable.cts));
        dsMonAn.add( new MonAn("Cơm sườn trứng", 27000, "Mô tả ở đây", R.drawable.cst));
        dsMonAn.add( new MonAn("Gà xối mỡ", 30000, "Mô tả ở đây", R.drawable.gxm));
        dsMonAn.add( new MonAn("Sườn bì chả", 32000, "Mô tả ở đây", R.drawable.sbc));
        dsMonAn.add( new MonAn("Đặc biệt", 35000, "Mô tả ở đây", R.drawable.db));
        // Gắn Adapter
        MonAnAdapter adapter = new MonAnAdapter(this, dsMonAn);
        lvDSMonAn.setAdapter(adapter);

        // Bắt xử lý sự kiện
        lvDSMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                // lấy phần tử được chạm
                MonAn monAnChon = dsMonAn.get(i);

                // Hiển thị thông báo
                Toast.makeText(MainActivity.this, monAnChon.getTenMonAn(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}