package kr.co.cofile.sbbshop.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.cofile.sbbshop.domain.Favorite;

@Service
public class NaverShoppingService {

    private final String CLIENT_ID = "pC3GjeCEBSu0WZctBhmR";
    private final String CLIENT_SECRET = "YSXtUl8Tom";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    public List<Favorite> searchProducts(String query) {
        String apiUrl = "https://openapi.naver.com/v1/search/shop.json?query=" + query;
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", CLIENT_ID);
        headers.set("X-Naver-Client-Secret", CLIENT_SECRET);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);

        return parseFavorites(response.getBody());
    }

    private List<Favorite> parseFavorites(String responseBody) {
        try {
            JsonNode itemsNode = objectMapper.readTree(responseBody).path("items");
            return itemsNode.isArray() ? 
                objectMapper.convertValue(itemsNode, objectMapper.getTypeFactory().constructCollectionType(List.class, Favorite.class)) : 
                List.of();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
