package kr.co.cofile.sbbshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.co.cofile.sbbshop.domain.Favorite;
import kr.co.cofile.sbbshop.mapper.FavoritesMapper;

@Service
public class FavoritesService {

    @Autowired
    private FavoritesMapper favoritesMapper;

    public void addFavorite(Favorite favorite) {
        favoritesMapper.insertFavorite(favorite);
    }

    public List<Favorite> getFavorites() {
        return favoritesMapper.getAllFavorites();
    }
}
