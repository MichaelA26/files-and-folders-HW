package com.codeclan.FilesAndFolders.components;

import com.codeclan.FilesAndFolders.models.Folder;
import com.codeclan.FilesAndFolders.models.User;
import com.codeclan.FilesAndFolders.repositories.FileRepository;
import com.codeclan.FilesAndFolders.repositories.FolderRepository;
import com.codeclan.FilesAndFolders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fieRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public void run(ApplicationArguments args){
        User mike = new User("Mike Lad");
        userRepository.save(mike);

        User sazz = new User("Sazz Lass");
        userRepository.save(sazz);

        Folder folder1 = new Folder("SecretFolder", mike);
        folderRepository.save(folder1);

        Folder folder2 = new Folder("Diablo IV", sazz);
        folderRepository.save(folder2);

        mike.addFolders(folder1);
        mike.addFolders(folder2);
        fieRepository.save(mike);

        


        }
    }
}
