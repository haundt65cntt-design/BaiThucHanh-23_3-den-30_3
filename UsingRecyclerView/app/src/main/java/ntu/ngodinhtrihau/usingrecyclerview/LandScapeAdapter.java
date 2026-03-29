package ntu.ngodinhtrihau.usingrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LandScapeAdapter extends RecyclerView.Adapter<LandScapeAdapter.ItemLandHolder> {
    Context context;
    ArrayList<LandScape> lstData;

    public LandScapeAdapter(Context context, ArrayList<LandScape> lstData) {
        this.context = context;
        this.lstData = lstData;
    }

    @NonNull
    @Override
    public ItemLandHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom = LayoutInflater.from(context);
        View vItem= cai_bom.inflate(R.layout.item_land, parent, false);
        ItemLandHolder viewholderCreated = new ItemLandHolder(vItem);
        return viewholderCreated;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLandHolder holder, int position) {
        // Lấy đối tượng hiển thị
        LandScape landScapeHienThi = lstData.get(position);

        // Trích thông tin đúng chuẩn
        String caption = landScapeHienThi.getLandCation();
        String tenFileAnh = landScapeHienThi.getLandImageFileName(); // Đã sửa lỗi lấy nhầm tên

        // Đặt vào các trường thông tin của holder
        holder.tvCaption.setText(caption);

        // Đặt ảnh
        String packagename = holder.itemView.getContext().getPackageName();

        int imageID = holder.itemView.getResources().getIdentifier(tenFileAnh, "mipmap", packagename);
        holder.ivLandscape.setImageResource(imageID);
    }

    @Override
    public int getItemCount() {
        // Đã sửa lại thành lấy kích thước của mảng dữ liệu thật
        return lstData.size();
    }

    class ItemLandHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvCaption;
        ImageView ivLandscape;

        public ItemLandHolder(@NonNull View itemView) {
            super(itemView);
            tvCaption = itemView.findViewById(R.id.textViewCation);
            ivLandscape = itemView.findViewById(R.id.imageViewLand);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Code ở đây
            int ViTriDuocClick = getAdapterPosition();
            LandScape PhantuDuocClick = lstData.get(ViTriDuocClick);
            // bóc thông tin
            String ten = PhantuDuocClick.getLandCation();
            String tenFile = PhantuDuocClick.getLandImageFileName();
            // Toast Tên
            String chuoiThongBao = "Bạn vừa click vào : " + ten;
            Toast.makeText(v.getContext(), chuoiThongBao, Toast.LENGTH_SHORT);
        }
    }
}