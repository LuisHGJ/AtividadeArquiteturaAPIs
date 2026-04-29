package application.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @Operation(summary = "Autentica o usuário e gera um token JWT")
    @ApiResponse(
        responseCode = "200",
        description = "Autenticação realizada com sucesso"
    )
    @ApiResponse(
        responseCode = "401",
        description = "Usuário ou senha inválidos"
    )
    public String login(@RequestBody Usuario usuario) {
        UsernamePasswordAuthenticationToken tk =
            new UsernamePasswordAuthenticationToken(
                usuario.getUsuario(), usuario.getSenha());
        authenticationManager.authenticate(tk);
        
        return tokenService.generateToken(usuario);
    }
}
