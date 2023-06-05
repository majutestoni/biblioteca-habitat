package br.furb.inf.furbot.services;

import br.furb.inf.furbot.models.usuario.Admin;
import br.furb.inf.furbot.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public class AdminService extends ServiceImpl<Admin>{
    @Autowired
    private AdminRepository adminRepository;
    @Override
    public JpaRepository<Admin, UUID> getRepository() {
        return adminRepository;
    }

    @Override
    public void validator(Admin entity) {

    }
}
