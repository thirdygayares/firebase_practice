package com.umak.testingheronsconduct.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.umak.testingheronsconduct.R;
import com.umak.testingheronsconduct.adapter.MyInterface;
import com.umak.testingheronsconduct.Model.StudentListModel;

import java.util.ArrayList;

public class sampleAdapter extends RecyclerView.Adapter<sampleAdapter.MyViewHolder> {

    public final MyInterface myInterfaces;


    Context context;
    ArrayList<StudentListModel> booksModels;
    String onclick;

    public sampleAdapter(Context context, ArrayList<StudentListModel> booksModels, MyInterface myInterfaces, String onclick){
        this.context = context;
        this.booksModels = booksModels;
        this.myInterfaces = myInterfaces;
        this.onclick = onclick;
    }

    @NonNull
    @Override
    public sampleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType  ) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_student_list, parent, false);

        return new sampleAdapter.MyViewHolder(view, myInterfaces, onclick);
    }

    @Override
    public void onBindViewHolder(@NonNull sampleAdapter.MyViewHolder holder, int position) {


    }


    @Override
    public int getItemCount() {

        return booksModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txt_count,txt_title,txt_author;
        ImageView img_book_cover;
        public MyViewHolder(@NonNull View itemView, MyInterface myInterfaces, String onclick) {
            super(itemView);


            itemView.setOnClickListener(view -> {
                if(myInterfaces != null ){
                    int pos = getAdapterPosition();
                    if(pos!= RecyclerView.NO_POSITION){
                        myInterfaces.onItemClick(pos, onclick);
                    }

                }
            });
        }
    }


}
