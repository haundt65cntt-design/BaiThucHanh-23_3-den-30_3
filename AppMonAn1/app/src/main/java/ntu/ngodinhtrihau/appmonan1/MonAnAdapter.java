package ntu.ngodinhtrihau.appmonan1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MonAnAdapter extends BaseAdapter {

    private ArrayList<MonAn> dsMonAn;
    private LayoutInflater layoutInflater;
    private Context context;

    // hàm tạo
    public MonAnAdapter(Context _context, ArrayList<MonAn> dsMonAn) {
        this.dsMonAn = dsMonAn;
        this.context = _context;
        this.layoutInflater = LayoutInflater.from(_context);
    }

    @Override
    public int getCount() {
        return dsMonAn.size();
    }

    @Override
    public Object getItem(int position) {
        return dsMonAn.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // View item hiện hành
        View viewHienHanh = convertView;

        // Kiểm tra xem view đã tồn tại chưa để tái sử dụng
        if (viewHienHanh == null) {
            viewHienHanh = layoutInflater.inflate(R.layout.item_monan, parent, false);
        }

        // Lấy dữ liệu của món ăn tại vị trí hiện tại
        MonAn monAnHienTai = dsMonAn.get(position);

        // Gắn tên các điều khiển (Đã sửa lại ID của ImageView)
        TextView textView_TenMon = (TextView) viewHienHanh.findViewById(R.id.tvTenMonAn);
        TextView textView_DonGia = (TextView) viewHienHanh.findViewById(R.id.tvDonGia);
        TextView textView_MoTa = (TextView) viewHienHanh.findViewById(R.id.tvMoTa);
        ImageView imageView_Anh = (ImageView) viewHienHanh.findViewById(R.id.imAnhDaiDien); // Đã xóa chữ 'tv' dư thừa

        // Set dữ liệu lên giao diện
        textView_TenMon.setText(monAnHienTai.getTenMonAn());

        // Nối thêm chữ "đ" hoặc "VND" cho sinh động
        textView_DonGia.setText(String.valueOf(monAnHienTai.getDonGia()) + "đ");

        textView_MoTa.setText(monAnHienTai.getMoTa());
        imageView_Anh.setImageResource(monAnHienTai.getIdAnhMinhHoa());

        return viewHienHanh;
    }
}