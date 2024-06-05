package controller;

import model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import respository.VehicleRespository;

import java.util.List;

@Controller
public class VehicleController {

    @Autowired
    private VehicleRespository vehicleRepository;

    // Hiển thị trang quản lý xe
    @GetMapping("/vehicle")
    public String showVehicleManagement(Model model) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        model.addAttribute("vehicles", vehicles);
        return "vehicle";
    }

    // Lưu hoặc cập nhật thông tin của xe
    @PostMapping("/save")
    public String saveVehicle(@ModelAttribute Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        return "redirect:/vehicle";
    }

    // Hiển thị form sửa thông tin của xe
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid vehicle Id:" + id));
        model.addAttribute("vehicle", vehicle);
        return "edit-vehicle";
    }

    // Xóa một xe
    @GetMapping("/delete/{id}")
    public String deleteVehicle(@PathVariable("id") int id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid vehicle Id:" + id));
        vehicleRepository.delete(vehicle);
        return "redirect:/vehicle";
    }
}