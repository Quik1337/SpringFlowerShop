package flowershop.springproject.flowershop.services;

import java.util.Set;

public interface CrudService<T> {

   T getById(Long id);

   Set<T> getAll();

   T add(T object);
}