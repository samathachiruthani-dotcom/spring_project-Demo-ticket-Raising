package com.example.liveapp.controller;

import com.example.liveapp.model.Ticket;
import com.example.liveapp.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Ticket> create(@RequestBody Ticket ticket) {
        Ticket created = service.create(ticket);
        return ResponseEntity.created(URI.create("/api/tickets/" + created.getId())).body(created);
    }

    @GetMapping
    public List<Ticket> list() {
        return service.listAll();
    }

    @GetMapping("/{id}")
public ResponseEntity<Ticket> get(@PathVariable("id") Long id) {
    return service.getById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}

@PutMapping("/{id}")
public ResponseEntity<Ticket> update(@PathVariable("id") Long id,
                                     @RequestBody Ticket ticket) {
    Ticket updated = service.update(id, ticket);
    if (updated == null) return ResponseEntity.notFound().build();
    return ResponseEntity.ok(updated);
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    boolean deleted = service.delete(id);
    if (!deleted) return ResponseEntity.notFound().build();
    return ResponseEntity.noContent().build();
}


}
