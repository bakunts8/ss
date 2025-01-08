package org.example.components;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    public static String BASE_PATH = "//div[@class='inventory_list']/div[@class='inventory_item']";
    private String image = BASE_PATH + "/div[@class='inventory_item_img']/a/img";
    private String descTitle = BASE_PATH + "/div[@class='inventory_item_description']/div[@class='inventory_item_label']/a/div[@class='inventory_item_name ']";
    private String description = BASE_PATH + "/div[@class='inventory_item_description']//div[@class='inventory_item_desc']";
    private String price = BASE_PATH + "//div[@class='inventory_item_description']//div[@class='pricebar']/div[@class='inventory_item_price']";
    private String addToCartButton = BASE_PATH + "//div[@class='inventory_item_description']//div[@class='pricebar']/button";
}
