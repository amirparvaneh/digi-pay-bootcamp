package com.digipay.inventory.repository;

import com.digipay.inventory.model.consumer.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumerRepository extends JpaRepository<Consumer,Long> {

}
