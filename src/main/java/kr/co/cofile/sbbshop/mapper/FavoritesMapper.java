package kr.co.cofile.sbbshop.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import kr.co.cofile.sbbshop.domain.Favorite;

@Mapper
public interface FavoritesMapper {

    @Insert("INSERT INTO favorites (title, link, image, lprice) VALUES (#{title}, #{link}, #{image}, #{lprice})")
    void insertFavorite(Favorite favorite);

    @Select("SELECT * FROM favorites")
    List<Favorite> getAllFavorites();
}
