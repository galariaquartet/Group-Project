package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.Color;
import java.util.List;

public interface ColorService {

    public List<Color> listAll();

    public void save(Color color);

    public Color getColor(Integer id);

    public void delete(Integer id);

    public void update(Color color);

}
