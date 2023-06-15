package edu.upc.dsa.services;


import edu.upc.dsa.GameManager;
import edu.upc.dsa.GameManagerImpl;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.models.dto.CredencialTO;
import edu.upc.dsa.models.dto.TablaCompra;
import edu.upc.dsa.models.dto.UsuarioTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/Game", description = "Endpoint to Game Service")
@Path("/game")
public class GameService {

    private GameManager manager;

    public GameService() {
        this.manager = GameManagerImpl.getInstance(); //GameManagerImpl.getInstance();  new UserDAOImpl();
        //IU

        if (manager.size() == 0) {
            // this.manager.addObjeto("pokeball", "Captura Pokemon", 5.00);
            this.manager.registrarUsuario("Jose", "jose@gmail.com", "123");
            this.manager.registrarUsuario("Jose", "n", "123");
            //this.manager.addUsuarioORM("P","p","12");
            //this.manager.registrarUsuario("Prueba", "prueba@gmail.com", "1234");
            this.manager.addObjeto("Monitor","144Hz",99.99,"https://img.freepik.com/vector-premium/monitor-computadora-realista_88272-327.jpg");
            this.manager.addObjeto("Raton","inalambrico",20.00,"https://www.info-computer.com/156049-medium_default/logitech-lgt-m90-1000-dpi-gris-q.jpg");
            this.manager.addObjeto("Teclado","Retroiluminado",50.00,"https://www.shutterstock.com/image-photo/computer-keyboard-isolated-on-white-260nw-222047851.jpg");
        }
    }

    //Registrar usuario
    @POST
    @ApiOperation(value = "Registrar usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = UsuarioTO.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/registrarUsuario")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registrarUsuario(UsuarioTO usuario) {
        //Usuario u = this.manager.getUsuarioPorCorreo(usuario.getCorreo());
        Usuario u = this.manager.getUserByEmailORM(usuario.getCorreo());

        if (u != null) {
            return Response.status(500).entity(usuario).build();

        } else {
            //this.manager.registrarUsuario(usuario.getNombre(), usuario.getCorreo(), usuario.getPassword());
            this.manager.addUsuarioORM(usuario.getNombre(), usuario.getCorreo(), usuario.getPassword());
            return Response.status(201).entity(usuario).build();
        }
    }

    @POST
    @ApiOperation(value = "registrar usuario 2", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= UsuarioTO.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/registrarUsuario2")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registrarUsuario2(UsuarioTO usuarioTO) {//Antes VOUsuario user
        Usuario user = new Usuario(usuarioTO);
        user = this.manager.addUsuario2(user);
        if (user == null) {
            return Response.status(500).build();
        }
        else
            return Response.status(201).entity(user).build();
    }



    //Añadir objeto
    @POST
    @ApiOperation(value = "crear objeto nuevo", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= Objeto.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/addObjeto")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addObjeto(Objeto objeto) {

        if (objeto.getNombre()==null || objeto.getDescripcion()==null || objeto.getPrecio()==0.00)  return Response.status(500).entity(objeto).build();
        this.manager.addObjeto(objeto.getNombre(), objeto.getDescripcion(),objeto.getPrecio(), objeto.getFotoimagen());
        return Response.status(201).entity(objeto).build();
    }



    //login
    @POST
    @ApiOperation(value = "login usuario", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = CredencialTO.class),
            @ApiResponse(code = 404, message = "No existe")
    })
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(CredencialTO credencials) {
/*        //Usuario u = this.manager.getUsuarioPorCorreo(credencials.getCorreo());
        Usuario u = this.manager.getUserByEmailORM(credencials.getCorreo());

        if (u == null) {
            return Response.status(404).entity("Usuario no encontrado").build();
        }

        if (credencials.getPassword().equals(u.getPassword())) {
            this.manager.loginORM(credencials.getCorreo(), credencials.getPassword());
            return Response.status(201).entity(credencials).build();

        } else {
            return Response.status(404).entity("credenciales invalidas").build();
        }*/

        this.manager.loginORM(credencials.getCorreo(), credencials.getPassword());
        if (manager.loginORM(credencials.getCorreo(), credencials.getPassword()) == true){
            return Response.status(201).entity(credencials).build();
        }
        else{
            return Response.status(404).entity("credenciales invalidas").build();
        }
    }



    // comprar objetos por parte de un usuario
    @POST
    @ApiOperation(value = "comprar objeto nuevo", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/compraObjetos/{correo}/{nombreObjeto}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response hacerCompra(@PathParam("correo")  String correo, @PathParam("nombreObjeto")  String nombreObjeto) {
/*        Objeto objeto = this.manager.getObjetoPorNombre(idUsuario);
        Usuario usuario = this.manager.getUsuarioPorNombre(Usuario);
        if (objeto.getNombre()==null || objeto.getDescripcion()==null)  return Response.status(500).build();
        this.manager.hacerCompraORM(usuario.getCorreo(), objeto.getNombre());
        return Response.status(201).entity(objeto).build();*/
        TablaCompra tablaCompra = this.manager.hacerCompraORM(correo, nombreObjeto);
        if (tablaCompra==null) {
            return Response.status(500).build();
        }
        else
            return Response.status(201).build();
    }

    //lista objetos
    @GET
    @ApiOperation(value = "lista objetos", notes = "asdas")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Objeto.class, responseContainer="List"),
    })
    @Path("/listaObjetos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getlistaObjetos() {
        List<Objeto> objeto = this.manager.listadeObjetosORM();
        GenericEntity<List<Objeto>> entity = new GenericEntity<List<Objeto>>(objeto) {};
        return Response.status(201).entity(entity).build()  ;
    }

    //Datos Usuario
    @GET
    @ApiOperation(value = "Datos Usuario", notes = "asdas")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class),
    })
    @Path("/datosUsuario/{correo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario(@PathParam("correo") String email) {
        Usuario u = this.manager.getUserByEmailORM(email);
        if (u != null)
            return Response.status(201).entity(u).build();
        else
            return Response.status(500).build();
    }

    //lista objetos de un usuario
    @GET
    @ApiOperation(value = "lista objetos de un usuario", notes = "asdas")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = TablaCompra.class, responseContainer="List"),
    })
    @Path("/listaObjetosUsuario/{correo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getlistaObjetosUsuario(@PathParam("correo") String correo) {
        List<TablaCompra> listaObjetoUsuario = this.manager.listaObjetosCompradosPorUsuarioORM(correo);
        GenericEntity<List<TablaCompra>> entity = new GenericEntity<List<TablaCompra>>(listaObjetoUsuario) {};
        return Response.status(201).entity(entity).build()  ;
    }

    //lista objetos ordenados ascendentemente
 /*   @GET
    @ApiOperation(value = "lista objetos ordenados ascendentemente", notes = "asdas")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Objeto.class, responseContainer="List"),
    })
    @Path("/listaObjetosAscendente")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getlistaObjetosOrdenadosAscendentemente() {

       List<Objeto> objeto = this.manager.listadeObjetosOrdenadosPorPrecio();

        GenericEntity<List<Objeto>> entity = new GenericEntity<List<Objeto>>(objeto) {};
        return Response.status(201).entity(entity).build();

    } */

}