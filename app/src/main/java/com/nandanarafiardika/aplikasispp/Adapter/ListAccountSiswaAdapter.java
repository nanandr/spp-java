package com.nandanarafiardika.aplikasispp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nandanarafiardika.aplikasispp.Model.AccountSiswa;
import com.nandanarafiardika.aplikasispp.R;

import java.util.List;

public class ListAccountSiswaAdapter extends RecyclerView.Adapter<ListAccountSiswaAdapter.ListViewHolder> {
    List<AccountSiswa> listSiswa;

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListAccountSiswaAdapter(List<AccountSiswa> listSiswa) {
        this.listSiswa = listSiswa;
    }

    @NonNull
    @Override
    public ListAccountSiswaAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_account_siswa, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAccountSiswaAdapter.ListViewHolder holder, int position) {
        holder.tvNama.setText(listSiswa.get(position).getNama());
        holder.tvNIS.setText(listSiswa.get(position).getNis());
        holder.tvJk.setText(listSiswa.get(position).getJk());
        holder.tvAngkatan.setText(listSiswa.get(position).getAngkatan());
        holder.tvKelas.setText(listSiswa.get(position).getKelas());
        holder.tvTransaksi.setText(listSiswa.get(position).getTransaksi());
        holder.tvSpp.setText(listSiswa.get(position).getSpp());
        holder.tvDiskon.setText(listSiswa.get(position).getDiskon());
        holder.tvHp.setText(listSiswa.get(position).getHp());
        holder.tvCreatedAt.setText(listSiswa.get(position).getCreatedAt());
        holder.tvUpdatedAt.setText(listSiswa.get(position).getUpdatedAt());
    }

    @Override
    public int getItemCount() {
        return listSiswa.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        TextView tvNama, tvNIS, tvJk, tvAngkatan, tvKelas, tvTransaksi, tvSpp, tvDiskon, tvHp, tvCreatedAt, tvUpdatedAt;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_item_Nama);
            tvNIS = itemView.findViewById(R.id.tv_item_NIS);
            tvJk = itemView.findViewById(R.id.tv_item_Jk);
            tvAngkatan = itemView.findViewById(R.id.tv_item_Angkatan);
            tvKelas = itemView.findViewById(R.id.tv_item_Kelas);
            tvTransaksi = itemView.findViewById(R.id.tv_item_Transaksi);
            tvSpp = itemView.findViewById(R.id.tv_item_Spp);
            tvDiskon = itemView.findViewById(R.id.tv_item_Diskon);
            tvHp = itemView.findViewById(R.id.tv_item_Hp);
            tvCreatedAt = itemView.findViewById(R.id.tv_item_CreatedAt);
            tvUpdatedAt = itemView.findViewById(R.id.tv_item_UpdatedAt);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(AccountSiswa data);
    }
}
