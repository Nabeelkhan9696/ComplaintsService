package com.payments.complaintsservice.complaint;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComplaintService {

    private final ComplaintRepository repository;

    public ComplaintService(ComplaintRepository repository) {
        this.repository = repository;
    }

    public List<Complaint> findAll() {
        return repository.findAllByOrderByCreatedAtDesc();
    }

    @Transactional
    public Complaint submit(Complaint complaint) {
        return repository.save(complaint);
    }
}
