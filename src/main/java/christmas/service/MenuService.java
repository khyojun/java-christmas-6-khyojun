package christmas.service;

import christmas.domain.Menu;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MenuService {

    public long calculateBeforeBenefit(Map<String, Integer> menuInfo) {
        long total=0L;
        List<Menu> menus= List.of(Menu.values());
        for (Menu menu : menus) {
            for (Entry<String, Integer> menuEntry : menuInfo.entrySet()) {
                if(menu.getMenuName().equals(menuEntry.getKey()))
                    total+= (long) menu.getPrice() * menuEntry.getValue();
            }
        }
        return total;
    }
}
