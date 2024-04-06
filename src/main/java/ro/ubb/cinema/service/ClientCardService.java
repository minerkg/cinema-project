package ro.ubb.cinema.service;

import ro.ubb.cinema.domain.ClientCard;
import ro.ubb.cinema.repository.CinemaRepository;

import java.util.List;

public class ClientCardService {
    private CinemaRepository<ClientCard> clientCardRepository;

    public ClientCardService(CinemaRepository<ClientCard> clientCardRepository) {
        this.clientCardRepository = clientCardRepository;
    }

    public void add(ClientCard clientCard) {
        // TODO: Add validation
        clientCardRepository.save(clientCard);
    }

    public List<ClientCard> getAll() {
        return clientCardRepository.findAll();
    }

    public ClientCard getById(int id) {
        return clientCardRepository.findById(id);
    }

    public void update(ClientCard newClientCard) {
        // TODO: Add Validation
        clientCardRepository.update(newClientCard);
    }

    public void deleteById(int id) {
        clientCardRepository.deleteById(id);
    }
}
