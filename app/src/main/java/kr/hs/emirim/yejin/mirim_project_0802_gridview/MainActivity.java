package kr.hs.emirim.yejin.mirim_project_0802_gridview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    GridView gridv;
    int[] posterId = {R.drawable.pos1,R.drawable.pos2,R.drawable.pos3,R.drawable.pos4,R.drawable.pos5,
                    R.drawable.pos6,R.drawable.pos7,R.drawable.pos8,R.drawable.pos9,R.drawable.pos10,
                    R.drawable.pos1,R.drawable.pos2,R.drawable.pos3,R.drawable.pos4,R.drawable.pos5,
                    R.drawable.pos6,R.drawable.pos7,R.drawable.pos8,R.drawable.pos9,R.drawable.pos10,
                    R.drawable.pos1,R.drawable.pos2,R.drawable.pos3,R.drawable.pos4,R.drawable.pos5,
                    R.drawable.pos6,R.drawable.pos7,R.drawable.pos8,R.drawable.pos9,R.drawable.pos10};
    String[] posterTitle = {"구르미 그린 달빛","그해 우리는","런온","스타트 업","쌈마이웨이","여신강림",
                            "유미의 세포들","에이틴2","호텔델루나","어느날 우리집 현관으로 멸망이 들어왔다",
                            "구르미 그린 달빛","그해 우리는","런온","스타트 업","쌈마이웨이","여신강림",
                            "유미의 세포들","에이틴2","호텔델루나","어느날 우리집 현관으로 멸망이 들어왔다",
                            "구르미 그린 달빛","그해 우리는","런온","스타트 업","쌈마이웨이","여신강림",
                            "유미의 세포들","에이틴2","호텔델루나","어느날 우리집 현관으로 멸망이 들어왔다"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("최신 드라마 포스터");
        gridv = findViewById(R.id.gridv);
        PosterAdapter adapter = new PosterAdapter(this);
        gridv.setAdapter(adapter);

    }

    public class PosterAdapter extends BaseAdapter{
        Context context;
        public PosterAdapter(Context context){
            this.context = context;
        }

        @Override
        public int getCount() {
            return posterId.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imgv = new ImageView(context);
            ViewGroup.LayoutParams params = new GridView.LayoutParams(200,300);
            imgv.setLayoutParams(params);
            imgv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imgv.setPadding(5,5,5,5);
            imgv.setImageResource(posterId[i]);
            final int pos = i;
            imgv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    dlg.setTitle(posterTitle[pos]);
                    dlg.setIcon(R.drawable.micon);
                    View dlgView = View.inflate(MainActivity.this, R.layout.dialog,null);
                    ImageView imgvDlg = dlgView.findViewById(R.id.imgv_dlg);
                    imgvDlg.setImageResource(posterId[pos]);
                    dlg.setView(dlgView);
                    dlg.setNegativeButton("close",null);
                    dlg.show();
                }
            });

            return imgv;
        }
    }
}