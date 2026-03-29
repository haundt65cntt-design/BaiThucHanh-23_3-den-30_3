package ntu.ngodinhtrihau.usingrecyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> recylerViewDatas;
    RecyclerView recyclerViewLandscape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //3
        recylerViewDatas = getDataForRecyclerView();
        //4
        recyclerViewLandscape = findViewById(R.id.recyclerLand);
        //5
//        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(this);
//        recyclerViewLandscape.setLayoutManager(layoutLinear);
        RecyclerView.LayoutManager layoutManagerHorizonal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewLandscape.setLayoutManager(layoutManagerHorizonal);
        //6
        landScapeAdapter = new LandScapeAdapter(this, recylerViewDatas);
        //7
        recyclerViewLandscape.setAdapter(landScapeAdapter);
    }

    ArrayList<LandScape> getDataForRecyclerView() {
        ArrayList<LandScape> dsDuLieu = new ArrayList<LandScape>();
        LandScape landScape1 = new LandScape("flag_tower_of_hanoi","Cột cờ H Nội");
        dsDuLieu.add(landScape1);
        dsDuLieu.add( new LandScape("eiffel_tower_paris", "Tháp eiffel" ) );
        dsDuLieu.add( new LandScape("buckingham", "Cung điện Buckingham" ) );
        dsDuLieu.add( new LandScape("hanoi_flag_tower", "Tượng nữ thần tự do" ) );
        return dsDuLieu;
    }
}