package poc.netzme.com.testgc;

import android.app.Application;

import com.brianegan.bansa.*;
import com.brianegan.bansa.Action;
import com.github.krukow.clj_ds.PersistentMap;
import com.github.krukow.clj_lang.PersistentHashMap;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by david on 5/18/16.
 */
public class GCApplication extends Application {
    private BaseStore<State> store;

    @Override
    public void onCreate() {
        super.onCreate();

        HashMap<Integer, String> hashMap = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        PersistentMap<Integer, String> persistentMap = PersistentHashMap.emptyMap();
        int counter = 10000;

        //meter.loop(counter, "init persistenceMap");
        for(int i=0 ; i<counter ; i++) {
            //hashMap.put(i, new String("HALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLO"));
            //arrayList.add(i);
            persistentMap = persistentMap.plus(i, new String("HALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLO"));
            //meter.recap();
        }

        store = new BaseStore<>(
                ImmutableState.builder().counter(0).persistentMap(persistentMap).build(),
                new Reducer());
    }

    public BaseStore<State> getStore() {
        return store;
    }
}
