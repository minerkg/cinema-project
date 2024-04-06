package ro.ubb.cinema.repository;

import java.util.List;

public interface CinemaRepository<Entity> {
    List<Entity> findAll();

    Entity findById(int id);

    void save(Entity entity);

    void update(Entity entity);

    void deleteById(int id);
}
