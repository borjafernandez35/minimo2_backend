package edu.upc.dsa;

import edu.upc.dsa.models.Usuario;
import edu.upc.eetac.dsa.IUserDAO;
import edu.upc.eetac.dsa.UserDAOImpl;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameManagerTest {

    GameManager manager = GameManagerImpl.getInstance();

    Logger logger = Logger.getLogger(GameManagerTest.class);
    @Before
    public void Inicializar() {

        manager = new GameManagerImpl();
        manager.registrarUsuario("Jose", "Larrinzal", "Jimenez");
        manager.registrarUsuario("Pedro", "Lopez", "Lopez");

        manager.addObjeto("pikachu","tipo electrico", 59.99,"pikachu");
        manager.addObjeto("charmander","tipo fuego", 45.99,"charmander");

    }

    @Test
    public void addUsuario() {
        manager.registrarUsuario("Hola","Prueba","xd");
    }

    @Test
    public void addObjeto(){
        manager.addObjeto("torchic","tipo fuego",49.99,"torchic");
    }

/*    @Test
    public void Compra(){
        manager.hacerCompra("Jose", "charmander");
        manager.hacerCompra("Jose", "pikachu");
        manager.hacerCompra("Pedro", "pikachu");
        manager.hacerCompra("Juan", "pikachu");
        manager.registrarUsuario("Juan","Prueba","xd");
        manager.hacerCompra("Juan", "pikachu");
    }*/

    @Test
    public void login(){
        manager.registrarUsuario("Jose", "DSA@gmail.com", "1234");
        manager.login("DSA@gmail.com","1234");
        manager.login("prueba@gmail.com","supersegura2");
    }

    @Test
    public void listaObjetos(){
        manager.addObjeto("Monitor","144Hz",99.99,"Monitor");
        manager.addObjeto("Raton","inalambrico",20.00,"Raton");
        manager.addObjeto("Teclado","Retroiluminado",50.00,"Teclado");
        manager.listadeObjetos();
    }

    @Test
    public void listaObjetosOrdenadosPorPrecio(){
        manager.addObjeto("Monitor","144Hz",99.99,"Monitor");
        manager.addObjeto("Raton","inalambrico",20.00,"Raton");
        manager.addObjeto("Teclado","Retroiluminado",50.00,"Teclado");
       // manager.listadeObjetosOrdenadosPorPrecio();

    }
/*

    @Test
    public void addUsuarioORM(){
        manager.addUsuario("2","2","12");
    }

    @Test
    public void addUsuarioORM2(){
        manager.addUsuario2("a","a","12");
    }
*/


    @Test
    public void getLoginTest(){
//      Assert.assertTrue(userDAO.login("Borja@gmail.com", "478356"));
        Assert.assertTrue(manager.loginORM("aa", "12"));
    }

    @Test
    public void getUserTest2() {

        //UsuarioTO user5 = manager.getUserByEmailORM("jose2@gmail.com");
      //  Assert.assertEquals("Jose", user5.getNombre());
    }
    @Test
    public void addObjetoORM(){
        manager.addObjetoORM("manzana","roja",5.00,"a");
    }

    @Test
    public void Compra() {
        manager.hacerCompraORM("j", "melon");
    }

    @Test
    public void getusuORM(){
        manager.getUsuarioORM("j");
    }

    @Test
    public void getobjORM(){
        manager.getObjetoORM("manzana");
    }

    @Test
    public void listaObjetosORM(){
        manager.listadeObjetosORM();
    }
    @Test
    public void listaTBORM(){
        manager.listadeTablaCompraORM();
    }

    @Test
    public void listaObjetosCompradosPorUsuarioORM(){
        manager.listaObjetosCompradosPorUsuarioORM("j");
    }

    @Test
    public void getLoginTest1() {
        Assert.assertTrue(manager.loginORM("r", "r"));
    }

    @Test
    public void addUsuarioORM() {
        Usuario usuario = new Usuario("Jose1","m","1");
        manager.addUsuario2(usuario);
    }

    @Test
    public void updateUsuario() {
        manager.updateUsuario("Jose","ñ","1");
    }

}
