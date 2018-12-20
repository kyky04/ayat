package id.uinbdg.ayat.adapters;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.uinbdg.ayat.R;
import id.uinbdg.ayat.models.DataItemSurat;


/**
 * Created by Comp on 2/11/2018.
 */

public class HasilAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<DataItemSurat> listItem;
    MediaPlayer mp = null;


    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);

        void onLongClick(int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public HasilAdapter(Context ctx) {
        this.ctx = ctx;
        listItem = new ArrayList<>();
    }


    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_ayat)
        TextView tvAyat;
        @BindView(R.id.tv_surah)
        TextView tvSurah;
        @BindView(R.id.lay)
        LinearLayout lay;
        @BindView(R.id.click)
        LinearLayout click;
        @BindView(R.id.tv_arti_surat)
        TextView tvArtiSurat;
        @BindView(R.id.btn_play)
        ImageButton btnPlay;

        public OriginalViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_matkul, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder view = (OriginalViewHolder) holder;
            DataItemSurat item = listItem.get(position);
            view.tvAyat.setText(item.getIsiSurat());
            view.tvSurah.setText("(QS. " + item.getNamaSurat() + " : " + item.getNomorAyat() + ")");
            view.tvArtiSurat.setText(item.getArti_ayat());
            view.click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(position);
                }
            });

            view.btnPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public void add(DataItemSurat item) {
        listItem.add(item);
        notifyItemInserted(listItem.size() + 1);
    }

    public void addAll(List<DataItemSurat> listItem) {
        for (DataItemSurat item : listItem) {
            add(item);
        }
    }

    public void removeAll() {
        listItem.clear();
        notifyDataSetChanged();
    }

    public void swap(List<DataItemSurat> datas) {
        if (datas == null || datas.size() == 0) listItem.clear();
        if (listItem != null && listItem.size() > 0)
            listItem.clear();
        listItem.addAll(datas);
        notifyDataSetChanged();

    }

    public DataItemSurat getItem(int pos) {
        return listItem.get(pos);
    }

    public String showHourMinute(String hourMinute) {
        String time = "";
        time = hourMinute.substring(0, 5);
        return time;
    }

    public void setFilter(List<DataItemSurat> list) {
        listItem = new ArrayList<>();
        listItem.addAll(list);
        notifyDataSetChanged();
    }

    public List<DataItemSurat> getListItem() {
        return listItem;
    }

    private void playSound(String fileName) {
        mp = new MediaPlayer();
        try {
            AssetFileDescriptor afd = ctx.getAssets().openFd(fileName);
            mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            afd.close();
            mp.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mp.start();

    }
}