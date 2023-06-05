package br.furb.inf.furbot.controllers;

import br.furb.inf.furbot.models.usuario.Admin;
import br.furb.inf.furbot.models.usuario.Usuario;
import br.furb.inf.furbot.services.AdminService;
import br.furb.inf.furbot.services.Service;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Serviço de administradores", externalDocs = @ExternalDocumentation(description = "Serviço responsável por administraores"))
@RestController
@RequestMapping("/admin")
public class AdminController extends ControllerImpl<Admin> {

    @Autowired
    private AdminService adminService;

    @Override
    public Service<Admin> getService() {
        return adminService;
    }

    @PostMapping
    public ResponseEntity<Admin> createAdmin(){}

}
