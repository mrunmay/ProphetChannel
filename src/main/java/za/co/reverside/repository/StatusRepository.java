package za.co.reverside.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.reverside.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long>
{
}
