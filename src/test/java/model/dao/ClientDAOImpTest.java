package test.model.dao;

import model.dao.ClientDAOImp;
import model.entities.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de testes para ClientDAOImp
 *
 * @author Vitor Augusto, Gabriel Vitor
 */
class ClientDAOImpTest {
    private ClientDAOImp dao;
    private Client client1;
    private Client client2;

    //O método anotado com @BeforeEach é executado antes de cada teste, e
    // é usado para inicializar as variáveis necessárias para o teste.

    //O método anotado com @AfterEach é executado após cada teste, e é
    // usado para limpar as variáveis usadas nos testes.
    // Isso ajuda a garantir que os testes não afetem uns aos outros.

    /**
     * O método setUp() é executado antes de cada teste e é usado para
     * inicializar as variáveis necessárias para os testes.
     */
    @BeforeEach
    void setUp() {
        dao = new ClientDAOImp();
        client1 = new Client("1", "John Rambo", "1234567890", "johnrambo@example.com", "123 main.Main St");
        client2 = new Client("2", "Sylvester Stallone", "0987654321", "stallone@example.com", "456 Elm St");
        dao.createClient(client1);
        dao.createClient(client2);
    }

    /**
     * O método tearDown() é executado após cada teste e é usado para
     * limpar as variáveis usadas nos testes.
     */
    @AfterEach
    void tearDown() {
        dao = null;
        client1 = null;
        client2 = null;
    }

    /**
     * Testa o método insertClient.
     */
    @Test
    void testInsertClient() {
        Client client3 = new Client("3", "Bob Smith", "1112223333", "bobsmith@example.com", "789 Oak St");
        dao.createClient(client3);
        assertEquals(client3, dao.getClientById(client3.getId()));
    }

    /**
     * Testa o método updateClient.
     */
    @Test
    void testUpdateClient() {
        dao.updateClient(client1, "name", "John Smith");
        assertEquals("John Smith", dao.getClientById(client1.getId()).getName());
    }

    /**
     * Testa o método deleteClient.
     */
    @Test
    void testDeleteClient() {
        dao.deleteClient(client2);
        assertNull(dao.getClientById(client2.getId()));
    }

    /**
     * Testa o método getAllClients.
     */
    @Test
    void testGetAllClients() {
        ArrayList<Client> expected = new ArrayList<>();
        expected.add(client1);
        expected.add(client2);
        assertEquals(expected, dao.readClients());
    }

    /**
     * Testa o método getClientById.
     */
    @Test
    void testGetClientById() {
        assertEquals(client1, dao.getClientById(client1.getId()));
    }

    /**
     * Testa o caso em que o atributo a ser alterado é inválido.
     */
    @Test
    void testInvalidAttributeToChange() {
        assertThrows(IllegalArgumentException.class, () -> dao.updateClient(client1, "invalidAttribute", "newValue"));
    }
}