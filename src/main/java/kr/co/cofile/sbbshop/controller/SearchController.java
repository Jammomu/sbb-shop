package kr.co.cofile.sbbshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import kr.co.cofile.sbbshop.service.NaverShoppingService;
import java.util.List;
import kr.co.cofile.sbbshop.domain.Favorite;

@RestController
@RequestMapping("/api/search")
public class SearchController {

	private final String clientId = "pC3GjeCEBSu0WZctBhmR";
	private final String clientSecret = "YSXtUl8Tom";

    @GetMapping("/{query}")
    public ResponseEntity<String> searchItems(@PathVariable String query) {
        String url = "https://openapi.naver.com/v1/search/shop.json?query=" + query;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", clientId);
        headers.set("X-Naver-Client-Secret", clientSecret);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        
        return response;
    }
    
//	@Autowired
//	private NaverShoppingService shoppingService;
//
//	@GetMapping("/{query}")
//	public ResponseEntity<List<Favorite>> searchItems(@PathVariable String query) {
//		List<Favorite> products = shoppingService.searchProducts(query);
//		return ResponseEntity.ok(products);
//	}
}
