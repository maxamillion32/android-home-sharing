package mcl.jejunu.ac.homesharing.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;

import mcl.jejunu.ac.homesharing.R;
import mcl.jejunu.ac.homesharing.model.Reservation;

/**
 * Created by neo-202 on 2016-05-31.
 */
public class ReservationListAdapter extends RecyclerView.Adapter<ReservationListAdapter.ViewHolder> {
    private ArrayList<Reservation> reservations;
    private View.OnClickListener listener;

    public ReservationListAdapter(Collection<Reservation> reservations, View.OnClickListener listener) {
        this.reservations = new ArrayList<>();
        this.reservations.addAll(reservations);
        this.listener = listener;
    }

    @Override
    public ReservationListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    }


    @Override
    public int getItemCount() {
        return reservations.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View v) {
            super(v);
        }
    }
}
