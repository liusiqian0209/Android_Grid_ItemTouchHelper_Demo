package cn.liusiqian.gridtouchhelper;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Créé par liusiqian 16/10/5.
 */

public class TextViewHolder extends RecyclerView.ViewHolder
{
    public TextView tvContent;

    public TextViewHolder(View itemView)
    {
        super(itemView);
        tvContent = (TextView) itemView.findViewById(R.id.item_text);
    }
}
