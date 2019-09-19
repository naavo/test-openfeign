package test.openfeign.client;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "whatever-service")
public interface DummyClient {
  @RequestMapping(path="/201/{dummyId}" , method = GET, produces="application/json")
  public void badClient(@PathVariable(name="dummyId") String dummyId, @RequestParam("term") String searchTerm, @RequestParam("page") int page, @RequestParam("pageSize") int pageSize);
  
  @RequestMapping(path="/201/{dummyId}" , method = GET, produces="application/json")
  public void resolvedClient(@PathVariable(name="dummyId") String dummyId, @SpringQueryMap Map<String,String> queryParam);
}
