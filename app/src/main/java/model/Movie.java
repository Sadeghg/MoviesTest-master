package model;


public class Movie {

    private String image;
    private String name;
    private String cover;


    public Movie(String name, String image, String cover) {
        this.name = name;
        this.image = image;
        this.cover = cover;
    }


    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getCover() {
        return cover;
    }
}

