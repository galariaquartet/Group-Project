package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.Gender;
import java.util.List;

public interface GenderService {

    public List<Gender> listAll();

    public void save(Gender gender);

    public Gender getGender(Integer id);

    public void delete(Integer id);

    public void update(Gender gender);
}
