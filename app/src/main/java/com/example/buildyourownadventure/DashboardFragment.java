package com.example.buildyourownadventure;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class DashboardFragment extends Fragment {

    public static final String USER_KEY = "USER_KEY";

    private User user;

    public DashboardFragment() {
        // Required empty public constructor
    }

    public static DashboardFragment newInstance(User user) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        args.putSerializable(USER_KEY, user);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            user = (User) getArguments().getSerializable(USER_KEY);
        }
    }

    TextView userLabel;
    Button dungeonAIButtonDashboard;
    Button gameSetupButtonDashboard;
    Button notesButtonDashboard;
    Button characterButtonDashboard;
    Button diceButtonDashboard;
    Button calcButtonDashboard;
    Button librariesButtonDashboard;
    Button soundsButtonDashboard;
    Button tutorialButtonDashboard;
    Button logoutButtonDashboard;
    Button faqButtonDashboard;
    Button settingsButtonDashboard;
    Button contactButtonDashboard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        getActivity().setTitle("Dashboard");

        userLabel = view.findViewById(R.id.userLabel);
        userLabel.setText("Welcome " + user.getFullName());

        dungeonAIButtonDashboard = view.findViewById(R.id.dungeonAIButtonDashboard);
        gameSetupButtonDashboard = view.findViewById(R.id.gameSetupButtonDashboard);
        notesButtonDashboard = view.findViewById(R.id.notesButtonDashboard);
        characterButtonDashboard = view.findViewById(R.id.characterButtonDashboard);
        diceButtonDashboard = view.findViewById(R.id.diceButtonDashboard);
        calcButtonDashboard = view.findViewById(R.id.calcButtonDashboard);
        librariesButtonDashboard = view.findViewById(R.id.librariesButtonDashboard);
        soundsButtonDashboard = view.findViewById(R.id.soundsButtonDashboard);
        tutorialButtonDashboard = view.findViewById(R.id.tutorialButtonDashboard);
        logoutButtonDashboard = view.findViewById(R.id.logoutButtonDashboard);
        faqButtonDashboard = view.findViewById(R.id.faqButtonDashboard);
        settingsButtonDashboard = view.findViewById(R.id.settingsButtonDashboard);
        contactButtonDashboard = view.findViewById(R.id.contactButtonDashboard);

        dungeonAIButtonDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardListener.startAIDungeon();
            }
        });

        gameSetupButtonDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardListener.startGameSetup();
            }
        });

        notesButtonDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardListener.startNotes();
            }
        });

        characterButtonDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardListener.startCharacters();
            }
        });

        diceButtonDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardListener.startDice();
            }
        });

        calcButtonDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardListener.startCalculator();
            }
        });

        librariesButtonDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardListener.startLibraries();
            }
        });

        soundsButtonDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardListener.startSounds();
            }
        });

        tutorialButtonDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardListener.startTutorial();
            }
        });

        logoutButtonDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardListener.logout();
            }
        });

        faqButtonDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardListener.startFAQ();
            }
        });

        settingsButtonDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardListener.startSettings();
            }
        });

        contactButtonDashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dashboardListener.startContact();
            }
        });


        return view;
    }

    IDashboardListener dashboardListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof IDashboardListener) {
            dashboardListener = (IDashboardListener) context;
        } else {
            throw new RuntimeException(context.toString() + "must implement IDashboardListener");
        }
    }

    public interface IDashboardListener{
        void startAIDungeon();
        void startGameSetup();
        void startNotes();
        void startCharacters();
        void startDice();
        void startCalculator();
        void startLibraries();
        void startSounds();
        void startTutorial();
        void logout();
        void startFAQ();
        void startSettings();
        void startContact();
    }

}