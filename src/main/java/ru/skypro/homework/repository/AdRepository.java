package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.entity.Ad;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {
    @Query(value = "SELECT * FROM ads", nativeQuery = true)
    List<Ad> findAllAds();


    @Query(value = "SELECT * FROM ads " +
            "WHERE user_id = :userId", nativeQuery = true)
    List<Ad> findAdsByUserId(long userId);

    Optional<Ad> findAdByPk(long pk);
}
