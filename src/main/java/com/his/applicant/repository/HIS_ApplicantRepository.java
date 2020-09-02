package com.his.applicant.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.his.applicant.entity.HIS_ApplicantEntity;

public interface HIS_ApplicantRepository extends JpaRepository<HIS_ApplicantEntity, Serializable> {

}
