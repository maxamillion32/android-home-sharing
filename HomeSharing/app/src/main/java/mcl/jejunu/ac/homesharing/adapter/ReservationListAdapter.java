package mcl.jejunu.ac.homesharing.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.reservation_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.cardView.setTag(getReservation(position));
        holder.cardView.setOnClickListener(listener);
        holder.checkInText.setText(getReservation(position).getCheck_in());
        holder.checkOutText.setText(getReservation(position).getCheck_out());
        holder.peopleText.setText(String.valueOf(getReservation(position).getPeople()));
    }

    public Reservation getReservation(int position) {
        return reservations.get(position);
    }

    @Override
    public int getItemCount() {
        return reservations.size();
    }

    public void replaceWith(Collection<Reservation> reservations) {
        this.reservations.clear();
        this.reservations.addAll(reservations);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public CardView cardView;
        public TextView checkInText;
        public TextView checkOutText;
        public TextView peopleText;

        public ViewHolder(View v) {
            super(v);
            cardView = (CardView) v.findViewById(R.id.card_view);
            checkInText = (TextView) v.findViewById(R.id.check_in_text);
            checkOutText = (TextView) v.findViewById(R.id.check_out_text);
            peopleText = (TextView) v.findViewById(R.id.people_text);
        }
    }
}

