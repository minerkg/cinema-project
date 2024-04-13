package ro.ubb.cinema.service;

import ro.ubb.cinema.domain.ClientCard;
import ro.ubb.cinema.domain.ClientCardValidator;
import ro.ubb.cinema.repository.CinemaRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClientCardService {
    private CinemaRepository<ClientCard> clientCardRepository;

    public ClientCardService(CinemaRepository<ClientCard> clientCardRepository) {
        this.clientCardRepository = clientCardRepository;
    }

    public void add(ClientCard clientCard) {
        ClientCardValidator.validate(clientCard);
        // here we check if the CNP is already exist or not
        if (clientCardRepository.findAll().stream().filter(clientC -> clientC.getCnp().equals(clientCard.getCnp())).findFirst().isPresent()) {
            throw new CnpException("CNP already exist");
        }
        clientCardRepository.save(clientCard);
    }

    public List<ClientCard> getAll() {
        return clientCardRepository.findAll();
    }

    public ClientCard getById(int id) {
        return clientCardRepository.findById(id);
    }

    public void update(ClientCard newClientCard) {
        ClientCardValidator.validate(newClientCard);
        clientCardRepository.update(newClientCard);
    }

    public void deleteById(int id) {
        clientCardRepository.deleteById(id);
    }

    public List<ClientCard> searchClients(String searchText) {
        List<ClientCard> clients = clientCardRepository.findAll();
        List<ClientCard> matchingClients = new ArrayList<>();

        for (ClientCard client : clients) {
            if (client.getFirstName().toLowerCase().contains(searchText.toLowerCase()) ||
                    client.getLastName().toLowerCase().contains(searchText.toLowerCase())) {
                matchingClients.add(client);
            }
        }

        if (!matchingClients.isEmpty()) {
            return matchingClients;
        }
        return null;
    }

    public List<ClientCard> getClientCardsByPoints() {
        return clientCardRepository.findAll().
                stream().
                sorted(new Comparator<>() {
                    @Override
                    public int compare(ClientCard clientCard1, ClientCard clientCard2) {
                        return Integer.compare(clientCard1.getLoyaltyPoints(), clientCard2.getLoyaltyPoints()) * -1;
                    }
                }).
                toList();
    }
}
