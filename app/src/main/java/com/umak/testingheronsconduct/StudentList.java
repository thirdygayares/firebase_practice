package com.umak.testingheronsconduct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.umak.testingheronsconduct.Model.StudentListModel;
import com.umak.testingheronsconduct.adapter.MyInterface;
import com.umak.testingheronsconduct.adapter.StudentListAdapter;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class StudentList extends AppCompatActivity implements MyInterface {

    RecyclerView recycler_student_list;

    //Model
    ArrayList<StudentListModel> studentListModels = new ArrayList<>();

    //call Adapter
    StudentListAdapter studentListAdapter;

    FirebaseFirestore firestore = FirebaseFirestore.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);


        //initialize xml
        initXml();

        //    public StudentListAdapter(Context context, ArrayList<StudentListModel> studentsListModels, MyInterface myInterfaces, String onclick){
        studentListAdapter = new StudentListAdapter(StudentList.this, studentListModels, this,  "studentlist") ;

        //geeting all the data in firebase
        setUpListOfStudentData();

    }

    private void setUpListOfStudentData() {

        firestore.collection("Student")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if(task.isSuccessful()){
                                for(QueryDocumentSnapshot documentSnapshot:task.getResult()){
                                    if(documentSnapshot.getData() != null ){
                                        //    public StudentListModel(String id, String image, String name, String college, String email) {
                                        studentListModels.add(new StudentListModel(documentSnapshot.getId(), documentSnapshot.get("image").toString(), documentSnapshot.get("first_name").toString(), documentSnapshot.get("college").toString(), documentSnapshot.get("umak_email").toString() ));
                                        studentListAdapter.notifyItemInserted(studentListModels.size());
                                    }
                                }


                            }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        //set adapter
        recycler_student_list.setAdapter(studentListAdapter);
        recycler_student_list.setLayoutManager(new LinearLayoutManager(StudentList.this));
    }

    private void initXml() {
        recycler_student_list = findViewById(R.id.recycler_student_list);
    }


    @Override
    public void onItemClick(int pos, String onclick) {
        //kapag clinick yung isang data
        Toast.makeText(getApplicationContext(), studentListModels.get(pos).getEmail(), Toast.LENGTH_SHORT).show();
    }
}