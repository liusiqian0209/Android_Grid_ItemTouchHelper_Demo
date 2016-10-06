package cn.liusiqian.gridtouchhelper;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Créé par liusiqian 16/10/5.
 */

public class DragAdapter extends RecyclerView.Adapter<TextViewHolder> implements OnItemMoveListener
{
    private LayoutInflater inflater;
    private Context context;
    private List<String> mDatas;

    public DragAdapter(Context context, List<String> mDatas)
    {
        this.context = context;
        this.mDatas = mDatas;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = inflater.inflate(R.layout.item_text, parent, false);
        return new TextViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TextViewHolder holder, int position)
    {
        holder.tvContent.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount()
    {
        return mDatas.size();
    }


    /******************************** Implements of OnItemMoveListener *********************/

    @Override
    public void onItemMoved(int from, int to)
    {
        mDatas.add(to, mDatas.remove(from));
        notifyItemMoved(from,to);
    }

    @Override
    public void onItemDragStart(RecyclerView.ViewHolder holder)
    {
        holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.red_bg));
    }

    @Override
    public void onItemDragEnd(RecyclerView.ViewHolder holder)
    {
        holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.gray_bg));
    }
}
