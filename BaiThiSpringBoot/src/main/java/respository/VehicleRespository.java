package respository;

import model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRespository extends JpaRepository<Vehicle, Integer> {
}
