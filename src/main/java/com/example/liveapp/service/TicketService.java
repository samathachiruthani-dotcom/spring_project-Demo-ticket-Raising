package com.example.liveapp.service;

import com.example.liveapp.model.Ticket;
import com.example.liveapp.repository.TicketRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class TicketService {

    private final TicketRepository repo;

    public TicketService(TicketRepository repo) {
        this.repo = repo;
    }

    public Ticket create(Ticket t) {
        if (t.getStatus() == null) t.setStatus("OPEN");
        return repo.save(t);
    }

    public List<Ticket> listAll() {
        return repo.findAll();
    }

    public Optional<Ticket> getById(Long id) {
        return repo.findById(id);
    }

    public Ticket update(Long id, Ticket incoming) {
        Ticket existing = repo.findById(id).orElse(null);

        if (existing == null) {
            return null;   // Controller will return 404
        }

        existing.setTitle(incoming.getTitle());
        existing.setDescription(incoming.getDescription());
        existing.setStatus(incoming.getStatus());

        return repo.save(existing);
    }

    public boolean delete(Long id) {
        if (!repo.existsById(id)) {
            return false;  // Controller will return 404
        }
        repo.deleteById(id);
        return true;
    }
}
