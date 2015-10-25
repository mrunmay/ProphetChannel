package za.co.reverside.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.reverside.model.HealthStatus;

@Repository
public interface HealthStatusRepository extends JpaRepository<HealthStatus, Long>
{
}
