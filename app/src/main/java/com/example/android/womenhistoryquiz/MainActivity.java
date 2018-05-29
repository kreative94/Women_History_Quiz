package com.example.android.womenhistoryquiz;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int theScore = 0;
    int baseScore = 0;
    Button submitQuizButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //the button to submit the quiz
        submitQuizButton = findViewById(R.id.submit_quiz);

        //Will show the quiz results
        submitQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //The Correct Answers
                RadioButton correctAnswer1 = findViewById(R.id.roosevelt), correctAnswer2 = findViewById(R.id.is_false),
                        correctAnswer4 = findViewById(R.id.ride), correctAnswer5 = findViewById(R.id.lovelace);

                CheckBox correctAnswer6One = findViewById(R.id.ginsburg), correctAnswer6Two = findViewById(R.id.sotomayor),
                        correctAnswer6Three = findViewById(R.id.connor);

                EditText correctAnswer3 = findViewById(R.id.curie);

                //Answer One
                correctAnswer1.setTextColor(Color.parseColor("#20A428"));
                boolean isCorrect1 = correctAnswer1.isChecked();
                //Answer Two
                correctAnswer2.setTextColor(Color.parseColor("#20A428"));
                boolean isCorrect2 = correctAnswer2.isChecked();
                //Answer Four
                correctAnswer4.setTextColor(Color.parseColor("#20A428"));
                boolean isCorrect4 = correctAnswer4.isChecked();
                //Answer 5
                correctAnswer5.setTextColor(Color.parseColor("#20A428"));
                boolean isCorrect5 = correctAnswer5.isChecked();

                //Checkboxes to 6
                boolean isCorrect6PtOne = correctAnswer6One.isChecked();
                boolean isCorrect6PtTwo = correctAnswer6Two.isChecked();
                boolean isCorrect6PtThree = correctAnswer6Three.isChecked();

                explainQuestion();
                theWrongAnswers();

                //Tally score from selected answers and show correct Answers
                theScore = theCorrectRadioAnswers(isCorrect1, isCorrect2, isCorrect4, isCorrect5) + theCorrectCheckboxAnswers(isCorrect6PtOne, isCorrect6PtTwo, isCorrect6PtThree) + correctEditTextAnswer(correctAnswer3);

                //Displays the score in a Toast
                Toast totalScore = Toast.makeText(MainActivity.this, "You scored " + theScore + " out of 6", Toast.LENGTH_LONG);
                totalScore.show();

                //Disable submitQuizButton
                submitQuizButton.setEnabled(false);
            }
        });
    }

    /**
     * @param correctAns1 adds points to question 1
     * @param correctAns2 adds points to question 2
     * @param correctAns4 adds points to question 4
     * @param correctAns5 adds points to question 5
     */
    public int theCorrectRadioAnswers(boolean correctAns1, boolean correctAns2, boolean correctAns4, boolean correctAns5) {
        baseScore = 0;
        if (correctAns1) {
            baseScore = baseScore + 1;
        }

        if (correctAns2) {
            baseScore = baseScore + 1;
        }

        if (correctAns4) {
            baseScore = baseScore + 1;
        }

        if (correctAns5) {
            baseScore = baseScore + 1;
        }

        return theScore + baseScore;
    }

    /**
     * @param correctAns1 is part one answer of question 6
     * @param correctAns2 is part two answer of question 6
     * @param correctAns3 is part three answer of question 6
     * @return score and base score
     */
    public int theCorrectCheckboxAnswers(boolean correctAns1, boolean correctAns2, boolean correctAns3) {
        baseScore = 0;
        if (correctAns1 && correctAns2 && correctAns3) {
            baseScore = baseScore + 1;
        }

        return theScore + baseScore;
    }

    /**
     * @param correctText checks if user inputs the correct answer
     * @return correctText
     */
    public int correctEditTextAnswer(EditText correctText) {
        baseScore = 0;
        if (correctText.getText().toString().equals("Marie Curie")) {
            baseScore = baseScore + 1;
            correctText.setTextColor(Color.parseColor("#20A428"));
        } else {
            correctText.setTextColor(Color.parseColor("#AE0C2F"));
        }
        return theScore + baseScore;
    }

    //Will display the wrong answers the user selected when they submit the quiz

    /**
     * @param isWrong          is the boolean to check if user selected the wrong answer
     * @param wrongAnswerRadio is the radio button for wrong answer
     */
    public void wrongAnswer(boolean isWrong, RadioButton wrongAnswerRadio) {
        isWrong = wrongAnswerRadio.isChecked();

        if (isWrong) {
            wrongAnswerRadio.setTextColor(Color.parseColor("#AE0C2F"));
        }
    }
    //The incorrect answers in the

    public void theWrongAnswers() {
        //The Wrong Answers
        RadioButton wrongAnsOne = findViewById(R.id.keller), wrongAnsTwo = findViewById(R.id.angelou),
                wrongAnsThree = findViewById(R.id.is_true), wrongAnsFour = findViewById(R.id.tereshkova),
                wrongAnsFive = findViewById(R.id.jemison), wrongAnsSix = findViewById(R.id.hopper),
                wrongAnsSeven = findViewById(R.id.conway);

        //Boolean to the wrong answer views
        boolean isWrongOne = wrongAnsOne.isChecked();
        boolean isWrongTwo = wrongAnsTwo.isChecked();
        boolean isWrongThree = wrongAnsThree.isChecked();
        boolean isWrongFour = wrongAnsFour.isChecked();
        boolean isWrongFive = wrongAnsFive.isChecked();
        boolean isWrongSix = wrongAnsSix.isChecked();
        boolean isWrongSeven = wrongAnsSeven.isChecked();

        wrongAnswer(isWrongOne, wrongAnsOne);
        wrongAnswer(isWrongTwo, wrongAnsTwo);
        wrongAnswer(isWrongThree, wrongAnsThree);
        wrongAnswer(isWrongFour, wrongAnsFour);
        wrongAnswer(isWrongFive, wrongAnsFive);
        wrongAnswer(isWrongSix, wrongAnsSix);
        wrongAnswer(isWrongSeven, wrongAnsSeven);
    }

    //Explains the correct answer to the user
    public void explainQuestion() {
        TextView explainOne = findViewById(R.id.explain_one);
        TextView explainTwo = findViewById(R.id.explain_two);
        TextView explainThree = findViewById(R.id.explain_three);
        TextView explainFour = findViewById(R.id.explain_four);
        TextView explainFive = findViewById(R.id.explain_five);
        TextView explainSix = findViewById(R.id.explain_six);

        explainOne.setText(R.string.explanation_one);
        explainTwo.setText(R.string.explanation_two);
        explainThree.setText(R.string.explanation_three);
        explainFour.setText(R.string.explanation_four);
        explainFive.setText(R.string.explanation_five);
        explainSix.setText(R.string.explanation_six);
    }

    //Resets the Quiz
   /* public void resetQuiz() {
        theScore = 0;
        baseScore = 0;
        tryAgainButton = new Button(this);
        tryAgainButton.setText(R.string.try_again);
        tryAgainButton.setEnabled(false);
        clearAnswers();
    }*/

   /*
    //un checks all questions
    public void clearAnswers() {
        //Clear all wrong answers selected
        wrongAnsOne.setChecked(false);
        wrongAnsTwo.setChecked(false);
        wrongAnsThree.isChecked();
        wrongAnsFour.setChecked(false);
        wrongAnsFive.setChecked(false);
        wrongAnsSix.setChecked(false);
        wrongAnsSeven.setChecked(false);

        //Clear all correct answers

        //Unhighlight correct answers. From green to black
        //Answer One
        correctAnswer1.setTextColor(Color.parseColor("#20A428"));
        //Answer Two
        correctAnswer2.setTextColor(Color.parseColor("#20A428"));
        //Answer Four
        correctAnswer4.setTextColor(Color.parseColor("#20A428"));
        //Answer 5
        correctAnswer5.setTextColor(Color.parseColor("#20A428"));


    }
    */
}
