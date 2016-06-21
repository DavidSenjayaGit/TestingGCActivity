package poc.netzme.com.testgc;

import com.github.krukow.clj_ds.PersistentMap;

import org.immutables.value.Value;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by david on 5/17/16.
 */
@Value.Immutable
public abstract class State {
    public abstract int counter();
    public abstract PersistentMap<Integer, String> persistentMap();
}
