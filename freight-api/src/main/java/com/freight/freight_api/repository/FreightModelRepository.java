package com.freight.freight_api.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.freight.freight_api.models.FreightModel;

@Repository
public interface FreightModelRepository extends JpaRepository<FreightModel, UUID> {
    Optional<FreightModel> findByOrderId(UUID orderId);
}
