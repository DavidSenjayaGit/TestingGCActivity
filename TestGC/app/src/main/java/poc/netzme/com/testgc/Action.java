package poc.netzme.com.testgc;

/**
 * Created by david on 5/18/16.
 */
public class Action implements com.brianegan.bansa.Action {

    enum Type {
        NEW_ACTION
    }

    Type type;
    String value;
}
