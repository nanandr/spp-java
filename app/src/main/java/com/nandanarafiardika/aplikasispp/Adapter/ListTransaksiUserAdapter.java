package com.nandanarafiardika.aplikasispp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nandanarafiardika.aplikasispp.Model.Pembayaran;
import com.nandanarafiardika.aplikasispp.Model.Transaksi;
import com.nandanarafiardika.aplikasispp.R;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ListTransaksiUserAdapter extends RecyclerView.Adapter<ListTransaksiUserAdapter.ListViewHolder> {
    List<Transaksi> listTransaksi;

    private ListTransaksiUserAdapter.OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(ListTransaksiUserAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListTransaksiUserAdapter(List<Transaksi> listTransaksi) {
        this.listTransaksi = listTransaksi;
    }

    @NonNull
    @Override
    public ListTransaksiUserAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tagihan, parent, false);
        return new ListTransaksiUserAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListTransaksiUserAdapter.ListViewHolder holder, int position) {
        Transaksi pembayaran = listTransaksi.get(position);
        holder.tvBulan.setText(pembayaran.getBulan());
        holder.tvTanggalBayar.setText(pembayaran.getTanggalBayar() != null ? pembayaran.getTanggalBayar() : "");
        int totalBayar = Integer.parseInt(pembayaran.getTotalBayar());
        String formattedTotalBayar = formatRupiah(totalBayar);
        holder.tvTotalBayar.setText(formattedTotalBayar);
    }

    @Override
    public int getItemCount() {
        return listTransaksi.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        TextView  tvBulan, tvTanggalBayar, tvTotalBayar;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBulan         = itemView.findViewById(R.id.tv_item_Bulan);
            tvTanggalBayar  = itemView.findViewById(R.id.tv_item_TanggalBayar);
            tvTotalBayar    = itemView.findViewById(R.id.tv_item_TotalBayar);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Pembayaran data);
    }

    private String formatRupiah(int nominal) {
        Locale localeID = new Locale("in", "ID");
        NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(localeID);
        return rupiahFormat.format(nominal);
    }
}
