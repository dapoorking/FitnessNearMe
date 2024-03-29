package com.example.fitnessnearme;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ExpertExerciseFragment extends Fragment {

    public static ExpertExerciseFragment newInstance() {
        return new ExpertExerciseFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_exercise, container, false);

        // Create a list of Expert exercises with GIF resource IDs
        List<Exercise> expertExercises = new ArrayList<>();
        expertExercises.add(new Exercise("Exercise 1", "Description 1", "Image URL 1", "12 reps", R.drawable.exercise1));
        expertExercises.add(new Exercise("Exercise 2", "Description 2", "Image URL 2", "15 reps", R.drawable.exercise2));
        // Add more exercises as needed

        // Initialize and set up the RecyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.exerciseRecyclerView);
        ExerciseAdapter exerciseAdapter = new ExerciseAdapter(expertExercises);
        recyclerView.setAdapter(exerciseAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return rootView;
    }
}