package za.co.reverside.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.reverside.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long>
{
}
