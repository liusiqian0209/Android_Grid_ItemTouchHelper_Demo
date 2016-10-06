package cn.liusiqian.gridtouchhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private RecyclerView recycler;
    private DragAdapter adapter;
    private List<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initWidget();
    }

    private void initWidget()
    {
        recycler = (RecyclerView) findViewById(R.id.recycler);
        adapter = new DragAdapter(this,datas);
        RecyclerView.LayoutManager manager = new GridLayoutManager(this,3);
        recycler.setLayoutManager(manager);
        ItemTouchHelper helper = new ItemTouchHelper(new DragHelperCallback(adapter));
        recycler.setAdapter(adapter);
        helper.attachToRecyclerView(recycler);
    }

    private void initData()
    {
        datas = new ArrayList<>();
        for(int i=0; i<35;i++)
        {
            String str = "Item--"+(i+1);
            datas.add(str);
        }
    }
}
