package sample.imco.com.circleimageviewmenu;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mqh on 2/18/16.
 */
public class CircleimageViewMenu extends FrameLayout implements View.OnClickListener {

    private FrameLayout mRedImageView;
    private TextView mRedText;
    private FrameLayout mGreenImageView;
    private TextView mGreenText;
    private FrameLayout mBlueImageView;
    private TextView mBlueText;
    private int redPosition = 1;   //up
    private int bluePosition = 2;  //middle
    private int greenPosition = 3; //down
    private Context mContext;


    public CircleimageViewMenu(Context context){
        this(context, null);
    }

    public CircleimageViewMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        View.inflate(context, R.layout.view_circleimagemenu, this);
        mContext = context;
        initView();



    }

    private void initView() {

        mRedImageView = (FrameLayout) findViewById(R.id.red_circleimageview);
        mRedImageView.setOnClickListener(this);

        mRedText = (TextView) findViewById(R.id.red_text);


        mGreenImageView = (FrameLayout) findViewById(R.id.green_circleimageview);
        mGreenImageView.setOnClickListener(this);

        mGreenText = (TextView) findViewById(R.id.green_text);


        mBlueImageView = (FrameLayout) findViewById(R.id.blue_circleimageview);
        mBlueImageView.setOnClickListener(this);

        mBlueText = (TextView) findViewById(R.id.blue_text);
    }

    public void setRedText(String redText){
        mRedText.setText(redText);
    }

    public void setBlueText(String blueText){
        mBlueText.setText(blueText);
    }

    public void setGreenText(String greenText){
        mGreenText.setText(greenText);
    }

    /**
     * dp --> px
     * @param dp
     * @return
     */
    public float dp2px(float dp) {
        float dimension = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX,
                dp,
                mContext.getResources().getDisplayMetrics());
        return dimension;
    }

    public float px2dp(float px) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                px,
                mContext.getResources().getDisplayMetrics());
    }

    @Override
    public void onClick(View v) {
        if (v == mRedImageView){
            ObjectAnimator translationY;
            ObjectAnimator translationX;
            ObjectAnimator scaleY;
            ObjectAnimator scaleX;
            ObjectAnimator translationY2 = null;
            ObjectAnimator translationX2 = null;
            ObjectAnimator scaleY2 = null;
            ObjectAnimator scaleX2 = null;
            Toast.makeText(getContext(), "red click  dp2px:" + dp2px(100) + "px2dp" + px2dp(100), Toast.LENGTH_SHORT).show();
          switch (redPosition){
              case 1: //up

                  translationY = ObjectAnimator.ofFloat(mRedImageView, "TranslationY", px2dp(52)).setDuration(700);

                  translationX = ObjectAnimator.ofFloat(mRedImageView, "TranslationX", -px2dp(85)).setDuration(700);

                  scaleY = ObjectAnimator.ofFloat(mRedImageView, "scaleY", 1f, 1.5f).setDuration(700);

                  scaleX = ObjectAnimator.ofFloat(mRedImageView, "scaleX", 1f, 1.5f).setDuration(700);

                  if (greenPosition == 2){
                      translationY2 = ObjectAnimator.ofFloat(mGreenImageView, "TranslationY", -px2dp(85)).setDuration(700);

                      translationX2 = ObjectAnimator.ofFloat(mGreenImageView, "TranslationX", -px2dp(24)).setDuration(700);

                      scaleY2 = ObjectAnimator.ofFloat(mGreenImageView, "scaleY", 1.5f, 1f).setDuration(700);

                      scaleX2 = ObjectAnimator.ofFloat(mGreenImageView, "scaleX", 1.5f, 1f).setDuration(700);
                      greenPosition  = 1;//up
                  }else if (bluePosition == 2){
                      translationY2 = ObjectAnimator.ofFloat(mBlueImageView, "TranslationY", -px2dp(50)).setDuration(700);
                      translationX2 = ObjectAnimator.ofFloat(mBlueImageView, "TranslationX", px2dp(85)).setDuration(700);
                      scaleY2 = ObjectAnimator.ofFloat(mBlueImageView, "scaleY", 1f, 0.67f).setDuration(700);
                      scaleX2 = ObjectAnimator.ofFloat(mBlueImageView, "scaleX", 1f, 0.67f).setDuration(700);
                      bluePosition = 1;//up
                  }
                  redPosition = 2;
                  AnimatorSet animatorSet = new AnimatorSet();
                  animatorSet.playTogether(translationX, translationY, scaleX, scaleY, translationX2, translationY2, scaleX2, scaleY2);
                  animatorSet.start();
                  mRedImageView.bringToFront();

                  break;
              case 2: //middle
                  break;
              case 3: //down
                  translationY = ObjectAnimator.ofFloat(mRedImageView, "TranslationY", px2dp(52)).setDuration(700);

                  translationX = ObjectAnimator.ofFloat(mRedImageView, "TranslationX", -px2dp(85)).setDuration(700);

                  scaleY = ObjectAnimator.ofFloat(mRedImageView, "scaleY", 1f, 1.5f).setDuration(700);

                  scaleX = ObjectAnimator.ofFloat(mRedImageView, "scaleX", 1f, 1.5f).setDuration(700);

                  if (greenPosition == 2){

                      translationY2 = ObjectAnimator.ofFloat(mGreenImageView, "TranslationY", 0).setDuration(700);

                      translationX2 = ObjectAnimator.ofFloat(mGreenImageView, "TranslationX", 0).setDuration(700);

                      scaleY2 = ObjectAnimator.ofFloat(mGreenImageView, "scaleY", 1.5f, 1f).setDuration(700);

                      scaleX2 = ObjectAnimator.ofFloat(mGreenImageView, "scaleX", 1.5f, 1f).setDuration(700);
                      greenPosition  = 3;//down
                  }else if (bluePosition == 2){
                      translationY2 = ObjectAnimator.ofFloat(mBlueImageView, "TranslationY", px2dp(33.3f)).setDuration(700);

                      translationX2 = ObjectAnimator.ofFloat(mBlueImageView, "TranslationX", px2dp(109)).setDuration(700);

                      scaleY2 = ObjectAnimator.ofFloat(mBlueImageView, "scaleY", 1f, 0.688f).setDuration(700);

                      scaleX2 = ObjectAnimator.ofFloat(mBlueImageView, "scaleX", 1f, 0.688f).setDuration(700);
                      bluePosition  = 3;//down
                  }
                  redPosition = 2;
                  AnimatorSet animatorSet2 = new AnimatorSet();
                  animatorSet2.playTogether(translationX, translationY, scaleX, scaleY, translationX2, translationY2, scaleX2, scaleY2);
                  animatorSet2.start();
                  mRedImageView.bringToFront();
                  break;
          }

        }else if (v == mGreenImageView){
            Toast.makeText(getContext(), "green click", Toast.LENGTH_SHORT).show();
            ObjectAnimator translationY;
            ObjectAnimator translationX;
            ObjectAnimator scaleY;
            ObjectAnimator scaleX;
            ObjectAnimator translationY2 = null;
            ObjectAnimator translationX2 = null;
            ObjectAnimator scaleY2 = null;
            ObjectAnimator scaleX2 = null;
            switch (greenPosition){
                case 1: //up
                    translationY = ObjectAnimator.ofFloat(mGreenImageView, "TranslationY", -px2dp(34)).setDuration(700);

                    translationX = ObjectAnimator.ofFloat(mGreenImageView, "TranslationX", -px2dp(110.3f)).setDuration(700);

                    scaleY = ObjectAnimator.ofFloat(mGreenImageView, "scaleY", 1f, 1.5f).setDuration(700);

                    scaleX = ObjectAnimator.ofFloat(mGreenImageView, "scaleX", 1f, 1.5f).setDuration(700);

                    if (redPosition == 2){
                        translationY2 = ObjectAnimator.ofFloat(mRedImageView, "TranslationY", 0).setDuration(700);
                        translationX2 = ObjectAnimator.ofFloat(mRedImageView, "TranslationX", 0).setDuration(700);
                        scaleY2 = ObjectAnimator.ofFloat(mRedImageView, "scaleY", 1.5f, 1f).setDuration(700);
                        scaleX2 = ObjectAnimator.ofFloat(mRedImageView, "scaleX", 1.5f, 1f).setDuration(700);
                        redPosition = 1;//up
                    }else if (bluePosition == 2){
                        translationY2 = ObjectAnimator.ofFloat(mBlueImageView, "TranslationY", -px2dp(50)).setDuration(700);
                        translationX2 = ObjectAnimator.ofFloat(mBlueImageView, "TranslationX", px2dp(85)).setDuration(700);
                        scaleY2 = ObjectAnimator.ofFloat(mBlueImageView, "scaleY", 1f, 0.67f).setDuration(700);
                        scaleX2 = ObjectAnimator.ofFloat(mBlueImageView, "scaleX", 1f, 0.67f).setDuration(700);
                        bluePosition = 1;//up
                    }
                    greenPosition = 2;
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(translationX, translationY, scaleX, scaleY, translationX2, translationY2, scaleX2, scaleY2);
                    animatorSet.start();
                    mGreenImageView.bringToFront();
                    break;
                case 2: //middle
                    break;
                case 3: //down
                    translationY = ObjectAnimator.ofFloat(mGreenImageView, "TranslationY", -px2dp(34)).setDuration(700);

                    translationX = ObjectAnimator.ofFloat(mGreenImageView, "TranslationX", -px2dp(110.3f)).setDuration(700);

                    scaleY = ObjectAnimator.ofFloat(mGreenImageView, "scaleY", 1f, 1.5f).setDuration(700);

                    scaleX = ObjectAnimator.ofFloat(mGreenImageView, "scaleX", 1f, 1.5f).setDuration(700);


                    if (bluePosition == 2){

                        translationY2 = ObjectAnimator.ofFloat(mBlueImageView, "TranslationY", px2dp(33.3f)).setDuration(700);

                        translationX2 = ObjectAnimator.ofFloat(mBlueImageView, "TranslationX", px2dp(109)).setDuration(700);

                        scaleY2 = ObjectAnimator.ofFloat(mBlueImageView, "scaleY", 1f, 0.688f).setDuration(700);

                        scaleX2 = ObjectAnimator.ofFloat(mBlueImageView, "scaleX", 1f, 0.688f).setDuration(700);
                        bluePosition  = 3;//down
                    }else if (redPosition == 2){
                        translationY2 = ObjectAnimator.ofFloat(mRedImageView, "TranslationY", px2dp(85)).setDuration(700);

                        translationX2 = ObjectAnimator.ofFloat(mRedImageView, "TranslationX", px2dp(25)).setDuration(700);

                        scaleY2 = ObjectAnimator.ofFloat(mRedImageView, "scaleY", 1.5f, 1f).setDuration(700);

                        scaleX2 = ObjectAnimator.ofFloat(mRedImageView, "scaleX", 1.5f, 1f).setDuration(700);

                        redPosition = 3;//down
                    }

                    greenPosition = 2;
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    animatorSet2.playTogether(translationX, translationY, scaleX, scaleY, translationX2, translationY2, scaleX2, scaleY2);
                    animatorSet2.start();
                    mGreenImageView.bringToFront();
                    break;
            }

        }else if (v == mBlueImageView){
            Toast.makeText(getContext(), "blue click", Toast.LENGTH_SHORT).show();
            ObjectAnimator translationY;
            ObjectAnimator translationX;
            ObjectAnimator scaleY;
            ObjectAnimator scaleX;
            ObjectAnimator translationY2 = null;
            ObjectAnimator translationX2 = null;
            ObjectAnimator scaleY2 = null;
            ObjectAnimator scaleX2 = null;

            switch (bluePosition){
                case 1: //up
                    Toast.makeText(getContext(), "red click", Toast.LENGTH_SHORT).show();

                    translationY = ObjectAnimator.ofFloat(mBlueImageView, "TranslationY", 0).setDuration(700);

                    translationX = ObjectAnimator.ofFloat(mBlueImageView, "TranslationX", 0).setDuration(700);

                    scaleY = ObjectAnimator.ofFloat(mBlueImageView, "scaleY", 0.688f, 1f).setDuration(700);

                    scaleX = ObjectAnimator.ofFloat(mBlueImageView, "scaleX", 0.688f, 1f).setDuration(700);

                    if (greenPosition == 2){

                        translationY2 = ObjectAnimator.ofFloat(mGreenImageView, "TranslationY", -px2dp(85)).setDuration(700);

                        translationX2 = ObjectAnimator.ofFloat(mGreenImageView, "TranslationX", -px2dp(25)).setDuration(700);

                        scaleY2 = ObjectAnimator.ofFloat(mGreenImageView, "scaleY", 1.5f, 1f).setDuration(700);

                        scaleX2 = ObjectAnimator.ofFloat(mGreenImageView, "scaleX", 1.5f, 1f).setDuration(700);
                        greenPosition  = 1;//up
                    }else if (redPosition == 2){
                        translationY2 = ObjectAnimator.ofFloat(mRedImageView, "TranslationY", 0).setDuration(700);
                        translationX2 = ObjectAnimator.ofFloat(mRedImageView, "TranslationX", 0).setDuration(700);
                        scaleY2 = ObjectAnimator.ofFloat(mRedImageView, "scaleY", 1.5f, 1f).setDuration(700);
                        scaleX2 = ObjectAnimator.ofFloat(mRedImageView, "scaleX", 1.5f, 1f).setDuration(700);
                        redPosition = 1;//up
                    }
                    bluePosition = 2;
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.playTogether(translationX, translationY, scaleX, scaleY, translationX2, translationY2, scaleX2, scaleY2);
                    animatorSet.start();
                    mBlueImageView.bringToFront();

                    break;
                case 2: //middle
                    break;
                case 3: //down
                    translationY = ObjectAnimator.ofFloat(mBlueImageView, "TranslationY", 0).setDuration(700);

                    translationX = ObjectAnimator.ofFloat(mBlueImageView, "TranslationX", 0).setDuration(700);

                    scaleY = ObjectAnimator.ofFloat(mBlueImageView, "scaleY", 0.688f, 1f).setDuration(700);

                    scaleX = ObjectAnimator.ofFloat(mBlueImageView, "scaleX", 0.688f, 1f).setDuration(700);


                    if (greenPosition == 2){

                        translationY2 = ObjectAnimator.ofFloat(mGreenImageView, "TranslationY", 0).setDuration(700);

                        translationX2 = ObjectAnimator.ofFloat(mGreenImageView, "TranslationX", 0).setDuration(700);

                        scaleY2 = ObjectAnimator.ofFloat(mGreenImageView, "scaleY", 1.5f, 1f).setDuration(700);

                        scaleX2 = ObjectAnimator.ofFloat(mGreenImageView, "scaleX", 1.5f, 1f).setDuration(700);
                        greenPosition  = 3;//down
                    }else if (redPosition == 2){
                        translationY2 = ObjectAnimator.ofFloat(mRedImageView, "TranslationY", px2dp(83.3f)).setDuration(700);

                        translationX2 = ObjectAnimator.ofFloat(mRedImageView, "TranslationX", px2dp(23.3f)).setDuration(700);

                        scaleY2 = ObjectAnimator.ofFloat(mRedImageView, "scaleY", 1.5f, 1f).setDuration(700);

                        scaleX2 = ObjectAnimator.ofFloat(mRedImageView, "scaleX", 1.5f, 1f).setDuration(700);

                        redPosition = 3;//down
                    }

                    bluePosition = 2;
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    animatorSet2.playTogether(translationX, translationY, scaleX, scaleY, translationX2, translationY2, scaleX2, scaleY2);
                    animatorSet2.start();
                    mBlueImageView.bringToFront();
                    break;
            }
        }
    }
}
