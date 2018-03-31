package com.bjtu.julie;
import com.bjtu.julie.FullyLinearLayoutManager;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class FootManFragment extends Fragment {
    public List<Order> orderlist=new ArrayList<>();
    public static FootManActivity FootManActivity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View orderLayout = inflater.inflate(R.layout.activity_foot_man, container, false);
        Button footButton=(Button)orderLayout.findViewById(R.id.Foot_Button1);
        footButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getActivity(),Pub_footActivity.class);
                startActivity(intent);

            }
        });
        Button messageButton=(Button)orderLayout.findViewById(R.id.Foot_Button2);
        messageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent =new Intent(getActivity(),P_MessageActivity.class);
                startActivity(intent);
            }
        });
        initGuide();
        RecyclerView recyclerView=(RecyclerView) orderLayout.findViewById(R.id.recycle_order_item);
        FullyLinearLayoutManager layoutManager=new FullyLinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        OrderAdapter adapter=new OrderAdapter();
        recyclerView.setAdapter(adapter);
        return orderLayout;
    }

    private void initGuide() {
        Order exorder=new Order("面和抄手代取","3元","主校区18号楼408","12时20分");
        orderlist.add(exorder);
        Order exorder2=new Order("面和抄手代取","3元","主校区18号楼408","12时20分");
        orderlist.add(exorder2);
    }


    public class OrderAdapter extends RecyclerView.Adapter<ViewHolder> {
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_item, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }


    @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Order exorder= orderlist.get(position);
            holder.text_title.setText(exorder.getTitle());
            holder.text_money.setText(exorder.getMoney());
            holder.text_title.setText(exorder.getAddress());
            holder.text_money.setText(exorder.getTime());

        }

        @Override
        public int getItemCount() {
            return orderlist.size();
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView text_title;
        TextView text_money;
        TextView text_address;
        TextView text_time;

        public ViewHolder(View view) {
            super(view);
            text_title= (TextView) view.findViewById(R.id.text_title);
            text_money= (TextView) view.findViewById(R.id.text_money);
            text_address=(TextView) view.findViewById(R.id.text_address);
            text_time=(TextView) view.findViewById(R.id.text_time);
        }
    }
}


