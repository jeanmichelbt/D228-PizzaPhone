package upjv.jeanmichel.pizzaphone.models;

public class HomeVerModel {
    int image;
    String name;
    Double price;
    String ingredients;

    public HomeVerModel(int image, String name, Double price, String ingredients) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
