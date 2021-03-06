package flowershop.springproject.flowershop.services;

import flowershop.springproject.flowershop.models.Admin;
import flowershop.springproject.flowershop.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Set;

@Service
public class AdminService implements CrudService<Admin> {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    
    @Override
    public Admin getById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }
    
    @Override
    public Set<Admin> getAll() {
        Set<Admin> admins = new HashSet<>();
        adminRepository.findAll().forEach(admins::add);
        return admins;
    }

    public Admin getAdminByEmailAndPassword(String email, String password) {
        return adminRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public Admin add(Admin object) {
        return adminRepository.save(object);
    }
}