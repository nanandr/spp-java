package com.nandanarafiardika.aplikasispp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nandanarafiardika.aplikasispp.Model.AccountPetugas;
import com.nandanarafiardika.aplikasispp.R;

import java.util.List;

public class ListAccountPetugasAdapter extends RecyclerView.Adapter<ListAccountPetugasAdapter.ListViewHolder> {
    List<AccountPetugas> listPetugas;

    private ListAccountPetugasAdapter.OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(ListAccountPetugasAdapter.OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListAccountPetugasAdapter(List<AccountPetugas> listPetugas) {
        this.listPetugas = listPetugas;
    }

    @NonNull
    @Override
    public ListAccountPetugasAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_account_petugas, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAccountPetugasAdapter.ListViewHolder holder, int position) {
        holder.tvNIP.setText(listPetugas.get(position).getNip());
        holder.tvNama.setText(listPetugas.get(position).getNama());
        holder.tvAlamat.setText(listPetugas.get(position).getAlamat());
        holder.tvEmail.setText(listPetugas.get(position).getEmail());
        holder.tvHp.setText(listPetugas.get(position).getHp());
        holder.tvCreatedAt.setText(listPetugas.get(position).getCreatedAt());
        holder.tvUpdatedAt.setText(listPetugas.get(position).getUpdatedAt());
    }

    @Override
    public int getItemCount() {
        return listPetugas.size();
    }


    public class ListViewHolder extends RecyclerView.ViewHolder{
        TextView tvNIP, tvNama, tvAlamat, tvEmail, tvHp, tvCreatedAt, tvUpdatedAt;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNIP = itemView.findViewById(R.id.tv_item_NIP);
            tvNama = itemView.findViewById(R.id.tv_item_Nama);
            tvAlamat = itemView.findViewById(R.id.tv_item_Alamat);
            tvEmail = itemView.findViewById(R.id.tv_item_Email);
            tvHp = itemView.findViewById(R.id.tv_item_Hp);
            tvCreatedAt = itemView.findViewById(R.id.tv_item_CreatedAt);
            tvUpdatedAt = itemView.findViewById(R.id.tv_item_UpdatedAt);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(AccountPetugas data);
    }
}
