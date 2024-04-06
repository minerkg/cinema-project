package ro.ubb.cinema.repository;

import ro.ubb.cinema.domain.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class CinemaRepositoryImpl<Entity extends BaseEntity> implements CinemaRepository<Entity> {
    private List<Entity> entityList;

    public CinemaRepositoryImpl() {
        entityList = new ArrayList<>();
    }

    @Override
    public List<Entity> findAll() {
        return entityList;
    }

    public Entity findById(int id) {
        for (Entity entity : entityList) {
            if (entity.getId() == id) {
                return entity;
            }
        }
        return null;
    }

    @Override
    public void save(Entity entity) {
        if (findById(entity.getId()) != null) {
            throw new RuntimeException("Duplicate id!");
        }
        entityList.add(entity);
    }

    @Override
    public void update(Entity newEntity) {
        for (int i = 0; i < entityList.size(); i++) {
            Entity oldEntity = entityList.get(i);
            if (oldEntity.getId() == newEntity.getId()) {
                entityList.set(i, newEntity);
                return;
            }
        }
        throw new RuntimeException("Item not found!");
    }

    @Override
    public void deleteById(int id) {
        if (findById(id) == null ){
            throw new RuntimeException("Item not found!");
        }
        entityList.removeIf(entity -> entity.getId() == id);
    }
}
