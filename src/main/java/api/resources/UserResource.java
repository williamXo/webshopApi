package api.resources;

import api.View;
import api.model.User;
import api.persistence.UserDAO;
import api.service.UserService;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.annotation.JsonView;
import io.dropwizard.auth.Auth;
import org.jdbi.v3.core.Jdbi;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    private  final UserService service;

    public UserResource(UserService service) {
    this.service = service;
    }

    @RolesAllowed("admin")
    @GET
    @Path("/{username}")
    public User sayHello(@PathParam("username")String name)
    {
        return service.getUserByName(name);
    }


    @PUT
    @PermitAll
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(User user){
        service.updateUser(user);
    }

    @GET
    @Path("/login")
    @JsonView(View.Public.class)
    public User  authenticate(@Auth User authenticator)
    {
        return service.getlogin(authenticator);
    }

    @POST
    @Path("/register")
    @JsonView(View.Public.class)
    public void register(User user)
    {
        service.register(user);
    }

    @DELETE
    @RolesAllowed("admin")
    @Path("/delete/{id}")
    @JsonView(View.Public.class)
    public void delete(@PathParam("id")int id)
    {
        service.deleteUserById(id);
    }


}