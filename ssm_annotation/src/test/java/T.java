import config.SpringConfig;
import domain.City;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.CityService;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class T {
    @Autowired
    private CityService cityService;

    @Test
    public void testSave() {
        City c = new City();
        c.setCityName("xuzhou");
        c.setCreateTime(new Date());
        cityService.save(c);
    }

    @Test
    public void testUpdate() {
        City c = new City();
        c.setId(1);
        c.setCityName("xuzhou_new");
        c.setCreateTime(new Date());
        cityService.update(c);
    }

    @Test
    public void testDelete() {
        cityService.delete(1);
    }

    @Test
    public void testGetById() {
        City c = cityService.getById(1);
        System.out.println(c);
    }

    @Test
    public void testGetAll() {
        List<City> all = cityService.getAll();
        System.out.println(all);
    }

}
