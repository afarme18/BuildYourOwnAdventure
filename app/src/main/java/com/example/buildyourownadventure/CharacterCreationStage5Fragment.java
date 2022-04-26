package com.example.buildyourownadventure;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CharacterCreationStage5Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterCreationStage5Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private Character c;

    public CharacterCreationStage5Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment CharacterCreationStage5Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CharacterCreationStage5Fragment newInstance(Character c) {
        CharacterCreationStage5Fragment fragment = new CharacterCreationStage5Fragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, c);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            c = (Character) getArguments().getSerializable(ARG_PARAM1);
        }
    }
    Button buttonBack5;
    Button buttonNext5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character_creation_stage5, container, false);
        buttonBack5 = view.findViewById(R.id.buttonBack5);
        buttonNext5 = view.findViewById(R.id.buttonNext5);

        buttonBack5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateCharacterStage5Listener.backFromStage5();
            }
        });
        buttonNext5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateCharacterStage5Listener.toStage6(c);
            }
        });


        return view;
    }


    ICreateCharacterStage5Listener CreateCharacterStage5Listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof ICreateCharacterStage5Listener) {
            CreateCharacterStage5Listener = (ICreateCharacterStage5Listener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement ICreateCharacterStage1Listener");
        }
    }

    public interface ICreateCharacterStage5Listener{
        void backFromStage5();
        void toStage6(Character c);
    }
}