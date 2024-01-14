package BT_20_12.Management.Repository;

import BT_20_12.Management.Entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity,Integer> {
    UsersEntity findByEmailAndPassword(String email,String password);
}
