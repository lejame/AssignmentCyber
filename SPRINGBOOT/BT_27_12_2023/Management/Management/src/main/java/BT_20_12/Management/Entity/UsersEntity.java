package BT_20_12.Management.Entity;
import jakarta.persistence.*;
/*
có 4 quan hệ
One to One: 1 dòng dữ liệu bên này chỉ lẩy được 1 dòng dữ liệu bên kia
One to Many: 1 dòng dữ liệu bên này chỉ lẩy được nhiều dòng dữ liệu bên kia
Many to Many: Nhiều dòng dữ liệu bên này chỉ lẩy được nhiều dòng dữ liệu bên kia
*/

/*
* Để mapping kháo ngoại trong Entity
* Bước 1: Xem kháo chính 2  bảng đang quan hệ với nhau có phải là tự động tăng hay không
* nếu tự động thì không phải one to one => one to many
*
* Bước 2: Nếu khóa chính không tự động tăng và vừa là khóa chính và kháo ngoại => one to ont
*
*
* (*) OnetoMany: Entity nào giữ khóa ngoại thì sẽ có 2 Anotation sao đây
* -@ManytoOne và @joinColumn
* Bảng được tham chiếu khóa ngoại sẽ map ngược lại
*
* - @OnetoOne chỉ cần 1 bảng là được
*
*
* */

@Entity
@Table(name = "users", schema = "crm_app", catalog = "")
public class UsersEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "fullname")
    private String fullname;
    @Basic
    @Column(name = "avatar")
    private String avatar;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private RolesEntity rolesEntity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public RolesEntity getRolesEntity() {
        return rolesEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != that.id) return false;
        if (rolesEntity != that.rolesEntity) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (fullname != null ? !fullname.equals(that.fullname) : that.fullname != null) return false;
        if (avatar != null ? !avatar.equals(that.avatar) : that.avatar != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + rolesEntity.getId();
        return result;
    }
}
