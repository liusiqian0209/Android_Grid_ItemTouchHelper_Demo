package cn.liusiqian.gridtouchhelper;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Créé par liusiqian 16/10/5.
 */

public class DragHelperCallback extends ItemTouchHelper.Callback
{
    private OnItemMoveListener listener;
    private RecyclerView.ViewHolder curDragHolder;

    public DragHelperCallback(@NonNull OnItemMoveListener listener)
    {
        this.listener = listener;
    }

    @Override
    public boolean isItemViewSwipeEnabled()
    {
        return false;
    }

    @Override
    public boolean isLongPressDragEnabled()
    {
        return true;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder)
    {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlags, 0);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target)
    {
        listener.onItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction)
    {

    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState)
    {
        switch (actionState)
        {
            case ItemTouchHelper.ACTION_STATE_DRAG:
                curDragHolder = viewHolder;
                listener.onItemDragStart(curDragHolder);
                break;
            case ItemTouchHelper.ACTION_STATE_IDLE:
                if(curDragHolder !=null)
                {
                    listener.onItemDragEnd(curDragHolder);
                    curDragHolder = null;
                }
                break;
        }
        super.onSelectedChanged(viewHolder, actionState);
    }
}
