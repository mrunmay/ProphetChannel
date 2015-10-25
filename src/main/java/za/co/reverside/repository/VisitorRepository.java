package za.co.reverside.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.reverside.model.Visitor;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long>
{
}
