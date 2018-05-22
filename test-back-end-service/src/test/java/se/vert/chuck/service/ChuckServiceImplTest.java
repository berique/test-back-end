package se.vert.chuck.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import se.vert.chuck.model.ChuckModel;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ChuckService.class)
public class ChuckServiceImplTest {

    @Autowired
    private ChuckService chuckService;

    public ChuckServiceImplTest() {

    }

    @Test
    public void obtainRandom() throws IOException {
        ChuckModel random = chuckService.obtainRandom();

        assertThat(random, is(notNullValue()));
        assertThat(random.getCategory(), is(nullValue()));
        assertThat(random.getIconURL().toString(), is("https://assets.chucknorris.host/img/avatar/chuck-norris.png"));
    }

    @Test
    public void obtainRandomWithCategory() {
        ChuckModel random = chuckService.obtainRandom("dev");

        assertThat(random, is(notNullValue()));
        assertThat(random.getCategory(), is(new String[]{"dev"}));
        assertThat(random.getIconURL().toString(), is("https://assets.chucknorris.host/img/avatar/chuck-norris.png"));
    }

}