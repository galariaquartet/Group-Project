package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.Gender;
import com.gquartet.GroupProject.repos.GenderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderServiceImpl implements GenderService {

    @Autowired
    GenderRepository repo;

    @Override
    public List<Gender> listAll() {
        return repo.findAll();
    }

    @Override
    public void save(Gender gender) {
        repo.save(gender);
    }

    @Override
    public Gender getGender(Integer id) {
        return repo.getOne(id);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Gender gender) {
        Gender g = new Gender();

        g.setGenderId(gender.getGenderId());
        g.setGenderName(gender.getGenderName());
        repo.save(g);

    }

}
