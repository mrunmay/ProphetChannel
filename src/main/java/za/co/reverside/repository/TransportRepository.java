package za.co.reverside.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.reverside.model.Transport;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Long>
{
}
