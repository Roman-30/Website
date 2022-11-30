package backend.repository;

import backend.entity.Record;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecordRepository extends CrudRepository<Record, Integer> {
    @NotNull
    List<Record> findAll();
}
