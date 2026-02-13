package com.fashion.style_advisor.data;

import com.fashion.style_advisor.enums.Climate;
import com.fashion.style_advisor.enums.ClothingCategory;
import com.fashion.style_advisor.enums.PersonType;
import com.fashion.style_advisor.model.ClothingItem;
import com.fashion.style_advisor.model.Outfit;
import com.fashion.style_advisor.repository.ClothingItemRepository;
import com.fashion.style_advisor.repository.OutfitRepository;
import com.fashion.style_advisor.repository.AvatarPartRepository;
import com.fashion.style_advisor.service.AvatarService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ClothingItemRepository clothingItemRepository;
    private final OutfitRepository outfitRepository;
    private final AvatarService avatarService;
    private final AvatarPartRepository avatarPartRepository;

    public DataInitializer(ClothingItemRepository clothingItemRepository, OutfitRepository outfitRepository,
                          AvatarService avatarService, AvatarPartRepository avatarPartRepository) {
        this.clothingItemRepository = clothingItemRepository;
        this.outfitRepository = outfitRepository;
        this.avatarService = avatarService;
        this.avatarPartRepository = avatarPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Always clear and reinitialize to ensure fresh data (delete outfits first due to FK constraint)
        outfitRepository.deleteAll();
        clothingItemRepository.deleteAll();

        List<ClothingItem> items = new ArrayList<>();

        // ===== SUMMER TOPWEAR - CHILD (10 items) =====
        items.add(createAndSaveItem("Light Cotton T-Shirt", ClothingCategory.TOP, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1503342217505-b0a15ec3261c?w=400"));
        items.add(createAndSaveItem("Colorful Summer Shirt", ClothingCategory.TOP, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1622445275463-afa2ab738c34?w=400"));
        items.add(createAndSaveItem("Beach Tank Top", ClothingCategory.TOP, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1581655353564-df123a1eb820?w=400"));
        items.add(createAndSaveItem("Striped Summer Top", ClothingCategory.TOP, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1519238263530-99bdd11df2ea?w=400"));
        items.add(createAndSaveItem("Graphic Print Tee", ClothingCategory.TOP, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1576566588028-4147f3842f27?w=400"));
        items.add(createAndSaveItem("Neon Summer Shirt", ClothingCategory.TOP, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1596755094514-f87e34085b2c?w=400"));
        items.add(createAndSaveItem("Tropical Print Tee", ClothingCategory.TOP, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1618354691373-d851c5c3a990?w=400"));
        items.add(createAndSaveItem("Sleeveless Cotton Top", ClothingCategory.TOP, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1622470953794-aa9c70b0fb9d?w=400"));
        items.add(createAndSaveItem("Tie-Dye T-Shirt", ClothingCategory.TOP, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1562157873-818bc0726f68?w=400"));
        items.add(createAndSaveItem("Summer Mesh Top", ClothingCategory.TOP, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1598032895397-b9372bc739c4?w=400"));

        // ===== SUMMER TOPWEAR - MALE (10 items) =====
        items.add(createAndSaveItem("Summer Casual Shirt", ClothingCategory.TOP, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1596755094514-f87e34085b2c?w=400"));
        items.add(createAndSaveItem("Cool Blue Tee", ClothingCategory.TOP, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?w=400"));
        items.add(createAndSaveItem("Linen Shirt", ClothingCategory.TOP, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1602810318383-e386cc2a3ccf?w=400"));
        items.add(createAndSaveItem("Polo Shirt", ClothingCategory.TOP, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1626497764746-6dc36546b388?w=400"));
        items.add(createAndSaveItem("Vintage Print Shirt", ClothingCategory.TOP, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1598033129183-c4f50c736f10?w=400"));
        items.add(createAndSaveItem("Hawaiian Print Shirt", ClothingCategory.TOP, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1620799140408-edc6dcb6d633?w=400"));
        items.add(createAndSaveItem("Plain White Tee", ClothingCategory.TOP, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1581655353564-df123a1eb820?w=400"));
        items.add(createAndSaveItem("Summer Henley", ClothingCategory.TOP, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1594938298603-c8148c4dae35?w=400"));
        items.add(createAndSaveItem("Casual Button Up", ClothingCategory.TOP, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1596755094514-f87e34085b2c?w=400"));
        items.add(createAndSaveItem("Sports T-Shirt", ClothingCategory.TOP, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1578587018452-892bacefd3f2?w=400"));

        // ===== SUMMER TOPWEAR - FEMALE (10 items) =====
        items.add(createAndSaveItem("Summer Blouse", ClothingCategory.TOP, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1564257577809-2e37e4f2c437?w=400"));
        items.add(createAndSaveItem("Floral Summer Top", ClothingCategory.TOP, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1618932260643-eee4a2f652a6?w=400"));
        items.add(createAndSaveItem("Crop Top", ClothingCategory.TOP, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1624206112918-f140f087f9f5?w=400"));
        items.add(createAndSaveItem("Beach Cover Up", ClothingCategory.TOP, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1578932750355-5eb30ece487a?w=400"));
        items.add(createAndSaveItem("Halter Top", ClothingCategory.TOP, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1594633313593-bab3825d0caf?w=400"));
        items.add(createAndSaveItem("Off Shoulder Top", ClothingCategory.TOP, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1583496661160-fb5886a0aaaa?w=400"));
        items.add(createAndSaveItem("Sleeveless Blouse", ClothingCategory.TOP, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1583743814966-8936f5b7be1a?w=400"));
        items.add(createAndSaveItem("Printed Summer Shirt", ClothingCategory.TOP, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1591369822096-ffd140ec948f?w=400"));
        items.add(createAndSaveItem("Bohemian Top", ClothingCategory.TOP, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1565084888279-aca607ecce0c?w=400"));
        items.add(createAndSaveItem("Linen Blend Top", ClothingCategory.TOP, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1554568218-0f1715e72254?w=400"));

        // ===== WINTER TOPWEAR - CHILD (10 items) =====
        items.add(createAndSaveItem("Warm Winter Jacket", ClothingCategory.TOP, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1551488831-00ddcb6c6bd3?w=400"));
        items.add(createAndSaveItem("Thermal Long Sleeve", ClothingCategory.TOP, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1515886657613-9f3515b0c78f?w=400"));
        items.add(createAndSaveItem("Cozy Sweater", ClothingCategory.TOP, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1576566588028-4147f3842f27?w=400"));
        items.add(createAndSaveItem("Wool Jumper", ClothingCategory.TOP, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1620799139834-6b8f844fbe61?w=400"));
        items.add(createAndSaveItem("Puffer Jacket", ClothingCategory.TOP, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1544923246-77307d684e72?w=400"));
        items.add(createAndSaveItem("Fleece Hoodie Kids", ClothingCategory.TOP, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1556821840-3a63f95609a7?w=400"));
        items.add(createAndSaveItem("Winter Vest", ClothingCategory.TOP, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1591047139829-d91aecb6caea?w=400"));
        items.add(createAndSaveItem("Knitted Sweater", ClothingCategory.TOP, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1576871337622-98d48d1cf531?w=400"));
        items.add(createAndSaveItem("Heavy Coat Kids", ClothingCategory.TOP, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1539533018447-63fcce2678e3?w=400"));
        items.add(createAndSaveItem("Lined Jacket", ClothingCategory.TOP, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1591047139829-d91aecb6caea?w=400"));

        // ===== WINTER TOPWEAR - MALE (10 items) =====
        items.add(createAndSaveItem("Heavy Winter Coat", ClothingCategory.TOP, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1551028719-00167b16eac5?w=400"));
        items.add(createAndSaveItem("Insulated Jacket", ClothingCategory.TOP, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1548126032-079fe5c5a85c?w=400"));
        items.add(createAndSaveItem("Wool Sweater", ClothingCategory.TOP, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1620799140188-3b2a02fd9a77?w=400"));
        items.add(createAndSaveItem("Thermal Shirt", ClothingCategory.TOP, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1618354691373-d851c5c3a990?w=400"));
        items.add(createAndSaveItem("Fleece Jacket", ClothingCategory.TOP, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1551028719-00167b16eac5?w=400"));
        items.add(createAndSaveItem("Down Jacket", ClothingCategory.TOP, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1544923408-75c5cef46f14?w=400"));
        items.add(createAndSaveItem("Wool Cardigan", ClothingCategory.TOP, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1620799139507-2a76f79a2f4d?w=400"));
        items.add(createAndSaveItem("Winter Blazer", ClothingCategory.TOP, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1507679799987-c73779587ccf?w=400"));
        items.add(createAndSaveItem("Turtleneck Sweater", ClothingCategory.TOP, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1564257577809-2e37e4f2c437?w=400"));
        items.add(createAndSaveItem("Parka Jacket", ClothingCategory.TOP, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1548126032-079fe5c5a85c?w=400"));

        // ===== WINTER TOPWEAR - FEMALE (10 items) =====
        items.add(createAndSaveItem("Winter Coat Women", ClothingCategory.TOP, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1539533018447-63fcce2678e3?w=400"));
        items.add(createAndSaveItem("Long Cardigan", ClothingCategory.TOP, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1591369822096-ffd140ec948f?w=400"));
        items.add(createAndSaveItem("Chunky Knit Sweater", ClothingCategory.TOP, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1576871337622-98d48d1cf531?w=400"));
        items.add(createAndSaveItem("Cashmere Sweater", ClothingCategory.TOP, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1620799140408-edc6dcb6d633?w=400"));
        items.add(createAndSaveItem("Turtleneck", ClothingCategory.TOP, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1583496661160-fb5886a0aaaa?w=400"));
        items.add(createAndSaveItem("Puffer Coat Women", ClothingCategory.TOP, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1591047139829-d91aecb6caea?w=400"));
        items.add(createAndSaveItem("Wool Blazer", ClothingCategory.TOP, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1594633312681-425c7b97ccd1?w=400"));
        items.add(createAndSaveItem("Thermal Layer", ClothingCategory.TOP, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1583743814966-8936f5b7be1a?w=400"));
        items.add(createAndSaveItem("Fleece Hoodie Women", ClothingCategory.TOP, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1556821840-3a63f95609a7?w=400"));
        items.add(createAndSaveItem("Denim Jacket Lined", ClothingCategory.TOP, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1565084888279-aca607ecce0c?w=400"));

        // ===== RAINY TOPWEAR - CHILD (10 items) =====
        items.add(createAndSaveItem("Waterproof Rain Jacket", ClothingCategory.TOP, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1544923246-77307d684e72?w=400"));
        items.add(createAndSaveItem("Light Rain Coat", ClothingCategory.TOP, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1551488831-00ddcb6c6bd3?w=400"));
        items.add(createAndSaveItem("Poncho", ClothingCategory.TOP, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1578932750355-5eb30ece487a?w=400"));
        items.add(createAndSaveItem("Yellow Rain Jacket", ClothingCategory.TOP, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1556821840-3a63f95609a7?w=400"));
        items.add(createAndSaveItem("Windproof Jacket", ClothingCategory.TOP, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1591047139829-d91aecb6caea?w=400"));
        items.add(createAndSaveItem("Water Resistant Hood", ClothingCategory.TOP, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1551028719-00167b16eac5?w=400"));
        items.add(createAndSaveItem("Rain Cape", ClothingCategory.TOP, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1539533018447-63fcce2678e3?w=400"));
        items.add(createAndSaveItem("Breathable Rain Jacket", ClothingCategory.TOP, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1548126032-079fe5c5a85c?w=400"));
        items.add(createAndSaveItem("Weather Proof Top", ClothingCategory.TOP, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1544923408-75c5cef46f14?w=400"));
        items.add(createAndSaveItem("Storm Jacket", ClothingCategory.TOP, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1591369822096-ffd140ec948f?w=400"));

        // ===== RAINY TOPWEAR - MALE (10 items) =====
        items.add(createAndSaveItem("Raincoat Men", ClothingCategory.TOP, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1551028719-00167b16eac5?w=400"));
        items.add(createAndSaveItem("Water Resistant Parka", ClothingCategory.TOP, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1548126032-079fe5c5a85c?w=400"));
        items.add(createAndSaveItem("Gore-Tex Jacket", ClothingCategory.TOP, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1544923408-75c5cef46f14?w=400"));
        items.add(createAndSaveItem("Waterproof Blazer", ClothingCategory.TOP, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1507679799987-c73779587ccf?w=400"));
        items.add(createAndSaveItem("Breathable Rain Shell", ClothingCategory.TOP, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1591047139829-d91aecb6caea?w=400"));
        items.add(createAndSaveItem("Weather Proof Coat", ClothingCategory.TOP, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1551028719-00167b16eac5?w=400"));
        items.add(createAndSaveItem("Hydrophobic Jacket", ClothingCategory.TOP, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1548126032-079fe5c5a85c?w=400"));
        items.add(createAndSaveItem("Rain Resistant Shirt", ClothingCategory.TOP, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1602810318383-e386cc2a3ccf?w=400"));
        items.add(createAndSaveItem("All Weather Jacket", ClothingCategory.TOP, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1544923408-75c5cef46f14?w=400"));
        items.add(createAndSaveItem("Storm Proof Coat", ClothingCategory.TOP, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1551028719-00167b16eac5?w=400"));

        // ===== RAINY TOPWEAR - FEMALE (10 items) =====
        items.add(createAndSaveItem("Raincoat Women", ClothingCategory.TOP, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1539533018447-63fcce2678e3?w=400"));
        items.add(createAndSaveItem("Stylish Rain Jacket", ClothingCategory.TOP, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1591047139829-d91aecb6caea?w=400"));
        items.add(createAndSaveItem("Trench Coat", ClothingCategory.TOP, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1539533018447-63fcce2678e3?w=400"));
        items.add(createAndSaveItem("Lightweight Rain Parka", ClothingCategory.TOP, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1591047139829-d91aecb6caea?w=400"));
        items.add(createAndSaveItem("Hooded Rain Cape", ClothingCategory.TOP, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1578932750355-5eb30ece487a?w=400"));
        items.add(createAndSaveItem("Water Resistant Dress", ClothingCategory.TOP, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1565084888279-aca607ecce0c?w=400"));
        items.add(createAndSaveItem("Rain Cardigan", ClothingCategory.TOP, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1591369822096-ffd140ec948f?w=400"));
        items.add(createAndSaveItem("Weather Resistant Jacket", ClothingCategory.TOP, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1539533018447-63fcce2678e3?w=400"));
        items.add(createAndSaveItem("Elegant Rain Coat", ClothingCategory.TOP, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1591047139829-d91aecb6caea?w=400"));
        items.add(createAndSaveItem("Waterproof Hoodie", ClothingCategory.TOP, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1556821840-3a63f95609a7?w=400"));

        // ===== SUMMER BOTTOMWEAR - CHILD (10 items) =====
        items.add(createAndSaveItem("Summer Shorts", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1591195853828-11db59a44f6b?w=400"));
        items.add(createAndSaveItem("Denim Shorts", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1582552938357-32b906d05b61?w=400"));
        items.add(createAndSaveItem("Cargo Shorts", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1598522325074-042db73aa4e6?w=400"));
        items.add(createAndSaveItem("Beach Shorts", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1591195853828-11db59a44f6b?w=400"));
        items.add(createAndSaveItem("Sports Shorts", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1598522325074-042db73aa4e6?w=400"));
        items.add(createAndSaveItem("Khaki Shorts", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1591195853828-11db59a44f6b?w=400"));
        items.add(createAndSaveItem("Linen Shorts", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1582552938357-32b906d05b61?w=400"));
        items.add(createAndSaveItem("Patterned Shorts", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1598522325074-042db73aa4e6?w=400"));
        items.add(createAndSaveItem("Striped Shorts", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1591195853828-11db59a44f6b?w=400"));
        items.add(createAndSaveItem("Casual Shorts", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1582552938357-32b906d05b61?w=400"));

        // ===== SUMMER BOTTOMWEAR - MALE (10 items) =====
        items.add(createAndSaveItem("Summer Pants", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Casual Shorts", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1591195853828-11db59a44f6b?w=400"));
        items.add(createAndSaveItem("Linen Trousers", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Chino Shorts", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1598522325074-042db73aa4e6?w=400"));
        items.add(createAndSaveItem("Denim Jeans", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1582552938357-32b906d05b61?w=400"));
        items.add(createAndSaveItem("Beach Trunks", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1591195853828-11db59a44f6b?w=400"));
        items.add(createAndSaveItem("Jogger Shorts", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1598522325074-042db73aa4e6?w=400"));
        items.add(createAndSaveItem("Cargo Pants", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Khaki Trousers", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Linen Shorts", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1591195853828-11db59a44f6b?w=400"));

        // ===== SUMMER BOTTOMWEAR - FEMALE (10 items) =====
        items.add(createAndSaveItem("Summer Skirt", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1583496661160-fb5886a0aaaa?w=400"));
        items.add(createAndSaveItem("Denim Shorts", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1591195853828-11db59a44f6b?w=400"));
        items.add(createAndSaveItem("Floral Skirt", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1583496661160-fb5886a0aaaa?w=400"));
        items.add(createAndSaveItem("Beach Shorts", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1591195853828-11db59a44f6b?w=400"));
        items.add(createAndSaveItem("Linen Pants", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1594633312681-425c7b97ccd1?w=400"));
        items.add(createAndSaveItem("Harem Pants", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1594633312681-425c7b97ccd1?w=400"));
        items.add(createAndSaveItem("Crop Pants", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1594633312681-425c7b97ccd1?w=400"));
        items.add(createAndSaveItem("Summer Jeans", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1582552938357-32b906d05b61?w=400"));
        items.add(createAndSaveItem("Bohemian Pants", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1594633312681-425c7b97ccd1?w=400"));
        items.add(createAndSaveItem("Capri Pants", ClothingCategory.BOTTOM, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1594633312681-425c7b97ccd1?w=400"));

        // ===== WINTER BOTTOMWEAR - CHILD (10 items) =====
        items.add(createAndSaveItem("Warm Winter Pants", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Fleece Lined Pants", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Thermal Leggings", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1594633312681-425c7b97ccd1?w=400"));
        items.add(createAndSaveItem("Wool Trousers", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Snow Pants", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Insulated Pants", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Winter Jeans", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1582552938357-32b906d05b61?w=400"));
        items.add(createAndSaveItem("Cozy Leggings", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1594633312681-425c7b97ccd1?w=400"));
        items.add(createAndSaveItem("Padded Pants", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Winter Joggers", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));

        // ===== WINTER BOTTOMWEAR - MALE (10 items) =====
        items.add(createAndSaveItem("Heavy Winter Pants", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Wool Trousers", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Snow Pants", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Thermal Pants", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Fleece Lined Jeans", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1582552938357-32b906d05b61?w=400"));
        items.add(createAndSaveItem("Insulated Trousers", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Winter Chinos", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Lined Slacks", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Padded Pants", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Winter Joggers", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));

        // ===== WINTER BOTTOMWEAR - FEMALE (10 items) =====
        items.add(createAndSaveItem("Winter Leggings", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1594633312681-425c7b97ccd1?w=400"));
        items.add(createAndSaveItem("Wool Pants", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1594633312681-425c7b97ccd1?w=400"));
        items.add(createAndSaveItem("Fleece Pants", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1594633312681-425c7b97ccd1?w=400"));
        items.add(createAndSaveItem("Winter Skirt", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1583496661160-fb5886a0aaaa?w=400"));
        items.add(createAndSaveItem("Thermal Leggings", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1594633312681-425c7b97ccd1?w=400"));
        items.add(createAndSaveItem("Snow Pants", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1594633312681-425c7b97ccd1?w=400"));
        items.add(createAndSaveItem("Lined Jeans", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1582552938357-32b906d05b61?w=400"));
        items.add(createAndSaveItem("Winter Trousers", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1594633312681-425c7b97ccd1?w=400"));
        items.add(createAndSaveItem("Padded Leggings", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1594633312681-425c7b97ccd1?w=400"));
        items.add(createAndSaveItem("Cozy Joggers", ClothingCategory.BOTTOM, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1594633312681-425c7b97ccd1?w=400"));

        // ===== RAINY BOTTOMWEAR - CHILD (10 items) =====
        items.add(createAndSaveItem("Water Resistant Pants", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Rain Proof Shorts", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1591195853828-11db59a44f6b?w=400"));
        items.add(createAndSaveItem("Moisture Wicking Pants", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Quick Dry Shorts", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1598522325074-042db73aa4e6?w=400"));
        items.add(createAndSaveItem("Waterproof Pants", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Weather Resistant Shorts", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1591195853828-11db59a44f6b?w=400"));
        items.add(createAndSaveItem("Hydrophobic Pants", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Splash Proof Shorts", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1598522325074-042db73aa4e6?w=400"));
        items.add(createAndSaveItem("All Weather Pants", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Storm Resistant Shorts", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1591195853828-11db59a44f6b?w=400"));

        // ===== RAINY BOTTOMWEAR - MALE (10 items) =====
        items.add(createAndSaveItem("Waterproof Pants Men", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Water Resistant Shorts", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1591195853828-11db59a44f6b?w=400"));
        items.add(createAndSaveItem("Gore-Tex Pants", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Moisture Wicking Shorts", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1598522325074-042db73aa4e6?w=400"));
        items.add(createAndSaveItem("Quick Dry Pants", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Weather Proof Trousers", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Rain Resistant Jeans", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1582552938357-32b906d05b61?w=400"));
        items.add(createAndSaveItem("All Weather Shorts", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1591195853828-11db59a44f6b?w=400"));
        items.add(createAndSaveItem("Storm Proof Pants", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1624378439575-d8705ad7ae80?w=400"));
        items.add(createAndSaveItem("Hydrophobic Shorts", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1598522325074-042db73aa4e6?w=400"));

        // ===== RAINY BOTTOMWEAR - FEMALE (10 items) =====
        items.add(createAndSaveItem("Waterproof Skirt", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1583496661160-fb5886a0aaaa?w=400"));
        items.add(createAndSaveItem("Water Resistant Pants", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1594633312681-425c7b97ccd1?w=400"));
        items.add(createAndSaveItem("Quick Dry Leggings", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1594633312681-425c7b97ccd1?w=400"));
        items.add(createAndSaveItem("Moisture Wicking Shorts", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1591195853828-11db59a44f6b?w=400"));
        items.add(createAndSaveItem("Gore-Tex Pants", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1594633312681-425c7b97ccd1?w=400"));
        items.add(createAndSaveItem("Weather Resistant Skirt", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1583496661160-fb5886a0aaaa?w=400"));
        items.add(createAndSaveItem("Rain Proof Leggings", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1594633312681-425c7b97ccd1?w=400"));
        items.add(createAndSaveItem("All Weather Pants", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1594633312681-425c7b97ccd1?w=400"));
        items.add(createAndSaveItem("Storm Resistant Shorts", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1591195853828-11db59a44f6b?w=400"));
        items.add(createAndSaveItem("Waterproof Trousers", ClothingCategory.BOTTOM, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1594633312681-425c7b97ccd1?w=400"));

        // ===== SUMMER ACCESSORIES - CHILD (10 items) =====
        items.add(createAndSaveItem("Summer Sunglasses", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1511499767150-a48a237f0083?w=400"));
        items.add(createAndSaveItem("Beach Hat", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1588850561407-ed78c282e89b?w=400"));
        items.add(createAndSaveItem("Canvas Backpack", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1553062407-98eeb64c6a62?w=400"));
        items.add(createAndSaveItem("Summer Scarf", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1601924994987-69e26d50dc26?w=400"));
        items.add(createAndSaveItem("Casual Belt", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1624222247344-550fb60583bb?w=400"));
        items.add(createAndSaveItem("Sports Watch", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=400"));
        items.add(createAndSaveItem("Flip Flops", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1603487742131-4160ec999306?w=400"));
        items.add(createAndSaveItem("Summer Bracelet", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1611591437281-460bfbe1220a?w=400"));
        items.add(createAndSaveItem("Baseball Cap", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1588850561407-ed78c282e89b?w=400"));
        items.add(createAndSaveItem("Sun Visor", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.CHILD, "https://images.unsplash.com/photo-1588850561407-ed78c282e89b?w=400"));

        // ===== SUMMER ACCESSORIES - MALE (10 items) =====
        items.add(createAndSaveItem("Aviator Sunglasses", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1511499767150-a48a237f0083?w=400"));
        items.add(createAndSaveItem("Summer Fedora", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1588850561407-ed78c282e89b?w=400"));
        items.add(createAndSaveItem("Messenger Bag", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1553062407-98eeb64c6a62?w=400"));
        items.add(createAndSaveItem("Leather Belt", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1624222247344-550fb60583bb?w=400"));
        items.add(createAndSaveItem("Wrist Watch", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=400"));
        items.add(createAndSaveItem("Ankle Socks", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1586350977771-b3b0abd50c82?w=400"));
        items.add(createAndSaveItem("Chain Necklace", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1599643478518-a784e5dc4c8f?w=400"));
        items.add(createAndSaveItem("Cotton Scarf", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1601924994987-69e26d50dc26?w=400"));
        items.add(createAndSaveItem("Bucket Hat", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1588850561407-ed78c282e89b?w=400"));
        items.add(createAndSaveItem("Canvas Shoes", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.MALE, "https://images.unsplash.com/photo-1603487742131-4160ec999306?w=400"));

        // ===== SUMMER ACCESSORIES - FEMALE (10 items) =====
        items.add(createAndSaveItem("Cat Eye Sunglasses", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1511499767150-a48a237f0083?w=400"));
        items.add(createAndSaveItem("Straw Hat", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1588850561407-ed78c282e89b?w=400"));
        items.add(createAndSaveItem("Shoulder Bag", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1548036328-c9fa89d128fa?w=400"));
        items.add(createAndSaveItem("Silk Scarf", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1601924994987-69e26d50dc26?w=400"));
        items.add(createAndSaveItem("Pearl Necklace", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1599643478518-a784e5dc4c8f?w=400"));
        items.add(createAndSaveItem("Gold Bracelet", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1611591437281-460bfbe1220a?w=400"));
        items.add(createAndSaveItem("Sandals", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1603487742131-4160ec999306?w=400"));
        items.add(createAndSaveItem("Summer Earrings", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1535632066927-ab7c9ab60908?w=400"));
        items.add(createAndSaveItem("Beach Bag", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1548036328-c9fa89d128fa?w=400"));
        items.add(createAndSaveItem("Wide Brimmed Hat", ClothingCategory.ACCESSORY, Climate.SUMMER, PersonType.FEMALE, "https://images.unsplash.com/photo-1588850561407-ed78c282e89b?w=400"));

        // ===== WINTER ACCESSORIES - CHILD (10 items) =====
        items.add(createAndSaveItem("Winter Beanie", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1576871337632-b9aef4c17ab9?w=400"));
        items.add(createAndSaveItem("Wool Gloves", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1520903920243-00d872a2d1c9?w=400"));
        items.add(createAndSaveItem("Winter Scarf", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1601924994987-69e26d50dc26?w=400"));
        items.add(createAndSaveItem("Thermal Socks", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1586350977771-b3b0abd50c82?w=400"));
        items.add(createAndSaveItem("Snow Boots", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1608256246200-53e635b5b65f?w=400"));
        items.add(createAndSaveItem("Winter Mittens", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1520903920243-00d872a2d1c9?w=400"));
        items.add(createAndSaveItem("Neck Warmer", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1601924994987-69e26d50dc26?w=400"));
        items.add(createAndSaveItem("Wool Hat", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1576871337632-b9aef4c17ab9?w=400"));
        items.add(createAndSaveItem("Insulated Gloves", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1520903920243-00d872a2d1c9?w=400"));
        items.add(createAndSaveItem("Winter Boots", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.CHILD, "https://images.unsplash.com/photo-1608256246200-53e635b5b65f?w=400"));

        // ===== WINTER ACCESSORIES - MALE (10 items) =====
        items.add(createAndSaveItem("Wool Beanie", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1576871337632-b9aef4c17ab9?w=400"));
        items.add(createAndSaveItem("Leather Gloves", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1520903920243-00d872a2d1c9?w=400"));
        items.add(createAndSaveItem("Cashmere Scarf", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1601924994987-69e26d50dc26?w=400"));
        items.add(createAndSaveItem("Winter Socks", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1586350977771-b3b0abd50c82?w=400"));
        items.add(createAndSaveItem("Hiking Boots", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1608256246200-53e635b5b65f?w=400"));
        items.add(createAndSaveItem("Wool Gloves Premium", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1520903920243-00d872a2d1c9?w=400"));
        items.add(createAndSaveItem("Infinity Scarf", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1601924994987-69e26d50dc26?w=400"));
        items.add(createAndSaveItem("Winter Cap", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1576871337632-b9aef4c17ab9?w=400"));
        items.add(createAndSaveItem("Tactical Gloves", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1520903920243-00d872a2d1c9?w=400"));
        items.add(createAndSaveItem("Desert Boots", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.MALE, "https://images.unsplash.com/photo-1608256246200-53e635b5b65f?w=400"));

        // ===== WINTER ACCESSORIES - FEMALE (10 items) =====
        items.add(createAndSaveItem("Knit Beanie", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1576871337632-b9aef4c17ab9?w=400"));
        items.add(createAndSaveItem("Faux Fur Gloves", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1520903920243-00d872a2d1c9?w=400"));
        items.add(createAndSaveItem("Pashmina Shawl", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1601924994987-69e26d50dc26?w=400"));
        items.add(createAndSaveItem("Fuzzy Socks", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1586350977771-b3b0abd50c82?w=400"));
        items.add(createAndSaveItem("Winter Flats", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1603487742131-4160ec999306?w=400"));
        items.add(createAndSaveItem("Wool Mittens", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1520903920243-00d872a2d1c9?w=400"));
        items.add(createAndSaveItem("Turtleneck Scarf", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1601924994987-69e26d50dc26?w=400"));
        items.add(createAndSaveItem("Winter Headband", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1576871337632-b9aef4c17ab9?w=400"));
        items.add(createAndSaveItem("Elegant Gloves", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1520903920243-00d872a2d1c9?w=400"));
        items.add(createAndSaveItem("Snow Boots Women", ClothingCategory.ACCESSORY, Climate.WINTER, PersonType.FEMALE, "https://images.unsplash.com/photo-1608256246200-53e635b5b65f?w=400"));

        // ===== RAINY ACCESSORIES - CHILD (10 items) =====
        items.add(createAndSaveItem("Rain Hat", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1588850561407-ed78c282e89b?w=400"));
        items.add(createAndSaveItem("Waterproof Gloves", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1520903920243-00d872a2d1c9?w=400"));
        items.add(createAndSaveItem("Rain Shoes", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1608256246200-53e635b5b65f?w=400"));
        items.add(createAndSaveItem("Reflective Scarf", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1601924994987-69e26d50dc26?w=400"));
        items.add(createAndSaveItem("Waterproof Bag", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1553062407-98eeb64c6a62?w=400"));
        items.add(createAndSaveItem("Rain Socks", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1586350977771-b3b0abd50c82?w=400"));
        items.add(createAndSaveItem("Hood Cover", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1588850561407-ed78c282e89b?w=400"));
        items.add(createAndSaveItem("Weather Resistant Hat", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1588850561407-ed78c282e89b?w=400"));
        items.add(createAndSaveItem("Splash Resistant Shoes", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1603487742131-4160ec999306?w=400"));
        items.add(createAndSaveItem("Rain Belt", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.CHILD, "https://images.unsplash.com/photo-1624222247344-550fb60583bb?w=400"));

        // ===== RAINY ACCESSORIES - MALE (10 items) =====
        items.add(createAndSaveItem("Rain Cap", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1588850561407-ed78c282e89b?w=400"));
        items.add(createAndSaveItem("Gore-Tex Gloves", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1520903920243-00d872a2d1c9?w=400"));
        items.add(createAndSaveItem("Rain Boots", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1608256246200-53e635b5b65f?w=400"));
        items.add(createAndSaveItem("Water Resistant Scarf", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1601924994987-69e26d50dc26?w=400"));
        items.add(createAndSaveItem("Waterproof Backpack", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1553062407-98eeb64c6a62?w=400"));
        items.add(createAndSaveItem("Water Resistant Socks", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1586350977771-b3b0abd50c82?w=400"));
        items.add(createAndSaveItem("Reflective Vest", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1591047139829-d91aecb6caea?w=400"));
        items.add(createAndSaveItem("Weather Hat", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1588850561407-ed78c282e89b?w=400"));
        items.add(createAndSaveItem("Hydrophobic Shoes", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1603487742131-4160ec999306?w=400"));
        items.add(createAndSaveItem("Rain Strap", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.MALE, "https://images.unsplash.com/photo-1624222247344-550fb60583bb?w=400"));

        // ===== RAINY ACCESSORIES - FEMALE (10 items) =====
        items.add(createAndSaveItem("Stylish Rain Hat", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1588850561407-ed78c282e89b?w=400"));
        items.add(createAndSaveItem("Elegant Rain Gloves", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1520903920243-00d872a2d1c9?w=400"));
        items.add(createAndSaveItem("Waterproof Heels", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1603487742131-4160ec999306?w=400"));
        items.add(createAndSaveItem("Silk Rain Scarf", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1601924994987-69e26d50dc26?w=400"));
        items.add(createAndSaveItem("Designer Rain Bag", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1548036328-c9fa89d128fa?w=400"));
        items.add(createAndSaveItem("Premium Rain Socks", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1586350977771-b3b0abd50c82?w=400"));
        items.add(createAndSaveItem("Rain Necklace", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1599643478518-a784e5dc4c8f?w=400"));
        items.add(createAndSaveItem("Waterproof Headband", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1576871337632-b9aef4c17ab9?w=400"));
        items.add(createAndSaveItem("Water Resistant Flats", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1603487742131-4160ec999306?w=400"));
        items.add(createAndSaveItem("Fashion Rain Clip", ClothingCategory.ACCESSORY, Climate.RAINY, PersonType.FEMALE, "https://images.unsplash.com/photo-1535632066927-ab7c9ab60908?w=400"));

        System.out.println("Sample data initialized successfully! Total items: " + items.size());
        
        // Initialize avatar parts for Snapchat-style avatar builder
        avatarService.initializeAvatarParts();
        System.out.println("Avatar parts initialized successfully!");
    }

    private ClothingItem createAndSaveItem(String name, ClothingCategory category, Climate climate, PersonType personType, String imagePath) {
        ClothingItem item = new ClothingItem();
        item.setName(name);
        item.setCategory(category);
        item.setClimate(climate);
        item.setPersonType(personType);
        item.setImagePath(imagePath);
        return clothingItemRepository.save(item);
    }
}