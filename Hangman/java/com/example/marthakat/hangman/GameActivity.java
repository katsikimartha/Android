package com.example.marthakat.hangman;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GameActivity extends AppCompatActivity {

    //array -> words
    private String[] words;

    //select word randomly from the array
    private Random r;

    //current word select
    private String currentWord;

    //layout for the answer
    private LinearLayout answerLayout;

    //holds each letter of the answer
    private TextView[] lViews;

    //alphabet button grid
    private GridView alphabet;

    //attribute - AlphabetButtons activity
    private AlphabetButtons letters;

    //array for the body parts images
    private ImageView[] bodyParts;

    //total parts - chances
    private int numParts=6;

    //current part
    private int currentPart;

    //number of characters in the current word
    private int numChars;

    //number of correct guesses so far
    private int numCG;


    public static final String MY_JSON ="MY_JSON";

    private static final String JSON_URL = "http://up789041.ct.port.ac.uk/words.php";
    //using the University's server as an example

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //read resources, get words from arrays.xml and store them into the array words[]
        Resources res = getResources();
        words = res.getStringArray(R.array.words);

        //initialize random
        r = new Random();
        //initialize word
        currentWord ="";

        //get answer area
        answerLayout = (LinearLayout)findViewById(R.id.words_space);

        //get letter button grid
        alphabet = (GridView)findViewById(R.id.letter_buttons);

        //get body part images
        bodyParts = new ImageView[numParts];
        bodyParts[0] = (ImageView)findViewById(R.id.head);
        bodyParts[1] = (ImageView)findViewById(R.id.body);
        bodyParts[2] = (ImageView)findViewById(R.id.arm1);
        bodyParts[3] = (ImageView)findViewById(R.id.arm2);
        bodyParts[4] = (ImageView)findViewById(R.id.leg1);
        bodyParts[5] = (ImageView)findViewById(R.id.leg2);

        //call method
        playGame();

        //if the words/data are going to be retrieved from a server/database, the follow method will be used.
//        getJSON(JSON_URL);


    }

    //play a new game
    private void playGame(){

        //choose a word randomly
        String newWord = words[r.nextInt(words.length)];
        //make sure not same word as last time
        while(newWord.equals(currentWord)) newWord = words[r.nextInt(words.length)];
        //update current word
        currentWord = newWord;

        //create new array for character text views
        lViews = new TextView[currentWord.length()];

        //remove any existing letters
        //when the user wants to play again a new game
        answerLayout.removeAllViews();

        //loop through characters
        //text view for each letter of the answer
        for(int c=0; c< currentWord.length(); c++){
            lViews[c] = new TextView(this);
            //set the current letter
            lViews[c].setText(""+ currentWord.charAt(c));
            //set display properties
            lViews[c].setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            lViews[c].setGravity(Gravity.CENTER);
            lViews[c].setTextColor(Color.WHITE);//user can not see it in the white background
            //it will change to black if it is correct
            lViews[c].setBackgroundResource(R.drawable.letter_bg);
            //add to layout
            answerLayout.addView(lViews[c]);
        }

        //we will create buttons for each letter of the alphabet in the following activity (grid view)
        letters =new AlphabetButtons(this);
        alphabet.setAdapter(letters);

        //start part at zero
        currentPart =0;
        //set word length and correct choices
        numChars= currentWord.length();
        numCG =0;

        //hide all parts  - until a wrong letter is given
        for(int p=0; p<numParts; p++){
            bodyParts[p].setVisibility(View.INVISIBLE);
        }
    }

    //response to user clicks
    public void letterPressed(View view){
        //find out which letter was pressed - reference to a view
        String ltr=((TextView)view).getText().toString();
        char letterChar = ltr.charAt(0);
        //disable view
        view.setEnabled(false);//when clicked
        view.setBackgroundResource(R.drawable.letter_down);//shows that button was clicked
        //check if it is correct
        boolean correct=false;
        for(int k=0; k< currentWord.length(); k++){
            if(currentWord.charAt(k)==letterChar){
                correct=true;
                numCG++;
                lViews[k].setTextColor(Color.BLACK);
            }
        }
        //check in case won
        if(correct){
            if(numCG ==numChars){
                //disable all buttons
                disableButtons();
                //let user know they have won, ask if they want to play again
                //if yes, the method playGame() is called again, otherwise the method finish() is called in order to exit the game
                AlertDialog.Builder winBuild = new AlertDialog.Builder(this);
                winBuild.setTitle("YAY");
                winBuild.setMessage("You win!\n\nThe answer was:\n\n"+ currentWord);
                winBuild.setPositiveButton("Play Again",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                GameActivity.this.playGame();
                            }});
                winBuild.setNegativeButton("Exit",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                GameActivity.this.finish();
                            }});
                winBuild.show();
            }
        }
        //check if user still has guesses
        else if(currentPart <numParts){
            //show next part
            bodyParts[currentPart].setVisibility(View.VISIBLE);
            currentPart++;
        }
        else{
            //user has lost
            disableButtons();
            //let the user know they lost, ask if they want to play again
            //if yes, the method playGame() is called again, otherwise the method finish() is called in order to exit the game
            AlertDialog.Builder loseBuild = new AlertDialog.Builder(this);
            loseBuild.setTitle("OOPS");
            loseBuild.setMessage("You lose!\n\nThe answer was:\n\n"+ currentWord);
            loseBuild.setPositiveButton("Play Again",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            GameActivity.this.playGame();
                        }});
            loseBuild.setNegativeButton("Exit",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            GameActivity.this.finish();
                        }});
            loseBuild.show();
        }
    }

    //disable letter buttons
    public void disableButtons(){
        int numLetters = alphabet.getChildCount();
        for(int l=0; l<numLetters; l++){
            alphabet.getChildAt(l).setEnabled(false);
        }
    }

    private void getJSON(String url) {
        class GetJSON extends AsyncTask<String, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(GameActivity.this, "Please Wait...", null, true, true);
            }

            @Override
            protected String doInBackground(String... params) {

                String uri = params[0];

                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(uri);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();

                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }

                    return sb.toString().trim();

                } catch (Exception e) {
                    return null;
                }

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSONArray w;
                JSONObject x = new JSONObject();
                try {
                    x.getJSONObject("arrays");//table name
                    w = x.getJSONArray("words");//column

                    for (int i=0; i<w.length();i++){
                        System.out.println(w.get(i)+ "/n");
                        String str = w.getJSONObject(i).getString("words");
                        words[i] = str.toString();//put words into String array words[]
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute(url);
    }


}
