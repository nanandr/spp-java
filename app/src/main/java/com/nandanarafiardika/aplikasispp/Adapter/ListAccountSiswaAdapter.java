package com.nandanarafiardika.aplikasispp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nandanarafiardika.aplikasispp.Model.AccountSiswa;
import com.nandanarafiardika.aplikasispp.Model.Kelas;
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
        AccountSiswa siswa = listSiswa.get(position);
        holder.tvNama.setText(siswa.getNama());
        holder.tvNIS.setText(siswa.getNis());
        holder.tvJk.setText(siswa.getJk());
        holder.tvAngkatan.setText(String.valueOf(siswa.getAngkatan()));
        holder.tvHp.setText(siswa.getHp());
        holder.tvTransaksi.setText(siswa.getTransaksi());
        holder.tvSpp.setText(siswa.getSpp());
        holder.tvDiskon.setText(siswa.getDiskon());
        holder.tvCreatedAt.setText(siswa.getCreatedAt());
        holder.tvUpdatedAt.setText(siswa.getUpdatedAt());
        List<Kelas> kelasList = siswa.getKelas();
        if (kelasList != null && kelasList.size() > 0) {
            Kelas kelas = kelasList.get(0);
            holder.tvKelas.setText(kelas.getNamaKelas());
        }
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
