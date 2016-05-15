package com.ea.neon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ea.neon.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
