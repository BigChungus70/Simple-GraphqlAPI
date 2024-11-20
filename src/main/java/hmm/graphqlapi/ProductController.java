package hmm.graphqlapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @QueryMapping
    public List<Product> products() {
        return productService.AllProducts();
    }

    @QueryMapping
    public Product productByID(@Argument Integer id) {
        return productService.GetProductById(id);
    }

    @MutationMapping
    public Product addProduct(@Argument String name, @Argument String description, @Argument Double price) {
        Product product = new Product(name, description, price);
        return productService.AddProduct(product);
    }

    @MutationMapping
    public Product updateProduct(@Argument int id, @Argument String name, @Argument String description, @Argument Double price) {

        return productService.UpdateProduct(id, name, description, price);

    }

    @MutationMapping
    public String deleteProduct(@Argument int id) {
        return productService.DeleteProduct(id);
    }
}
