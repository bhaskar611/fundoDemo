package com.example.fundoapp;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fundoapp.model.Note;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private final ArrayList<Note> notesList;
    private final Context context;

    public Adapter(ArrayList<Note> notesList, Context context){
        this.notesList = notesList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_layout,parent,false);
        Log.e("bhaskar", "onCreateViewHolder: " );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Note note = notesList.get(position);
        holder.noteTitle.setText(note.getTitle());
        holder.noteContent.setText(note.getContent());
        Log.e("bhaskar", "onBindViewHolder: "+position );
//        Note note = new Note()
//        holder.noteTitle.setText(notesList.get(position).getTitle());
//        holder.noteContent.setText(notesList.get(position).getContent());
       // final int code = getRandomColor();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            holder.mCardView.setCardBackgroundColor(holder.view.getResources().getColor(code,null));
//        }


    }

//    private int getRandomColor() {
//
//        List<Integer> colorCode = new ArrayList<>();
//        colorCode.add(R.color.gray);
//        colorCode.add(R.color.pink);
//        colorCode.add(R.color.lightgreen);
//        colorCode.add(R.color.skyblue);
//        colorCode.add(R.color.color1);
//        colorCode.add(R.color.color2);
//        colorCode.add(R.color.color3);
//        colorCode.add(R.color.color4);
//        colorCode.add(R.color.color5);
//        colorCode.add(R.color.green);
//
//        Random randomColor = new Random();
//        int number = randomColor.nextInt(colorCode.size());
//        return colorCode.get(number);
//
//    }

    @Override
    public int getItemCount() {
        Log.e("bhaskar", "get Item Count: " + notesList.size());
        return notesList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView noteTitle,noteContent;
        View view;
        CardView mCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            noteTitle = itemView.findViewById(R.id.title);
            noteContent = itemView.findViewById(R.id.content);
            mCardView = itemView.findViewById(R.id.notecard);
            view = itemView;
        }
    }
}