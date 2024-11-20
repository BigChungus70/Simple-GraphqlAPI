package hmm.graphqlapi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> AllProducts() {
        return productRepository.findAll();
    }

    public Product GetProductById(int id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product doesn't exist :("));
    }

    public Product AddProduct(Product product) {
        return productRepository.save(product);
    }

    public Product UpdateProduct(int id, String name, String description, Double price) {
        Product SavedProduct = productRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Product doesn't exist :("));

        if (name != null) {
            SavedProduct.setName(name);
        }
        if (description != null) {
            SavedProduct.setDescription(description);
        }
        if (price != 0) {
            SavedProduct.setPrice(Math.abs(price));
        }
        return productRepository.save(SavedProduct);
    }

    public String DeleteProduct(int id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            productRepository.deleteById(id);
            return "Product deleted successfully";
        } else {
            throw new RuntimeException("Product doesn't exist :(");
        }
    }


}
