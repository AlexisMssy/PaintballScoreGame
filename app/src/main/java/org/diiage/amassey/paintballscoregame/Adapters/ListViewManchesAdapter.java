package org.diiage.amassey.paintballscoregame.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.diiage.amassey.paintballscoregame.Manche.Manche;
import org.diiage.amassey.paintballscoregame.R;

import java.util.List;

public class ListViewManchesAdapter extends RecyclerView.Adapter<ListViewManchesAdapter.MyViewHolder> {

    private List<Manche> dataListeManches;
    Context context;

    // Provide a suitable constructor (depends on the kind of dataset)
    public ListViewManchesAdapter(List<Manche> data, Context context) {
        super();
        this.context = context;
        dataListeManches = data;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.listview_rowmanche, parent, false);

        // TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_listmatch, parent, false);

        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        final Manche manche = dataListeManches.get(position);
        holder.idManche.setText(String.valueOf(manche.getId()));
        holder.numeroManche.setText(String.valueOf(manche.getNumero()));
        holder.dateManche.setText(String.valueOf(manche.getDate()));
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private final TextView idManche;
        private final TextView numeroManche;
        private final TextView dateManche;

        public MyViewHolder(final View itemView) {
            super(itemView);
            idManche = itemView.findViewById(R.id.item_id);
            numeroManche = itemView.findViewById(R.id.item_numero);
            dateManche = itemView.findViewById(R.id.item_date);
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return dataListeManches.size();
    }

}
