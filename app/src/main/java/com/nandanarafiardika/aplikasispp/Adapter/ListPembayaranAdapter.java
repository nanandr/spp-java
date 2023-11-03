package com.nandanarafiardika.aplikasispp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nandanarafiardika.aplikasispp.Model.Pembayaran;
import com.nandanarafiardika.aplikasispp.R;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ListPembayaranAdapter extends RecyclerView.Adapter<ListPembayaranAdapter.ListViewHolder> {
    List<Pembayaran> listPembayaran;

    private ListPembayaranAdapter.OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(ListPembayaranAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListPembayaranAdapter(List<Pembayaran> listPembayaran) {
        this.listPembayaran = listPembayaran;
    }

    @NonNull
    @Override
    public ListPembayaranAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pembayaran, parent, false);
        return new ListPembayaranAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListPembayaranAdapter.ListViewHolder holder, int position) {
        Pembayaran pembayaran = listPembayaran.get(position);
        holder.tvNamaSiswa.setText(pembayaran.getNamaSiswa());
        holder.tvNamaPetugas.setText(pembayaran.getNamaPetugas());
        holder.tvTanggalBayar.setText(pembayaran.getTanggalBayar());
        int totalBayar = Integer.parseInt(pembayaran.getTotalBayar());
        String formattedTotalBayar = formatRupiah(totalBayar);
        holder.tvTotalBayar.setText(formattedTotalBayar);
        holder.tvBulan.setText(pembayaran.getBulan());
    }

    @Override
    public int getItemCount() {
        return listPembayaran.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        TextView tvNamaSiswa, tvNamaPetugas, tvTanggalBayar, tvTotalBayar, tvBulan;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
                tvNamaSiswa     = itemView.findViewById(R.id.tv_item_NamaSiswa);
                tvNamaPetugas   = itemView.findViewById(R.id.tv_item_NamaPetugas);
                tvTanggalBayar  = itemView.findViewById(R.id.tv_item_TanggalBayar);
                tvTotalBayar    = itemView.findViewById(R.id.tv_item_TotalBayar);
                tvBulan         = itemView.findViewById(R.id.tv_item_Bulan);
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
