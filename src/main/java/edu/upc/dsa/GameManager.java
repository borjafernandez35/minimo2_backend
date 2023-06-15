package edu.upc.dsa;

import edu.upc.dsa.models.Insignia;
import edu.upc.dsa.models.Objeto;
import edu.upc.dsa.models.Usuario;
import edu.upc.dsa.models.dto.TablaCompra;
import edu.upc.dsa.models.dto.TablaInsignia;

import java.util.List;

public interface GameManager {

    //Añadir Usuario
    public void registrarUsuario(String nombre, String correo, String password);
    public int addUsuarioORM(String nombre, String correo, String password); // Añadir Usuario a BBDD
    public Usuario addUsuario2(Usuario usuario); // Añadir usuario con las clases Usuario y UsuarioTO
    public void addObjeto(String nombre, String descripcion, double precio, String fotoImagen); //Añadir Objeto/Producto
    public Objeto addObjetoORM(String nombre, String descripcion, double precio, String fotoImagen); //Añadir Objeto/Producto
    public void login(String correo, String password); // login Usuario en arraylist
    public boolean loginORM(String correo, String password); // login usuario en BBDD
   // public Objeto hacerCompra(String Usuario, String nombreObjeto);     // Metodo hacer una compra con arraylist
    public TablaCompra hacerCompraORM(String correo, String nombreObjeto); // Metodo para hacer compra en BBDD

    public TablaCompra medallas(String correo, String nombreInsignia);
    public List<Objeto> listadeObjetos();// get lista de objetos
    public List<Objeto> listadeObjetosORM();
    public List<Insignia> listadeInsignias();
    public List<Objeto> listadeInsigniasORM();
    public List<TablaCompra> listadeTablaCompraORM();
    public List<TablaCompra> listaObjetosCompradosPorUsuarioORM(String correo);
    public List<TablaInsignia> listaInsigniasConseguidasPorUsuarioORM(String correo);
    public void updateUsuario( String nombre, String correo, String password); // Actualizar los datos de un usuario
    //Lista de objetos ordenados precio ascendente
 //   List<Objeto> listadeObjetosOrdenadosPorPrecio();

    //auxiliares
    Usuario getUsuarioPorCorreo(String correo);

    Usuario getUserByEmailORM(String correo);
    public Objeto getObjectByNameORM(String nombreObjeto);
    public Insignia getMedalByNameORM(String nombreInsignia);
    Usuario getUsuarioORM(String correo);
    Objeto getObjetoORM(String nombre);

    Usuario getUsuarioPorNombre(String nombreObjeto);

    Objeto getObjetoPorNombre(String nombreObjeto);

    public void clear();

    public int size();

}
