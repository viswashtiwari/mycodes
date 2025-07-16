package com.vishwas.service;

import com.vishwas.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO save(ProductDTO productDTO);
    ProductDTO update(ProductDTO productDTO);
    void delete(Integer id);
    ProductDTO getProduct(Integer id);
    List<ProductDTO> getAllProduct();
}
