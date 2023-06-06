package com.example.demo.controller;

import com.example.demo.dto.ItemDto;
import com.example.demo.service.ItemService;
import java.util.List;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {

    private static final Logger LOG = LoggerFactory.getLogger(ItemController.class);
    private final ItemService itemService;
//    private final ObservationRegistry observationRegistry;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemDto getItem(@PathVariable Long id) {
        LOG.info("Get ite {}", id);
        return itemService.getItem(id);
    }

    @GetMapping(value="/all")
    public List<ItemDto> getAllItems() {
        LOG.info("Get all items");
        return itemService.getItems();
        /*
                return Observation.createNotStarted("get-all-items", observationRegistry)
            .observe(() -> itemService.getItems());

         */
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto createItem(@Valid @RequestBody ItemDto itemDto) {
        LOG.info("Create item {}", itemDto);
        return itemService.saveItem(itemDto);

    }
}
