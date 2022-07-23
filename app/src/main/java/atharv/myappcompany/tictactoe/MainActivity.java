package atharv.myappcompany.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPos = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    int activePlayer = 0;  //o for X and 1 for O 2 for empty
    boolean gameActive = true;

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;
        int tappedSpace = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedSpace] == 2 && gameActive) {
            gameState[tappedSpace] = activePlayer;

            counter.setTranslationY(-1500);


            if (activePlayer == 0) {
                activePlayer = 1;
                counter.setImageResource(R.drawable.x);

            } else {
                activePlayer = 0;
                counter.setImageResource(R.drawable.o);
            }
            counter.animate().translationYBy(1500).rotation(1800).setDuration(300);

            for (int[] curWinningPos : winningPos) {
                if (gameState[curWinningPos[0]] == gameState[curWinningPos[1]] && gameState[curWinningPos[1]] == gameState[curWinningPos[2]] && gameState[curWinningPos[0]] != 2) {
                    String winner;
                    gameActive = false;

                    if (activePlayer == 1) {
                        winner = "player 1";
                    } else {
                        winner = "player 2";
                    }


                    Button playAgain = (Button) findViewById(R.id.button);
                    TextView winnerTextView = (TextView) findViewById(R.id.textView);
                    winnerTextView.setText(winner + " has won");
                    playAgain.setVisibility(View.VISIBLE);
                    winnerTextView.setVisibility(View.VISIBLE);

                }
//                else
//                {
//                    Button playAgain = (Button) findViewById(R.id.button);
//                    TextView winnerTextView = (TextView) findViewById(R.id.textView);
//                    winnerTextView.setText("draw");
//                    playAgain.setVisibility(View.VISIBLE);
//                    winnerTextView.setVisibility(View.VISIBLE);
                }
            }
        }


    public void playAgain(View v) {
        Button playAgain = (Button) findViewById(R.id.button);
        TextView winnerTextView = (TextView) findViewById(R.id.textView);
        playAgain.setVisibility(View.INVISIBLE);
        winnerTextView.setVisibility(View.INVISIBLE);

//        GridLayout grid = (GridLayout) findViewById(R.id.grid);
//        for (int i = 0; i < grid.getChildCount(); i++) {
//            ImageView counter = (ImageView) grid.getChildAt(i);
//            counter.setImageDrawable(null);
//        }
        ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
        ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
        ImageView imageView4 = (ImageView) findViewById(R.id.imageView4);
        ImageView imageView5 = (ImageView) findViewById(R.id.imageView5);
        ImageView imageView6 = (ImageView) findViewById(R.id.imageView6);
        ImageView imageView7 = (ImageView) findViewById(R.id.imageView7);
        ImageView imageView8 = (ImageView) findViewById(R.id.imageView8);
        ImageView imageView9 = (ImageView) findViewById(R.id.imageView9);

        imageView1.setImageDrawable(null);
        imageView2.setImageDrawable(null);
        imageView3.setImageDrawable(null);
        imageView4.setImageDrawable(null);
        imageView5.setImageDrawable(null);
        imageView6.setImageDrawable(null);
        imageView7.setImageDrawable(null);
        imageView8.setImageDrawable(null);
        imageView9.setImageDrawable(null);

        for (int i = 0; i < gameState.length; i++)
        {
            gameState[i] = 2;
        }
        activePlayer = 0;  //o for X and 1 for O 2 for empty
        gameActive = true;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}