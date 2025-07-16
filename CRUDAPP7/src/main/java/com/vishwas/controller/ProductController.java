package com.vishwas.controller;

import com.vishwas.dto.ProductDTO;
import com.vishwas.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Integer id){
        ProductDTO product = productService.getProduct(id);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll(){
        List<ProductDTO> lst =productService.getAllProduct();
        return ResponseEntity.status(HttpStatus.OK).body(lst);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
          productService.delete(id);
          return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO productDTO){
        ProductDTO update = productService.update(productDTO);
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> save(@RequestBody ProductDTO productDTO){
        ProductDTO save = productService.save(productDTO);
        return ResponseEntity.status(HttpStatus.OK).body(save);
    }
}
