package de.aittr.shop.service.mapping;

import de.aittr.shop.domain.dto.ProductDto;
import de.aittr.shop.domain.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
public interface ProductMappingService {

    //Маппинг в ручном режиме
//    public ProductDto mapEntityToDto(Product entity) {
//        ProductDto dto = new ProductDto();
//        dto.setId(entity.getId());
//        dto.setTitle(entity.getTitle());
//        dto.setPrice(entity.getPrice());
//        return dto;
//    }

    ProductDto mapEntityToDto(Product entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", constant = "true")
    //@Mapping(target = "id", expression = "java(new Long(0))")
    Product mapDtoToEntity(ProductDto dto);
//    public Product mapDtoToEntity(ProductDto Dto) {
//
//    }
}
