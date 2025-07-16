package com.vishwas.service;

import com.vishwas.dto.ProductDTO;
import com.vishwas.entity.Product;
import com.vishwas.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepo productRepo;

    public Product convertToProduct(ProductDTO productDTO){
        return Product.builder().id(productDTO.getId())
                .name(productDTO.getName())
                .category(productDTO.getCategory())
                .build();
    }
    public ProductDTO convertToDTO(Product product){
       return ProductDTO.builder().id(product.getId()).name(product.getName()).category(product.getCategory()).build();
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        Product save = productRepo.save(convertToProduct(productDTO));
        return convertToDTO(save);
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        Product product = productRepo.findById(productDTO.getId()).orElseThrow(() -> new RuntimeException("Product Not Found"));

        product.setName(productDTO.getName());
        product.setCategory(productDTO.getCategory());
        productRepo.save(product);
        return convertToDTO(product);
    }

    @Override
    public void delete(Integer id) {

        if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
        }

    }

    @Override
    public ProductDTO getProduct(Integer id) {

        Product product=productRepo.findById(id).orElseThrow(()->new RuntimeException("Product Not Found"));
        return convertToDTO(product);

    }

    @Override
    public List<ProductDTO> getAllProduct() {
        List<Product> products =productRepo.findAll();
        List<ProductDTO> list = products.stream().map(this::convertToDTO).toList();
        return list;
    }
}
