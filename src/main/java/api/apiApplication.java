package api;

import api.model.User;
import api.resources.OrderResource;
import api.resources.ProductResource;
import api.resources.UserResource;
import api.service.*;
import com.sun.org.apache.xpath.internal.operations.Or;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.HeaderFilter;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.jdbi.v3.core.Jdbi;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.FilterRegistration;
import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class apiApplication extends Application<apiConfiguration> {

    public static void main(final String[] args) throws Exception {
        new apiApplication().run(args);
    }

    @Override
    public String getName() {
        return "api";
    }

    @Override
    public void initialize(final Bootstrap<apiConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final apiConfiguration configuration,
                    final Environment environment) {


        environment.jersey().register(headerFilter.class);



        //setup for the database
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");



        UserService userService = new UserService(jdbi);
        ProductService productService = new ProductService(jdbi);
        OrderService orderService = new OrderService(jdbi);

        ProductResource productResource = new ProductResource(productService);
        UserResource userResource = new UserResource(userService);
        OrderResource orderResource =  new OrderResource(orderService);

        environment.jersey().register(productResource);
        environment.jersey().register(userResource);
        environment.jersey().register(orderResource);


        environment.jersey().register(new AuthDynamicFeature(
                new BasicCredentialAuthFilter.Builder<User>()
                .setAuthenticator(new UserAuthenticator(userService))
                .setAuthorizer(new UserAuthorizer())
                .setRealm("secresy")
                .buildAuthFilter()));
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(User.class));
    }

}
