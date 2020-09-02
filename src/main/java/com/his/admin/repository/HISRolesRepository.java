package com.his.admin.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.his.admin.entity.HIS_RolesEntity;

public interface HISRolesRepository extends JpaRepository<HIS_RolesEntity, Serializable> {

}
