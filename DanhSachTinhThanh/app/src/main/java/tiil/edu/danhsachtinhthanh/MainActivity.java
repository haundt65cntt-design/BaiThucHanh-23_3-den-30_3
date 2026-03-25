package tiil.edu.danhsachtinhthanh;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> dsTenTinhThanhVN; // khai báo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Hiển thị dữ liệu lên ListView
        // B1+: Cần phải có dữ liệu
        // ? từ đâu có: từ cơ sở dữ liệu (SQL, noSQL, XML,..)
        // ở bài này chúng ta hard-code dữ liệu trực tiếp
        dsTenTinhThanhVN = new ArrayList<String>(); // tạo thể hiện công cụ, xin mới
        // Thêm dữ liệu ở đây (đúng ra, ta phải đọc từ một nguồn
        // Nhưng ta hard-code (cho sẵn demo)
        dsTenTinhThanhVN.add("Hà Nội");
        dsTenTinhThanhVN.add("Thành Phố Hồ Chí Minh");
        dsTenTinhThanhVN.add("Đồng Nai");
        dsTenTinhThanhVN.add("Bình Thuận");
        dsTenTinhThanhVN.add("Ninh Thuận");
        dsTenTinhThanhVN.add("Nha Trang");

        // B2. Tạo adapter
        ArrayAdapter<String> adapterTinhThanh;
        adapterTinhThanh = new ArrayAdapter<String>( this,
                                                                android.R.layout.simple_list_item_1,
                                                                dsTenTinhThanhVN
                                                                );

        // B3. Gắn vào điều khiển hiển thị ListView
        // B3.1, Tìm
        ListView lvTenTinhThanh = findViewById(R.id.lvDanhSachTT);
        // B3.2 Gắn
        lvTenTinhThanh.setAdapter(adapterTinhThanh);
        // B3.3 Lắng nghe và xử lý sự kiện user tương tác
        // Gắn bộ lắng nghe vào
        lvTenTinhThanh.setOnItemClickListener(BoLangNghevaXL);
    }
    // Tạo bộ lắng nghe và xử lý sự kiện OnItemClick, đặt vào một biến
    // vd: BoLangNghevaXL
    AdapterView.OnItemClickListener BoLangNghevaXL = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            // Code xử lý ở đây
            // i là vị trí phần tử vừa được click
            // vd khác, thay vì hiện vị trí, ta hiện giá trị
            // lấy giá trị của phần tử i
            String strTenTinhChon= dsTenTinhThanhVN.get(i);

            Toast.makeText(MainActivity.this, strTenTinhChon, Toast.LENGTH_LONG).show();

        }
    };
}