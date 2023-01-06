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

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.MyViewHolder> {

    public final MyInterface myInterfaces;


    Context context;
    ArrayList<StudentListModel> studentsListModels;
    String onclick;

    public StudentListAdapter(Context context, ArrayList<StudentListModel> studentsListModels, MyInterface myInterfaces, String onclick){
        this.context = context;
        this.studentsListModels = studentsListModels;
        this.myInterfaces = myInterfaces;
        this.onclick = onclick;
    }

    @NonNull
    @Override
    public StudentListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType  ) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_student_list, parent, false);

        return new StudentListAdapter.MyViewHolder(view, myInterfaces, onclick);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentListAdapter.MyViewHolder holder, int position) {
        //hold na siya ng data
        holder.txt_name.setText(studentsListModels.get(position).getName());
        holder.txt_college.setText(studentsListModels.get(position).getCollege());
        holder.txt_email.setText(studentsListModels.get(position).getEmail());
        Picasso.get().load(studentsListModels.get(position).getImage()).error(R.drawable.placeholder).into(holder.img_profile);

    }


    @Override
    public int getItemCount() {

        return studentsListModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        //Textview
        TextView txt_name,txt_college,txt_email;

        //imgaeview
        ImageView img_profile;

        public MyViewHolder(@NonNull View itemView, MyInterface myInterfaces, String onclick) {
            super(itemView);

            img_profile = itemView.findViewById(R.id.img_profile);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_email = itemView.findViewById(R.id.txt_email);
            txt_college = itemView.findViewById(R.id.txt_college);

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
