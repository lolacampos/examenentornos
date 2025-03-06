package java;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private Libro libro1;
    private Libro libro2;
    private Libro libro3;

    @BeforeEach
    public void setUp() {
        /** Inicializamos los objetos necesarios para los tests*/

        libro1 = new Libro("Los pilares de la Tierra", "Ken Follett");
        libro2 = new Libro("La bestia", "Rosa Montero");
        libro3 = new Libro("Matar a un ruiseñor", "Harper Lee");

        /** Creamos la biblioteca y agregamos libros */

        biblioteca = new Biblioteca();
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
    }

    /** Test para agregar Libro*/
    @Test
    public void agregarLibro() {
        assertTrue(biblioteca.agregarLibro(libro3),
                List<Libro> libros = biblioteca.getLibros();
        assertTrue(libros.contains(libro3), "El libro debería existir en la biblioteca.");
    }


    /** Test para eliminar Libro*/
    @Test
    public void eliminarLibro() {
        /** Intentamos eliminar un libro que existe*/
        assertTrue(biblioteca.eliminarLibro(libro1), "El libro debería ser eliminado correctamente.");

        /** Comprobamos que el libro ya no está en la biblioteca*/
        List<Libro> libros = biblioteca.getLibros();
        assertFalse(libros.contains(libro1), "El libro ya no debería estar en la biblioteca.");

        /** Intentamos eliminar un libro que no existe*/
        assertFalse(biblioteca.eliminarLibro(libro1), "No se debería poder eliminar un libro que no está en la biblioteca.");
    }

    /** Test para encontrar libro por titulo */
    @Test
    public void getLibros() {
        /** Buscamos un libro que existe*/
        Libro encontrado = biblioteca.encuentraLibroPorTitulo("La Bestia");
        assertNotNull(encontrado, "El libro debería ser encontrado.");
        assertEquals("La Bestia", encontrado.getTitulo(), "El título debería coincidir.");

        /** Buscamos un libro que no existe*/
        encontrado = biblioteca.encuentraLibroPorTitulo("El Quijote");
        assertNull(encontrado, "El libro no debería ser encontrado.");
    }

    @Test
    public void encuentraLibroPorTitulo() {
    }

    @Test
    public void encuentaLibroPorAutor() {

        /** Buscamos los libros de un autor existente*/
        List<Libro> librosDeAutor = biblioteca.encuentraLibrosPorAutor("Rosa Montero");
        assertNotNull(librosDeAutor, "La lista no debería ser nula.");
        assertEquals(1, librosDeAutor.size(), "Debería haber 1 libro de Rosa Montero");
        assertTrue(librosDeAutor.contains(libro2), "La lista debería contener 'La Bestia'.");

        /** Buscamos los libros de un autor no existente*/
        librosDeAutor = biblioteca.encuentraLibrosPorAutor("J.K. Rowling");
        assertNotNull(librosDeAutor, "La lista no debería ser nula.");
        assertTrue(librosDeAutor.isEmpty(), "La lista debería estar vacía.");
    }

    @Test
    public void encuentraLibrosPorAutor() {

        /** Test para el metodo obsoleto*/
        Libro libroEncontrado = biblioteca.encuentaLibroPorAutor("Rosa Montero");
        assertNotNull(libroEncontrado, "El libro debería ser encontrado.");
        assertEquals("La Bestia", libroEncontrado.getTitulo(), "El título debería coincidir.");

    }
}