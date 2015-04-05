package com.os.operando.samplecodeproject.views;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.os.operando.samplecodeproject.R;
import com.os.operando.samplecodeproject.model.TestModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewSampleActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_sample);

        List<TestModel> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            TestModel t = new TestModel();
            t.str = "test " + i;
            list.add(t);
        }

        RecyclerView v = (RecyclerView) findViewById(R.id.list);
        v.setLayoutManager(new LinearLayoutManager(this));
        v.setItemAnimator(new DefaultItemAnimator());
        v.setAdapter(new TestAdapter(list, R.layout.list_item_sample, this));
    }


    public static class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {

        private List<TestModel> countries;
        private int rowLayout;
        private Context mContext;

        public TestAdapter(List<TestModel> countries, int rowLayout, Context context) {
            this.countries = countries;
            this.rowLayout = rowLayout;
            this.mContext = context;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            TestModel test = countries.get(i);
            viewHolder.text.setText(test.str);
            viewHolder.icon.setImageResource(R.mipmap.ic_launcher);
        }

        @Override
        public int getItemCount() {
            return countries == null ? 0 : countries.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public TextView text;
            public ImageView icon;

            public ViewHolder(View itemView) {
                super(itemView);
                text = (TextView) itemView.findViewById(R.id.text);
                icon = (ImageView) itemView.findViewById(R.id.icon);
            }

        }
    }
}
