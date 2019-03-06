package com.rusinek.suszitest.repositories;

import com.rusinek.suszitest.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message,Long> {

}
