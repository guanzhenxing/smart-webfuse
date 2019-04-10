package cn.webfuse.cloud.uaa.uc.user.repository;

import cn.webfuse.cloud.uaa.uc.user.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
