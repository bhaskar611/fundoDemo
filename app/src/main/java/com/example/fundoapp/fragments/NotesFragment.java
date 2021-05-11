package com.example.fundoapp.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fundoapp.Adapter;
import com.example.fundoapp.R;
import com.example.fundoapp.model.FireBaseNoteManager;
import com.example.fundoapp.model.Note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Objects;

public class NotesFragment extends Fragment {

    RecyclerView recyclerView;
    FireBaseNoteManager fireBaseNoteManager;

    private final ArrayList<Note> notes = new ArrayList<Note>();
    private Adapter notesAdapter;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notes, container, false);
       // findViews(view);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        //recyclerView.setAdapter(notesAdapter);
        fireBaseNoteManager = new FireBaseNoteManager();




        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

//    private void findViews(View view) {
//        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView = view.findViewById(R.id.recyclerview);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setHasFixedSize(true);
//        //recyclerView.setAdapter(notesAdapter);
//        fireBaseNoteManager = new FireBaseNoteManager();
//
//
//        fireBaseNoteManager.getAllNotes(notesList -> {
//            Log.e("bhaskar", "onNoteReceived: " + notesList);
//
//
//
//            notesAdapter = new Adapter(notesList,this.getContext());
//
//            recyclerView.setAdapter(notesAdapter);
//        });
////        Adapter notesAdapter = new Adapter(notes);
////        recyclerView.setAdapter(notesAdapter);
//
//
//    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fireBaseNoteManager.getAllNotes(notesList -> {
           Log.e("bhaskar", "onNoteReceived: " + notesList);



          notesAdapter = new Adapter(notesList,this.getContext());

            recyclerView.setAdapter(notesAdapter);
            notesAdapter.notifyDataSetChanged();
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        FloatingActionButton addnote = Objects.requireNonNull(getView()).findViewById(R.id.addNotes);
        addnote.setOnClickListener(v -> {
            Fragment fragment = new AddNotes_Fragment();
            FragmentManager fragmentManager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        });
    }
}
