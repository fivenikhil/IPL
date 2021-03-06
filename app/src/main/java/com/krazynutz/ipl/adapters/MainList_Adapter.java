package com.krazynutz.ipl.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.krazynutz.ipl.R;
import com.krazynutz.ipl.activites.MatchesList;
import com.krazynutz.ipl.activites.Stadium_List;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainList_Adapter extends RecyclerView.Adapter<MainList_Adapter.MyViewHolder>
{
    private List<String> datalist_H;
    private Context mContext;

    public MainList_Adapter(Context context, List<String> datalist)
    {
        this.mContext=context;
        this.datalist_H = datalist;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvTitle)
        TextView title;

       /* @BindView(R.id.card_content)
        TextView sub_title;*/

        public MyViewHolder(View v)
        {
            super(v);
            ButterKnife.bind(this, v);

        }
    }

    @Override
    public MainList_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_cardview_top, parent, false);
        MyViewHolder vh =new MyViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position)
    {

        holder.title.setText(datalist_H.get(position));
        holder.title.setTypeface(Typeface.createFromAsset(mContext.getAssets(), "Oxygen.otf"));

        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == 1)
                {
                    Intent i = new Intent(mContext, MatchesList.class);
                    mContext.startActivity(i);
                }

                if(position == 2)
                {
                    Intent i = new Intent(mContext, Stadium_List.class);
                    mContext.startActivity(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return datalist_H.size();
    }
}
