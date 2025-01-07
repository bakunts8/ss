package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import org.example.components.Product;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePage {

    private List<Product> products;
    public static final int PRODUCTS_SIZE = 6;
    private final String titlePath = "//div[@class='header_secondary_container']/span[@class='title']";

    @Override
    public String getEndpoint() {
        return "/inventory.html";
    }

    public Product getProduct() {
        return new Product();
    }

    public List<Product> getProducts() {
        products = $$x(Product.BASE_PATH)
                .stream()
                .map(element -> new Product())
                .collect(Collectors.toList());
        return products;
    }

    public String getTitle() {
        return $x(titlePath).text();
    }
}
