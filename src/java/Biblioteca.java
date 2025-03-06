package java;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    /**
     * Clase que representa una biblioteca con una coleción de libros
     * Permite agregar, eliminar y buscar libros por titulo y por autor
     *
     * @author Dolores Campos Rodriguez
     */



    // TODO: Documentar estos atributos
    /** Lista de libros disponibles en la biblioteca */
    private final List<Libro> libros;

    // TODO: Documentar este método

    /** Constructor por defecto de la biblioteca sin libros */

    public Biblioteca() {
        libros = new ArrayList<>();
    }

    // TODO: Documentar este método.
    //  Test: NO HAY QUE TESTEAR ESTE METODO

    /** Constructor con parámetros
     * @param libros Lista de libros con la que se inicializaría la bilioteca
     */

    public Biblioteca(List<Libro> libros) {
        this.libros = libros;
    }

    // TODO: Testear este metodo.
    //  Test: Comprobar si se ha agregado

    /**
     * Este metodo agrega un libro a la lista de libros de la biblioteca
     * @param libro El libro que se va a agregar a la biblioteca
     * @return true si el libro se agrega, false si no se agrega correctamente
     */

    public boolean agregarLibro(Libro libro) {
        return libros.add(libro);
    }

    // TODO: Testear este metodo.
    //  Test: comprobar si se ha eliminado
    /**
     * Este metodo elimina un libro de la lista de libros de la biblioteca si existe
     * @param libro El libro que se va a eliminar de la biblioteca
     * @return true si el libro fue eliminado correctamente, false si no se encontró el libro
     */

    public boolean eliminarLibro(Libro libro) {
        return libros.remove(libro);
    }

    // TODO: Documentar este método
    /**
     * Este metodo devuelve la lista de libros que contiene la biblioteca
     * @return La lista de libros de la biblioteca
     */

    public List<Libro> getLibros() {
        return libros;
    }

    // TODO: Documentar este método.
    //  Test 01: buscar libro existente y comprobar que lo localiza.
    //  Test 02: buscar libro NO existente y comprobar que no lo localiza.

    /**
     * Este metodo busca un libro en la biblioteca según su titulo
     * @param titulo El título del libro que se quiere buscar
     * @return El libro encontrado si existe, o null si no se existe
     */

    public Libro encuentraLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                return libro;
            }
        }
        return null;
    }

    // TODO: Documentar este metodo.
    //  No testearlo
    // Este metodo está obsoleto. Hay que documentarlo como tal.
    //  Recuerda: las anotaciones @deprecated y @link a la nueva
    //  versión mejorada encuentraLibrosPorAutor(...)
    //  En esta ocasión, NO TESTEAREMOS este metodo

    /**
     * @deprecated
     * Este metodo está obsoleto y ha sido reemplazado por el metodo {@link #encuentraLibrosPorAutor(String)}
     * Busca un libro en la biblioteca por el nombre de su autor
     *
     * @param autor El autor del libro que se va a buscar
     * @return El libro encontrado si existe, o null si no existe
     * @deprecated
     */
    public Libro encuentaLibroPorAutor(String autor) {
        for (Libro libro : libros) {
            if (libro.getAutor().equals(autor)) {
                return libro;
            }
        }
        return null;
    }

    // TODO: Documentar este metodo
    // Este metodo sustituye al metodo anterior. Está disponible desde la
    //  versión 2.0. Hay que documentarlo teniéndolo en cuenta.
    // TODO: Testear este metodo.
    //  Test: Comprobar la lista de libros que devuelve para un autor existentes.
    //  Test: Comprobar la lista de libros que devuelve para un autor No existente

    /**
     * Este metodo sustituye al metodo {@link #encuentraLibrosPorAutor(String)} y busca todos los libros
     * de la biblioteca según autor
     * @param autor El autor de los libros
     * @return Una lista de libros del autor
     */

    public List<Libro> encuentraLibrosPorAutor(String autor) {
        List<Libro> listaLibros = null;
        for (Libro libro : libros) {
            if (libro.getAutor().equals(autor)) {
                if (listaLibros == null) {
                    listaLibros = new ArrayList<>();
                }
                listaLibros.add(libro);
            }
        }
        return listaLibros;
    }
}

