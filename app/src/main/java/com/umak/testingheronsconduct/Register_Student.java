package com.umak.testingheronsconduct;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

import java.util.AbstractList;
import java.util.Calendar;
import java.util.HashMap;

public class Register_Student extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private DatePickerDialog datePickerDialog;
    private Button dateButton;

    ImageButton cancelButton, cancelButtonError;
    Button ok_btn, ok_btnError;
    
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);

        reg_stu();


        dateButton = findViewById(R.id.birthdateStudent);
        //dateButton.setText(getTodaysDate());


        Spinner spinner = findViewById(R.id.genderStudent);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.genders, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Spinner spinner1 = findViewById(R.id.collegeStudent);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.colleges, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);

        Spinner spinner2 = findViewById(R.id.yearLevelStudent);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        Spinner spinner3 = findViewById(R.id.courseStudent);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.courses, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(this);

        //comment
        initDatePicker();

        //registerMethod
        registerMethod();



        Button have_acc = findViewById(R.id.login_haveAccSTU);

        have_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });
        
        


    }

    private void registerMethod() {
        //TODO : get all the data requirements






    }

    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    public void reg_stu() {
        EditText edtFNameSTU = findViewById(R.id.fNameStudent);
        EditText edtMNameSTU = findViewById(R.id.mNameStudent);
        EditText edtLNameSTU = findViewById(R.id.lNameStudent);
        Spinner edtGenderSTU = findViewById(R.id.genderStudent);
        Button edtBirthSTU = findViewById(R.id.birthdateStudent);
        EditText edtAddressSTU = findViewById(R.id.addressStudent);
        EditText edtContactNumSTU = findViewById(R.id.contactNumberStudent);
        EditText edtUmakEmailSTU = findViewById(R.id.umakEmailStudent);

         EditText edtStudentID = findViewById(R.id.studentID);
        EditText edtPersonalEmailSTU = findViewById(R.id.personalEmail_Student);
        Spinner edtCollegeSTU = findViewById(R.id.collegeStudent);
        Spinner edtYearSTU = findViewById(R.id.yearLevelStudent);
        Spinner edtCourseSTU = findViewById(R.id.courseStudent);
        EditText edtPasswordSTU = findViewById(R.id.passwordStudent);
        EditText edtConfirmPasswordSTU = findViewById(R.id.ConfirmPassword_Student);


        Button reg_stu = findViewById(R.id.Register_STU);
        reg_stu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String FNameSTU = edtFNameSTU.getText().toString();
                String MNameSTU = edtMNameSTU.getText().toString();
                String LNameSTU = edtLNameSTU.getText().toString();
                String GenderSTU = edtGenderSTU.toString();
                String BirthSTU = edtBirthSTU.getText().toString();
                String AddressSTU = edtAddressSTU.getText().toString();
                String ContactNumSTU = edtContactNumSTU.getText().toString();
                String UmakEmailSTU = edtUmakEmailSTU.getText().toString();
                String StudentIDSTU = edtStudentID.getText().toString();
                String PersonalEmailSTU = edtPersonalEmailSTU.getText().toString();
                String CollegeSTU = edtCollegeSTU.toString();
                String YearSTU = edtYearSTU.toString();
                String CourseSTU = edtCourseSTU.toString();
                String PasswordSTU = edtPasswordSTU.getText().toString();
                String ConfirmPasswordSTU = edtConfirmPasswordSTU.getText().toString();


//                if(TextUtils.isEmpty(FNameSTU) || TextUtils.isEmpty(MNameSTU) || TextUtils.isEmpty(LNameSTU) || TextUtils.isEmpty(GenderSTU) || TextUtils.isEmpty(BirthSTU) || TextUtils.isEmpty(AddressSTU) || TextUtils.isEmpty(ContactNumSTU) || TextUtils.isEmpty(UmakEmailSTU) || TextUtils.isEmpty(StudentIDSTU) ||
//                        TextUtils.isEmpty(PersonalEmailSTU) || TextUtils.isEmpty(CollegeSTU) || TextUtils.isEmpty(YearSTU) || TextUtils.isEmpty(CourseSTU) || TextUtils.isEmpty(PasswordSTU)) {
//                    openDialogError();
//                    return;
//                }

//                else if(FNameSTU.isEmpty()) {
//                    openDialogError();
//                    return;
//                }

                if(ConfirmPasswordSTU.equals(PasswordSTU)) {
                    Toast.makeText(Register_Student.this, "Mismatch Password", Toast.LENGTH_SHORT).show();
                }

                else {


                    //para malaman kung ano yung pinindot
                    Register type = new Register();


                    //1. May account na siya
                    firebaseAuth.createUserWithEmailAndPassword(UmakEmailSTU, ConfirmPasswordSTU).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {

                            HashMap<String, Object> addData = new HashMap<>();
                            addData.put("type", type.Account);

                            //account_table
                            firebaseFirestore.collection("ACCOUNT_TABLE").document(firebaseAuth.getUid())
                                    .set(addData).addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void unused) {

                                            //add data to table of Parent, Student and Reporter

                                            if(type.Account.equalsIgnoreCase("student")){

                                                HashMap<String, Object> addStudents = new HashMap<>();
                                                addStudents.put("first_name", FNameSTU);
                                                addStudents.put("contact_num", ContactNumSTU);
                                                addStudents.put("umak_email", UmakEmailSTU);
                                                //TODO add the other data

                                                firebaseFirestore.collection("Student").document(firebaseAuth.getUid())
                                                        .set(addStudents)
                                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                            @Override
                                                            public void onSuccess(Void unused) {
                                                                Toast.makeText(getApplicationContext(), "SUCCESS UPLOAD DATA", Toast.LENGTH_SHORT).show();
                                                            }
                                                        });
                                                
                                            }else if(type.Account.equalsIgnoreCase("parent")){
                                                //TODO : add data in Parent Table
                                            }else if(type.Account.equalsIgnoreCase("reporter")){
                                                //TODO : add data in Report
                                            }

                                        }
                                    });


                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            //halimbaa email is already existed
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

                    openDialog();
                }

            }
        });






    }


    private void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = android.app.AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
    }

    private String makeDateString(int day, int month, int year){
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month) {
        if(month == 1)
            return "JAN";
        if(month == 2)
            return "FEB";
        if(month == 3)
            return "MAR";
        if(month == 4)
            return "APRIL";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JULY";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";

        return "JAN";
    }


    public void openDatePicker(View view) {
        datePickerDialog.show();
    }


    private void openDialog() {
        View alertCustomDialog = LayoutInflater.from(Register_Student.this).inflate(R.layout.custom_dialog, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Register_Student.this);

        alertDialog.setView(alertCustomDialog);
        cancelButton = (ImageButton) alertCustomDialog.findViewById(R.id.cancelID);
        ok_btn = (Button) alertCustomDialog.findViewById(R.id.ok_btn_id);

        final AlertDialog dialog = alertDialog.create();


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();

            }
        });
        ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                Intent intent = new Intent (getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });
    }



    private void openDialogError() {
        View alertCustomDialog = LayoutInflater.from(Register_Student.this).inflate(R.layout.custom_dialog_error, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(Register_Student.this);

        alertDialog.setView(alertCustomDialog);
        cancelButtonError = (ImageButton) alertCustomDialog.findViewById(R.id.cancelID_error);
        ok_btnError = (Button) alertCustomDialog.findViewById(R.id.ok_btn_id_error);

        final AlertDialog dialog = alertDialog.create();


        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


        cancelButtonError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();

            }
        });
        ok_btnError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
    }


    


    public void x_back(View view) {

        Intent intent = new Intent(getApplicationContext(), Register.class);
        startActivity(intent);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {



        String text = adapterView.getItemAtPosition(i).toString();
        //Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();

        ((TextView) adapterView.getChildAt(0)).setTextSize(12);
        ((TextView) adapterView.getChildAt(0)).setTextColor(Color.BLACK);

        String text1 = adapterView.getItemAtPosition(i).toString();


        ((TextView) adapterView.getChildAt(0)).setTextSize(12);
        ((TextView) adapterView.getChildAt(0)).setTextColor(Color.BLACK);

        String text2 = adapterView.getItemAtPosition(i).toString();

        ((TextView) adapterView.getChildAt(0)).setTextSize(12);
        ((TextView) adapterView.getChildAt(0)).setTextColor(Color.BLACK);

        String text3 = adapterView.getItemAtPosition(i).toString();

        ((TextView) adapterView.getChildAt(0)).setTextSize(12);
        ((TextView) adapterView.getChildAt(0)).setTextColor(Color.BLACK);

    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}