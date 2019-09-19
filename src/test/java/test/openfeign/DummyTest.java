package test.openfeign;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import test.openfeign.client.DummyClient;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { TestConfiguration.class })
public class DummyTest {
  
  @Autowired
  private DummyClient dummyClient;
  
  @Test
  public void testClient_withRequestParam() {
    RandomStringUtils randomStringUtils = new RandomStringUtils();
    String randomSubjectWithSplcharacters = randomStringUtils.randomAlphanumeric(5) + "&&" + randomStringUtils.randomAlphanumeric(3);
    
    dummyClient.badClient("1",randomSubjectWithSplcharacters, 0, 1);
  }
  
  @Test
  public void testClient_withRequestParamAsMaps() {
    RandomStringUtils randomStringUtils = new RandomStringUtils();
    String randomSubjectWithSplcharacters = randomStringUtils.randomAlphanumeric(5) + "&&" + randomStringUtils.randomAlphanumeric(3);
    Map<String,String> parameters = new HashMap<String,String>();
    parameters.put("term",randomSubjectWithSplcharacters );
    parameters.put("page",String.valueOf(0));
    parameters.put("pageSize",String.valueOf(1));
    
    dummyClient.resolvedClient("1",parameters);
  }
}
