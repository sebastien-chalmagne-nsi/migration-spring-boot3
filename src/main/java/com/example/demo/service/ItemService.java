package com.example.demo.service;


import com.example.demo.dto.ItemDto;
import com.example.demo.entity.ItemEntity;
import com.example.demo.mapper.ItemMapper;
import com.example.demo.repository.ItemRepository;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository,
                       ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public ItemDto getItem(long id) {
        ItemEntity entity = itemRepository.findById(id).orElse(null);
        return itemMapper.toDto(entity);
    }

    public List<ItemDto> getItems() {
        Iterable<ItemEntity> itemsEntities = itemRepository.findAll(Sort.by("quantity"));
        return itemMapper.toDtoIterable(itemsEntities);

    }
    public ItemDto saveItem(ItemDto itemDto) {
        ItemEntity entity = itemRepository.save(itemMapper.toEntity(itemDto));
        return itemMapper.toDto(entity);
    }
}
