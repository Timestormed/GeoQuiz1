package com.ctech.olson.geoquiz1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheatActivity extends AppCompatActivity {
    private static final String EXTRA_ANSWER_IS_TRUE = "com.ctech.olson.geoquiz1.answer_is_true";

    private boolean mAnswerIsTrue;
    private Button mShowAnswerButton;

    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        Intent intent = new Intent(packageContext, CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return intent;
    }
    public static boolean (wasAnswerShown intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_WAS_SHOWN, false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerIsTrue = findViewById(R.id.answer_text_view);
        mShowAnswerButton = findViewById(R.id.show_answer_button);

        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue) {
                    mAnswerIsTrue.setText(R.string.true_button);
                } else {
                    mAnswerIsTrue.setText(R.string.false_button);
                }
                setAnswerShownResult(true);
            }
        });
    }
}
private void setAnswerShownResult(boolean isAnswerShown) {
    Intent toReturn = new Intent();
    toReturn.putExtra(EXTRA_ANSWER_WAS_SHOWN, isAnswerShown);
    setResult(RESULT_OK, toReturn);
}
