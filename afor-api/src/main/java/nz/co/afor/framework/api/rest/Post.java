package nz.co.afor.framework.api.rest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Created by Matt Belcher on 10/10/2015.
 */
@Component
public class Post extends AbstractHttpRequest {
    private static Log log = LogFactory.getLog(Post.class);

    public <T> ResponseEntity<T> request(String uri, Object request, Class<T> responseType) {
        HttpHeaders headers = getHeaders();
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri);
        URI url = builder.build().encode().toUri();
        log.info(String.format("Sending POST request to URL '%s'", url.toString()));
        HttpEntity entity = new HttpEntity(request, headers);
        ResponseEntity<T> response = getRestTemplate().exchange(url, HttpMethod.POST, entity, responseType);
        log.info(String.format("Received the status code from request '%s'", response.getStatusCode()));
        log.info(String.format("Received the response body '%s'", response.getBody()));
        return response;
    }
}
