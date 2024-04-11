package ro.ubb.cinema.service;

import ro.ubb.cinema.domain.ClientCard;
import ro.ubb.cinema.domain.ClientCardValidator;
import ro.ubb.cinema.repository.CinemaRepository;

import java.util.Comparator;
import java.util.List;

public class ClientCardService {
    private CinemaRepository<ClientCard> clientCardRepository;

    public ClientCardService(CinemaRepository<ClientCard> clientCardRepository) {
        this.clientCardRepository = clientCardRepository;
    }

    public void add(ClientCard clientCard) {
        ClientCardValidator.validate(clientCard);
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
