package kr.co.cofile.sbbshop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import kr.co.cofile.sbbshop.domain.Favorite;
import kr.co.cofile.sbbshop.service.FavoritesService;

@RestController
@RequestMapping("/api/favorites")
public class FavoritesController {

    @Autowired
    private FavoritesService favoritesService;

    @PostMapping
    public ResponseEntity<Void> addToFavorites(@RequestBody Favorite favorite) {
        favoritesService.addFavorite(favorite);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Favorite> getFavorites() {
        return favoritesService.getFavorites();
    }
}
