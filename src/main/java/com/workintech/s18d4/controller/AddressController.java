package com.workintech.s18d4.controller;

import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/")
    public List<Address> findAll() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public Address find(@PathVariable long id) {
        return addressService.find(id);
    }

    @PostMapping("/")
    public Address save(@RequestBody Address address) {
        return addressService.save(address);
    }

    @PutMapping("/{id}")
    public Address save(@RequestBody Address address, @PathVariable long id) {
        Address foundAddress = addressService.find(id);
        if (foundAddress != null) {
            address.setId(id);
            return addressService.save(address);
        } else {
            throw new RuntimeException("no customer found");
        }
    }

    @DeleteMapping("/{id}")
    public Address remove(@PathVariable long id) {
        return addressService.delete(id);
    }


}
