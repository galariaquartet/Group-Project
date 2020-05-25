package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.Material;
import java.util.List;

public interface MaterialService {

    public List<Material> listAll();

    public void save(Material material);

    public Material getMaterial(Integer id);

    public void delete(Integer id);

    public void update(Material material);

}
