package sandbox;

import java.util.ArrayList;
import java.util.List;

public class sandbox {

    public static void main(String[] args) {
        List<Interface> objs = new ArrayList<Interface>();
        objs.add(new Implementation2());
        objs.add(new implementation());
        for(Interface obj: objs) {
            obj.display();
        }
    }
}
