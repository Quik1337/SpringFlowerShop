package flowershop.springproject.flowershop.services;

import flowershop.springproject.flowershop.models.Admin;
import flowershop.springproject.flowershop.repositories.AdminRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class AdminServiceTest {

    @Mock
    AdminRepository adminRepository;

    private AdminService adminService;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        adminService = new AdminService(adminRepository);
    }

    @Test
    public void getAdminByFirstName() {

    }

    @Test
    public void getById() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void add() {
    }
}