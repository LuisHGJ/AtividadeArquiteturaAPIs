package application.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Api de Gerenciamento Financeiro",
        version = "v1",
        description = "API para gerenciamento de dados financeiros",
        contact = @Contact(
            name = "Luis Henrique",
            email = "luis.henrique@cps.sp.gov.br"
        ),license = @License(
            name = "MIT",
            url = "https://opensource.org/license/mit"
        )
    ),
    servers = {
        @Server(url="/", description="Servidor"),
    },
    security = @SecurityRequirement(name = "bearerAuth")
)
@SecurityScheme(
    name = "bearerAuth",
    type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    bearerFormat = "JWT"
)
public class OpenApiConfig {
    
}