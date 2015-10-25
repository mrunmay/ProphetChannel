package za.co.reverside.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.reverside.model.Reason;

@Repository
public interface ReasonRepository  extends JpaRepository<Reason, Long>
{
}
