package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    boolean activate = true;
    int active_player = 0; // can have either 0 or 1 (0->X,1->O)
    int []state = {2,2,2,2,2,2,2,2,2}; // 0->X,1->O,2->blank
    int[][] win_pos = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void touch(View v)
    {
        ImageView img = (ImageView) v;
        int tapped_img = Integer.parseInt(img.getTag().toString());
        if(!activate)
        {
            reset(v);

        }
        if (state[tapped_img] == 2 )
        {
            state[tapped_img] = active_player;
            img.setTranslationY(-1000f);
            if (active_player == 0)
            {
                img.setImageResource(R.drawable.x_img);
                active_player = 1;
                TextView result = findViewById(R.id.result);
                result.setText("O's turn TAP to PLAY");

            }
            else {
                img.setImageResource(R.drawable.o_img);
                active_player = 0;
                TextView result = findViewById(R.id.result);
                result.setText("X's turn TAP to PLAY");
            }
            img.animate().translationYBy(1000f).setDuration(300);


        }
        for(int[] win_pos:win_pos) // to get winner
        {
            if(state[win_pos[0]] == state[win_pos[1]] && state[win_pos[1]] == state[win_pos[2]] &&
                    state[win_pos[0]] != 2)
            {
                String winner;
                activate = false;

                if(state[win_pos[0]]== 0)
                {
                    winner = "X has won !!!";
                }
                else
                {
                    winner = "O has won !!!";
                }
                TextView result = findViewById(R.id.result);
                result.setText(winner);

            }
        }

    }
    public void reset(View v)
    {
        activate = true;
        active_player = 0;
        for(int i = 0;i<state.length;i++)
        {
            state[i] = 2;

        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        TextView result = findViewById(R.id.result);
        result.setText("X's turn TAP to PLAY");

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

}