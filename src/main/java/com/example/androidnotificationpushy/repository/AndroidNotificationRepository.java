package com.example.androidnotificationpushy.repository;

import com.example.androidnotificationpushy.model.AOSDeviceToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AndroidNotificationRepository extends JpaRepository<AOSDeviceToken, UUID> {
    Optional<AOSDeviceToken> findByUserId(UUID userId);
}
