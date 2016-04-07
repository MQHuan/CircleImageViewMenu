package sample.imco.com.circleimageviewmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CircleimageViewMenu circleMenu = (CircleimageViewMenu) findViewById(R.id.circle_menu);
        circleMenu.setRedText("66,885");
        circleMenu.setBlueText("25");
        circleMenu.setGreenText("256,885");
    }
}
