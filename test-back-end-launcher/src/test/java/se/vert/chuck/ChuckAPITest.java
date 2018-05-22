package se.vert.chuck;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import se.vert.chuck.api.ChuckAPI;
import se.vert.chuck.model.ChuckModel;
import se.vert.chuck.service.ChuckService;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChuckAPITest {

    public static final String ICON_URL = "http://wwww.google.com";
    public static final String ID = "1";
    public static final String VALUE = "Facebook as got a Chuck Norris account";

    @Autowired
    private ChuckAPI chuckAPI;

    @Autowired
    private ChuckService chuckService;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void random() {
        ChuckModel chuck = this.testRestTemplate.getForObject("/api/chuck/random", ChuckModel.class);
        assertThat(chuck, is(notNullValue()));
        assertThat(chuck.getIconURL(), is(ICON_URL));
        assertThat(chuck.getId(), is(ID));
        assertThat(chuck.getValue(), is(VALUE));
    }

}