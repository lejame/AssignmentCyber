package BT_20_12.Management.Services;

import BT_20_12.Management.Entity.RolesEntity;
import BT_20_12.Management.Entity.UsersEntity;
import BT_20_12.Management.Repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService{
    @Autowired
    public RolesRepository rolesRepository;

    @Autowired
    public UsersService usersService;
    public boolean saveNewRoles(String name,String description){
        boolean isSuccess = false;
        if(name.isEmpty() || description.isEmpty()){
            return isSuccess;
        }
        rolesRepository.save(new RolesEntity(name,description));
        isSuccess = true;
        return isSuccess;
    }
    public List<RolesEntity> getListRole(){
        return rolesRepository.findAll();
    }
    public Boolean delete_Role(int id){
        if(rolesRepository.existsById(id) && !usersService.findUserHasRole(id)){
            rolesRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
