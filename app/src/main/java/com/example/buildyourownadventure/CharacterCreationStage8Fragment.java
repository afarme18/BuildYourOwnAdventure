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
 * Use the {@link CharacterCreationStage8Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterCreationStage8Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private Character c;

    public CharacterCreationStage8Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment CharacterCreationStage8Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CharacterCreationStage8Fragment newInstance(Character c) {
        CharacterCreationStage8Fragment fragment = new CharacterCreationStage8Fragment();
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

    Button buttonBack8;
    Button buttonNext8;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character_creation_stage8, container, false);
        buttonBack8 = view.findViewById(R.id.buttonBack8);
        buttonNext8 = view.findViewById(R.id.buttonNext8);


        buttonBack8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateCharacterStage8Listener.backFromStage8();
            }
        });
        buttonNext8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateCharacterStage8Listener.toStage9(c);
            }
        });

        return view;
    }

    ICreateCharacterStage8Listener CreateCharacterStage8Listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof ICreateCharacterStage8Listener) {
            CreateCharacterStage8Listener = (ICreateCharacterStage8Listener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement ICreateCharacterStage1Listener");
        }
    }

    public interface ICreateCharacterStage8Listener{
        void backFromStage8();
        void toStage9(Character c);
    }
}