package application.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String author;
    private String article;
    private String available;

    private String rating;
    private int price;
    private int oldPrice;
    private String imageUrl;

    public Book(String name, String author, String article, String available, String rating, int price, int oldPrice, String imageUrl) {
        this.name = name;
        this.author = author;
        this.article = article;
        this.available = available;
        this.rating = rating;
        this.price = price;
        this.oldPrice = oldPrice;
        this.imageUrl = imageUrl;
    }
}
