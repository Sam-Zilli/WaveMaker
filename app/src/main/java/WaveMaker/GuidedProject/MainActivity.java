package WaveMaker.GuidedProject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
        Log.i("MainActivity", "hi");
    }

    private native void touchEvent(int action);

    private native void startEngine();

    private native void stopEngine();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startEngine();
    }

    private void logClick(View v) {
        Log.i("MainActivity", "loggedClick");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touchEvent(event.getAction());
        return super.onTouchEvent(event);
    }

    @Override
    public void onDestroy() {
        stopEngine();
        super.onDestroy();
    }
}