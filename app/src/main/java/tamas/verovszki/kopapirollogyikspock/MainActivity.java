package tamas.verovszki.kopapirollogyikspock;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView Text_View_Your_Choice, Text_View_Computers_Choice, Text_View_Info_Line;
    private ImageView Image_View_Your_Choice, Image_View_Computers_Choice;
    private Button Button_Stone, Button_Paper, Button_Scissors, Button_Lizard, Button_Spock;
    int people_won = 0, computer_won = 0;
    int people_choice_value=0, computer_choice_value;
    String winner = "";
    Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        Button_Stone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_View_Your_Choice.setVisibility(View.VISIBLE); // azért van ez a két sor, mert az app indulásakor elrejtem a szöveget! Így kicsit elegénsabb szerintem!
                Text_View_Computers_Choice.setVisibility(View.VISIBLE); // azért van ez a két sor, mert az app indulásakor elrejtem a szöveget! Így kicsit elegénsabb szerintem!
                people_choice_value=0;
                computer_choice_value = rand.nextInt(5);
                Image_View_Your_Choice.setBackgroundResource(R.drawable.stone);
                setComputersChoiceBackground(computer_choice_value);
                winner = evaluateThisRound(people_choice_value, computer_choice_value);
                popupMessage(winner);
                Text_View_Info_Line.setText(getString(R.string.standing) + " " + getString(R.string.people) + " " + people_won + " - " + getString(R.string.computer) + " " + computer_won);
            }
        });

        Button_Paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_View_Your_Choice.setVisibility(View.VISIBLE);
                Text_View_Computers_Choice.setVisibility(View.VISIBLE);
                people_choice_value=1;
                computer_choice_value = rand.nextInt(5);
                Image_View_Your_Choice.setBackgroundResource(R.drawable.paper);
                setComputersChoiceBackground(computer_choice_value);
                winner = evaluateThisRound(people_choice_value, computer_choice_value);
                popupMessage(winner);
                Text_View_Info_Line.setText(getString(R.string.standing) + " " + getString(R.string.people) + " " + people_won + " - " + getString(R.string.computer) + " " + computer_won);
            }
        });

        Button_Scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_View_Your_Choice.setVisibility(View.VISIBLE);
                Text_View_Computers_Choice.setVisibility(View.VISIBLE);
                people_choice_value=2;
                computer_choice_value = rand.nextInt(5);
                Image_View_Your_Choice.setBackgroundResource(R.drawable.scissors);
                setComputersChoiceBackground(computer_choice_value);
                winner = evaluateThisRound(people_choice_value, computer_choice_value);
                popupMessage(winner);
                Text_View_Info_Line.setText(getString(R.string.standing) + " " + getString(R.string.people) + " " + people_won + " - " + getString(R.string.computer) + " " + computer_won);
            }
        });

        Button_Lizard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_View_Your_Choice.setVisibility(View.VISIBLE);
                Text_View_Computers_Choice.setVisibility(View.VISIBLE);
                people_choice_value=3;
                computer_choice_value = rand.nextInt(5);
                Image_View_Your_Choice.setBackgroundResource(R.drawable.lizard);
                setComputersChoiceBackground(computer_choice_value);
                winner = evaluateThisRound(people_choice_value, computer_choice_value);
                popupMessage(winner);
                Text_View_Info_Line.setText(getString(R.string.standing) + " " + getString(R.string.people) + " " + people_won + " - " + getString(R.string.computer) + " " + computer_won);
            }
        });

        Button_Spock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Text_View_Your_Choice.setVisibility(View.VISIBLE);
                Text_View_Computers_Choice.setVisibility(View.VISIBLE);
                people_choice_value=4;
                computer_choice_value = rand.nextInt(5);
                Image_View_Your_Choice.setBackgroundResource(R.drawable.spock);
                setComputersChoiceBackground(computer_choice_value);
                winner = evaluateThisRound(people_choice_value, computer_choice_value);
                popupMessage(winner);
                Text_View_Info_Line.setText(getString(R.string.standing) + " " + getString(R.string.people) + " " + people_won + " - " + getString(R.string.computer) + " " + computer_won);
            }
        });
    }

    public void init(){
        Text_View_Your_Choice = (TextView) findViewById(R.id.Text_View_Your_Choice);
        Text_View_Computers_Choice = (TextView) findViewById(R.id.Text_View_Computers_Choice);
        Text_View_Info_Line = (TextView) findViewById(R.id.Text_View_Info_Line);
        Image_View_Your_Choice = (ImageView) findViewById(R.id.Image_View_Your_Choice);
        Image_View_Computers_Choice = (ImageView) findViewById(R.id.Image_View_Computers_Choice);
        Button_Paper = (Button) findViewById(R.id.Button_Paper);
        Button_Stone = (Button) findViewById(R.id.Button_Stone);
        Button_Scissors = (Button) findViewById(R.id.Button_Scissors);
        Button_Lizard = (Button) findViewById(R.id.Button_Lizard);
        Button_Spock = (Button) findViewById(R.id.Button_Spock);
    }

    public void setComputersChoiceBackground(int computers_value){
        switch (computers_value){
            case 0:
                Image_View_Computers_Choice.setBackgroundResource(R.drawable.stone);
                break;
            case 1:
                Image_View_Computers_Choice.setBackgroundResource(R.drawable.paper);
                break;
            case 2:
                Image_View_Computers_Choice.setBackgroundResource(R.drawable.scissors);
                break;
            case 3:
                Image_View_Computers_Choice.setBackgroundResource(R.drawable.lizard);
                break;
            case 4:
                Image_View_Computers_Choice.setBackgroundResource(R.drawable.spock);
                break;
        }
    }

    public String evaluateThisRound(int value_people, int value_computer){
        switch (value_people){ // a break-eket kihagytam, helyette return-ok vannak!
            case 0:
                switch(value_computer){
                    case 0:
                        return "equal";
                    case 1:
                        computer_won++;
                        return "computer";
                    case 2:
                        people_won++;
                        return "people";
                    case 3:
                        people_won++;
                        return "people";
                    case 4:
                        computer_won++;
                        return "computer";
                }
            case 1:
                switch(value_computer){
                    case 0:
                        people_won++;
                        return "people";
                    case 1:
                        return "equal";
                    case 2:
                        computer_won++;
                        return "computer";
                    case 3:
                        computer_won++;
                        return "computer";
                    case 4:
                        people_won++;
                        return "people";
                }
            case 2:
                switch(value_computer){
                    case 0:
                        computer_won++;
                        return "computer";
                    case 1:
                        people_won++;
                        return "people";
                    case 2:
                        return "equal";
                    case 3:
                        people_won++;
                        return "people";
                    case 4:
                        computer_won++;
                        return "computer";
                }
            case 3:
                switch(value_computer){
                    case 0:
                        computer_won++;
                        return "computer";
                    case 1:
                        people_won++;
                        return "people";
                    case 2:
                        computer_won++;
                        return "computer";
                    case 3:
                        return "equal";
                    case 4:
                        people_won++;
                        return "people";
                }
            case 4:
                switch(value_computer){
                    case 0:
                        people_won++;
                        return "people";
                    case 1:
                        computer_won++;
                        return "computer";
                    case 2:
                        people_won++;
                        return "people";
                    case 3:
                        computer_won++;
                        return "computer";
                    case 4:
                        return "equal";
                }
        }
        return null;
    }

    public void popupMessage(String winner){
        String text_for_toast = "";
        switch (winner){
            case "people":
                switch ((people_choice_value * 10) + computer_choice_value){
                    case 1:
                    case 10:
                        text_for_toast = getString(R.string.paper_stronger_than_stone);
                        break;
                    case 2:
                    case 20:
                        text_for_toast = getString(R.string.stone_stronger_than_scissors);
                        break;
                    case 3:
                    case 30:
                        text_for_toast = getString(R.string.stone_stronger_than_lizard);
                        break;
                    case 4:
                    case 40:
                        text_for_toast = getString(R.string.spock_stronger_than_stone);
                        break;
                    case 12:
                    case 21:
                        text_for_toast = getString(R.string.scissors_stronger_than_paper);
                        break;
                    case 13:
                    case 31:
                        text_for_toast = getString(R.string.lizard_stronger_than_paper);
                        break;
                    case 14:
                    case 41:
                        text_for_toast = getString(R.string.paper_stronger_than_spock);
                        break;
                    case 23:
                    case 32:
                        text_for_toast = getString(R.string.scissors_stronger_than_lizard);
                        break;
                    case 24:
                    case 42:
                        text_for_toast = getString(R.string.spock_stronger_than_scissors);
                        break;
                    case 34:
                    case 43:
                        text_for_toast = getString(R.string.lizard_stronger_than_spock);
                        break;
                }
                text_for_toast+= " " + getString(R.string.winner_people);
                Toast.makeText(this, text_for_toast, Toast.LENGTH_SHORT).show();
                break;
            case "computer":
                switch ((people_choice_value * 10) + computer_choice_value){
                    case 1:
                    case 10:
                        text_for_toast = getString(R.string.paper_stronger_than_stone);
                        break;
                    case 2:
                    case 20:
                        text_for_toast = getString(R.string.stone_stronger_than_scissors);
                        break;
                    case 3:
                    case 30:
                        text_for_toast = getString(R.string.stone_stronger_than_lizard);
                        break;
                    case 4:
                    case 40:
                        text_for_toast = getString(R.string.spock_stronger_than_stone);
                        break;
                    case 12:
                    case 21:
                        text_for_toast = getString(R.string.scissors_stronger_than_paper);
                        break;
                    case 13:
                    case 31:
                        text_for_toast = getString(R.string.lizard_stronger_than_paper);
                        break;
                    case 14:
                    case 41:
                        text_for_toast = getString(R.string.paper_stronger_than_spock);
                        break;
                    case 23:
                    case 32:
                        text_for_toast = getString(R.string.scissors_stronger_than_lizard);
                        break;
                    case 24:
                    case 42:
                        text_for_toast = getString(R.string.spock_stronger_than_scissors);
                        break;
                    case 34:
                    case 43:
                        text_for_toast = getString(R.string.lizard_stronger_than_spock);
                        break;
                }
                text_for_toast+= " " + getString(R.string.winner_computer);
                Toast.makeText(this, text_for_toast, Toast.LENGTH_SHORT).show();
                break;
            case "equal":
                Toast.makeText(this, R.string.winner_noone, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
