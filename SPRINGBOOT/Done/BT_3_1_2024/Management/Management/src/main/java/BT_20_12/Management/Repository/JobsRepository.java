package BT_20_12.Management.Repository;

import BT_20_12.Management.Entity.JobsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends JpaRepository<JobsEntity,Integer> {
}
