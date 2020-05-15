package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.Color;
import com.gquartet.GroupProject.repos.ColorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorServiceImpl implements ColorService {

    @Autowired
    private ColorRepository repo;

    @Override
    public List<Color> listAll() {
        return repo.findAll();
    }

    @Override
    public void save(Color color) {
        repo.save(color);
    }

    @Override
    public Color getColor(Integer id) {
        return repo.getOne(id);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Color color) {
        Color c = new Color();
        c.setColorId(color.getColorId());
        c.setColorName(color.getColorName());
        c.setColorImageFilepath(color.getColorImageFilepath());
        repo.save(c);
    }

}
