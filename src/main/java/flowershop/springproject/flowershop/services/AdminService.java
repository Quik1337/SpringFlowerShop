package flowershop.springproject.flowershop.services;

import flowershop.springproject.flowershop.models.Admin;
import flowershop.springproject.flowershop.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AdminService implements CrudService<Admin> {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    Admin getAdminByFirstName(String firstName){
        return adminRepository.getByFirstName(firstName);
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

    @Override
    public Admin add(Admin object) {
        return adminRepository.save(object);
    }
}
