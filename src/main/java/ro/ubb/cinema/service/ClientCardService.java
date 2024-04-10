package ro.ubb.cinema.service;

import ro.ubb.cinema.domain.ClientCard;
import ro.ubb.cinema.domain.ClientCardValidator;
import ro.ubb.cinema.repository.CinemaRepository;

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
}
