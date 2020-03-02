package store;

import java.util.List;

public interface Observer {
    public void update(List<List<Object>>comrental, List<List<Object>> actrental, List<String> leftcarlist, int date, double dayincome);
}
