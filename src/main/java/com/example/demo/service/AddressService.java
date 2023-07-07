package com.example.demo.service;


import com.example.demo.dto.address.AddAddressDto;
import com.example.demo.dto.address.GetAddressDto;
import com.example.demo.entity.Address;
import com.example.demo.entity.Office;
import com.example.demo.exception.ResponseStatusNotFoundException;
import com.example.demo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {


    AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }





    public GetAddressDto getAddressByname(String name) throws ResponseStatusNotFoundException {

        Optional<Address> optionalAddress = addressRepository.getReferenceByName(name);

        if(optionalAddress.isPresent()){

            Address address = optionalAddress.get();

            GetAddressDto getAddressDto = new GetAddressDto();

            getAddressDto.setCity(address.getCity());
            getAddressDto.setOffice(address.getOffice().toString());
            getAddressDto.setStreet(address.getStreet());
            getAddressDto.setPostalCode(address.getPostalCode());
            getAddressDto.setAdditionalInformation(address.getAdditionalInformation());

            return getAddressDto;


        } else {
            throw new ResponseStatusNotFoundException("Something went wrong!");
        }

    }

    public GetAddressDto findbyId(Long id) throws ResponseStatusNotFoundException {

        Optional<Address> optionalAddress = addressRepository.findById(id);

        if(optionalAddress.isPresent()){

            Address address = optionalAddress.get();

            GetAddressDto addressDto = new GetAddressDto();

            addressDto.setCity(addressDto.getCity());

            addressDto.setAdditionalInformation(address.getAdditionalInformation());
            addressDto.setOffice(address.getOffice().toString());
            addressDto.setPostalCode(address.getPostalCode());
            addressDto.setStreet(addressDto.getStreet());
            addressDto.setCity(address.getCity());


            return addressDto;




        } else  {
            throw new ResponseStatusNotFoundException("Address not found!");
        }
    }




    public void AddAddress(AddAddressDto address) throws ResponseStatusNotFoundException {

        if(address != null){
            Address address1 = new Address();

            address1.setStreet(address.getStreet());
            address1.setCity(address.getCity());
            address1.setOffice(address.getOffice());
            address1.setPostalCode(address.getPostalCode());
            address1.setAdditionalInformation(address.getAdditionalInformation());

            addressRepository.save(address1);


        }else throw new ResponseStatusNotFoundException("This address is empty!");

    }

    public void deleteAddressByName(String name) {

        Optional<Address> address = addressRepository.getReferenceByName(name);

        if(address.isPresent()){

            addressRepository.deleteByName(name);
        } else{

            throw new NullPointerException("The name seems to be null!");
        }

    }

}
