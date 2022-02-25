package com.example.buildyourownadventure;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class LoginFragment extends Fragment {

    public LoginFragment() {
        // Required empty public constructor
    }
    public static final String USER_LIST_KEY = "USER_LIST_KEY";
    public static final String LOGIN_KEY = "LOGIN_KEY";

    public ArrayList<User> users = new ArrayList<>();

    public static LoginFragment newInstance(ArrayList<User> users) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putSerializable(LOGIN_KEY, users);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            users = (ArrayList<User>) getArguments().getSerializable(LOGIN_KEY);
        }
    }

    EditText emailValue;
    EditText passwordValue;
    Button loginButton;
    TextView signUpTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        emailValue = view.findViewById(R.id.emailValue);
        passwordValue = view.findViewById(R.id.passwordValue);
        loginButton = view.findViewById(R.id.loginButton);
        signUpTextView = view.findViewById(R.id.signUpTextView);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailValue.getText().toString();
                String password = passwordValue.getText().toString();

                Log.d("TEST", "users" + users.toString());
                Log.d("TEST", "user" + users.get(0).toString());
                Log.d("TEST", "Fullname: " + users.get(0).getFullName());
                Log.d("TEST", "Email: " + users.get(0).getEmail());
                Log.d("TEST", "Password: " + users.get(0).getPassword());

                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getEmail().equals(email) && users.get(i).getPassword().equals(password)) {
                        loginListener.successfulLogin(users.get(i));
                    } else {
                        if (i == users.size()-1) {
                            loginListener.unsuccessfulLogin();
                        }
                    }
                }
            }
        });

        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginListener.startRegister(users);
            }
        });

        return view;
    }

    ILoginListener loginListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof ILoginListener) {
            loginListener = (ILoginListener) context;
        } else {
            throw new RuntimeException(context.toString() + "must implement ILoginListener");
        }
    }

    public interface ILoginListener{
        void successfulLogin(User user);
        void unsuccessfulLogin();
        void startRegister(ArrayList<User> users);
    }

}