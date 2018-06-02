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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button submitQuizButton = findViewById(R.id.submit_quiz_button);

        submitQuizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //The Correct Answers
                RadioButton correctAnswer1 = findViewById(R.id.question_1_answer_3_rb), correctAnswer2 = findViewById(R.id.question_2_answer_2_rb),
                        correctAnswer4 = findViewById(R.id.question_4_answer_2_rb), correctAnswer5 = findViewById(R.id.question_5_answer_1_rb);

                CheckBox correctAnswer6One = findViewById(R.id.question_6_answer_1_cb), correctAnswer6Two = findViewById(R.id.question_6_answer_2_cb),
                        correctAnswer6Three = findViewById(R.id.question_6_answer_3_cb);

                EditText correctAnswer3 = findViewById(R.id.question_3_answer_et);

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

                explainsTheQuestions();
                theWrongAnswers();

                //Tally score from selected answers and show correct Answers
                theScore = theCorrectRadioAnswers(isCorrect1, isCorrect2, isCorrect4, isCorrect5) + theCorrectCheckboxAnswers(isCorrect6PtOne, isCorrect6PtTwo, isCorrect6PtThree) + correctEditTextAnswer(correctAnswer3);

                //Displays the score in a Toast
                Toast totalScore = Toast.makeText(MainActivity.this, "You scored " + theScore + " out of 6", Toast.LENGTH_LONG);
                totalScore.show();

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
     * @param wrongAnswerRb is the radio button for wrong answer that the user selects
     */
    public void wrongAnswer(RadioButton wrongAnswerRb) {
        boolean isWrong = wrongAnswerRb.isChecked();

        if (isWrong) {
            wrongAnswerRb.setTextColor(Color.parseColor("#AE0C2F"));
        }
    }

    public void theWrongAnswers() {
        //The Wrong Answers
        RadioButton wrongAnsOneRb = findViewById(R.id.question_1_answer_1_rb), wrongAnsTwoRb = findViewById(R.id.question_1_answer_2_rb),
                wrongAnsThreeRb = findViewById(R.id.question_2_answer_1_rb), wrongAnsFourRb = findViewById(R.id.question_4_answer_1_rb),
                wrongAnsFiveRb = findViewById(R.id.question_4_answer_3_rb), wrongAnsSixRb = findViewById(R.id.question_5_answer_2_rb),
                wrongAnsSevenRb = findViewById(R.id.question_5_answer_3_rb);

        //Boolean to the wrong answer views
        wrongAnswer(wrongAnsOneRb);
        wrongAnswer(wrongAnsTwoRb);
        wrongAnswer(wrongAnsThreeRb);
        wrongAnswer(wrongAnsFourRb);
        wrongAnswer(wrongAnsFiveRb);
        wrongAnswer(wrongAnsSixRb);
        wrongAnswer(wrongAnsSevenRb);
    }

    //Explains the correct answer to the user
    public void explainsTheQuestions() {
        TextView explainQuestionOne = findViewById(R.id.explain_question_1);
        TextView explainQuestionTwo = findViewById(R.id.explain_question_2);
        TextView explainQuestionThree = findViewById(R.id.explain_question_3);
        TextView explainQuestionFour = findViewById(R.id.explain_question_4);
        TextView explainQuestionFive = findViewById(R.id.explain_question_5);
        TextView explainQuestionSix = findViewById(R.id.explain_question_6);

        explainQuestionOne.setText(R.string.explanation_one);
        explainQuestionTwo.setText(R.string.explanation_two);
        explainQuestionThree.setText(R.string.explanation_three);
        explainQuestionFour.setText(R.string.explanation_four);
        explainQuestionFive.setText(R.string.explanation_five);
        explainQuestionSix.setText(R.string.explanation_six);
    }
}
