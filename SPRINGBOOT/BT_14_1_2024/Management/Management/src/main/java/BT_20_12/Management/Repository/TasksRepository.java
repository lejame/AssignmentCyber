package BT_20_12.Management.Repository;

import BT_20_12.Management.Entity.TasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends JpaRepository<TasksEntity,Integer> {
}
