package com.solomonron.mystudent_pilot;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.StudentViewHolder> {

    private Context mContext;
    private List<Student> mStudentList;
    private Dialog commentDialog;



    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_list_item_row, parent, false);

        StudentViewHolder holder = new StudentViewHolder(view);

        holder = openCommentDialog(holder);



        return holder;
    }



    private StudentViewHolder openCommentDialog(final StudentViewHolder holder) {
        commentDialog = new Dialog(mContext);
        commentDialog.setContentView(R.layout.missing_student_dialog);


        holder.editComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView header = commentDialog.findViewById(R.id.add_student_header);
                TextView studentName = commentDialog.findViewById(R.id.missing_student);
                studentName.setText(mStudentList.get(holder.getAdapterPosition()).getFirstName() + " " +
                        mStudentList.get(holder.getAdapterPosition()).getLastName());
                RadioButton illness = commentDialog.findViewById(R.id.radio_illness);
                RadioButton vacation = commentDialog.findViewById(R.id.radio_vaction);
                RadioButton other = commentDialog.findViewById(R.id.radio_other);
                final EditText reason = commentDialog.findViewById(R.id.reason_ET);
                final ImageView editReason = commentDialog.findViewById(R.id.editReason_img);
                TextView confirm = commentDialog.findViewById(R.id.confirm_addStudent_dlg);
                TextView cancel = commentDialog.findViewById(R.id.cancel_dlg);

                other.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        reason.setVisibility(View.VISIBLE);
                        editReason.setVisibility(View.VISIBLE);
                        reason.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                            @Override
                            public void onFocusChange(View v, boolean hasFocus) {
                                editReason.setVisibility(View.INVISIBLE);

                            }
                        });
                    }
                });

                illness.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        reason.setVisibility(View.GONE);
                        editReason.setVisibility(View.GONE);

                    }
                });

                vacation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        reason.setVisibility(View.GONE);
                        editReason.setVisibility(View.GONE);

                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        commentDialog.dismiss();
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        commentDialog.dismiss();
                    }
                });

                commentDialog.show();


            }
        });
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull final StudentViewHolder holder, final int position) {


        Student student = mStudentList.get(position);


        holder.firstName.setText(student.getFirstName());
        holder.lastName.setText(student.getLastName());
        holder.green.setVisibility(View.INVISIBLE);
        holder.red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.red.setVisibility(View.INVISIBLE);
                holder.editComment.setVisibility(View.INVISIBLE);
                holder.green.setVisibility(View.VISIBLE);
            }
        });
        holder.green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.green.setVisibility(View.INVISIBLE);
                holder.editComment.setVisibility(View.VISIBLE);
                holder.red.setVisibility(View.VISIBLE);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mStudentList.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {

        private TextView firstName;
        private TextView lastName;
        private ImageView green;
        private ImageView red;
        private ImageView editComment;


        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);

            firstName = itemView.findViewById(R.id.first_name_TV);
            lastName = itemView.findViewById(R.id.last_name_TV);
            green = itemView.findViewById(R.id.green_switch);
            red = itemView.findViewById(R.id.red_switch);
            editComment = itemView.findViewById(R.id.editComment);


        }
    }

    public StudentListAdapter(Context context, List<Student> studentList) {
        mContext = context;
        mStudentList = studentList;
    }

    public StudentListAdapter(List<Student> studentList) {
        mStudentList = studentList;

    }


}
