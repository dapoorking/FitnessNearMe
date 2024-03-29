package com.example.fitnessnearme;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ExercisePagerAdapter extends FragmentPagerAdapter {
    ExercisePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // Return the appropriate fragment for each difficulty level
        switch (position) {
            case 0:
                return new BeginnerExerciseFragment();
            case 1:
                return new IntermediateExerciseFragment();
            case 2:
                return new ExpertExerciseFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3; // Three difficulty levels
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Set tab titles for each difficulty level
        switch (position) {
            case 0:
                return "Beginner";
            case 1:
                return "Intermediate";
            case 2:
                return "Expert";
            default:
                return "";
        }
    }
}
