package kr.co.cofile.sbbshop.domain;

import java.io.Serializable;

public class Favorite implements Serializable {

    private Long id;
    private String title;
    private String link;
    private String image;
    private Integer lprice;
    
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }
    
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
    
    public Integer getLprice() { return lprice; }
    public void setLprice(Integer lprice) { this.lprice = lprice; }
}
