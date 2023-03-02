package net.radar.yandexconsole.repository;

import net.radar.yandexconsole.model.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {
    List<Profile> findByName(String name);
}
