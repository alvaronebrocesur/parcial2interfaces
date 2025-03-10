package alvaro.parcial2;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "item") // Nombre de la colección en MongoDB
public class Item {
    @Id
    private String _id;
    private int id;
    private String title;
    private double price;
    private String category;
    private String description;
    private double rate;
    private int count;
    private String image;


    public Item() {}

    public Item(String _id, int id, String title, double price, String category,
                String description, double rate, int count, String image) {
        this._id = _id;
        this.id = id;
        this.title = title;
        this.price = price;
        this.category = category;
        this.description = description;
        this.rate = rate;
        this.count = count;
        this.image = image;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
