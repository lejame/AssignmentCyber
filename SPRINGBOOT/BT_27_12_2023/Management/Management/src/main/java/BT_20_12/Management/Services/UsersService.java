package BT_20_12.Management.Services;

import BT_20_12.Management.Entity.UsersEntity;
import BT_20_12.Management.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private final UsersRepository usersRepository;
    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }
    public UsersEntity getUsersEntityByEmailAndAndPassword(String email,String password){
        UsersEntity user = usersRepository.findByEmailAndPassword(email,password);
        return user;
    }
    public boolean findUserHasRole(int idRole){
        List<UsersEntity> list = usersRepository.findAll();
        for(UsersEntity user: list){
            if(user.getRolesEntity().getId()==idRole){
                return true;
            }
        }
        return false;
    }
}
