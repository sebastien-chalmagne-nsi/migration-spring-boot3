package com.example.demo.mapper;

import com.example.demo.entity.ItemEntity;
import com.example.demo.dto.ItemDto;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public ItemDto toDto(ItemEntity itemEntity) {
        ItemDto itemDto = new ItemDto();
        itemDto.setId(itemEntity.getId());
        itemDto.setName(itemEntity.getName());
        itemDto.setQuantity(itemEntity.getQuantity());
        return itemDto;
    }

    public ItemEntity toEntity(ItemDto itemDto) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(itemDto.getId());
        itemEntity.setName(itemDto.getName());
        itemEntity.setQuantity(itemDto.getQuantity());
        return itemEntity;
    }

    public List<ItemDto> toDtoIterable(Iterable<ItemEntity> entities) {
        return IterableUtils.toList(entities).stream()
            .map(e -> toDto(e))
            .collect(Collectors.toList());
    }
}
