package cn.webfuse.cloud.uaa.repository;

import cn.webfuse.cloud.uaa.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, String> {

}