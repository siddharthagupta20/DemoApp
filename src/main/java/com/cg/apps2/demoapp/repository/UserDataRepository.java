package com.cg.apps2.demoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.apps2.demoapp.model.UserData;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {
}
