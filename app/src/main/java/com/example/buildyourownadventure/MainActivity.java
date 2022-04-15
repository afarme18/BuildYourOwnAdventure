package com.example.buildyourownadventure;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LoginFragment.ILoginListener, RegisterFragment.IRegisterListener, DashboardFragment.IDashboardListener, ContactFragment.IContactListener, CharacterFragment.ICreateCharacterListener {
    //Purpose and todos. Updated: 2/18/2022
    //Landing screen, leads to other functions of the app.

    //FirebaseAuth object variable
    FirebaseAuth mAuth;
    final String TAG = "demo"; //For Logging and Testing Purposes

    //Following keys for starting and identifying Fragments
    public static final String LOGIN_KEY = "LOGIN_KEY";
    public static final String USER_KEY = "USER_KEY";
    public static final String REGISTER_KEY = "REGISTER_KEY";
    public static final String SETTINGS_KEY = "SETTINGS_KEY";
    public static final String CONTACT_KEY = "CONTACT_KEY";
    public static final String CALCULATOR_KEY = "CALCULATOR_KEY";
    public static final String LIBRARIES_KEY = "LIBRARIES_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Home"); //Log successful launch

        //Initialize FirebaseAuth instance object
        mAuth = FirebaseAuth.getInstance();

        //If there is not a current user authenticated, send Login Fragment
        //If there is a user authenticated, send Dashboard fragment
        if(mAuth.getCurrentUser() == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.rootView, new LoginFragment())
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.rootView, new DashboardFragment())
                    .commit();
        }
    }

    @Override
    public void successfulLogin() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, DashboardFragment.newInstance(), USER_KEY)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void unsuccessfulLogin(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void startRegister() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, RegisterFragment.newInstance(), REGISTER_KEY)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void successfulRegister() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, new LoginFragment())
                .commit();
    }

    @Override
    public void unsuccessfulRegister(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void cancelRegister() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void startFAQ() {
        /*
        Intent intentFAQ = new Intent(MainActivity.this, FaqActivity.class);
        startActivity(intentFAQ);
         */
    }

    @Override
    public void startSettings() {
        /*
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, SettingsFragment.newInstance(null, null), SETTINGS_KEY)
                .addToBackStack(null)
                .commit();
         */
    }

    @Override
    public void startContact() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, ContactFragment.newInstance(), CONTACT_KEY)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void runOnUIThreadDashboardSetDisplayName(Runnable runnable) {
        runnable.run();
    }

    @Override
    public void startAIDungeon() {
        /*
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, AIDungeonFragment.newInstance(null, null), AI_DUNGEON_KEY)
                .addToBackStack(null)
                .commit();
         */
    }

    @Override
    public void startGameSetup() {
        /*
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, GameSetupFragment.newInstance(null, null), GAME_SETUP_KEY)
                .addToBackStack(null)
                .commit();
         */
    }

    @Override
    public void startNotes() {
        /*
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, NotesFragment.newInstance(null, null), NOTES_KEY)
                .addToBackStack(null)
                .commit();
         */
    }

    @Override
    public void startCharacters() {

        Intent intent = new Intent(this, CharacterActivity.class);
        startActivity(intent);

    }

    @Override
    public void startDice() {
        Intent intentDice = new Intent(MainActivity.this, roll_the_dice.class);
        startActivity(intentDice);
    }

    @Override
    public void startCalculator() {
        /*
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, CalculatorFragment.newInstance(null, null), CALCULATOR_KEY)
                .addToBackStack(null)
                .commit();
         */
    }

    @Override
    public void startLibraries() {
        /*
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, LibrariesFragment.newInstance(null, null), LIBRARIES_KEY)
                .addToBackStack(null)
                .commit();
         */
    }

    @Override
    public void startSounds() {
        Intent intentSounds = new Intent(MainActivity.this, BgMusicActivity.class);
        startActivity(intentSounds);
    }

    @Override
    public void startTutorial() {
        /*
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, LibrariesFragment.newInstance(null, null), TUTORIAL_KEY)
                .addToBackStack(null)
                .commit();
         */
    }

    @Override
    public void logout() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.rootView, LoginFragment.newInstance(), LOGIN_KEY)
                .commit();
    }

    @Override
    public void endContact() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void newCharacter() {

    }
}