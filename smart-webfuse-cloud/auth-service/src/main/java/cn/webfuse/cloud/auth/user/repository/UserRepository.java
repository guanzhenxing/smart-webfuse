package cn.webfuse.cloud.auth.user.repository;

import cn.webfuse.cloud.auth.user.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
