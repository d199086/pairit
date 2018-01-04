package com.serpacom.pairit.server;

import com.serpacom.pairit.server.dto.Pair;
import com.serpacom.pairit.server.dto.PairEntity;
import com.serpacom.pairit.server.service.PairitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "pairit/api/v1")
public class PairController {

    @Autowired
    private PairitRepository repository;

    @RequestMapping(value = "/getAllPairs", method = RequestMethod.GET)
    public ResponseEntity getAllPair(){
        return new ResponseEntity(repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/addPair/{userId}", method = RequestMethod.POST)
    public ResponseEntity addPair(@PathVariable final UUID userId , @RequestBody List<Pair> pairs){
        final List<PairEntity> pairEntityList = new ArrayList<PairEntity>();
        pairs.stream().forEach(pair -> {
            PairEntity pairEntity = new PairEntity();
            pairEntity.setPairId(UUID.randomUUID());
            pairEntity.setUserId(userId);
            pairEntity.setName(pair.getName());
            pairEntity.setValue(pair.getValue());
            repository.save(pairEntity);
        });
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/getPair/{userId}", method = RequestMethod.GET)
    public ResponseEntity getPair(@PathVariable UUID userId){
      /*  return new ResponseEntity(repository.findAll().stream()
                .filter(pairEntity -> pairEntity.getUserId().equals(userId))
                .collect(Collectors.toList()), HttpStatus.OK);
                */
        return new ResponseEntity(repository.findPairsByUserId(userId), HttpStatus.OK);
    }

    @RequestMapping(value = "/pair/{pairId}", method = RequestMethod.DELETE)
    public ResponseEntity deletePair(@PathVariable UUID pairId){
        repository.delete(pairId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAllPair(@PathVariable UUID userId){
        repository.deleteAllUserPairs(userId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
