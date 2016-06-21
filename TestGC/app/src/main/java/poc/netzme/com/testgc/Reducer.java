package poc.netzme.com.testgc;

import com.brianegan.bansa.Action;
import com.github.krukow.clj_ds.PersistentMap;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by david on 5/18/16.
 */
public class Reducer implements com.brianegan.bansa.Reducer<State> {
    private Random random;

    public Reducer() {
        this.random = new Random();
    }

    @Override
    public State reduce(State state, Action action) {
        poc.netzme.com.testgc.Action myAction = (poc.netzme.com.testgc.Action)action;

        switch (myAction.type) {
            case NEW_ACTION:
                PersistentMap persistentMap = state.persistentMap().plus(state.persistentMap().size(), new String("HALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLOHALLO"));
                return ImmutableState.builder().from(state).counter(state.counter() + 1).persistentMap(persistentMap).build();
        }

        return state;
    }
}
