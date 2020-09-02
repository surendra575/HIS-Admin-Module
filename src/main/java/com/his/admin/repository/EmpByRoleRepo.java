package com.his.admin.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.his.admin.entity.HIS_EmployeeEntity;

public interface EmpByRoleRepo extends PagingAndSortingRepository<HIS_EmployeeEntity, Serializable> {
	
	Page<HIS_EmployeeEntity> findAllByRole(String role,Pageable pg);
	

}
