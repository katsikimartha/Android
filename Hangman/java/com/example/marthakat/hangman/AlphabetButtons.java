package com.example.marthakat.hangman;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

public class AlphabetButtons extends BaseAdapter {

    //holds alphabet letters
    private String[] alphabet;
    //inflater for button layout
    private LayoutInflater layoutInflater;

    public AlphabetButtons(Context c) {
        //instantiate alphabet array
        alphabet =new String[26];
        for(int a=0; a< alphabet.length; a++){
            alphabet[a]=""+(char)(a+'A');
        }
        //specify layout to inflate
        layoutInflater = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return alphabet.length;
    }

    @Override
    public Object getItem(int arg0) {
        return null;
    }

    @Override
    public long getItemId(int arg0) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //create a button for the letter at this position
        Button alphabetButton;
        if (convertView == null) {
            //inflate the button layout
            alphabetButton = (Button) layoutInflater.inflate(R.layout.activity_alphabet_buttons, parent, false);//26 views
        } else {
            alphabetButton = (Button) convertView;
        }
        //set the text to this letter
        alphabetButton.setText(alphabet[position]);
        return alphabetButton;
    }
}
