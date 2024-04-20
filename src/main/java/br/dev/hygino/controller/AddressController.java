package br.dev.hygino.controller;

import br.dev.hygino.dto.AddressDTO;
import br.dev.hygino.dto.AddressInsertDTO;
import br.dev.hygino.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<Page<AddressDTO>> findAll(Pageable pageable) {
        Page<AddressDTO> page = addressService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @PostMapping
    ResponseEntity<AddressDTO> insert(@RequestBody AddressInsertDTO dto) {
        AddressDTO addressDTO = addressService.insert(dto);
        return ResponseEntity.status(201).body(addressDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> findById(@PathVariable Long id) {
        AddressDTO addressDTO = addressService.findById(id);
        return ResponseEntity.status(200).body(addressDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDTO> update(@PathVariable Long id, @RequestBody AddressInsertDTO dto) {
        AddressDTO addressDTO = addressService.update(id, dto);
        return ResponseEntity.status(200).body(addressDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        addressService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
