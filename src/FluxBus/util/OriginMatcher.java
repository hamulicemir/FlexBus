package FluxBus.util;

import FluxBus.entities.Busride;
import FluxBus.provided.Matcher;

public class OriginMatcher implements Matcher<Busride> {
    private String origin;
    public OriginMatcher(String o){
        this.origin = o;
    }
    @Override
    public boolean match(Busride busride) {
        return origin.equals(busride.getOrigin());
    }
}