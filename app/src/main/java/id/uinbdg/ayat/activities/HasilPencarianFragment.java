package id.uinbdg.ayat.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import id.uinbdg.ayat.R;
import id.uinbdg.ayat.adapters.HasilAdapter;
import id.uinbdg.ayat.algoritma.JaroWinkler;
import id.uinbdg.ayat.models.ItemMateri;
import id.uinbdg.ayat.utils.CommonUtil;

public class HasilPencarianFragment extends DialogFragment {
    private static final String TAG = "HasilPencarianFragment";
    @BindView(R.id.tv_toolbar)
    TextView tvToolbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    HasilAdapter adapter;
    Unbinder unbinder;

    String hasil;
    List<ItemMateri> itemMateriList = new ArrayList<>();
    List<ItemMateri> temp = new ArrayList<>();
    @BindView(R.id.tv_hasil)
    TextView tvHasil;

    public static HasilPencarianFragment newInstance(String hasil) {

        Bundle args = new Bundle();
        args.putString("hasil", hasil);
        HasilPencarianFragment fragment = new HasilPencarianFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_hasil_pencarian, container, false);
        unbinder = ButterKnife.bind(this, v);

        hasil = getArguments().getString("hasil");
        tvHasil.setText(hasil);
        adapter = new HasilAdapter(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);


        itemMateriList = loadData();
        for (int i = 0; i < itemMateriList.size(); i++) {
            JaroWinkler jaroWinkler = new JaroWinkler();
            Log.d(TAG, "onCreateView: " + hasil + " " + jaroWinkler.distance(hasil, itemMateriList.get(i).getSurah()));
            if (jaroWinkler.distance(hasil, itemMateriList.get(i).getSurah()) < 0.3) {
                temp.add(itemMateriList.get(i));
            }
        }
        if (temp.size() > 0) {
            adapter.addAll(temp);
        } else {
            CommonUtil.showSnack(getActivity(), "Tidak ada data di temukan");
        }

        adapter.setOnItemClickListener(new HasilAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }

            @Override
            public void onLongClick(int position) {

            }
        });

        return v;
    }


    public ArrayList<ItemMateri> loadData() {
        ArrayList<ItemMateri> list = new ArrayList<>();
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open("materi_arab.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        try {
            JSONObject obj = new JSONObject(json);
            JSONArray m_jArry = obj.getJSONArray("materi");

            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                ItemMateri materi = new ItemMateri();
                materi.setId(jo_inside.getInt("id"));
                materi.setId_surah(jo_inside.getInt("id_surah"));
                materi.setId_ayat(jo_inside.getInt("id_ayat"));
                materi.setSurah(jo_inside.getString("ayat_text"));

                //Add your values in your `ArrayList` as below:
                list.add(materi);
//                notesBox.put(doa);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }


}
