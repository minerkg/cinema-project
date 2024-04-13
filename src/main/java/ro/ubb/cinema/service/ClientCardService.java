package ro.ubb.cinema.service;

import ro.ubb.cinema.domain.ClientCard;
import ro.ubb.cinema.domain.ClientCardValidator;
import ro.ubb.cinema.repository.CinemaRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
    public void addBonusToClients(LocalDate start, LocalDate end, int bonusPoints){
        List<ClientCard> bonusList = getAll().stream().filter(client -> client.getBirthDate().isAfter(start) && client.getBirthDate().isBefore(end)).collect(Collectors.toList());
        for (ClientCard clientCard : bonusList){
            int bonusPoint = clientCard.getLoyaltyPoints();
            clientCard.setLoyaltyPoints(bonusPoint+bonusPoints);
        }
    }
}
