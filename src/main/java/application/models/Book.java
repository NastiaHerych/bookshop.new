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
    private String description;
    private String author;
    private int price;
    private String imageUrl;

    public Book(String name, String description, String author, int price, String imageUrl) {
        this.name = name;
        this.description = description;
        this.author = author;
        this.price = price;
        this.imageUrl = imageUrl;
    }


}
