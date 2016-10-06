package cn.liusiqian.gridtouchhelper;
import android.support.v7.widget.RecyclerView;

/**
 * Créé par liusiqian 16/10/5.
 */

public interface OnItemMoveListener
{
    void onItemMoved(int from, int to);
    void onItemDragStart(RecyclerView.ViewHolder holder);
    void onItemDragEnd(RecyclerView.ViewHolder holder);
}
