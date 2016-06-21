package poc.netzme.com.testgc;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.github.krukow.clj_lang.PersistentHashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyRunnable runnable = new MyRunnable(this);
        Thread thread = new Thread(runnable);
        thread.start();

    }

    private static class MyRunnable implements Runnable {
        private MainActivity mainActivity;

        public MyRunnable(MainActivity mainActivity) {
            this.mainActivity = mainActivity;
        }

        @Override
        public void run() {
            while (true) {
                Action action = new Action();
                action.type = Action.Type.NEW_ACTION;
                action.value = Byte.toString(Byte.MAX_VALUE);
                ((GCApplication) mainActivity.getApplication()).getStore().dispatch(action);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
