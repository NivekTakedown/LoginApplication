package Control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Entidad.Usuario;
import static Frontera.FramePrincipal.sistema;
import java.util.ArrayList;

/**
 *
 * @author Nivektakedown
 */
public class TestLogin {
    private static ValidarLogin validarLogin= new ValidarLogin();
    private String LONG_NOMBRE_INCORRECTA="Longitud de nombre incorrecta";
    private String LONG_PASSWORD_INCORRECTA="Longitud de contraseña incorrecta";
    private String DATOS_INCORRECTOS="Datos incorrectos";
    private String USUARIO_AUTORIZADO="Bienvenido";
    public TestLogin() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception{
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void TestLongitudDeNombre() {
        Usuario u=new Usuario();
        u.setNombre("R");
        u.setPassword("123456");
        assertEquals(validarLogin.verificarLongin(u),LONG_NOMBRE_INCORRECTA);
        
        u.setNombre("Roberto");
        u.setPassword("123456");
        assertEquals(validarLogin.verificarLongin(u),LONG_NOMBRE_INCORRECTA);
    }
    @Test
    public void testNombre() {
        Usuario u=new Usuario();
        u.setNombre("Henry");
        u.setPassword("12345");
        assertEquals(validarLogin.verificarLongin(u),DATOS_INCORRECTOS);
        
    }
    @Test
    public void TestLongitudDeContraseña() {
        Usuario u=new Usuario();
        u.setNombre("Pepe");
        u.setPassword("12");
        assertEquals(validarLogin.verificarLongin(u),LONG_PASSWORD_INCORRECTA);
        
        u.setNombre("Pepe");
        u.setPassword("123456");
        assertEquals(validarLogin.verificarLongin(u),LONG_PASSWORD_INCORRECTA);
    }
    @Test
    public void TestContraseña() {
        Usuario u=new Usuario();
        u.setNombre("maria");
        u.setPassword("1234");
        assertEquals(validarLogin.verificarLongin(u),DATOS_INCORRECTOS);
    }
    @Test
    public void TestDatos() {
        Usuario u=new Usuario();
        u.setNombre("Henry");
        u.setPassword("A234");
        assertEquals(validarLogin.verificarLongin(u),DATOS_INCORRECTOS);
    }
    @Test
    public void TestTodoCorrecto() {
        Usuario u=new Usuario();
        u.setNombre("juan");
        u.setPassword("1234");
        assertEquals(validarLogin.verificarLongin(u),USUARIO_AUTORIZADO);
        
        u.setNombre("pedro");
        u.setPassword("123");
        assertEquals(validarLogin.verificarLongin(u),USUARIO_AUTORIZADO);
        
        u.setNombre("maria");
        u.setPassword("12345");
        assertEquals(validarLogin.verificarLongin(u),USUARIO_AUTORIZADO);
    }
    
}
    
