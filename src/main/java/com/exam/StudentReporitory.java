package com.exam;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentReporitory extends CrudRepository<Student, String>{

}
