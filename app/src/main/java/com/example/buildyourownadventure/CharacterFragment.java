package com.example.buildyourownadventure;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CharacterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterFragment extends Fragment {


    ArrayList<Character> character = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";


    recyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    public ArrayList<Character> characters = new ArrayList<>();


    // TODO: Rename and change types of parameters
    private Character c;

    public CharacterFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment CharacterFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CharacterFragment newInstance(Character c) {
        CharacterFragment fragment = new CharacterFragment();
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
    Button CreateNewButton;
    Button Back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character, container, false);


        // This determines what is displayed int he list of characters //
        if(c == null){
        }else {
            character.add(new Character(c.getName(), c.getRace(), c.getCharacterClass()));
        }




        recyclerView = view.findViewById(R.id.CharacterRecyclerView);
        adapter = new recyclerAdapter(character);
        recyclerView.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        CreateNewButton = view.findViewById(R.id.CreateNewButton);
        Back = view.findViewById(R.id.buttonBackFirst);


        CreateNewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateCharacterListener.newCharacter();
            }
        });

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateCharacterListener.backToCharacterActivity();
            }
        });


        return view;
    }


    ICreateCharacterListener CreateCharacterListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof CharacterFragment.ICreateCharacterListener) {
            CreateCharacterListener = (CharacterFragment.ICreateCharacterListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement ICreateCharacterListener");
        }
    }

    public interface ICreateCharacterListener{
        void newCharacter();
        void backToCharacterActivity();
    }
}