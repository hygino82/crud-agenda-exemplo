package br.dev.hygino.services;

import br.dev.hygino.dto.AddressDTO;
import br.dev.hygino.dto.AddressInsertDTO;
import br.dev.hygino.entities.Address;
import br.dev.hygino.entities.Person;
import br.dev.hygino.repositories.AddressRepository;
import br.dev.hygino.repositories.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    PersonRepository personRepository;

    @Transactional(readOnly = true)
    public Page<AddressDTO> findAll(Pageable pageable) {
        Page<Address> page = addressRepository.findAll(pageable);
        return page.map(AddressDTO::new);
    }

    @Transactional
    public AddressDTO insert(AddressInsertDTO dto) {
        Address entity = new Address(dto);
        try {
            Person person = personRepository.findById(dto.personId()).orElseThrow(() -> new IllegalArgumentException("Não existe pessoa com o id: " + dto.personId()));
            entity.setPerson(person);
            entity = addressRepository.save(entity);
            return new AddressDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new IllegalArgumentException("Não existe pessoa com o id: " + dto.personId());
        }
    }

    @Transactional(readOnly = true)
    public AddressDTO findById(Long id) {
        Address entity = addressRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Não existe endereço com o id: " + id));
        return new AddressDTO(entity);
    }

    @Transactional
    public AddressDTO update(Long id, AddressInsertDTO dto) {
        try {
            Address address = addressRepository.getReferenceById(id);
            dtoToEntity(address, dto);

            Person person = personRepository.findById(dto.personId()).orElseThrow(() -> new IllegalArgumentException("Não existe pessoa com o id: " + dto.personId()));
            address.setPerson(person);

            return new AddressDTO(address);
        } catch (EntityNotFoundException e) {
            throw new IllegalArgumentException("Não existe endereço com o id: " + dto.personId());
        }
    }

    private void dtoToEntity(Address address, AddressInsertDTO dto) {
        address.setZipCode(dto.zipCode());
        address.setStreetName(dto.streetName());
        address.setStreetNumber(dto.streetNumber());
        address.setCity(dto.city());
        address.setZipCode(dto.zipCode());
    }

    public void delete(Long id) {
        try {
            Address address = addressRepository.getReferenceById(id);
            addressRepository.delete(address);
        } catch (EntityNotFoundException e) {
            throw new IllegalArgumentException("Não existe endereço com o id: " + id);
        }
    }
}
