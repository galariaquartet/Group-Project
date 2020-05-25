package com.gquartet.GroupProject.services;

import com.gquartet.GroupProject.models.Material;
import com.gquartet.GroupProject.repos.MaterialRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialRepository repo;

    @Override
    public List<Material> listAll() {
        return repo.findAll();
    }

    @Override
    public void save(Material material) {
        repo.save(material);
    }

    @Override
    public Material getMaterial(Integer id) {
        return repo.getOne(id);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public void update(Material material) {
        Material m = new Material();
        m.setMaterialId(material.getMaterialId());
        m.setMaterialName(material.getMaterialName());
        repo.save(m);
    }

}
