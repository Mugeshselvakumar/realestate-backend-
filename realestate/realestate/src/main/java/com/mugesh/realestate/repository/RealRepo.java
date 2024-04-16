package com.mugesh.realestate.repository;


import com.mugesh.realestate.model.RealEstate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface RealRepo extends JpaRepository<RealEstate, Integer> {
    }

