package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.entity.Ad;
import ru.skypro.homework.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
