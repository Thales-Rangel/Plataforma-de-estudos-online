package com.estudolivre.ProjetoPDS.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.estudolivre.ProjetoPDS.models.VideoAula;
import com.estudolivre.ProjetoPDS.repositories.VideoRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    @Autowired
    private VideoRepository repository;

    public VideoAula salvarVideo(MultipartFile file) throws IOException {
        VideoAula v = new VideoAula();
        v.setTipo(file.getContentType());
        v.setDados(file.getBytes());
        return repository.save(v);
    }
    
    public void save(VideoAula videoAula) {
    	repository.save(videoAula);
    }
    
    public List<VideoAula> listar(){
    	List<VideoAula> all = repository.findAll();
    	
    	return all.stream().toList();
    }

    public VideoAula obterVideo(Long id) {
        Optional<VideoAula> byId = repository.findById(id);
        
        if (byId.isEmpty()) {
			return null;
		}
        
        VideoAula videoAula = byId.get();
    	
    	return videoAula;
    }
}
