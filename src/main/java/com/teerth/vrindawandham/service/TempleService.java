package com.teerth.vrindawandham.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.teerth.vrindawandham.entity.Temple;
import com.teerth.vrindawandham.repository.TempleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TempleService {

    @Autowired
    TempleRepo templeRepo;

    public ResponseEntity<List<Temple>> getTemples() {

        List<Temple> templList = templeRepo.findAll();
        if (templList == null || templList.isEmpty())
        {

            return ResponseEntity.notFound().build();

        }
            else
            return ResponseEntity.ok(templList);

    }

    public ResponseEntity<Temple> addTemple(Temple temple) {
        try {
            return ResponseEntity.ok(templeRepo.save(temple));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Temple> getTempleById(int id) {
        try{
            Optional<Temple> t = templeRepo.findById(id);
            return t.isPresent() ? ResponseEntity.ok(t.get()) : ResponseEntity.notFound().build();
        }
        catch (Exception e) {}
        return null;
    }
}
