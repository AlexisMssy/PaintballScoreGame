package org.diiage.amassey.paintballscoregame.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.diiage.amassey.paintballscoregame.Manche.Manche;
import org.diiage.amassey.paintballscoregame.R;

import java.text.SimpleDateFormat;
import java.util.List;

public class ListViewManchesAdapter extends BaseAdapter {

    private List<Manche> data;
    Context context;
    ListView lv;

    // Provide a suitable constructor (depends on the kind of dataset)
    public ListViewManchesAdapter(List<Manche> data, Context context) {
        super();
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Manche getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder holder = null;

        if(view == null)
        {
            view = LayoutInflater.from(this.context).inflate(R.layout.listview_rowmanche, viewGroup, false);
        }
        holder = new MyViewHolder(view);
        Manche manche = getItem(i);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        holder.idManche.setText(String.valueOf(manche.getId()));
        holder.dateManche.setText(String.valueOf(df.format(manche.getDate())));
        holder.numeroManche.setText(String.valueOf(manche.getNumero()));

        return view;
    }

}

class MyViewHolder {
    // each data item is just a string in this case
    public final TextView idManche;
    public final TextView numeroManche;
    public final TextView dateManche;

    public MyViewHolder(final View itemView) {
        idManche = itemView.findViewById(R.id.item_id);
        numeroManche = itemView.findViewById(R.id.item_numero);
        dateManche = itemView.findViewById(R.id.item_date);
    }
}