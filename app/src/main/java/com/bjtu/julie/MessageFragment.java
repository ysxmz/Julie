package com.bjtu.julie;


import android.app.Fragment;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MessageFragment extends android.support.v4.app.Fragment {
    private List<Exchange> exchangeList=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View messageLayout = inflater.inflate(R.layout.activity_message, container, false);
        initExchange();
        RecyclerView recyclerView=(RecyclerView)messageLayout.findViewById(R.id.mes_recycleView);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        MessageAdaper adaper=new MessageAdaper(exchangeList);
        recyclerView.setAdapter(adaper);
        return messageLayout;
    }
    private void initExchange(){
        for (int i=0;i<=3;i++){
            Exchange aaa=new Exchange("aaa",R.drawable.aaa_pic);
            exchangeList.add(aaa);
            Exchange bbb=new Exchange("bbb",R.drawable.bbb_pic);
            exchangeList.add(bbb);
            Exchange ccc=new Exchange("ccc",R.drawable.ccc_pic);
            exchangeList.add(ccc);
            Exchange ddd=new Exchange("ddd",R.drawable.ddd_pic);
            exchangeList.add(ddd);
        }
    }
}
